package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public final void moreThan2NumbersThenHandleThem() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(12 + 46, 13, stringCalculator.add("12,46,13"));
    }

    @Test
    public final void newLineBetweenNumbersReturnTheirSums() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1 + 2, stringCalculator.add("//;\n1;2"));
    }
}
