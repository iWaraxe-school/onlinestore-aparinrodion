package by.issoft.store.httpServer;

import by.issoft.store.Store;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class TopFiveProductsHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) {
        String topFiveProducts = Store.getInstance().getTopFiveByPrice();
        HttpResponseUtil.sendResponse(exchange, topFiveProducts);
    }
}
