package br.com.conversor_de_moedas.helpers;

import br.com.conversor_de_moedas.enums.CurrencyOptions;
import br.com.conversor_de_moedas.records.CurrencyPairRecord;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyRequest {
    public static CurrencyPairRecord getCurrencyConversion(CurrencyOptions from, CurrencyOptions to) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        String url = "https://v6.exchangerate-api.com/v6/da2c6d9c15752ba0f8b46d00/pair/" + from + "/" + to;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), CurrencyPairRecord.class);
    }

}
