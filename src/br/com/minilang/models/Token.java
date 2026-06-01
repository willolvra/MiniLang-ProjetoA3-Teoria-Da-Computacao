package br.com.minilang.models;

import br.com.minilang.enums.TokenType;

public class Token {
    private TokenType type;
    private String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (value == null) {
            return type.toString();
        }

        return type + "(" + value + ")";
    }
}
