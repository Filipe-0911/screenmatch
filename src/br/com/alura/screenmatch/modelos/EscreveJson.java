package br.com.alura.screenmatch.modelos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

public class EscreveJson {

    private FileWriter escrita;
    private String nomeDoArquivo;
    private List<Titulo> lista;
    Gson gson = new GsonPrettyPrinting().getGson();

    public EscreveJson(String nomeDoArquivo, List<Titulo> lista) throws IOException {
        this.nomeDoArquivo = nomeDoArquivo;
        this.lista = lista;
        this.escrita = new FileWriter(this.nomeDoArquivo);
 
    }

    public void escreve() throws IOException {
        this.escrita.write(gson.toJson(this.lista));
        escrita.close();
        System.out.println(this.lista);
    }


        

}
