package br.com.fatec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
    Produto novo;
    Mercado mercado;
    private List<Produto> produtos = new ArrayList<>();

    String verdim = "\033[36m";
    String limpo = "\033[m";
    String vermelho = "\033[31m";
    String verde = "\033[32m";
    String amarelo = "\033[33m";

    Scanner lerstr = new Scanner(System.in);
    Scanner lernum = new Scanner(System.in);


//////////////////////////////////// MÉTODOS PARA VERIFICAR EXISTENCIA DE UM PRODUTO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public boolean verifNome(String nome) {
        for (int c = 0; c < produtos.size(); c++) {
            if (produtos.get(c).getNome().equals(nome))
                return true;
        }
        return false;
    }


//////////////////////////////////////////// MÉTODOS PARA ADICIONAR PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private int intid = 0;

    public void addProduto() {
        String nome;
        boolean valid = false;
        ArrayList<String> tags = new ArrayList<>();

        intid = intid + 1;

        do {
            if (valid) {
                System.out.println(vermelho + "Esse produtp já existe!\n" + limpo);
            }
            System.out.print("Digite um nome para o produto: ");
            nome = lerstr.nextLine();
            valid = verifNome(nome);
        } while (valid);
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = lernum.nextInt();

        System.out.print("Digite o preço do produto: ");
        double preco = lernum.nextDouble();

        int option;
        System.out.println("Deseja adidcionar algumas tags? ");
        System.out.print("\t1 - SIM    2 - NÃO");
        option = lernum.nextInt();
        if (option == 1) {
            String tag;
            int qtdade;
            System.out.print("Quantas? ");
            qtdade = lernum.nextInt();
            for (int i = 0; i < qtdade; i++) {
                System.out.print("Digite a tag: ");
                tag = lerstr.nextLine();
                tags.add(tag);
            }
        } else {
            System.out.println(verde + "Tudo bem, você pode adicionar mais tarde!" + limpo);
        }

        novo = new Produto(nome, tags, quantidade, preco, intid);
        produtos.add(novo);
        System.out.println(verdim + "\nProduto cadastrado com sucesso!\n" + limpo);
    }


////////////////////////////////////////////// VERIFICAR QUANTIDADE \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public boolean verificarQuantidade(int id, int qtd) {
        int qtdn;

        for (Produto produto : produtos)
            if (id == produto.getId()) {
                qtdn = produto.getQuantidade();
                if (qtd <= qtdn) {
                    return true;
                } else {
                    return false;
                }
            }
        return false;
    }

///////////////////////////////////////////// MÉTODOS PARA VARRER PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void varrerProduto() {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getQuantidade() == 0) {
                produtos.remove(i);
            }
        }
    }

///////////////////////////////////////////// MÉTODO PARA EDITAR PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void editarProduto() {

        System.out.println("****************** EDITAR QUAL ATRIBUTO? *******************");
        System.out.println("**   1 - NOME   2 - QUANTIDADE   3 - PREÇO   4 - VOLTAR   **");
        System.out.println("************************************************************");
        int option = lernum.nextInt();

        switch (option) {
            case 1:
                editarNome();
                break;

            case 2:
                editarQtd();
                break;

            case 3:
                editarPreco();
                break;

            case 4:
                break;


        }
    }


////////////////////////////////////////// MÉTODO PARA EDITAR NOME DO PRODUTO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void editarNome() {
        System.out.println("Digite o ID do produto: ");
        int idprod = lernum.nextInt();
        for (Produto produto : produtos) {
            if (idprod == produto.getId()) {
                System.out.println("Novo nome para " + produto.getNome() + ":");
                String nome = lerstr.nextLine();
                produto.setNome(nome);
                System.out.println(verdim + "Nome alterado para: " + produto.getNome() + limpo);
            }
        }

    }

////////////////////////////////////// MÉTODO PARA EDITAR QUANTIDADE DO PRODUTO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void editarQtd() {
        System.out.println("Digite o ID do produto: ");
        int idprod = lernum.nextInt();
        for (Produto produto : produtos) {
            if (idprod == produto.getId()) {
                System.out.println("Nova quantidade para " + produto.getNome() + ":");
                int quantidade = lerstr.nextInt();
                produto.setQuantidade(quantidade);
                System.out.println(verdim + "Quanridade alterada para: " + produto.getQuantidade() + limpo);
            }
        }

    }

///////////////////////////////////////// MÉTODO PARA EDITAR PRECO DO PRODUTO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void editarPreco() {
        System.out.println("Digite o ID do produto: ");
        int idprod = lernum.nextInt();
        for (Produto produto : produtos) {
            if (idprod == produto.getId()) {
                System.out.println("Novo preço para " + produto.getNome() + ":");
                double preco = lernum.nextDouble();
                produto.setPreco(preco);
                System.out.println(verdim + "Preço alterado para: " + produto.getPreco() + limpo);
            }
        }

    }

///////////////////////////////////////// ################################### \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
