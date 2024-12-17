package  main.java.com.novaesquadria.controller;

import main.java.com.novaesquadria.model.Estoque;
import main.java.com.novaesquadria.model.notificacao.Notificacao;
import main.java.com.novaesquadria.model.notificacao.NotificacaoFactory;
import main.java.com.novaesquadria.model.observer.NotificacaoService;
import main.java.com.novaesquadria.model.observer.PedidoFornecedorService;

public class Main {
    public static void main(String[] args) throws Exception {
       // Criação do estoque inicial
       Estoque estoque = new Estoque(15);

       // Configuração de observadores
       Notificacao emailNotificacao = NotificacaoFactory.criarNotificacao("email");
       NotificacaoService notificacaoService = new NotificacaoService(emailNotificacao);
       PedidoFornecedorService fornecedorService = new PedidoFornecedorService();

       estoque.adicionarObservador(notificacaoService);
       estoque.adicionarObservador(fornecedorService);

       // Simulação de alterações no estoque
       System.out.println("Alterando o estoque para 8 unidades...");
       estoque.alterarQuantidade(8); // Estoque crítico: observadores devem ser acionados

       System.out.println("Alterando o estoque para 20 unidades...");
       estoque.alterarQuantidade(20); // Estoque suficiente: nenhum observador é acionado
    }
}

/* 
 Este código Java é um exemplo de um sistema de gerenciamento de estoque que utiliza o padrão de projeto Observer. Aqui está uma descrição passo a passo do que o código faz:

Importações: Importa classes necessárias para o funcionamento do sistema de notificação e pedido de fornecedor.

Classe Principal (Main): Define a classe principal Main que contém o método main, o ponto de entrada do programa.

Método main:

Criação do Estoque Inicial: Cria uma instância da classe Estoque com uma quantidade inicial de 15 unidades.
Configuração de Observadores:
Cria uma notificação de email usando a fábrica de notificações (NotificacaoFactory).
Cria um serviço de notificação (NotificacaoService) que utiliza a notificação de email.
Cria um serviço de pedido de fornecedor (PedidoFornecedorService).
Adição de Observadores ao Estoque: Adiciona os serviços de notificação e pedido de fornecedor como observadores do estoque.
Simulação de Alterações no Estoque:
Altera a quantidade de estoque para 8 unidades, o que deve acionar os observadores, pois é uma quantidade crítica.
Altera a quantidade de estoque para 20 unidades, o que não deve acionar os observadores, pois é uma quantidade suficiente.
O código demonstra como os observadores são notificados quando o estoque atinge um nível crítico, utilizando o padrão Observer para desacoplar a lógica de notificação e pedido de fornecedor da lógica de gerenciamento de estoque.
 */