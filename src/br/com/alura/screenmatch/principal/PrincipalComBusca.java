package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.ConectaAPI;
import br.com.alura.screenmatch.modelos.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.EscreveJson;
import br.com.alura.screenmatch.modelos.GsonPrettyPrinting;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> listaTitulo = new ArrayList<>();

        Gson gson = new GsonPrettyPrinting().getGson();
        
        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para busca ou Digite sair: ");
            busca = leitura.nextLine().toLowerCase();
            if (busca.equals("sair")) break;

            try {
                String json = new ConectaAPI(busca).getJsonRetornado();
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                listaTitulo.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ocorreu um erro, verifique o endereço de busca.");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e);
            } finally {
                System.out.println("O programa finalizou corretamente");
            }
        }

        leitura.close();
        EscreveJson escreve = new EscreveJson("titulos.json", listaTitulo);
        escreve.escreve();
    }
}
