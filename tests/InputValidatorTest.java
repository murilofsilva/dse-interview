package tests;

import org.junit.jupiter.api.Test;
import src.InputValidator;
import src.InvalidInputException;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    @Test
    void testValidInput() {
        assertDoesNotThrow(() -> InputValidator.validate("palavra"));
        assertDoesNotThrow(() -> InputValidator.validate("abc"));
        assertDoesNotThrow(() -> InputValidator.validate("A"));
        assertDoesNotThrow(() -> InputValidator.validate("AbC"));
    }

    @Test
    void testNullInput() {
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> InputValidator.validate(null)
        );
        assertEquals("A entrada não pode ser nula.", exception.getMessage());
    }

    @Test
    void testEmptyInput() {
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> InputValidator.validate("")
        );
        assertEquals("A entrada está vazia. Digite uma palavra.", exception.getMessage());
    }

    @Test
    void testWhitespaceOnlyInput() {
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> InputValidator.validate("   ")
        );
        assertEquals("A entrada está vazia. Digite uma palavra.", exception.getMessage());
    }

    @Test
    void testInputWithNumbers() {
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> InputValidator.validate("abc123")
        );
        assertEquals("A entrada deve conter apenas letras (sem espaços, números ou símbolos).", exception.getMessage());
    }

    @Test
    void testInputWithSpaces() {
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> InputValidator.validate("a b c")
        );
        assertEquals("A entrada deve conter apenas letras (sem espaços, números ou símbolos).", exception.getMessage());
    }

    @Test
    void testInputWithSymbols() {
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> InputValidator.validate("abc@#$")
        );
        assertEquals("A entrada deve conter apenas letras (sem espaços, números ou símbolos).", exception.getMessage());
    }
}