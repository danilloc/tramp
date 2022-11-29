package com.Controller;

public class Email {

    private String assunto;
    private String remetente;
    private String destinatario;
    private String corpo;

    public Email(String assunto, String remetente, String destinatario, String corpo) {
        this.assunto = assunto;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.corpo = corpo;
    }

    public Email() {
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

}
