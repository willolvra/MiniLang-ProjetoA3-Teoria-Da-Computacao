package br.com.minilang.parser;

import br.com.minilang.models.TokenType;
import br.com.minilang.models.Token;

import java.util.List;
import java.util.Stack;

public class Parser {

    public boolean analisar(List<Token> tokens) {

        //ve quantos tokens sao
        if (tokens.size() == 3) {
            return atribuicaoSimples(tokens);
        }

        if (tokens.size() == 5) {
            return atribuicaoComSoma(tokens);
        }

        if (tokens.size() == 4) {
            return comandoPrint(tokens);
        }

        return false;
    }

    private boolean atribuicaoSimples(List<Token> tokens) { //ve se os tokens estao na sequencia correta
        return tokens.get(0).getType() == TokenType.ID
                && tokens.get(1).getType() == TokenType.EQUAL
                && ehValor(tokens.get(2));
    }

    private boolean atribuicaoComSoma(List<Token> tokens) {
        return tokens.get(0).getType() == TokenType.ID
                && tokens.get(1).getType() == TokenType.EQUAL
                && ehValor(tokens.get(2))
                && tokens.get(3).getType() == TokenType.PLUS
                && ehValor(tokens.get(4));
    }

    private boolean ehValor(Token token) { //verifica se o token eh um ID ou um NUM, se nao for, retorna false
        return token.getType() == TokenType.ID
                || token.getType() == TokenType.NUM;
    }

    private boolean comandoPrint(List<Token> tokens) {
        if (tokens.get(0).getType() != TokenType.PRINT) {
            return false;
        }

        if (tokens.get(2).getType() != TokenType.ID) {
            return false;
        }

        Stack<TokenType> pilha = new Stack<>();

        for (Token token : tokens) {
            if (token.getType() == TokenType.LPAREN) {
                pilha.push(TokenType.LPAREN);
            }

            if (token.getType() == TokenType.RPAREN) {
                if (pilha.isEmpty()) {
                    return false;
                }

                pilha.pop();
            }
        }

        return pilha.isEmpty()
                && tokens.get(1).getType() == TokenType.LPAREN
                && tokens.get(3).getType() == TokenType.RPAREN;
    }

}