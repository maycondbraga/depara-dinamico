package com.md.deparadinamico.entities;

import java.util.function.Function;

public record DePara(String chave, String caminho, Function<String, String> formatacao) {
}
