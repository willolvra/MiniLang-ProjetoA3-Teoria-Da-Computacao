package br.com.minilang.semantic;

import br.com.minilang.enums.TokenType;
import br.com.minilang.models.Token;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Semantic {

    private final Set<String> variaveis = new HashSet<>();

    public boolean analisar(List<Token> tokens) {

        if (tokens.size() == 3) {

            if (tokens.get(0).getType() == TokenType.ID) {

                Token valor = tokens.get(2);

                if (valor.getType() == TokenType.ID) {

                    if (!variaveis.contains(valor.getValue())) {
                        System.out.println(
                                "Erro semantico: variavel "
                                        + valor.getValue()
                                        + " nao foi declarada."
                        );

                        return false;
                    }
                }

                variaveis.add(tokens.get(0).getValue());
            }
        }

        return true;
    }
}