package br.com.fatec;
import java.io.*;
import java.util.Scanner;

public class ManupuladorDeArquivos {
    public static void leitor(String path) throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while(true){
            if(linha != null){
                System.out.println(linha);
            }
            else{ break;}
            linha = buffRead.readLine();
        }
        buffRead.close();
    }

    /*public static void escritor(String path, int n) throws IOException{
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "";
        System.out.println("");
        PrintWriter  gravarArq = new PrintWriter(path);

        for(int i =0; i<= n; i++){
            buffWrite.append(linha);
        }
    }*/
}
