//code from: https://www.devmedia.com.br/como-criar-um-chat-multithread-com-socket-em-java/33639

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Servidor extends Thread {
    private static ArrayList<BufferedWriter> jogadores;
    private static ServerSocket server;
    private String nome;
    private Socket con;
    private InputStream in;
    private InputStreamReader inr;
    private BufferedReader bfr;

    public Servidor(Socket con) {
        this.con = con;
        try {
            in = con.getInputStream();
            inr = new InputStreamReader(in);
            bfr = new BufferedReader(inr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
            try {
                String msg;
                OutputStream ou = this.con.getOutputStream();
                Writer ouw = new OutputStreamWriter(ou);
                BufferedWriter bfw = new BufferedWriter(ouw);
                jogadores.add(bfw);
                nome = msg = bfr.readLine();

                while (!"/sair".equalsIgnoreCase(msg) && msg != null) {
                    msg = bfr.readLine();
                    sendToAll(bfw, msg);
                    System.out.println(msg);
                }

            } catch (IOException e) {
                e.printStackTrace();
                SocketException em= new SocketException();
                em.printStackTrace();
            }

    }

    public void sendToAll(BufferedWriter bwSaida, String msg) throws IOException {
        BufferedWriter bwS;

        for (BufferedWriter bw : jogadores) {
            bwS = (BufferedWriter) bw;
            if (!(bwSaida == bwS)) {
                bw.write(nome + " -> " + msg + "\r\n");
                bw.flush();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        try {

            JLabel lblMessage = new JLabel("Porta do Servidor:");
            JTextField txtPorta = new JTextField("12345");
            Object[] texts = {lblMessage, txtPorta};
            JOptionPane.showMessageDialog(null, texts);
            server = new ServerSocket(Integer.parseInt(txtPorta.getText()));
            jogadores = new ArrayList<BufferedWriter>();
            JOptionPane.showMessageDialog(null, "Servidor na porta: " + txtPorta.getText());

            while (true) {
                System.out.println("Aguardando Conexão...");
                Socket con = server.accept();
                System.out.println("Cliente conectado...");
                Thread t = new Servidor(con);
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

