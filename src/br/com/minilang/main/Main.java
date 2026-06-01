package br.com.minilang.main;

import br.com.minilang.lexer.Lexer;
import br.com.minilang.models.Token;
import br.com.minilang.parser.Parser;

import java.util.List;

public class Main {
    public static void main() {

        String codigo = "x = 10"; // valido
        //String codigo = "x = 10 + 5"; // valido
        //String codigo = "print(y)"; // valido
        //String codigo = "x = + 5"; // invalido
        //String codigo = "print()"; // invalido
        //String codigo = "x 10 ="; // invalido

        Lexer lexer = new Lexer();
        List<Token> tokens = lexer.analisar(codigo);

        Parser parser = new Parser();

        System.out.println(tokens);
        System.out.println(parser.analisar(tokens));

    }
}
