package by.issoft.consoleApp;

import by.issoft.store.Store;
import by.issoft.store.db.DatabaseUtil;

public class StoreApp {
    public static void main(String[] args) {
        Store store = Store.getInstance();
        DatabaseUtil.initDatabases();
        ConsoleReader consoleReader = new ConsoleReader(store, System.in);
        consoleReader.start();

    }
}
