package br.maua.api;

import br.maua.json.ArrayParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    ArrayParser arrayParser;

    public void leituraAPIAnime(String nome) throws Exception {
        arrayParser = new ArrayParser();

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(
                "https://api.jikan.moe/v3/search/anime?q=" + nome)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Recebidos");
        System.out.println(arrayParser.parseJsonAnime(response.body()));
    }

    public void leituraAPIManga(String nome) throws Exception {
        arrayParser = new ArrayParser();

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(
                "https://api.jikan.moe/v3/search/manga?q=" + nome)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Recebidos");
        System.out.println(arrayParser.parseJsonManga(response.body()));
    }
}
