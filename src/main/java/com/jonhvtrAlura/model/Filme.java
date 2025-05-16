package com.jonhvtrAlura.model;

import com.jonhvtrAlura.service.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme() {
    }

    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    @Override
    public void exibeFichaTecnica() {
        super.exibeFichaTecnica();
        System.out.println("Diretor: " + diretor);
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ") ";
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }
}
