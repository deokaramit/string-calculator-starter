package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public int extractDelimiter(String numbers) {
        Pattern p = Pattern.compile("^//(.+)\\n(.*)$");
        Matcher m = p.matcher(numbers);
        if (!m.matches()) {
            System.out.println("Input string not valid");
            return 0;
        }

        String delimString = m.group(1);
        String searchString = m.group(2);

        Pattern pDelim = Pattern.compile("\\[([^\\]]+)\\]");
        Matcher mDelim = pDelim.matcher(delimString);

        String delimiters = "";
        while (mDelim.find()) {
            delimiters += (Pattern.quote(mDelim.group(1)) + "|");
        }
        delimiters = delimiters.substring(0, delimiters.length() - 1);
        return add(searchString, delimiters);
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