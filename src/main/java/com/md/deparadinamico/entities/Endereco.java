package com.md.deparadinamico.entities;

public class Endereco {
    private String rua;
    private String cidade;

    public String getRua() {
        return rua;
    }

    public Endereco setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }


    public Endereco mock() {
        this.rua = "Rua das Flores";
        this.cidade = "SÃO PAULO";
        return this;
    }
}
