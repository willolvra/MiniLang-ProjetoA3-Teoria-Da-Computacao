package br.com.minilang.main;

import br.com.minilang.lexer.Lexer;
import br.com.minilang.models.Token;

import java.util.List;

public class Main {
    public static void main() {

                String codigo = "x + 10 = 4";

                Lexer lexer = new Lexer();
                List<Token> tokens = lexer.analisar(codigo);

                System.out.println(tokens);

    }
}
