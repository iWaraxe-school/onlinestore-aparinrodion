package by.issoft.store.httpServer;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class HttpResponseUtil {

    public static void sendResponse(HttpExchange exchange, String data) {
        try {
            exchange.sendResponseHeaders(200, data.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(data.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
