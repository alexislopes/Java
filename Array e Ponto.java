package br.com.fatec;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] lista = new int[10];
        Random gerador = new Random();
	    String menu;
        String setup;

        setup = JOptionPane.showInputDialog("1 - Exercicio 1\n"+
                                            "2 - Exercicio 2\n");

        switch (setup) {
            case "1":
                System.out.println("--------------Exercicio 1--------------");

                do {
                    menu = JOptionPane.showInputDialog(
                                    "1 - Criar array\n" +
                                    "2 - Imprimir na ordem normal\n" +
                                    "3 - Imprimir na ordem invertida\n" +
                                    "4 - Imprimir os elementos em posições pares\n" +
                                    "5 - Imprimir os elementos pares\n" +
                                    "6 - Imprimir o somatório\n"
                    );

                    if (menu != null) {
                        switch (menu) {
                            case "1":
                                System.out.print("1 --> ");
                                for (int i = 0; i < lista.length; i++) {
                                    lista[i] = gerador.nextInt(20);
                                }
                                System.out.print("Lista criada!");
                                System.out.println();
                                break;

                            case "2":
                                System.out.print("2 --> ");
                                for (int i = 0; i < lista.length; i++) {
                                    System.out.printf("%d ", lista[i]);
                                }
                                System.out.println();
                                break;

                            case "3":
                                System.out.print("3 --> ");
                                for (int i = 9; i >= 0; i--) {
                                    System.out.printf("%d ", lista[i]);
                                }
                                System.out.println();
                                break;

                            case "4":
                                System.out.print("4 --> ");
                                for (int i = 0; i < lista.length; i = i + 2) {
                                    System.out.printf("%d ", lista[i]);
                                }
                                System.out.println();
                                break;

                            case "5":
                                System.out.print("5 --> ");
                                for (int i = 0; i < lista.length; i++) {
                                    if (lista[i] % 2 == 0) {
                                        System.out.print(lista[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;

                            case "6":
                                int soma = 0;
                                System.out.print("6 --> ");
                                for (int i = 0; i < lista.length; i++) {
                                    soma = soma + lista[i];
                                }
                                System.out.print(soma);
                                break;
                        }
                    }
                } while (menu != null);

            case "2":
                System.out.println("\n--------------Exercicio 2--------------");
                Ponto lp[] = new Ponto[10];


                do {
                    menu = JOptionPane.showInputDialog("1 - Cria array\n"+
                                                       "2 - Imprimir elementos da variável\n"+
                                                       "3 - Imprimir elementos que D>4\n"+
                                                       "4 - imprimir soma da distancia dos pontos\n");
                    if(menu != null){
                        switch (menu){
                            case "1":
                                System.out.print("1 --> ");
                                for(int i = 0; i<10; i++){
                                    lp[i] = new Ponto();
                                    lp[i].x = gerador.nextInt(10);
                                    lp[i].y = gerador.nextInt(10);
                                }
                                System.out.println("Lista criada!");
                                break;
                            case "2":
                                System.out.print("2 --> ");
                                for(int i = 0; i<lp.length; i++){
                                    lp[i].imprimir();
                                    //System.out.print("(" + lp[i].x  + ","  + lp[i].y + ")" + " ");
                                }
                                System.out.println();
                                break;
                            case "3":
                                System.out.print("3 --> ");
                                for(int i = 0; i<lp.length; i++){
                                    if(lp[i].distancia() > 4){
                                        lp[i].imprimir();
                                    }
                                }

                                System.out.println();
                                break;
                            case"4":
                                System.out.print("4 --> ");
                                double dis = 0;
                                for(int i = 0; i<lp.length; i++) {
                                    dis = dis + lp[i].distancia();
                                }
                                System.out.printf("Soma das distancas: %.2f", dis);
                                System.out.println();
                        }

                    }
                } while (menu != null);

        }
    }
}
