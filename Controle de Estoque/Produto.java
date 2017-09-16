package br.com.fatec;

public class Produto implements Informacao, Comparable<Produto> {
    private String nome;
    private int quantidade;
    private String id = "P";


    public Produto() {
        this.nome = nome;
        this.quantidade = quantidade;
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String dadosFormatados() {
        String dadosFormatados;
        dadosFormatados = "\n\tID: " + this.getId();
        dadosFormatados = dadosFormatados + "\n\tNome: " + this.getNome();
        dadosFormatados = dadosFormatados + "\n\tQuantidade: " + this.getQuantidade();

        return dadosFormatados;
    }

    @Override
    public String relatorio() {
        String relatorio = " ";
        relatorio = relatorio + this.getNome();
        relatorio = relatorio + this .getQuantidade();

        return relatorio;
    }


    @Override
    public int compareTo(Produto o) {
        return nome.compareTo(o.getNome());
    }

    @Override
    public boolean equals(Object obj){
        Produto outro = (Produto) obj;
        return(nome.equals(outro.getNome()));
    }
}


