package com.novaesquadria.model.observer;

import com.novaesquadria.model.Estoque;

public interface Observer {
    void atualizar(Estoque estoque);
}

/* 
 Este código define uma interface chamada Observer no pacotecom.novaesquadria.estoque.observer. A interface Observer possui um único método, atualizar, que recebe um objeto do tipo Estoque como parâmetro.

Interfaces em Java são usadas para definir um contrato que outras classes podem implementar. Neste caso, qualquer classe que implemente a interface Observer deve fornecer uma implementação para o método atualizar, que será chamado quando houver uma atualização no objeto Estoque.

Este padrão é comumente usado no padrão de design Observer, onde objetos (observadores) são notificados sobre mudanças em outro objeto (o sujeito). Neste caso, a interface Observer define o contrato para os observadores que desejam ser notificados sobre mudanças no estoque.
 */