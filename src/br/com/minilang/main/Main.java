package br.com.minilang.main;

import br.com.minilang.lexer.Lexer;
import br.com.minilang.models.Token;
import br.com.minilang.parser.Parser;
import br.com.minilang.semantic.Semantic;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String codigo = "y = x + 5";

        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        Semantic semantic = new Semantic();

        List<Token> tokens = lexer.analisar(codigo);

        System.out.println("Tokens:");
        System.out.println(tokens);

        if (!parser.analisar(tokens)) {
            System.out.println("Erro sintatico.");
            return;
        }

        System.out.println("Sintaxe valida.");

        if (!semantic.analisar(tokens)) {
            return;
        }

        System.out.println("Semantica valida.");


    }
}
