package Trab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {

    String verdim = "\033[36m";
    String limpo = "\033[m";
    String vermelho = "\033[31m";
    String verde = "\033[32m";

    Scanner in = new Scanner(System.in);
    Scanner innum = new Scanner(System.in);
    private List<Produto> produtos = new ArrayList<>();



    public boolean verifNome(String nome) {
        for (int c = 0; c < produtos.size(); c++) {
            if (produtos.get(c).getNome().equals(nome))
                return true;
        }
        return false;
    }

    /*public void criarProduto() {
        boolean c = true;
        String nome = "";
        List<String> teg;
        while (c) {
            System.out.print("Digite o nome do Produto: ");
            nome = in.next();
            if (verifNome(nome)) {
                System.out.println(vermelho + "Ja existe este produto!" + limpo);
                break;
            }
        }
        teg = criarTeg();
        System.out.print("Digite a quantidade: ");
        int quantidade = in.nextInt();
        System.out.print("Digite o preco: ");
        float preco = in.nextFloat();
        Produto prod = new Produto(nome, teg, quantidade, preco);
        produtos.add(prod);
        System.out.println(verdim + "\nProduto cadastrado com sucesso!" + limpo);
    }*/

// MÉTODO ATUALIZADO PARA ADD PRODUTO

    public void addProduto() {
        String nome;
        boolean valid = false;
        ArrayList<String> tags = new ArrayList<>();

        do {
            if (valid){
                System.out.println(vermelho + "Esse produtp já existe!\n" + limpo);
            }
            System.out.print("Digite um nome para o produto: ");
            nome = in.nextLine();
            valid = verifNome(nome);
        } while (valid);
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = innum.nextInt();

        System.out.print("Digite  o preço do produto: ");
        double preco = innum.nextDouble();

        int option;
        System.out.println("Deseja adidcionar algumas tags? ");
        System.out.print("\t1 - SIM    2 - NÃO");
        option = innum.nextInt();
        if (option == 1) {
            String tag;
            int qtdade;
            System.out.print("Quantas? ");
            qtdade = innum.nextInt();
            for (int i = 0; i < qtdade; i++) {
                System.out.print("Digite a tag: ");
                tag = in.nextLine();
                tags.add(tag);
            }
        } else {
            System.out.println(verde + "Tudo bem, você pode adicionar mais tarde!" + limpo);
        }

        Produto novo = new Produto(nome, tags, quantidade, preco);
        produtos.add(novo);
        System.out.println(verdim + "\nProduto cadastrado com sucesso!\n" + limpo);
    }

// MÉTODOS PARA LISTAR PRODUTOS

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println(verde + "Ainda não há nenhum produto\n" + limpo);
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto.dadosFormatados());
            }
        }
    }

    public void excluirProduto(String nome) {
        for (int c = 0; c < produtos.size(); c++)
            if (produtos.get(c).equals(nome))
                produtos.remove(c);
    }

    public List<String> criarTeg() {
        boolean c = true;
        List<String> teg = new ArrayList<>();
        while (c) {
            System.out.println("Digite as teg's a serem vinculadas");
            teg.add(in.next());
            System.out.println("Deseja vincular outra teg? 1-sim/qualquer outro numero-nao");
            int resp = in.nextInt();
            if (resp != 1)
                c = false;
        }
        return teg;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
