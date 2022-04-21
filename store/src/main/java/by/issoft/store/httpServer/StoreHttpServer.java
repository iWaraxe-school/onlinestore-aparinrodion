package by.issoft.store.httpServer;

import by.issoft.store.Store;
import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpServer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

@Slf4j
public class StoreHttpServer {
    private static final int PORT = 8080;
    public static final String LOCALHOST = "http://localhost:" + PORT;
    public static final String SORT = "/sort";
    public static final String TOP = "/top";
    public static final String CATEGORIES = "/categories";
    public static final String PRODUCTS = "/products/";
    public static final String CART = "/cart";
    public static final String SORT_URL = LOCALHOST + SORT;
    public static final String TOP_URL = LOCALHOST + TOP;
    public static final String CATEGORIES_URL = LOCALHOST + CATEGORIES;
    public static final String PRODUCTS_URL = LOCALHOST + PRODUCTS;
    public static final String CART_URL = LOCALHOST + CART;

    private final HttpServer server;

    @SneakyThrows
    public StoreHttpServer() {
        server = HttpServer.create(new InetSocketAddress(PORT), 0);
        BasicAuthenticator authenticator = new StoreBasicAuthenticator("users");
        server.createContext("/", exchange -> {
            String text = "Welcome to StoreApp!!!";
            HttpResponseUtil.sendResponse(exchange, text);
        }).setAuthenticator(authenticator);
        server.createContext(SORT, new SortedStoreHandler()).setAuthenticator(authenticator);
        server.createContext(TOP, new TopFiveProductsHandler()).setAuthenticator(authenticator);
        server.createContext(CATEGORIES, exchange -> {
            String categories = Store.getInstance().getAllCategories();
            HttpResponseUtil.sendResponse(exchange, categories);
        }).setAuthenticator(authenticator);
        server.createContext(PRODUCTS, new ProductsHandler()).setAuthenticator(authenticator);
        server.createContext(CART, new CartHandler()).setAuthenticator(authenticator);
    }

    public void start() {
        server.start();
        log.info("Server is working");
    }

    public void stop() {
        server.stop(0);
        log.info("Server stopped");
    }

}
