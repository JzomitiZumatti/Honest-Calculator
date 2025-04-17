public class InputParser {
    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String[] parseInput(String input) {
        return input.trim().split("\\s+");
    }
}
