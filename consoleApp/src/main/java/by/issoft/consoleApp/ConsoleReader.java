package by.issoft.consoleApp;

import by.issoft.store.Store;
import by.issoft.store.httpServer.StoreHttpServer;
import by.issoft.store.threadsCreatorUtil.ThreadCreatorUtil;
import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner;
    private CloseableHttpClient client;

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

    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    @SneakyThrows
    public void start() {
        boolean messageIsNotExit = true;
        ThreadCreatorUtil.getInstance(Store.getInstance()).createClearingPurchasedGoodsThread();
        while (messageIsNotExit) {
            System.out.println(commandsInfo);
            String message = scanner.nextLine();
            switch (message) {
                case SORT_COMMAND: {
                    System.out.println(executeGetRequest(StoreHttpServer.SORT_URL));
                    break;
                }
                case TOP_COMMAND: {
                    System.out.println(executeGetRequest(StoreHttpServer.TOP_URL));
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

    @SneakyThrows
    private void createOrder() {
        System.out.print("Choose category or quit:\n" + executeGetRequest(StoreHttpServer.CATEGORIES_URL));
        String categoryName = scanner.nextLine();
        if (!QUIT_COMMAND.equals(categoryName)) {
            System.out.println(executeGetRequest(StoreHttpServer.PRODUCTS_URL + categoryName));
            String productName = scanner.nextLine();
            HttpPost httpPost = new HttpPost(StoreHttpServer.CART_URL);
            httpPost.setEntity(new StringEntity(productName));
            client = createClient();
            client.execute(httpPost);
            client.close();
        }
    }

    private CloseableHttpClient createClient() {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials("username", "password");
        credentialsProvider.setCredentials(AuthScope.ANY, credentials);
        return HttpClients.custom().setDefaultCredentialsProvider(credentialsProvider).build();
    }

    private String executeGetRequest(String path) throws IOException {
        HttpGet httpGet = new HttpGet(path);
        client = createClient();
        HttpEntity entity = client.execute(httpGet).getEntity();
        String response = EntityUtils.toString(entity);
        client.close();
        return response;
    }
}
