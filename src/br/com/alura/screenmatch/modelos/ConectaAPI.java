package br.com.alura.screenmatch.modelos;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConectaAPI {
    private String url = "https://www.omdbapi.com/?t=%s&apikey=%s";
    private String filmeParaBuscar;
    private String apiKey = _getApiKey();
    private String jsonRetornado;

    public ConectaAPI(String filmeParaBuscar) {  
        this.filmeParaBuscar = filmeParaBuscar.replaceAll(" ", "+");
        this.url = this.url.formatted(this.filmeParaBuscar, apiKey);
        
        _conectaApi(this.url);
    }

    private void _conectaApi(String url2) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(this.getUrl()))
            .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            jsonRetornado = json;

        } catch(IllegalArgumentException i) {
            System.out.println("Verifique o nome do filme: " + this.getFilmeParaBuscar());

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String _getApiKey() {
        Properties propriedades = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(".env");
            propriedades.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return propriedades.getProperty("API_KEY");
    }

    public String getUrl() {
        return this.url;
    }

    public String getFilmeParaBuscar() {
        return filmeParaBuscar;
    }

    public String getJsonRetornado() {
        return jsonRetornado;
    }

    @Override
    public String toString() {
        return this.getJsonRetornado();
    }

}
