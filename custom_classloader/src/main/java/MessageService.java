public class MessageService {
    private MessagePrinter messagePrinter;

    public void setMessagePrinter(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public void printMessage(String message) {
        messagePrinter.printMessage(message);
    }
}
