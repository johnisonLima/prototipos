package com.novaesquadria.model.notificacao;

public class NotificacaoFactory {
    public static Notificacao criarNotificacao(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "email" -> new EmailNotificacao();
            case "sms" -> new SMSNotificacao();
            default -> throw new IllegalArgumentException("Tipo de notificação não suportado");
        };
    }
}