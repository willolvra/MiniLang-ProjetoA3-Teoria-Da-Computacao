package br.com.minilang.parser;

import br.com.minilang.enums.TokenType;
import br.com.minilang.models.Token;

import java.util.List;

public class Parser {

    public boolean analisar(List<Token> tokens) {

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

    private boolean atribuicaoSimples(List<Token> tokens) {
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

    private boolean ehValor(Token token) {
        return token.getType() == TokenType.ID
                || token.getType() == TokenType.NUM;
    }

    private boolean comandoPrint(List<Token> tokens) {
        return tokens.get(0).getType() == TokenType.PRINT
                && tokens.get(1).getType() == TokenType.LPAREN
                && tokens.get(2).getType() == TokenType.ID
                && tokens.get(3).getType() == TokenType.RPAREN;
    }

}