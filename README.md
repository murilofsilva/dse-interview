# Gerador de Anagramas em Java

## Descrição do Projeto

Este projeto é uma aplicação Java simples que gera todos os anagramas possíveis de uma palavra fornecida pelo usuário. O programa lê uma palavra, valida sua entrada para garantir que contenha apenas letras, e então calcula e imprime todos os anagramas possíveis, sem repetições.

---

## Como funciona a geração de anagramas?

A geração de anagramas é feita através de uma técnica recursiva chamada **backtracking**, que constrói permutações de caracteres passo a passo.

### Lógica da Recursão

Dada uma string de entrada, o algoritmo:

1. Mantém uma `prefix` que representa a parte já construída da permutação.
2. Mantém um `remaining` que contém os caracteres ainda não usados.
3. Se `remaining` estiver vazio, a permutação está completa e adiciona o `prefix` ao conjunto de resultados.
4. Caso contrário, para cada caractere em `remaining`:

   * Remove o caractere da posição atual.
   * Chama recursivamente a função com o `prefix` acrescido deste caractere e o `remaining` atualizado.
5. Como o resultado é armazenado em um `Set`, evita anagramas duplicados automaticamente.

---

## Estrutura do Código

* **TextProcessor**:
  Classe principal que contém a lógica para gerar anagramas (`generateAnagrams` e método auxiliar recursivo `generatePermutations`), além do método `main` para interação com o usuário.

* **InputValidator**:
  Classe responsável por validar a entrada do usuário, garantindo que ela não seja nula, vazia ou contenha caracteres inválidos.

* **InvalidInputException**:
  Exceção personalizada para sinalizar entradas inválidas.

---

## Boas Práticas e Clean Code aplicados

### 1. **Separação de responsabilidades (Single Responsibility Principle)**

Cada classe tem uma responsabilidade clara: validação de entrada, geração de anagramas e interface com o usuário. Isso facilita manutenção e extensibilidade.

### 2. **Tratamento de exceções**

O código trata exceções específicas (`InvalidInputException`) e também possui um bloco `catch` genérico para evitar falhas inesperadas, garantindo maior robustez.

### 3. **Uso de Set para evitar duplicidade**

A utilização de `HashSet` garante que anagramas repetidos não sejam adicionados ao resultado, evitando trabalho desnecessário.

### 4. **Código legível e autoexplicativo**

Nomes de métodos e variáveis são claros (`generateAnagrams`, `generatePermutations`, `prefix`, `remaining`), tornando o código fácil de entender sem necessidade de comentários excessivos.

### 5. **Métodos pequenos e focados**

A geração dos anagramas está dividida em um método público (`generateAnagrams`) e um método privado recursivo (`generatePermutations`), seguindo o princípio de decomposição funcional.

### 6. **Validação antecipada (fail-fast)**

Antes de processar a entrada, o código valida os dados recebidos para evitar processamento desnecessário e erros posteriores.

---

## Padrões de Projeto Utilizados

Embora o projeto seja simples e não use frameworks, alguns padrões básicos podem ser reconhecidos:

* **Template Method (parcialmente)**:
  A separação entre validação e geração dos anagramas pode ser vista como etapas de um template para processamento de entrada.

* **Defensive Programming**:
  Validar entrada e tratar exceções previne comportamentos errôneos.

* **Imutabilidade em recursão**:
  Em `generatePermutations`, `prefix` e `remaining` são tratados como novos objetos em cada chamada, evitando efeitos colaterais.

---

## Como executar

1. Compile as classes:

```bash
javac src/*.java
```

2. Execute a aplicação:

```bash
java src.TextProcessor
```

3. Insira uma palavra contendo apenas letras quando solicitado.

4. O programa exibirá todos os anagramas possíveis e o total encontrado.

## Possíveis melhorias futuras

* Adicionar suporte para palavras com caracteres repetidos sem gerar permutações duplicadas (otimização do algoritmo).
* Implementar interface gráfica.
* Permitir entrada com caracteres acentuados.
* Transformar o gerador de anagramas em uma biblioteca reutilizável com testes unitários mais robustos.
