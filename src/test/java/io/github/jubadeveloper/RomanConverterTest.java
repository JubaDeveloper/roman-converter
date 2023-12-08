package io.github.jubadeveloper;

import io.github.jubadeveloper.converter.RomanConverter;
import io.github.jubadeveloper.converter.exceptions.InputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RomanConverterTest {
    private  final RomanConverter romanConverter = new RomanConverter();
    @Test
    @DisplayName("Testing invalid input")
    public void throwOnInvalidInput () {
        InputException inputExceptionCase1 = Assertions.assertThrows(InputException.class, () -> {
            romanConverter.validateIn("");
        });
        Assertions.assertEquals(inputExceptionCase1.getMessage(), "Input cant be empty");
        InputException inputExceptionCase2 = Assertions.assertThrows(InputException.class, () -> {
            romanConverter.validateIn("ivxlxxa");
        });
        Assertions.assertEquals(inputExceptionCase2.getMessage(), "Invalid input format");
    }
    @Test
    @DisplayName("Testing conversion")
    public void converterGivenRomanLiteral () throws Exception {
        String romanCase1 = "IV";
        Double resultCase1 = romanConverter.converterIn(romanCase1);
        Assertions.assertEquals(4d, resultCase1);
        String romanCase2 = "IVVX";
        Double resultCase2 = romanConverter.converterIn(romanCase2);
        Assertions.assertEquals(9d, resultCase2);
        String romanCase3 = "XIXIXILV";
        Double resultCase3 = romanConverter.converterIn(romanCase3);
        Assertions.assertEquals(82d, resultCase3);
    }
}
