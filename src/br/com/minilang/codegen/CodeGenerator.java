package br.com.minilang.codegen;

import br.com.minilang.models.Token;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    public List<String> gerar(List<Token> tokens) {
        List<String> codigoIntermediario = new ArrayList<>();

        if (tokens.size() == 3) {
            gerarAtribuicaoSimples(tokens, codigoIntermediario);
        }

        if (tokens.size() == 5) {
            gerarAtribuicaoComSoma(tokens, codigoIntermediario);
        }

        if (tokens.size() == 4) {
            gerarPrint(tokens, codigoIntermediario);
        }

        return codigoIntermediario;
    }

    private void gerarAtribuicaoSimples(List<Token> tokens, List<String> codigoIntermediario) {
        String variavel = tokens.get(0).getValue();
        String valor = tokens.get(2).getValue();

        codigoIntermediario.add("LOAD " + valor);
        codigoIntermediario.add("STORE " + variavel);
    }

    private void gerarAtribuicaoComSoma(List<Token> tokens, List<String> codigoIntermediario) {
        String variavel = tokens.get(0).getValue();
        String primeiroValor = tokens.get(2).getValue();
        String segundoValor = tokens.get(4).getValue();

        codigoIntermediario.add("LOAD " + primeiroValor);
        codigoIntermediario.add("ADD " + segundoValor);
        codigoIntermediario.add("STORE " + variavel);
    }

    private void gerarPrint(List<Token> tokens, List<String> codigoIntermediario) {
        String variavel = tokens.get(2).getValue();

        codigoIntermediario.add("PRINT " + variavel);
    }
}