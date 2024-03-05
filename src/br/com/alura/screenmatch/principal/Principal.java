package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão",1970, 180);
        Filme outroFilme = new Filme("Avatar", 2023, 180);
        Filme filmeDoFilipe = new Filme("Dogville", 2003, 200);
        Serie lost = new Serie("Lost",2004,10,10,50);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        meuFilme.avalia(3.3);

        System.out.println(meuFilme.pegaMedia());
        System.out.println(meuFilme.getTotalDeAvaliacoes());

        System.out.println("Duração em minutos " + lost.getDuracaoEmMinutos());;
        lost.exibeFichaTecnica();

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println((calculadora.getTempoTotal()));

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        filmeDoFilipe.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>(10);
        listaDeFilmes.add(filmeDoFilipe);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);

        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme da lista: " + listaDeFilmes.get(0).getNome());

        for(Filme filme : listaDeFilmes) System.out.println(filme);

        System.out.println(lost);
    }
}