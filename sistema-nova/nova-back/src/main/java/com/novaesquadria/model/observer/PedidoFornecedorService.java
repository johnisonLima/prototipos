package com.novaesquadria.model.observer;

import com.novaesquadria.model.entity.Estoque;

public class PedidoFornecedorService implements Observer {
    @Override
    public void atualizar(Estoque estoque) {
        if (estoque.getQuantidade() < 10) {
            System.out.printf("Enviando pedido de reposição para o produto %s com estoque atual de %d%n", estoque.getProduto().getNome(), estoque.getQuantidade());
        }
    }
}