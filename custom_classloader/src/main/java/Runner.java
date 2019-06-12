import java.io.*;

public class Runner {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MessageService messageService = new MessageService();
        messageService.setMessagePrinter(new ConsoleMessagePrinter());
        String message = "Hello";

        messageService.printMessage(message);
        //Загружаем класс из папки resources и подменяем реализацию
        //messageService.printMessage(message); - вывод должен быть "Hello world!"
        ClassLoader classLoader = new CustomClassloader(ClassLoader.getSystemClassLoader());
        Class<?> consoleMessagePrinterClass = classLoader.loadClass("custom_classloader/src/main/resources/ConsoleMessagePrinter.class");
        MessagePrinter messagePrinter = (MessagePrinter) consoleMessagePrinterClass.newInstance();
        messageService.setMessagePrinter(messagePrinter);
        messageService.printMessage(message);
    }
}
