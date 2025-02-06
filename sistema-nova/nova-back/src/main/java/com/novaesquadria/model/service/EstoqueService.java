package com.novaesquadria.model.service;

import com.novaesquadria.model.entity.Estoque;
import com.novaesquadria.model.notificacao.Notificacao;
import com.novaesquadria.model.notificacao.NotificacaoFactory;
import com.novaesquadria.model.observer.NotificacaoService;
import com.novaesquadria.model.observer.PedidoFornecedorService;
import com.novaesquadria.model.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    private final EstoqueRepository estoqueRepository;

    @Autowired
    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public Optional<Estoque> getEstoqueByProdutoId(Long produtoId) {
        return estoqueRepository.findByProdutoId(produtoId);
    }

    public Estoque alterarQuantidade(Long produtoId, int novaQuantidade) {
        Optional<Estoque> estoqueOpt = estoqueRepository.findByProdutoId(produtoId);
        if (estoqueOpt.isPresent()) {
            Estoque estoque = estoqueOpt.get();
            estoque.setQuantidade(novaQuantidade);
            estoqueRepository.save(estoque);
            notificarObservadores(estoque);
            return estoque;
        } else {
            throw new IllegalArgumentException("Produto não encontrado");
        }
    }

    public List<Estoque> listaEstoque() {
        return estoqueRepository.findAll();
    }

    private void notificarObservadores(Estoque estoque) {
        Notificacao emailNotificacao = NotificacaoFactory.criarNotificacao("email");
        NotificacaoService notificacaoService = new NotificacaoService(emailNotificacao);
        PedidoFornecedorService fornecedorService = new PedidoFornecedorService();

        if (estoque.getQuantidade() < 10) {
            notificacaoService.atualizar(estoque);
            fornecedorService.atualizar(estoque);
        }
    }
}
