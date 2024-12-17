package main.java.com.novaesquadria.estoque.notificacao;

public class NotificacaoFactory {
    public static Notificacao criarNotificacao(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "email" -> new EmailNotificacao();
            case "sms" -> new SMSNotificacao();
            default -> throw new IllegalArgumentException("Tipo de notificação não suportado");
        };
    }
}

/* 
 Este código define uma classe NotificacaoFactory que contém um método estático criarNotificacao. Este método é responsável por criar instâncias de diferentes tipos de notificações com base em uma string fornecida como argumento.

Aqui está uma descrição detalhada:

Pacote: O código está no pacote main.java.com.novaesquadria.estoque.notificacao.
Classe: A classe NotificacaoFactory é uma fábrica de notificações.
Método criarNotificacao:
É um método estático que recebe uma string tipo.
Utiliza uma expressão switch para determinar o tipo de notificação a ser criada com base no valor da string tipo.
Se tipo for "email", cria uma instância de EmailNotificacao.
Se tipo for "sms", cria uma instância de SMSNotificacao.
Se tipo não for nenhum dos valores esperados, lança uma exceção IllegalArgumentException com a mensagem "Tipo de notificação não suportado".
Este padrão de design é conhecido como "Factory Method", que permite a criação de objetos sem expor a lógica de instanciamento ao cliente. Neste caso, a fábrica de notificações encapsula a lógica de criação de diferentes tipos de notificações com base em um tipo fornecido como argumento.
 */