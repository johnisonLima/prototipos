package com.novaesquadria.model.observer;


import com.novaesquadria.model.Estoque;
import com.novaesquadria.model.notificacao.Notificacao;

public class NotificacaoService implements Observer {
    private final Notificacao notificacao;

    public NotificacaoService(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    @Override
    public void atualizar(Estoque estoque) {
        if (estoque.getQuantidade() < 10) {
            notificacao.enviar("Estoque crítico: apenas " + estoque.getQuantidade() + " unidades restantes!");
        }
    }
}

/* 
 Este código define uma classe NotificacaoService que implementa a interface Observer. A classe é usada para enviar notificações quando o estoque de um item está baixo. Aqui está uma descrição detalhada:

Pacote e Importações:

O código está no pacotecom.novaesquadria.estoque.observer.
Importa as classes Estoque e Notificacao.
Classe NotificacaoService:

Implementa a interface Observer.
Possui um atributo notificacao do tipo Notificacao.
Construtor:

O construtor recebe um objeto Notificacao e o atribui ao atributo notificacao.
Método atualizar:

Implementa o método atualizar da interface Observer.
Verifica se a quantidade de itens no estoque é menor que 10.
Se for, envia uma notificação com uma mensagem indicando que o estoque está crítico.
Este serviço é útil para monitorar o estoque e alertar quando a quantidade de itens está baixa, ajudando a evitar a falta de produtos.
*/