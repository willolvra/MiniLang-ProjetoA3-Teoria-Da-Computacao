package br.com.minilang.main;

import br.com.minilang.codegen.CodeGenerator;
import br.com.minilang.lexer.Lexer;
import br.com.minilang.models.Token;
import br.com.minilang.parser.Parser;
import br.com.minilang.semantic.Semantic;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        Semantic semantic = new Semantic();
        CodeGenerator codeGenerator = new CodeGenerator();

        String codigo = "x = 10 + 5";

        List<Token> tokens = lexer.analisar(codigo);

        System.out.println("Tokens:");
        System.out.println(tokens);

        if (!parser.analisar(tokens)) {
            System.out.println("Erro sintatico.");
            return;
        }

        if (!semantic.analisar(tokens)) {
            System.out.println("Erro semantico.");
            return;
        }

        List<String> codigoIntermediario = codeGenerator.gerar(tokens);

        System.out.println("Codigo intermediario:");
        System.out.println(codigoIntermediario);

    }
}
