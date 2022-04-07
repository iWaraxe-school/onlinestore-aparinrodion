package by.issoft.store.httpServer;

import by.issoft.store.Store;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.SneakyThrows;

public class ProductsHandler implements HttpHandler {
    @SneakyThrows
    @Override
    public void handle(HttpExchange exchange) {
        String uri = exchange.getRequestURI().toString();
        String productsPath = "products/";
        String categoryName = uri.substring(uri.lastIndexOf(productsPath) + productsPath.length());
        StringBuilder stringBuilder = new StringBuilder();
        Store.getInstance().getAllProductByCategory(categoryName)
                .forEach(product -> stringBuilder.append(product).append("\n"));
        HttpResponseUtil.sendResponse(exchange, stringBuilder.toString());
    }
}
