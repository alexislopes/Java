package br.com.fatec;

public abstract class Pessoa implements Contato {
    private String nome, email;
    private long telefone;

    @Override
    public String dadosFormatados() {
        String dadosFormatados;
        dadosFormatados = "\n\tNome: " + this.getNome();
        dadosFormatados = dadosFormatados + "\n\tTelefone: " + this.getTelefone();
        dadosFormatados = dadosFormatados + "\n\tEmail: " + this.getEmail();

        return dadosFormatados;
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
