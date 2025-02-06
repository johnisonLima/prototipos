package com.novaesquadria.model;

import java.util.ArrayList;
import java.util.List;

import com.novaesquadria.model.observer.Observer;

public class Estoque {
    private int quantidade; // Nível atual do estoque
    private final List<Observer> observadores = new ArrayList<>();

    public Estoque(int quantidadeInicial) {
        this.quantidade = quantidadeInicial;
    }

    public void adicionarObservador(Observer observador) {
        observadores.add(observador);
    }

    public void alterarQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
        notificarObservadores();
    }

    public int getQuantidade() {
        return quantidade;
    }

    private void notificarObservadores() {
        for (Observer obs : observadores) {
            obs.atualizar(this);
        }
    }
}