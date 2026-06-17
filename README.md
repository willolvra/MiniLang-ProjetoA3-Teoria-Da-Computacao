# RELATÓRIO – COMPILADOR MINILANG

## 1. Introdução

O objetivo deste projeto foi desenvolver um compilador educacional simplificado para a linguagem MiniLang, aplicando conceitos fundamentais da Teoria da Computação. O compilador é capaz de realizar análise léxica, análise sintática, análise semântica, geração de código intermediário e execução do programa.

A linguagem MiniLang suporta declarações de variáveis, operações de soma e impressão de valores.

Exemplo de código:

x = 10

y = x + 5

print(y)

Saída esperada:

15

---

## 2. Estrutura do Compilador

O projeto foi dividido em cinco etapas principais:

### Análise Léxica

Responsável por transformar o código-fonte em tokens.

Exemplo:

x = 10 + 5

Tokens gerados:

[ID(x), EQUAL, NUM(10), PLUS, NUM(5)]

Classe responsável: Lexer.

### Análise Sintática

Responsável por verificar se a sequência de tokens segue as regras da linguagem MiniLang.

Exemplo válido:

x = 10 + 5

Exemplo inválido:

x 10 = + 5

Classe responsável: Parser.

### Análise Semântica

Responsável por verificar o significado das instruções.

Exemplo inválido:

y = x + 5

Nesse caso, a variável x não foi declarada anteriormente.

Classe responsável: Semantic.

### Geração de Código Intermediário

Responsável por converter o programa em instruções de pseudo-assembly.

Exemplo:

LOAD 10

STORE x

LOAD x

ADD 5

STORE y

PRINT y

Classe responsável: CodeGenerator.

### Execução

Responsável por executar o código intermediário gerado.

Classe responsável: VirtualMachine.

---

## 3. Aplicação da Teoria da Computação

### Análise Léxica – Autômato Finito Determinístico (AFD)

O conceito de AFD foi aplicado na classe Lexer. O código percorre o programa caractere por caractere utilizando métodos como Character.isLetter() e Character.isDigit() para reconhecer identificadores, números e símbolos da linguagem.

Cada caractere lido representa uma transição de estado do autômato até que um token seja reconhecido.

### Análise Léxica – Expressões Regulares

As expressões regulares foram utilizadas para validar identificadores e números.

Exemplos:

texto.matches("[a-zA-Z]+")

texto.matches("[0-9]+")

Essas expressões garantem que os tokens reconhecidos possuam o formato esperado.

### Análise Sintática – Gramática Livre de Contexto (CFL)

A Gramática Livre de Contexto foi aplicada na classe Parser.

Foram definidas regras para validar a estrutura da linguagem MiniLang, como:

ATRIBUICAO -> ID EQUAL VALOR

ATRIBUICAO -> ID EQUAL VALOR PLUS VALOR

PRINT -> PRINT LPAREN ID RPAREN

O Parser verifica se a sequência de tokens segue essas produções da gramática.

### Análise Sintática – Autômato de Pilha (PDA)

O conceito de PDA foi aplicado através do uso de uma pilha (Stack) para validar os parênteses do comando print.

Quando o analisador encontra um parêntese de abertura, ele realiza uma operação de empilhar (push). Ao encontrar um parêntese de fechamento, realiza uma operação de desempilhar (pop).

A estrutura é considerada válida apenas quando a pilha termina vazia.

### Análise Semântica – Linguagem Sensível ao Contexto (CSL)

O conceito de Linguagem Sensível ao Contexto foi aplicado na classe Semantic.

Foi utilizada uma tabela de símbolos implementada com HashSet para armazenar as variáveis declaradas.

Durante a análise, o compilador verifica se uma variável foi declarada antes de ser utilizada em expressões ou comandos print.

A validade da instrução depende do contexto criado pelas instruções anteriores, caracterizando uma linguagem sensível ao contexto.

### Execução – Máquina de Turing

O conceito de Máquina de Turing foi representado pela classe VirtualMachine.

A máquina virtual executa o código intermediário de forma sequencial, processando uma instrução por vez.

As variáveis são armazenadas em memória utilizando um HashMap, enquanto um acumulador é utilizado para realizar os cálculos temporários.

Exemplo:

LOAD 10

ADD 5

STORE x

PRINT x

Cada instrução é lida e executada em sequência, simulando o processamento de uma Máquina de Turing.

---

## 4. Como a Teoria da Computação foi aplicada no projeto?

A Teoria da Computação foi aplicada em todas as etapas do desenvolvimento do compilador. Na análise léxica foram utilizados Autômatos Finitos Determinísticos e Expressões Regulares para reconhecer os tokens da linguagem. Na análise sintática foram utilizadas Gramáticas Livres de Contexto e um Autômato de Pilha para validar a estrutura dos comandos. Na análise semântica foi aplicado o conceito de Linguagem Sensível ao Contexto para verificar a existência de variáveis declaradas anteriormente. Por fim, a execução do programa foi realizada por uma máquina virtual que processa instruções sequencialmente, representando o funcionamento de uma Máquina de Turing.

---

## 5. Conclusão

O projeto permitiu implementar um compilador funcional para a linguagem MiniLang e aplicar na prática diversos conceitos estudados na disciplina de Teoria da Computação. A construção do Lexer, Parser, Semantic Analyzer, Code Generator e Virtual Machine demonstrou como linguagens de programação são analisadas e executadas internamente, reforçando os conceitos teóricos por meio de uma aplicação prática.
