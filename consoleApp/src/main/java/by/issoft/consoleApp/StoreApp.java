package by.issoft.consoleApp;

import by.issoft.store.RandomStorePopulator;
import by.issoft.store.Store;

public class StoreApp {
    public static void main(String[] args) {
        Store store = Store.getInstance();
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        randomStorePopulator.fillStore(store);

        ConsoleReader consoleReader = new ConsoleReader(store, System.in);
        consoleReader.start();
    }
}
