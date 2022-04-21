package by.issoft.store.httpServer;

import by.issoft.domain.Product;
import by.issoft.store.Store;
import by.issoft.store.threadsCreatorUtil.ThreadCreatorUtil;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.SneakyThrows;

import java.io.InputStreamReader;
import java.util.Scanner;

public class CartHandler implements HttpHandler {
    @SneakyThrows
    @Override
    public void handle(HttpExchange exchange) {
        exchange.sendResponseHeaders(200, 0);
        Scanner scanner = new Scanner(new InputStreamReader(exchange.getRequestBody()));
        String productName = scanner.nextLine();
        scanner.close();
        Product product = Store.getInstance().getProductByName(productName);
        ThreadCreatorUtil.getInstance(Store.getInstance()).
                createAddingProductThread(product);
    }
}
