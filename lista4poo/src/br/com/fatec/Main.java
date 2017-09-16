package br.com.fatec;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int menu;

        do {
            agenda.intro();
            System.out.print("\nEscolha uma das opções: ");
            menu = ler.nextInt();

            switch (menu) {
                case 1:
                    agenda.listarTodos();
                    break;
                case 2:
                    int opcao;
                    agenda.setup();
                    opcao = ler.nextInt();
                    if (opcao == 1) {
                        agenda.addAluno();
                    } else {
                        agenda.addProfessor();
                    }
                    break;
                case 3:
                    System.out.println("Até logo e obrigado pelos peixes!");
                case 4:
                    agenda.leTodos();

            }

        } while (menu != 3);
    }
}
