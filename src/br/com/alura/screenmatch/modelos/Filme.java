package br.com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    @SerializedName("Director")
    private String diretor;
    @SerializedName("Plot")
    private String descricao;
    
    
    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
        
    }
    
    public String getDiretor() {
        return diretor;
    }
    
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
    public String getDescricao() {
        return descricao;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }
    
    @Override
    public String toString() {
        String stringoDoFilme = 
        "Nome: %s; Ano de lançamento: %d; Diretor: %s; Descrição: %s"
        .formatted(this.getNome(), this.getAnoDeLancamento(), this.getDiretor(), this.getDescricao());
        return stringoDoFilme;
    }
}
