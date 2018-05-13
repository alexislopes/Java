package aula;

import xml.Cidade;
import xml.Previsao;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        int i = 0;

        while(true) {
            new Manager();
            System.out.println("<1> -- Nova Consulta\n<2> -- Sair");
            i = leitor.nextInt();
            if(i != 1){
                break;
            }
        }
        //String query = "select * from tbcidade";
        //Banco b = new Banco();
        //b.conectar();
        //b.selectCidade(query);

    }
}

