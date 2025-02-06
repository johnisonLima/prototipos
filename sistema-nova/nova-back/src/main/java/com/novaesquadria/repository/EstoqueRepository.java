package com.novaesquadria.repository;

import com.novaesquadria.model.Estoque;

public class EstoqueRepository {
    private Estoque estoque;

    public EstoqueRepository() {
        this.estoque = new Estoque(15);
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}