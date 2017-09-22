package Trab;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private String nome;
    private List<String> teg;
    private int quantidade;
    private double preco;
    private List<String> coment = new ArrayList<>();

    public Produto(String nome, List<String> teg, int quantidade, float preco){
        this.nome=nome;
        this.teg=teg;
        this.quantidade=quantidade;
        this.preco=preco;
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
        for(int i=0;i<teg.size();i++)
            if(teg.get(i).equals(nome))
                teg.remove(i);
    }
    public void addQuantidade(int qnt) {
        this.quantidade+=qnt;
    }
    public void decressQuantidade (int qnt) {
        this.quantidade-=qnt;
    }


}
