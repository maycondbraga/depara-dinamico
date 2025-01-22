package com.md.deparadinamico.entities;

public class Telefone {
    private String ddd;
    private String numero;

    public String getDdd() {
        return ddd;
    }

    public Telefone setDdd(String ddd) {
        this.ddd = ddd;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Telefone setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public Telefone mock() {
        this.ddd = "11";
        this.numero = "999999999";
        return this;
    }
}
