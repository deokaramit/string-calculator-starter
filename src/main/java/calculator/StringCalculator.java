package calculator;

class StringCalculator {

    public int add(String input) {
        int returnValue = 0;
        String[] numbers = input.split(",|\n");
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                returnValue += Integer.parseInt(number);
            }
        }
        return returnValue;
    }

}