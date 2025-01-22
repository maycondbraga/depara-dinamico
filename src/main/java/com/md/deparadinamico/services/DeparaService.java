package com.md.deparadinamico.services;

import org.springframework.stereotype.Service;
import com.md.deparadinamico.entities.DePara;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class DeparaService {

    public List<Map<String, String>> getDepara(List<DePara> deParaList, Object inputObject) {
        List<Map<String, String>> result = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Converte o objeto de entrada em um JsonNode
            JsonNode rootNode = objectMapper.valueToTree(inputObject);

            for (DePara dePara : deParaList) {
                String chave = dePara.chave();
                String caminho = dePara.caminho();
                Function<String, String> formatacao = dePara.formatacao();

                // Processa o caminho e extrai o valor
                String valor = extrairValor(rootNode, caminho, formatacao);

                // Adiciona o resultado ao mapa, se o valor for encontrado
                if (valor != null) {
                    Map<String, String> map = new HashMap<>();
                    map.put("chave", chave);
                    map.put("valor", valor);
                    result.add(map);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao mapear de-para: " + e.getMessage(), e);
        }

        return result;
    }

    private static String extrairValor(JsonNode rootNode, String caminho, Function<String, String> formatacao) {
        String[] partes = caminho.split("-");
        StringBuilder valorFinal = new StringBuilder();

        for (String parte : partes) {
            JsonNode node = rootNode.at(convertToJsonPointer(parte.trim()));
            if (!node.isMissingNode()) {
                valorFinal.append(node.asText());
            } else {
                return null; // Interrompe se algum nó não for encontrado
            }
        }

        String valor = valorFinal.toString();
        return formatacao != null ? formatacao.apply(valor) : valor;
    }

    // Converte caminho no formato "telefone.ddd" para o formato JSON Pointer "/telefone/ddd"
    private static String convertToJsonPointer(String caminho) {
        return "/" + caminho.replace(".", "/");
    }
}
