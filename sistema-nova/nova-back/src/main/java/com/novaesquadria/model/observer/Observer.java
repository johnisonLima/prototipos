package com.novaesquadria.model.observer;

import com.novaesquadria.model.entity.Estoque;

public interface Observer {
    void atualizar(Estoque estoque);
}
