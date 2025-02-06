## Arquitetura

Este projeto segue a arquitetura Model-View-Controller (MVC). A camada de visualização será implementada usando Angular no futuro. A estrutura atual inclui:

- `model`: Contém as classes de domínio e lógica de negócios.
  - `entity`: Define as entidades (`Produto` e `Estoque`).
  - `repository`: Interfaces para acessar e manipular dados.
  - `service`: Orquestra as regras e lógica de negócios.
- `controller`: Controladores REST que gerenciam a comunicação entre a visualização e o modelo.

## Padrões de Projeto

O projeto utiliza os seguintes padrões de projeto:

1. **Factory Method**: Usado para criar diferentes tipos de notificações (`EmailNotificacao`, `SMSNotificacao`) na classe `NotificacaoFactory`.
2. **Observer**: Usado para monitorar os níveis de estoque e notificar outros componentes quando o estoque atinge um nível crítico. A classe `Estoque` notifica os observadores (`NotificacaoService`, `PedidoFornecedorService`) sobre mudanças nos níveis de estoque.

## Executando o Projeto

Para executar o projeto, siga estes passos:

1. Certifique-se de ter Java 17 e Maven instalados em seu sistema.
2. Abra o terminal no diretório raiz do projeto.
3. Compile e execute o projeto usando o seguinte comando:
   ```sh
   mvn spring-boot:run
   ```

## Banco de Dados

O projeto usa H2 como banco de dados em memória. O banco de dados é configurado no arquivo `application.properties`. Ao iniciar, a classe `DataInitializer` cria dois produtos e seus respectivos níveis de estoque para fins de teste.

## Endpoints da API

Os seguintes endpoints estão disponíveis:

- **Obter quantidade de estoque para um produto específico**: `GET http://localhost:8080/estoque/{produtoId}`
  - Exemplo: `GET http://localhost:8080/estoque/1`
- **Atualizar quantidade de estoque para um produto específico**: `POST http://localhost:8080/estoque/{produtoId}/alterar?novaQuantidade=20`
  - Exemplo: `POST http://localhost:8080/estoque/1/alterar?novaQuantidade=15`

Esses endpoints permitem visualizar e atualizar os níveis de estoque de produtos específicos.

