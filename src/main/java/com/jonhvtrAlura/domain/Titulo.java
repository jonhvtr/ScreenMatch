package com.jonhvtrAlura.domain;

import com.google.gson.annotations.SerializedName;
import com.jonhvtrAlura.domain.dto.TituloOmdb;
import com.jonhvtrAlura.exception.ErroConversaoAnoException;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo() {
    }

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meutituloOmdb) {
        this.nome = meutituloOmdb.title();
        if (meutituloOmdb.year().length() > 4) {
            throw new ErroConversaoAnoException("Não consegui converter o ano");
        }
        this.anoDeLancamento = Integer.parseInt(meutituloOmdb.year());
        this.duracaoEmMinutos = Integer.parseInt(meutituloOmdb.runtime().substring(0, 2));
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
        System.out.println("Duração: " + getDuracaoEmMinutos() + "min");
        System.out.println("Total de Avalições: " + totalDeAvaliacoes);
        System.out.println(String.format("Média das Avaliações: %.1f", pegaMedia()));
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public double getSomaDasAvaliacoes() {
        return somaDasAvaliacoes;
    }

    public void setSomaDasAvaliacoes(double somaDasAvaliacoes) {
        this.somaDasAvaliacoes = somaDasAvaliacoes;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(Nome: " + nome + ", Ano de Lançamento: " + anoDeLancamento +
                ", Duração em minutos: " + duracaoEmMinutos + ")";
    }
}
