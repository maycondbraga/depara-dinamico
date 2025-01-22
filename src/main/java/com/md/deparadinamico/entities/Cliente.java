package com.md.deparadinamico.entities;

import java.math.BigDecimal;

public class Cliente {
    private String nome;
    private BigDecimal salario;
    private Telefone telefone;
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Cliente setSalario(BigDecimal salario) {
        this.salario = salario;
        return this;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(Telefone telefoneModel) {
        this.telefone = telefoneModel;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Cliente setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Cliente mock() {
        this.nome = "Fulano de Tal";
        this.salario = new BigDecimal("18000.00");
        this.telefone = new Telefone().mock();
        this.endereco = new Endereco().mock();
        return this;
    }
}
