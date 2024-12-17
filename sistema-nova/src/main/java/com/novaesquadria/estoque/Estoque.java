package main.java.com.novaesquadria.estoque;

import java.util.ArrayList;
import java.util.List;

import main.java.com.novaesquadria.estoque.observer.Observer;

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

/* 
 Este código define uma classe chamada Estoque que gerencia a quantidade de um item em estoque e notifica observadores sobre mudanças nessa quantidade. Aqui está uma descrição detalhada:

Construtor Estoque(int quantidadeInicial): Inicializa a quantidade de estoque com o valor fornecido (quantidadeInicial).

Método adicionarObservador(Observer observador): Adiciona um observador à lista de observadores. Os observadores são objetos que implementam a interface Observer e que serão notificados quando a quantidade de estoque mudar.

Método alterarQuantidade(int novaQuantidade): Altera a quantidade de estoque para o valor fornecido (novaQuantidade) e chama o método notificarObservadores() para notificar todos os observadores sobre a mudança.

Método getQuantidade(): Retorna a quantidade atual de estoque.

Método notificarObservadores(): Notifica todos os observadores na lista de observadores chamando o método atualizar(this) em cada um deles. O método atualizar é presumivelmente definido na interface Observer.

Este código segue o padrão de projeto Observer, onde a classe Estoque é o sujeito que mantém uma lista de observadores e notifica-os sobre mudanças de estado.
 */