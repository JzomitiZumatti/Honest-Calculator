import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    private float memory;
    private final Scanner scanner = new Scanner(System.in);
    public void start() {
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

            String msg = checkInputValues(input);
            if (!msg.isEmpty()) {
                System.out.println(msg);
            }

            float result = Objects.requireNonNull(OperationFactory.getOperation(operation))
                    .execute(Float.parseFloat(firstNumber),
                            Float.parseFloat(secondNumber));

            System.out.printf("%.1f\n", result);

            memorySaver(result);

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

    public String checkInputValues(String input) {
        StringBuilder message = new StringBuilder();
        InputHandler parser = new InputHandler(input, memory);

        String firstNumber = parser.getResolvedFirstNumber();
        String secondNumber = parser.getResolvedSecondNumber();
        String operation = parser.getOperation();
        if (InputHandler.isOneDigit(firstNumber) && InputHandler.isOneDigit(secondNumber)) {
            message.append(Message.MSG_6);
        }
        if ((Float.parseFloat(firstNumber) == 1 || Float.parseFloat(secondNumber) == 1) &&
                operation.equals("*")) {
            message.append(Message.MSG_7);
        }
        if ((Float.parseFloat(firstNumber) == 0 || Float.parseFloat(secondNumber) == 0) &&
                (operation.equals("*") || operation.equals("+") || operation.equals("-"))) {
            message.append(Message.MSG_8);
        }
        if (!message.isEmpty()) {
            message.insert(0, Message.MSG_9);
        }
        return message.toString();
    }


    private void memorySaver(float result) {
        System.out.println(Message.MSG_4);
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y") && !InputHandler.isOneDigit(result)) {
            memory = result;
            return;
        }

        if (choice.equalsIgnoreCase("n")) {
            return;
        }

        int msgIndex = 10;
        while (msgIndex <= 12) {
            System.out.println(getMessageByIndex(msgIndex));
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                if (msgIndex == 12) {
                    memory = result;
                    return;
                }
                msgIndex++;
            } else if (choice.equalsIgnoreCase("n")) {
                return;
            }
        }
    }

    private Message getMessageByIndex(int index) {
        return switch (index) {
            case 10 -> Message.MSG_10;
            case 11 -> Message.MSG_11;
            case 12 -> Message.MSG_12;
            default -> null;
        };
    }

    private boolean continueCalculation(String input) {
        return input.equalsIgnoreCase("y");
    }

}
