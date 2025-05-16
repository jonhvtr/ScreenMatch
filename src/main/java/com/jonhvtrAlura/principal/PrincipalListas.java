package com.jonhvtrAlura.principal;

import com.jonhvtrAlura.model.Filme;
import com.jonhvtrAlura.model.Serie;
import com.jonhvtrAlura.model.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Filme meuFilme2 = new Filme("Avatar 3", 2023);
        meuFilme2.avalia(8.7);
        var filmeDoP = new Filme("Dogville", 2003);
        filmeDoP.avalia(10);
        Serie minhaSerie = new Serie("La casa del papelitos", 2025);
        minhaSerie.avalia(10);

        List<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoP);
        lista.add(meuFilme);
        lista.add(meuFilme2);
        lista.add(minhaSerie);
        for (Titulo item : lista) {
            System.out.println(item);
            if (item instanceof Filme filmes && filmes.getClassificacao() > 2) {
                System.out.println("Classificação: " + filmes.getClassificacao());
            }
        }

        // Ordenação de Listas
        System.out.println("----------Ordenando a lista----------");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("----------Ordenando por ano de lançamento----------");
        System.out.println(lista);
    }
}
