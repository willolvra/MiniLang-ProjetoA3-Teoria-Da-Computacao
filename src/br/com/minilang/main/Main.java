package br.com.minilang.main;

import br.com.minilang.codegen.CodeGenerator;
import br.com.minilang.lexer.Lexer;
import br.com.minilang.models.Token;
import br.com.minilang.parser.Parser;
import br.com.minilang.semantic.Semantic;
import br.com.minilang.vm.VirtualMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        Semantic semantic = new Semantic();
        CodeGenerator codeGenerator = new CodeGenerator();
        VirtualMachine vm = new VirtualMachine();

        System.out.println("Digite o programa.");
        System.out.println("Digite 'fim' para encerrar.");

        StringBuilder codigo = new StringBuilder();

        while (true) {
            String linha = sc.nextLine();

            if (linha.isBlank() || linha.equals("fim")) {
                break;
            }

            codigo.append(linha).append("\n");
        }

        List<String> codigoIntermediarioCompleto = new ArrayList<>();

        String[] linhas = codigo.toString().split("\n");

        for (String linha : linhas) {
            if (linha.isBlank()) {
                continue;
            }

            List<Token> tokens = lexer.analisar(linha);

            System.out.println("\nLinha: " + linha);
            System.out.println("Tokens: " + tokens);

            if (!parser.analisar(tokens)) {
                System.out.println("Erro sintatico na linha: " + linha);
                return;
            }

            if (!semantic.analisar(tokens)) {
                System.out.println("Erro na linha: " + linha);
                return;
            }

            List<String> codigoIntermediario = codeGenerator.gerar(tokens);
            codigoIntermediarioCompleto.addAll(codigoIntermediario);

            System.out.println("Codigo intermediario: " + codigoIntermediario);
        }

        System.out.println("\nCodigo intermediario completo:");
        System.out.println(codigoIntermediarioCompleto);

        System.out.println("\nResultado:");
        vm.executar(codigoIntermediarioCompleto);

        sc.close();
    }
}