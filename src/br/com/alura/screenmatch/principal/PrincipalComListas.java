package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão",1970, 180);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023, 180);
        outroFilme.avalia(6);
        Filme filmeDoFilipe = new Filme("Dogville", 2003, 200);
        filmeDoFilipe.avalia(10);

        Serie lost = new Serie("Lost",2004,10,10,50);

        List<Titulo> lista = new ArrayList<>(10);

        lista.add(filmeDoFilipe);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
//        lista.forEach(filme -> Titulo instanceof Filme filme ? System.out.println(filme));
        //nomes.forEach(System.out::println);

        for(Titulo titulo : lista) {
            if (titulo instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println(filme.getNome() + ": " + "Classificação " + filme.getClassificacao());
            }

        }

        List<String> buscaPorArtista = new LinkedList<>();

        buscaPorArtista.add("Olavo");
        buscaPorArtista.add("Ianca");
        buscaPorArtista.add("Filipe");
        buscaPorArtista.add("Adam Sandler");

        System.out.println(lista);

        Collections.sort(lista);

        System.out.println(lista);
        //Metodo de comparação utilizando lambda function
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);


    }
}
