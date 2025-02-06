package com.novaesquadria.controller;

import com.novaesquadria.model.entity.Estoque;
import com.novaesquadria.model.service.EstoqueService;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;

    }

    @GetMapping("/lista")
    public Iterable<Estoque> listaEstoque() {
        return estoqueService.listaEstoque();
    }

    @GetMapping("/quantidade")
    public Optional<Estoque> getQuantidade(@RequestParam Long produtoId) {
        return estoqueService.getEstoqueByProdutoId(produtoId);
    }

    @PostMapping("/alterar")
    public void alterarQuantidade(@RequestParam int novaQuantidade, @RequestParam Long produtoId) {
        estoqueService.alterarQuantidade(produtoId, novaQuantidade);
    }
}
