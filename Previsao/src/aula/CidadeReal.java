package aula;

import xml.Cidade;

public class CidadeReal {


    private String atualizacao;
    private String id;
    private String nome;
    private String uf;

    public void cidadeReal(Cidade c){
        this.id = c.getId();
        this.nome = c.getNome();
        this.uf = c.getUf();

    }

    public String getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(String atualizacao) {
        this.atualizacao = atualizacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "CidadeReal{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
