package com.novaesquadria.model.notificacao;

public interface Notificacao {
    void enviar(String mensagem);
}

/* 
Este código define uma interface chamada Notificacao no pacotecom.novaesquadria.estoque.notificacao. A interface Notificacao declara um método enviar que aceita uma string como parâmetro. Este método é destinado a enviar uma mensagem, mas a implementação específica do envio da mensagem será fornecida pelas classes que implementarem esta interface. Este é um exemplo do padrão de projeto Factory Method, onde a interface define um contrato para a criação de objetos, mas permite que as subclasses alterem o tipo de objetos que serão criados.
*/