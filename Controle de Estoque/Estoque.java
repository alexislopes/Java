package br.com.fatec;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Estoque {
    Scanner lernum;
    Scanner lerstr;
    private ArrayList<Produto> produtos;
    String vermelho = "\033[31m";
    String amarelo = "\033[32m";
    String limpo = "\033[m";

    public Estoque() {
        lernum = new Scanner(System.in);
        lerstr = new Scanner(System.in);
        produtos = new ArrayList<>();
    }

////////////////////////////// MÉTODO PARA ADICIONAR PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private int nid = 0;

    public void addProduto() {
        Produto novo = new Produto();

        nid = nid + 1;
        String id = "P" + nid;
        novo.setId(id);

        System.out.print("\nNome: ");
        String nome = lerstr.nextLine();
        novo.setNome(nome);

        System.out.print("Quantidade: ");
        int quantidade = lernum.nextInt();
        novo.setQuantidade(quantidade);

        produtos.add(novo);
        System.out.println("Prodturo cadastrado com sucesso!");

    }

////////////////////////////// MÉTODO PARA LISTAR PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void listaProdutos() throws IOException {
        Collections.sort(produtos);
        System.out.println("\nLISTA DE PRODUTOS: ");
        if (produtos.isEmpty()) {
            System.out.println("Ainda sem produtos!");
        }
        for (Produto produto : produtos) {
            System.out.println(produto.dadosFormatados());
        }
        opcoes();
    }

    ////////////////////////////// MÉTODO DE INICIO DO SISTEMA \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public void intro() throws IOException {
        int opcoes;

        do {

            System.out.println("\n" + vermelho + "***********************************" + limpo + " CONTROLE DE ESTOQUE " + vermelho + "*************************************" + limpo);
            System.out.println(vermelho + "***" + limpo + " 1  - Listar     2 - Adicionar      3 - Sair      4  - Ler arquivo      5 - Relatório  " + vermelho + "***");
            System.out.println(vermelho + "*********************************************************************************************" + limpo);
            System.out.print("\nEscolha uma das opções: ");
            opcoes = lernum.nextInt();

            switch (opcoes) {
                case 1:
                    listaProdutos();
                    break;
                case 2:
                    addProduto();
                    break;
                case 3:
                    System.out.println("Hasta la vista Baby!");
                    break;
                case 4:
                    lerRelatorio();
                    break;

                case 5:
                    relatorio();
                    break;
            }
        } while (opcoes != 3);
    }

////////////////////////////// MÉTODO DAS OPÇOES DE PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void opcoes() throws IOException {
        int escolha;
        System.out.println("\n" +amarelo+ "**************************" + limpo + " OPÇÕES DO PRODUTO " +amarelo+"*************************" + limpo);
        System.out.println( amarelo +"** " + limpo + "1  - Excluir       2 - Editar        3 - Voltar       4 - Salvar" +  amarelo +" **" + limpo);
        System.out.println(amarelo+"**********************************************************************"+ limpo);
        System.out.print("\nEscolha uma das opçôes: ");
        escolha = lernum.nextInt();

        switch (escolha) {
            case 1:
                excluirProduto();
                break;
            case 2:
                editarProduto();
                break;
            case 3:
                break;
            case 4:
                salvaRelatorio();
                break;
        }
    }

////////////////////////////// MÉTODO PARA EXCLUSÃO DE PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void excluirProduto() {
        System.out.print("\nDigite o ID do prodtuto: ");
        String id = lerstr.nextLine();
        for (int i = 0; i < produtos.size(); i++) {
            if (id.equals(produtos.get(i).getId())) {
                System.out.println("Você realmente deseja excluir " + produtos.get(i).getNome() + "?");
                System.out.println("\t\t\t1 - SIM        2 - NÃO");
                int escolha = lernum.nextInt();
                if (escolha == 1) {
                    produtos.remove(i);
                    System.out.println("Produto foi removido da lista.");
                } else {
                    break;
                }
            }
        }
    }

////////////////////////////// MÉTODO PARA EDIÇÃO DE PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void editarProduto() {
        System.out.println("Você deseja editar: ");
        System.out.println("\t\t\t1 - NOME        2 - QUANTIDADE        3 - VOLTAR\n");
        int opcoes = lernum.nextInt();

        switch (opcoes) {
            case 1:
                editarNome();
                break;
            case 2:
                editarQuantidade();
                break;
            case 3:
                break;
        }
    }

////////////////////////////// MÉTODO PARA EDIÇÃO DO NOME PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void editarNome() {
        System.out.println("Digite o ID do produto: ");
        String id = lerstr.nextLine();
        for (int i = 0; i < produtos.size(); i++) {
            if (id.equals(produtos.get(i).getId())) {
                System.out.println("Novo nome para " + produtos.get(i).getNome());
                String nome = lerstr.nextLine();
                produtos.get(i).setNome(nome);
                System.out.println("O nome foi alterado para: " + produtos.get(i).getNome());
            } else {
                break;
            }
        }
    }

////////////////////////////// MÉTODO PARA EDIÇÃO DA QUANTIDADE DO PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void editarQuantidade() {
        System.out.println("Digite o ID do produto: ");
        String id = lerstr.nextLine();
        for (int i = 0; i < produtos.size(); i++) {
            if (id.equals(produtos.get(i).getId())) {
                System.out.println("Nova quantidade para " + produtos.get(i).getNome());
                int quantidade = lernum.nextInt();
                produtos.get(i).setQuantidade(quantidade);
                System.out.println("A quantidade foi alterada para: " + produtos.get(i).getQuantidade());
            } else {
                break;
            }
        }
    }

////////////////////////////// MÉTODO PARA IMPRIMIR O RELATÓRIO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void relatorio() throws IOException {
        int total = 0;
        if (produtos.isEmpty()) {
            System.out.println("\t\t\tSem dados suficientes!\n");
        } else {
            System.out.println("\n---------------- RELATÓRIO ----------------");
            System.out.println("|        NOME        |     QUANTIDADE     |");
            System.out.println("-------------------------------------------");

            for (int i = 0; i < produtos.size(); i++) {
                System.out.println("|" + produtos.get(i).getNome() + "             |" + produtos.get(i).getQuantidade() + "                |");
            }
            System.out.println("-------------------------------------------");
        }
        total = totalProdutos();
        System.out.println("\nQuantidade total de produtos: " + total + "\n");
        opcoesRelatorio();
    }

////////////////////////////// MÉTODO PARA SOMAR TOTAL DE PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public int totalProdutos() {
        int soma = 0;
        for (int i = 0; i < produtos.size(); i++) {
            soma = soma + produtos.get(i).getQuantidade();
        }

        return soma;
    }

////////////////////////////// MÉTODO DE OPÇÕES DE RELATÓRIO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void opcoesRelatorio() throws IOException {
        int escolha;
        System.out.println("\n********* OPÇÕES DE RELATÓRIO ***********");
        System.out.println("** 1  - Salvar       2 - Voltar          **");
        System.out.println("*******************************************");
        System.out.print("\nEscolha uma das opçôes: ");
        escolha = lernum.nextInt();

        switch (escolha) {
            case 1:
                salvaRelatorio();
            case 2:
                break;
        }
    }

////////////////////////////// MÉTODO PARA SALVAR O RELATÓRIO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void salvaRelatorio() throws IOException {
        System.out.print("Digite o nome do arquivo: ");
        String nome = lerstr.nextLine();

        FileWriter arquivo = new FileWriter("d:\\" + nome + ".txt");
        PrintWriter gravarArq = new PrintWriter(arquivo);
        
        gravarArq.printf("\t\t\t\tRELATÓRIO %n");
        for (Produto produto : produtos) {
            gravarArq.printf("| %s | %d |", produto.getNome(), produto.getQuantidade());
        }

        arquivo.close();
        System.out.println("Relatório salvo em d:\\" + nome + ".\n");
    }

////////////////////////////// MÉTODO PARA LER ALGUM ARQUIVO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void lerRelatorio() throws IOException {
        System.out.print("Digite o nome do arquivo a ser lido: ");
        String nome = lerstr.nextLine();

        BufferedReader buffRead = new BufferedReader(new FileReader("d:\\" + nome + ".txt"));
        String linha = "";

        while (true) {
            if (linha != null) {
                System.out.println(linha);
            } else {
                break;
            }
            linha = buffRead.readLine();
        }

        buffRead.close();
    }


}
