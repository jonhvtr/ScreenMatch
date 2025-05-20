package com.jonhvtrAlura.principal;

import com.google.gson.Gson;
import com.jonhvtrAlura.model.Titulo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new Gson();
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca:");
        var busca = leitura.nextLine();

        String endereco = "http://www.omdbapi.com/?t=" + busca + "&apikey=f5f71bed";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

        Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        System.out.println(meuTitulo.toString());
    }
}
