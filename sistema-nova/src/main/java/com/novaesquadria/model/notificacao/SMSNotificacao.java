package main.java.com.novaesquadria.model.notificacao;

public class SMSNotificacao implements Notificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}

/* 
 *Este código define uma classe SMSNotificacao que implementa a interface Notificacao. A classe possui um método enviar que recebe uma string mensagem como parâmetro e imprime essa mensagem no console, precedida pelo texto "Enviando SMS: ".

Aqui está uma descrição detalhada:

A classe SMSNotificacao está no pacote main.java.com.novaesquadria.estoque.notificacao.
A classe implementa a interface Notificacao.
O método enviar é sobrescrito para imprimir uma mensagem no console.
Este método simula o envio de uma notificação via SMS, mas na verdade apenas imprime a mensagem no console.
 */