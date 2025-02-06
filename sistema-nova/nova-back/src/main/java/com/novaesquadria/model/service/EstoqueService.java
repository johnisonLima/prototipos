package com.novaesquadria.model.service;


import com.novaesquadria.model.Estoque;
import com.novaesquadria.model.notificacao.Notificacao;
import com.novaesquadria.model.notificacao.NotificacaoFactory;
import com.novaesquadria.model.observer.NotificacaoService;
import com.novaesquadria.model.observer.PedidoFornecedorService;

public class EstoqueService {
    private final Estoque estoque;

    public EstoqueService() {
        this.estoque = new Estoque(15);

        // Configuração de observadores
        Notificacao emailNotificacao = NotificacaoFactory.criarNotificacao("email");
        NotificacaoService notificacaoService = new NotificacaoService(emailNotificacao);
        PedidoFornecedorService fornecedorService = new PedidoFornecedorService();

        estoque.adicionarObservador(notificacaoService);
        estoque.adicionarObservador(fornecedorService);
    }

    public int getQuantidade() {
        return estoque.getQuantidade();
    }

    public void alterarQuantidade(int novaQuantidade) {
        estoque.alterarQuantidade(novaQuantidade);
    }
}
