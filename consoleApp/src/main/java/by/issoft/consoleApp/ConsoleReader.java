package by.issoft.consoleApp;

import by.issoft.store.Store;
import by.issoft.store.productComparatorUtil.ProductComparatorUtil;
import by.issoft.store.xmlReader.XMLReader;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader {
    private final Store store;
    private final Scanner scanner;

    private final String SORT_COMMAND = "sort";
    private final String SORT_COMMAND_DESCRIPTION = "Print sorted products";
    private final String TOP_COMMAND = "top";
    private final String TOP_COMMAND_DESCRIPTION = "Print top 5 products by price";
    private final String QUIT_COMMAND = "quit";
    private final String commandsInfo = "___Store App___\n"
            + "Available commands:\n"
            + "- " + SORT_COMMAND + " : " + SORT_COMMAND_DESCRIPTION + "\n"
            + "- " + TOP_COMMAND + " : " + TOP_COMMAND_DESCRIPTION + "\n"
            + "- " + QUIT_COMMAND;

    public ConsoleReader(Store store, InputStream inputStream) {
        this.store = store;
        scanner = new Scanner(inputStream);
    }

    public void start() {
        System.out.println(commandsInfo);
        boolean messageIsNotExit = true;
        while (messageIsNotExit) {
            String message = scanner.nextLine();
            switch (message) {
                case SORT_COMMAND: {
                    System.out.print(store
                            .getSortedStore(ProductComparatorUtil.createComparator(XMLReader.getSortingRulesFromXML())));
                    break;
                }
                case TOP_COMMAND: {
                    System.out.print(store.getTopFiveByPrice());
                    break;
                }
                case QUIT_COMMAND: {
                    System.out.println("Goodbye!");
                    messageIsNotExit = false;
                    break;
                }
                default: {
                    System.out.println("Command " + message + " is not supported");
                }
            }
        }
    }
}
