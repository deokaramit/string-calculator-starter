package calculator;

import java.util.ArrayList;
import java.util.List;

class StringCalculator {

    public int add(String numbers) {
        String delimiter = ",|\n";
        String numbersWithoutDelimiter = numbers;
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("//") + 2;
            delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
            numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n") + 1);
        }
        return add(numbersWithoutDelimiter, delimiter);
    }

    public int add(String input, String delimiter) {
        int returnValue = 0;
        String[] numbers = input.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int intNumber = Integer.parseInt(number.trim());
                if (intNumber < 0) {
                    negativeNumbers.add(intNumber);
                } else if (intNumber <= 1000) {
                    returnValue += intNumber;
                }
            }
        }
        if (negativeNumbers.size() == 1) {
            throw new RuntimeException("Negatives not allowed");
        } else if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return returnValue;
    }

}