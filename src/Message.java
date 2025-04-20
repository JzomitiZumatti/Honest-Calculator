public enum Message {
    MSG_0("Enter an equation"),
    MSG_1("Do you even know what numbers are? Stay focused!"),
    MSG_2("Yes ... an interesting math operation. You've slept through all classes, haven't you?"),
    MSG_3("Yeah... division by zero. Smart move..."),
    MSG_4("Do you want to store the result? (y / n):"),
    MSG_5("Do you want to continue calculations? (y / n):"),
    MSG_6(" ... lazy"),
    MSG_7(" ... very lazy"),
    MSG_8(" ... very, very lazy"),
    MSG_9("You are");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
