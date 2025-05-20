package com.jonhvtrAlura.service;

import com.jonhvtrAlura.domain.Titulo;

public class CalculadoraTempo {
    private int tempoTotal;

    public void inclui(Titulo titulo) {
        tempoTotal += titulo.getDuracaoEmMinutos();
    }

    public int getTempoTotal() {
        return tempoTotal;
    }
}
