package com.jonhvtrAlura.principal;

import com.jonhvtrAlura.domain.Episodio;
import com.jonhvtrAlura.domain.Filme;
import com.jonhvtrAlura.domain.Serie;
import com.jonhvtrAlura.service.CalculadoraTempo;
import com.jonhvtrAlura.service.FiltroRecomendacao;

import java.util.ArrayList;

public class PrincipalMain {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.setDuracaoEmMinutos(180);
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        meuFilme.setDiretor("Carlos Braga");

        meuFilme.exibeFichaTecnica();

        System.out.println("--------------------------");

        Serie minhaSerie = new Serie("La casa del papelitos", 2025);
        minhaSerie.avalia(8);
        minhaSerie.avalia(9);
        minhaSerie.avalia(10);
        minhaSerie.setEpisodiosPorTemporada(10);
        minhaSerie.setMinutosPorEpisodios(40);
        minhaSerie.setTemporadas(8);
        minhaSerie.exibeFichaTecnica();

        System.out.println("-------------------------------");

        Filme meuFilme2 = new Filme("O poderoso chefinho", 2019);
        meuFilme2.setAnoDeLancamento(2019);
        meuFilme2.setDuracaoEmMinutos(190);

        CalculadoraTempo calc = new CalculadoraTempo();
        calc.inclui(minhaSerie);
        System.out.println(calc.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(minhaSerie);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoP = new Filme("Dogville", 2003);
        filmeDoP.setDuracaoEmMinutos(200);
        filmeDoP.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoP);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(meuFilme2);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes.toString());
    }
}
