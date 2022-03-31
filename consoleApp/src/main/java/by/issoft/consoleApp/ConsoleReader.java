package by.issoft.consoleApp;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.store.Store;
import by.issoft.store.productComparatorUtil.ProductComparatorUtil;
import by.issoft.store.threadsCreatorUtil.ThreadCreatorUtil;
import by.issoft.store.xmlReader.XMLReader;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;


public class ConsoleReader {
    private final Store store;
    private final Scanner scanner;
    private final ThreadCreatorUtil threadCreatorUtil;

    private final String SORT_COMMAND = "sort";
    private final String SORT_COMMAND_DESCRIPTION = "Print sorted products";
    private final String TOP_COMMAND = "top";
    private final String TOP_COMMAND_DESCRIPTION = "Print top 5 products by price";
    private final String QUIT_COMMAND = "quit";
    private final String ORDER_COMMAND = "order";
    private final String commandsInfo = "___Store App___\n"
            + "Available commands:\n"
            + "- " + SORT_COMMAND + " : " + SORT_COMMAND_DESCRIPTION + "\n"
            + "- " + TOP_COMMAND + " : " + TOP_COMMAND_DESCRIPTION + "\n"
            + "- " + ORDER_COMMAND + "\n"
            + "- " + QUIT_COMMAND;

    public ConsoleReader(Store store, InputStream inputStream) {
        this.store = store;
        scanner = new Scanner(inputStream);
        threadCreatorUtil = new ThreadCreatorUtil(store);
    }

    public void start() {
        boolean messageIsNotExit = true;
        threadCreatorUtil.createClearingPurchasedGoodsThread();
        while (messageIsNotExit) {
            System.out.println(commandsInfo);
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
                case ORDER_COMMAND: {
                    createOrder();
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

    private void createOrder() {
        System.out.print("Choose category or quit:\n" + store.getAllCategories());
        String message = scanner.nextLine();
        if (!QUIT_COMMAND.equals(message)) {
            try {
                int numOfCategory = Integer.parseInt(message);
                Category category = store.getCategoryList().get(numOfCategory - 1);
                System.out.println("Choose product or quit:");
                List<Product> productList = category.getSortedProductsList(
                        ProductComparatorUtil.createComparator(XMLReader.getSortingRulesFromXML()));
                for (int i = 0; i < productList.size(); i++) {
                    System.out.println(i + 1 + " - " + productList.get(i));
                }
                message = scanner.nextLine();
                if (!QUIT_COMMAND.equals(message)) {
                    int numOfProduct = Integer.parseInt(message);
                    Product purchasedProduct = productList.get(numOfProduct - 1);
                    threadCreatorUtil.createAddingProductThread(purchasedProduct);
                }
            } catch (NumberFormatException | IndexOutOfBoundsException exception) {
                System.out.println("Wrong input");
            }
        }
    }
}
