import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean valid;

        do {
            System.out.println(Message.MSG_0);
            input = scanner.nextLine();
            valid = validateInput(input);
        } while (!valid);
    }

    private boolean validateInput(String input) {
        String[] elementsOfInput = InputParser.parseInput(input);
        if (!InputParser.isNumber(elementsOfInput[0]) || !InputParser.isNumber(elementsOfInput[2])) {
            System.out.println(Message.MSG_1);
            return false;
        } else if (OperationFactory.getOperation(elementsOfInput[1]) == null) {
            System.out.println(Message.MSG_2);
            return false;
        } else {
            Objects.requireNonNull(OperationFactory.getOperation(elementsOfInput[1])).execute(Double.parseDouble(elementsOfInput[0]),
                    Double.parseDouble(elementsOfInput[2]));
            return true;
        }
    }
}
