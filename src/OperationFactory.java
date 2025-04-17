public class OperationFactory {
    public static Operation getOperation(String operation) {
        return switch (operation) {
            case "+" -> new Addition();
            case "-" -> new Subtraction();
            case "*" -> new Multiplication();
            case "/" -> new Division();
            default ->  null;
        };
    }
}
