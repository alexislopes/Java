package br.com.fatec;

public class Professor extends Pessoa {
    private long numeroRegistro;
    private int quantidadeHoraAula;

    public Professor() {
        super();
    }

    @Override
    public String dadosFormatados() {
        String dadosFormatados = super.dadosFormatados();
        dadosFormatados = dadosFormatados + "\n\tRegistro: " + this.getNumeroRegistro();
        dadosFormatados = dadosFormatados + "\n\tHora/Aula: " + this.getQuantidadeHoraAula();

        return dadosFormatados;
    }

    public long getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(long numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public int getQuantidadeHoraAula() {
        return quantidadeHoraAula;
    }

    public void setQuantidadeHoraAula(int quantidadeHoraAula) {
        this.quantidadeHoraAula = quantidadeHoraAula;
    }
}
