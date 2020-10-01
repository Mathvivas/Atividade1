package br.maua.api;

import br.maua.json.ArrayParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe que se conecta com a API.
 * @author Gabriel de Godoy Braz - 17.00163-3
 * @author Matheus Lopes Vivas - 17.04401-4
 */
public class API {
    ArrayParser arrayParser;

    /**
     *
     * @param nome Nome do Anime desejado pelo usuário.
     * @throws Exception Evitar que o programa pare de executar caso encontre uma exceção.
     */
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

    /**
     *
     * @param nome Nome do Mangá desejado pelo usuário.
     * @throws Exception Evitar que o programa pare de executar caso encontre uma exceção.
     */
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
