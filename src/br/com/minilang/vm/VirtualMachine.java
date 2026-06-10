package br.com.minilang.vm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VirtualMachine {

    private final Map<String, Integer> memoria = new HashMap<>();

    private int acumulador = 0;

    public void executar(List<String> instrucoes) {

        for (String instrucao : instrucoes) {

            String[] partes = instrucao.split(" ");

            String comando = partes[0];

            switch (comando) {

                case "LOAD":
                    carregar(partes[1]);
                    break;

                case "ADD":
                    somar(partes[1]);
                    break;

                case "STORE":
                    armazenar(partes[1]);
                    break;

                case "PRINT":
                    imprimir(partes[1]);
                    break;
            }
        }
    }

    private void carregar(String valor) {

        if (valor.matches("\\d+")) {
            acumulador = Integer.parseInt(valor);
        } else {
            acumulador = memoria.get(valor);
        }
    }

    private void somar(String valor) {

        if (valor.matches("\\d+")) {
            acumulador += Integer.parseInt(valor);
        } else {
            acumulador += memoria.get(valor);
        }
    }

    private void armazenar(String variavel) {
        memoria.put(variavel, acumulador);
    }

    private void imprimir(String variavel) {
        System.out.println(memoria.get(variavel));
    }
}