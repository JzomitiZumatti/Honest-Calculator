import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    private float memory;
    public void start() {
        Scanner scanner = new Scanner(System.in);
        InputHandler parser;
        String input;
        boolean valid;
        boolean isOn = true;

        while (isOn) {
            do {
                System.out.println(Message.MSG_0);
                input = scanner.nextLine();
                valid = validateInput(input);
            } while (!valid);
            parser = new InputHandler(input, memory);

            String firstNumber = parser.getResolvedFirstNumber();
            String secondNumber = parser.getResolvedSecondNumber();
            String operation = parser.getOperation();

            memory = Objects.requireNonNull(OperationFactory.getOperation(operation))
                    .execute(Float.parseFloat(firstNumber),
                            Float.parseFloat(secondNumber));

            System.out.println(memory);
            System.out.println(Message.MSG_4);
            input = scanner.nextLine();
            if (!storeResult(input)) {
                memory = 0f;
                System.out.println(memory);
            }
            System.out.println(Message.MSG_5);
            input = scanner.nextLine();
            if (!continueCalculation(input)) {
                isOn = false;
            }
        }
        scanner.close();
    }

    private boolean validateInput(String input) {
        InputHandler parser = new InputHandler(input, memory);

        String firstNumber = parser.getResolvedFirstNumber();
        String secondNumber = parser.getResolvedSecondNumber();
        String operation = parser.getOperation();

        if (!InputHandler.isNumber(firstNumber) || !InputHandler.isNumber(secondNumber)) {
            System.out.println(Message.MSG_1);
            return false;
        } else if (OperationFactory.getOperation(operation) == null) {
            System.out.println(Message.MSG_2);
            return false;
        } else if (operation.equals("/") && Float.parseFloat(secondNumber) == 0) {
            System.out.println(Message.MSG_3);
            return false;
        } else {
            Objects.requireNonNull(OperationFactory.getOperation(operation))
                    .execute(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber));
            return true;
        }
    }


    private boolean storeResult(String input) {
        return input.equalsIgnoreCase("y");
    }

    private boolean continueCalculation(String input) {
        return input.equalsIgnoreCase("y");
    }

}
