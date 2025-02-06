package com.novaesquadria.controller;

import com.novaesquadria.model.Estoque;
import com.novaesquadria.model.notificacao.Notificacao;
import com.novaesquadria.model.notificacao.NotificacaoFactory;
import com.novaesquadria.model.observer.NotificacaoService;
import com.novaesquadria.model.observer.PedidoFornecedorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final Estoque estoque;

    public EstoqueController() {
        // Inicializa o estoque
        this.estoque = new Estoque(15);

        // Configura observadores
        Notificacao emailNotificacao = NotificacaoFactory.criarNotificacao("email");
        NotificacaoService notificacaoService = new NotificacaoService(emailNotificacao);
        PedidoFornecedorService fornecedorService = new PedidoFornecedorService();

        estoque.adicionarObservador(notificacaoService);
        estoque.adicionarObservador(fornecedorService);
    }

    @GetMapping("/quantidade")
    public int getQuantidade() {
        return estoque.getQuantidade();
    }

    @PostMapping("/alterar")
    public void alterarQuantidade(@RequestParam int novaQuantidade) {
        estoque.alterarQuantidade(novaQuantidade);
    }
}
