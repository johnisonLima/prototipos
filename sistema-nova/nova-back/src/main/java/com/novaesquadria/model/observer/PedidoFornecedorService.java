package com.novaesquadria.model.observer;

import com.novaesquadria.model.Estoque;

public class PedidoFornecedorService implements Observer {
    @Override
    public void atualizar(Estoque estoque) {
        if (estoque.getQuantidade() < 10) {
            System.out.println("Enviando pedido de reposição ao fornecedor para estoque crítico de: " + estoque.getQuantidade());
        }
    }
}


/* 
 Este código define uma classe PedidoFornecedorService que implementa a interface Observer. A classe é usada para monitorar o estoque de produtos e enviar um pedido de reposição ao fornecedor quando a quantidade de estoque cai abaixo de um determinado nível crítico (neste caso, 10 unidades).

Aqui está uma descrição detalhada:

Pacote e Importações:

O código está no pacotecom.novaesquadria.estoque.observer.
Importa a classe Estoque do pacotecom.novaesquadria.estoque.
Classe PedidoFornecedorService:

Implementa a interface Observer.
Método atualizar:

Este método é chamado quando há uma atualização no estoque.
Verifica se a quantidade de estoque é menor que 10.
Se for, imprime uma mensagem no console indicando que um pedido de reposição está sendo enviado ao fornecedor.
 */