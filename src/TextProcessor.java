package src;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TextProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra (apenas letras): ");
        String userInput = scanner.nextLine();

        try {
            InputValidator.validate(userInput);
            Set<String> anagrams = generateAnagrams(userInput);
            printAnagrams(userInput, anagrams);
        } catch (InvalidInputException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro desconhecido: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static Set<String> generateAnagrams(String input) {
        Set<String> result = new HashSet<>();
        generatePermutations("", input, result);
        return result;
    }

    private static void generatePermutations(String prefix, String remaining, Set<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutations(newPrefix, newRemaining, result);
        }
    }

    private static void printAnagrams(String original, Set<String> anagrams) {
        System.out.println("\nAnagramas possíveis de \"" + original + "\":");
        for (String word : anagrams) {
            System.out.println(word);
        }
        System.out.println("Total: " + anagrams.size() + " anagramas.");
    }
}