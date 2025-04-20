public class InputHandler {
    private final String firstNumber;
    private final String secondNumber;
    private final String operation;
    private final float memory;

    public InputHandler(String input, float memory) {
        String[] inputParts = parseInput(input);
        this.firstNumber = inputParts[0];
        this.operation = inputParts[1];
        this.secondNumber = inputParts[2];
        this.memory = memory;
    }

    private String resolveValue(String value) {
        if (value.equalsIgnoreCase("M")) {
            return Float.toString(memory);
        } else {
            return value;
        }
    }

    public static boolean isNumber(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOneDigit(String str) {
        float number = Float.parseFloat(str);
        return number / Math.floor(number) == 1.0f && number > - 10 && number < 10 || number == 0;
    }

    public static String[] parseInput(String input) {
        return input.trim().split("\\s+");
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public String getResolvedFirstNumber() {
        return resolveValue(firstNumber);
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public String getResolvedSecondNumber() {
        return resolveValue(secondNumber);
    }

    public String getOperation() {
        return operation;
    }
}
