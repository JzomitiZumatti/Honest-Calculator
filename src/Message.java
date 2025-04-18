public enum Message {
    MSG_0("Enter an equation"),
    MSG_1("Do you even know what numbers are? Stay focused!"),
    MSG_2("Yes ... an interesting math operation. You've slept through all classes, haven't you?"),
    MSG_3("Yeah... division by zero. Smart move...");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
