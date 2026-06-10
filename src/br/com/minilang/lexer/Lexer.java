package br.com.minilang.lexer;

import br.com.minilang.models.TokenType;
import br.com.minilang.models.Token;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public List<Token> analisar(String codigo) {
        List<Token> tokens = new ArrayList<>();

        int i = 0;

        while (i < codigo.length()) {
            char atual = codigo.charAt(i); //pega o caractere atual da string na posição i

            if (Character.isWhitespace(atual)) { //verificar se o caractere eh um espaco em branco
                i++;
            } else if (Character.isLetter(atual)) { //verificar se eh letra, analise lexica
                StringBuilder palavra = new StringBuilder(); //uso de stringbuilder para armazenar a letra, vai ajudar se vier uma palavra como o print

                while (i < codigo.length() && Character.isLetter(codigo.charAt(i))) { //esse loop vai servir para adicionar uma letra ou montar a palavra
                    palavra.append(codigo.charAt(i)); //adiciona o caractere no stringbuilder
                    i++;
                }

                if (palavra.toString().equals("print")) { //verifica se a palavra eh print, se for, passa o tipo PRINT e o print
                    tokens.add(new Token(TokenType.PRINT, palavra.toString()));
                } else if (ehIdentificador(palavra.toString())){
                    tokens.add(new Token(TokenType.ID, palavra.toString())); //se nao for, passa o tipo ID, e a variavel digitada
                }

            } else if (Character.isDigit(atual)) { //verificar se o caractere eh um numero, analise lexica
                StringBuilder numero = new StringBuilder(); //Stringbuilder para caso seja numeros acima de 9

                while (i < codigo.length() && Character.isDigit(codigo.charAt(i))) {
                    numero.append(codigo.charAt(i));
                    i++;
                }
                if(ehNumero(numero.toString())){
                    tokens.add(new Token(TokenType.NUM, numero.toString())); //adiciona o numero
                }

            } else if (atual == '=') { //verifica se o caractere eh um igual e adiciona, analise lexica
                tokens.add(new Token(TokenType.EQUAL, null));
                i++;

            } else if (atual == '+') { //verifica se o caractere eh um sinal de mais e adiciona
                tokens.add(new Token(TokenType.PLUS, null));
                i++;

            } else if (atual == '(') { //verifica se eh um parentese esquerdo
                tokens.add(new Token(TokenType.LPAREN, null));
                i++;

            } else if (atual == ')') { //verifica se eh um parentese direito
                tokens.add(new Token(TokenType.RPAREN, null));
                i++;

            } else { //caso nao tenha entrado em nenhum if acima, retorna a mensagem abaixo
                System.out.println("Caractere inválido: " + atual);
                i++;
            }
        }

        return tokens; //retorna a lista que foi criada
    }

    private boolean ehNumero(String texto) {
        return texto.matches("[0-9]+");
    }

    private boolean ehIdentificador(String texto) {
        return texto.matches("[a-zA-Z]+");
    }

}