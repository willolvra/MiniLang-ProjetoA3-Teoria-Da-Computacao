package br.com.minilang.lexer;

import br.com.minilang.enums.TokenType;
import br.com.minilang.models.Token;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public List<Token> analisar(String codigo) {
        List<Token> tokens = new ArrayList<>();

        int i = 0;

        while (i < codigo.length()) {
            char atual = codigo.charAt(i);

            if (Character.isWhitespace(atual)) {
                i++;
            } else if (Character.isLetter(atual)) {
                StringBuilder palavra = new StringBuilder();

                while (i < codigo.length() && Character.isLetter(codigo.charAt(i))) {
                    palavra.append(codigo.charAt(i));
                    i++;
                }

                if (palavra.toString().equals("print")) {
                    tokens.add(new Token(TokenType.PRINT, palavra.toString()));
                } else {
                    tokens.add(new Token(TokenType.ID, palavra.toString()));
                }

            } else if (Character.isDigit(atual)) {
                StringBuilder numero = new StringBuilder();

                while (i < codigo.length() && Character.isDigit(codigo.charAt(i))) {
                    numero.append(codigo.charAt(i));
                    i++;
                }

                tokens.add(new Token(TokenType.NUM, numero.toString()));

            } else if (atual == '=') {
                tokens.add(new Token(TokenType.EQUAL, null));
                i++;

            } else if (atual == '+') {
                tokens.add(new Token(TokenType.PLUS, null));
                i++;

            } else if (atual == '(') {
                tokens.add(new Token(TokenType.LPAREN, null));
                i++;

            } else if (atual == ')') {
                tokens.add(new Token(TokenType.RPAREN, null));
                i++;

            } else {
                System.out.println("Caractere inválido: " + atual);
                i++;
            }
        }

        return tokens;
    }
}