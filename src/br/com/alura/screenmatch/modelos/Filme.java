package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    public Filme(String nome, int anoDeLancamento, int duracaoEmMinutos) {
        super(nome, anoDeLancamento);
        this.setDuracaoEmMinutos(duracaoEmMinutos);
    }
    private String diretor;
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }
}
