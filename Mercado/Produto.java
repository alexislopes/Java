package Trab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {
    Scanner lernum = new Scanner(System.in);
    Scanner lerstr = new Scanner(System.in);

    Estoque e = new Estoque();

    private String id = "P";
    private int intid;
    private String nome;
    private List<String> teg;
    private int quantidade;
    private double preco;
    private List<String> coment = new ArrayList<>();

    String verdim = "\033[36m";
    String amarelo = "\033[33m";
    String limpo = "\033[m";
    String verde = "\033[32m";
    String vermelho = "\033[31m";

    public Produto(String nome, List<String> teg, int quantidade, double preco, int intid) {
        this.id = id + intid;
        this.nome = nome;
        this.teg = teg;
        this.quantidade = quantidade;
        this.preco = preco;
    }

/////////////////////////////////////////// MÉTODOS PARA LISTAR COMENTÁRIOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void listarCommment() {
        if (coment.isEmpty()) {
            System.out.println(vermelho + "Ainda não há nenhumm comentário!" + limpo);
        } else {
            System.out.println(amarelo + "COMENTÁRIOS" + limpo);
            for (String comment : coment) {
                System.out.println(comment);
            }
        }
    }

///////////////////////////////////////////// MÉTODOS DE OPÇÕES DE PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void opcoesDeProd() {
        int option;
        do {
            System.out.println("********************** OPÇÕES DE PRODUTO *******************");
            System.out.println("**   1 - COMPRAR   2 - COMENTAR   3 - VOLTAR   4 - INFO   **");
            System.out.println("************************************************************");
            option = lernum.nextInt();

            switch (option) {
                case 1:
                    e.comprarProduto();
                    break;

                case 2:
                    commentProd();
                    break;

                case 3:
                    break;

                case 4:
                    e.informacaoProduto();
                    break;
            }
        } while (option != 3);
    }

//////////////////////////////// MÉTODO DE FORMATAÇÃO DE DADOS DO PRODUTO PARA LISTAGEM \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    public String dadosFormatados() {

        String dadosFormatados;
        dadosFormatados = "ID: " + getId();
        dadosFormatados = dadosFormatados + "\nNome: " + getNome();
        dadosFormatados = dadosFormatados + "\nQuantidade: " + getQuantidade();
        dadosFormatados = dadosFormatados + "\nPreço: R$" + getPreco() + "\n";

        return dadosFormatados;
    }

///////////////////////////////////////////// MÉTODO PARA COMENTAR PRODUTOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void commentProd() {

        String idProd;
        String comment;

        System.out.println("Digite o ID do produto: ");
        idProd = lerstr.nextLine();
        for (int i = 0; i < e.getProdutos().size(); i++) {
            if (idProd.equals(e.getProdutos().get(i).getId())) {
                System.out.println("Digite seu comentário: ");
                comment = lerstr.nextLine();
                e.getProdutos().get(i).coment.add(comment);
            }
        }
        System.out.println(verdim + "Seu comentário foi adicionado ao produto, Obrigado!" + limpo);
    }

//////////////////////////////////////////// MÉTODO DE INFORMAÇÕES DO PRODUTO \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void infoProd() {
        System.out.print("Digite o ID do produto: ");
        String id = lerstr.nextLine();
        for (int i = 0; i < e.getProdutos().size(); i++) {
            if (e.getProdutos().get(i).getId().equals(id)) {
                System.out.println(e.getProdutos().get(i).dadosFormatados());
                e.getProdutos().get(i).listarCommment();
            }
        }

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getTeg() {
        return teg;
    }

    public void setTeg(List<String> teg) {
        this.teg = teg;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public List<String> getComent() {
        return coment;
    }

    public void setComent(List<String> coment) {
        this.coment = coment;
    }

    public void addComent(String coment) {
        this.coment.add(coment);
    }

    public void removeComent(int posi) {
        this.coment.remove(posi);
    }

    public void addTeg(String teg) {
        this.teg.add(teg);
    }

    public void decressTeg(String nome) {
        for (int i = 0; i < teg.size(); i++)
            if (teg.get(i).equals(nome))
                teg.remove(i);
    }

    public void addQuantidade(int qnt) {
        this.quantidade += qnt;
    }

    public void decressQuantidade(int qnt) {
        this.quantidade -= qnt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
