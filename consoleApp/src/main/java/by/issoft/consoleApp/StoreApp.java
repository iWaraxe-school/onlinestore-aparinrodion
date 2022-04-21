package by.issoft.consoleApp;

import by.issoft.store.db.DatabaseUtil;
import by.issoft.store.httpServer.StoreHttpServer;

public class StoreApp {
    public static void main(String[] args) {
        DatabaseUtil.initDatabases();
        StoreHttpServer server = new StoreHttpServer();
        server.start();
        ConsoleReader consoleReader = new ConsoleReader();
        consoleReader.start();
        server.stop();
        System.exit(0);
    }
}
