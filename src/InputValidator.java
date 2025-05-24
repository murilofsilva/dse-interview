package src;

public class InputValidator {

    public static void validate(String input) throws InvalidInputException {
        if (input == null) {
            throw new InvalidInputException("A entrada não pode ser nula.");
        }

        if (input.trim().isEmpty()) {
            throw new InvalidInputException("A entrada está vazia. Digite uma palavra.");
        }

        if (!input.matches("[a-zA-Z]+")) {
            throw new InvalidInputException("A entrada deve conter apenas letras (sem espaços, números ou símbolos).");
        }
    }
}