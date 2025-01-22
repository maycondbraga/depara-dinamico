package com.md.deparadinamico.entities;

public class Endereco {
    private String rua;

    public String getRua() {
        return rua;
    }

    public Endereco setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public Endereco mock() {
        this.rua = "Rua das Flores";
        return this;
    }
}
