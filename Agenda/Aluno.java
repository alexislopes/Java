package br.com.fatec;

public class Aluno extends Pessoa {
    private long numeroMatricula;

    public Aluno() {
        super();
    }

    @Override
    public String dadosFormatados() {
        String dadosFormatados = super.dadosFormatados();
        dadosFormatados = dadosFormatados + "\n\tMatricula: " + this.getNumeroMatricula();
        return dadosFormatados;
    }

    public long getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(long numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
}
