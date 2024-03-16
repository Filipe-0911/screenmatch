package br.com.alura.screenmatch.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonPrettyPrinting {
    private Gson gson;

    public GsonPrettyPrinting() {
        gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();
    }

    public Gson getGson() {
        return this.gson;
    }
}
