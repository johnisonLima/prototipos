package com.novaesquadria.model.observer;


import com.novaesquadria.model.entity.Estoque;
import com.novaesquadria.model.notificacao.Notificacao;

public class NotificacaoService implements Observer {
    private final Notificacao notificacao;

    public NotificacaoService(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    @Override
    public void atualizar(Estoque estoque) {
        if (estoque.getQuantidade() < 10) {
            notificacao.enviar("Estoque crítico: " + "Produto " + estoque.getId() + " com apenas " + estoque.getQuantidade() + " unidades restantes!");
        }
    }
}
