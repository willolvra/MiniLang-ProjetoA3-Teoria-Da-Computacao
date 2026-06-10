package br.com.minilang.semantic;

import br.com.minilang.models.TokenType;
import br.com.minilang.models.Token;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Semantic {

    private final Set<String> variaveis = new HashSet<>();

    public boolean analisar(List<Token> tokens) {

        if (tokens.size() == 3) {
            return analisarAtribuicaoSimples(tokens);
        }

        if (tokens.size() == 5) {
            return analisarAtribuicaoComSoma(tokens);
        }

        if (tokens.size() == 4) {
            return analisarPrint(tokens);
        }

        return true;
    }

    private boolean analisarAtribuicaoSimples(List<Token> tokens) {
        Token nomeVariavel = tokens.get(0);
        Token valor = tokens.get(2);

        if (valor.getType() == TokenType.ID && !variaveis.contains(valor.getValue())) { //ve se o valor eh um ID,
            mostrarErro(valor.getValue());                                    //se for, verifica se ja foi declarado antes, se nao foi, da erro
            return false;
        }

        variaveis.add(nomeVariavel.getValue());
        return true;
    }

    private boolean analisarAtribuicaoComSoma(List<Token> tokens) {
        Token nomeVariavel = tokens.get(0);
        Token primeiroValor = tokens.get(2);
        Token segundoValor = tokens.get(4);

        if (primeiroValor.getType() == TokenType.ID && !variaveis.contains(primeiroValor.getValue())) {
            mostrarErro(primeiroValor.getValue());
            return false;
        }

        if (segundoValor.getType() == TokenType.ID && !variaveis.contains(segundoValor.getValue())) {
            mostrarErro(segundoValor.getValue());
            return false;
        }

        variaveis.add(nomeVariavel.getValue());
        return true;
    }

    private boolean analisarPrint(List<Token> tokens) {
        Token variavelPrint = tokens.get(2);

        if (!variaveis.contains(variavelPrint.getValue())) {
            mostrarErro(variavelPrint.getValue());
            return false;
        }

        return true;
    }

    private void mostrarErro(String nome) {
        System.out.println("Erro semantico: variavel " + nome + " nao foi declarada.");
    }
}