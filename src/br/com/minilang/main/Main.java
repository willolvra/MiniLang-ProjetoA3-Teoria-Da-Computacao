package br.com.minilang.main;

import br.com.minilang.lexer.Lexer;
import br.com.minilang.semantic.Semantic;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Semantic semantic = new Semantic();
        Lexer lexer = new Lexer();

        semantic.analisar(
                lexer.analisar("x = 10") // retorna true
        );

        semantic.analisar(
                lexer.analisar("x = y") // vai retornar false, y nao esta declarada
        );

        semantic.analisar(
                lexer.analisar("y = x") // retorna true
        );

    }
}
