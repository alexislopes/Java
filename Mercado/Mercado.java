package br.com.fatec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mercado {
    Scanner lernum = new Scanner(System.in);
    Scanner lerstr = new Scanner(System.in);

    private List<Usuário> usuários = new ArrayList<>();

    String vermelho = "\033[31m";
    String verde = "\033[32m";
    String amarelo = "\033[33m";
    String azul = "\033[34m";
    String roxo = "\033[35m";
    String verdim = "\033[36m";
    String cinza = "\033[37m";
    String limpo = "\033[m";

    public void intro() {
        int option;
        System.out.println("****************** LOJA ***************");
        System.out.println("**   1 - ENTRAR   2 - CADASTRAR-SE   **");
        System.out.println("***************************************");
        option = lernum.nextInt();

        switch (option){
            case 1:
                break;
                
            case 2:
                break;


        }

    }

    public void cadUser() throws Exception {
        boolean valid = false;
        String nome;

        System.out.print("Digite seu nome de usuário: ");
        nome = lerstr.nextLine();

        String senha, senha2;
        do {
            System.out.print("Digite sua senha: ");
            senha = lerstr.nextLine();

            System.out.print("Digite novamente sua senha: ");
            senha2 = lerstr.nextLine();
            if (senha.equals(senha2)) {
                System.out.println(verdim + "\nCadastro efetuado com sucesso!" + limpo);
            } else {
                System.out.println(vermelho + "As senhas não coincidem!\n" + limpo);
            }
        } while (!senha.equals(senha2));

        Usuário novoUser = new Usuário(nome, senha);

        usuários.add(novoUser);

        //storeInfo();
    }


}

