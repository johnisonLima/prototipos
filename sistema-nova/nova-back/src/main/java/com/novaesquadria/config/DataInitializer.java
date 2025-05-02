package com.novaesquadria.config;

import com.novaesquadria.model.entity.Estoque;
import com.novaesquadria.model.entity.Produto;
import com.novaesquadria.model.repository.EstoqueRepository;
import com.novaesquadria.model.repository.ProdutoRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ProdutoRepository produtoRepository, EstoqueRepository estoqueRepository) {
        return args -> {
            Produto produto = new Produto();
            produto.setNome("Porta N1 2,10m x 0,80m");
            produto.setDescricao("Porta de aluminio com vidro nas medidas 2,10m x 0,80m");
            produto.setPreco(499.0);
            produtoRepository.save(produto);

            Produto produto2 = new Produto();
            produto2.setNome("Janela N2 1,20m x 1,20m");
            produto2.setDescricao("Janela de aluminio com vidro nas medidas 1,20m x 1,20m");
            produto2.setPreco(299.0);
            produtoRepository.save(produto2);

            Estoque estoque = new Estoque();
            estoque.setProduto(produto);
            estoque.setQuantidade(20);
            estoqueRepository.save(estoque);

            Estoque estoque2 = new Estoque();
            estoque2.setProduto(produto2);
            estoque2.setQuantidade(10);
            estoqueRepository.save(estoque2);
        };
    }
}
