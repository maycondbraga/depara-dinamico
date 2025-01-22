package com.md.deparadinamico.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Formatter {
    public static String formatarMonetario(String valor) {
        try {
            BigDecimal salario = new BigDecimal(valor);
            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
            return formatter.format(salario);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor inválido para formatação monetária: " + valor, e);
        }
    }

    public static String formatarTelefone(String telefone) {
        if (telefone == null || telefone.length() < 10) {
            throw new IllegalArgumentException("Telefone inválido: " + telefone);
        }
        String ddd = telefone.substring(0, 2);
        String numero = telefone.substring(2, 7) + "-" + telefone.substring(7);
        return "(" + ddd + ") " + numero;
    }
}
