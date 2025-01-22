package com.md.deparadinamico.controllers;

import com.md.deparadinamico.entities.Cliente;
import com.md.deparadinamico.entities.DePara;
import com.md.deparadinamico.services.DeparaService;
import com.md.deparadinamico.utils.Formatter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/depara")
public class DeparaController {

    private final DeparaService deparaService;

    public DeparaController(DeparaService deparaService) {
        this.deparaService = deparaService;
    }

    @GetMapping
    public ResponseEntity<Object> getDepara() {
        List<DePara> deParaList = List.of(
                new DePara("nome_cliente", "nome", String::toUpperCase),
                new DePara("salario_cliente", "salario", Formatter::formatarMonetario),
                new DePara("telefone_cliente", "telefone.ddd-telefone.numero", Formatter::formatarTelefone),
                new DePara("endereco_cliente", "endereco.rua", String::toUpperCase)
        );

        Cliente cliente = new Cliente().mock();

        // Mapeia os valores
        List<Map<String, String>> resultado = deparaService.getDepara(deParaList, cliente);

        // Imprime o resultado
        resultado.forEach(System.out::println);

        return ResponseEntity.ok().body(resultado);
    }
}
