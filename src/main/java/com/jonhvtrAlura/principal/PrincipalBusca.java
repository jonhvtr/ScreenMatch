package com.jonhvtrAlura.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jonhvtrAlura.domain.Titulo;
import com.jonhvtrAlura.domain.dto.TituloOmdb;
import com.jonhvtrAlura.exception.ErroConversaoAnoException;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca:");
        var busca = leitura.nextLine();
        String query = URLEncoder.encode(busca, StandardCharsets.UTF_8);

        // OBS: Na query também poderia ser usado de uma maneira mais simples com busca.replace(" ", "+")
        String endereco = "http://www.omdbapi.com/?t=" + query + "&apikey=f5f71bed";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);
            System.out.println("------------------------");


            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);
        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Algum erro de argumento na busca, verifique o endereco");
        } catch (ErroConversaoAnoException e) {
            System.out.println(e.getMessage());
        }
    }
}
