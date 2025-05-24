package tests;

import org.junit.jupiter.api.Test;
import src.TextProcessor;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    @Test
    void testThreeLetterAnagrams() {
        Set<String> result = TextProcessor.generateAnagrams("abc");
        assertEquals(6, result.size());
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
    }

    @Test
    void testSingleLetter() {
        Set<String> result = TextProcessor.generateAnagrams("x");
        assertEquals(1, result.size());
        assertTrue(result.contains("x"));
    }

    @Test
    void testEmptyInput() {
        Set<String> result = TextProcessor.generateAnagrams("");
        assertEquals(1, result.size());
        assertTrue(result.contains(""));
    }

    @Test
    void testTwoLetters() {
        Set<String> result = TextProcessor.generateAnagrams("ab");
        assertEquals(2, result.size());
        assertTrue(result.contains("ab"));
        assertTrue(result.contains("ba"));
    }

    @Test
    void testDuplicateLetters() {
        Set<String> result = TextProcessor.generateAnagrams("aab");
        assertEquals(3, result.size());
        assertTrue(result.contains("aab"));
        assertTrue(result.contains("aba"));
        assertTrue(result.contains("baa"));
    }

    @Test
    void testSameLetters() {
        Set<String> result = TextProcessor.generateAnagrams("aaa");
        assertEquals(1, result.size());
        assertTrue(result.contains("aaa"));
    }

    @Test
    void testCaseInsensitive() {
        Set<String> result = TextProcessor.generateAnagrams("Ab");
        assertEquals(2, result.size());
        assertTrue(result.contains("Ab"));
        assertTrue(result.contains("bA"));
    }
}