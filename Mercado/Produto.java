package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private int id = 0;
    private String nome;
    private List<String> tegs;
    private int quantidade;
    private double preco;
    private List<String> coments = new ArrayList<>();

    public Produto(String nome, List<String> tegs, int quantidade, double preco, int intid) {
        this.id = id + intid;
        this.nome = nome;
        this.tegs = tegs;
        this.quantidade = quantidade;
        this.preco = preco;
    }

//////////////////////////////// MÉTODO DE FORMATAÇÃO DE DADOS DO PRODUTO PARA LISTAGEM \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    public String dadosFormatados() {

        String dadosFormatados;
        dadosFormatados = "ID: " + getId();
        dadosFormatados = dadosFormatados + "\nNome: " + getNome();
        dadosFormatados = dadosFormatados + "\nQuantidade: " + getQuantidade();
        dadosFormatados = dadosFormatados + "\nPreço: R$ " + getPreco() + "\n";

        return dadosFormatados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getTegs() {
        return tegs;
    }

    public void setTegs(List<String> tegs) {
        this.tegs = tegs;
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

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<String> getComents() {
        return coments;
    }

    public void setComents(List<String> coments) {
        this.coments = coments;
    }

    public void addComent(String coment) {
        this.coments.add(coment);
    }

    public void removeComent(int posi) {
        this.coments.remove(posi);
    }

    public void addTeg(String teg) {
        this.tegs.add(teg);
    }

    public void decressTeg(String nome) {
        for (int i = 0; i < tegs.size(); i++)
            if (tegs.get(i).equals(nome))
                tegs.remove(i);
    }

    public void addQuantidade(int qnt) {
        this.quantidade += qnt;
    }

    public void decressQuantidade(int qnt) {
        this.quantidade -= qnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
