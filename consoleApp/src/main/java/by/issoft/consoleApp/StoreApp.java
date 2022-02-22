package by.issoft.consoleApp;

import by.issoft.store.RandomStorePopulator;
import by.issoft.store.Store;
import by.issoft.store.productComparatorUtil.ProductComparatorUtil;
import by.issoft.store.xmlReader.XMLReader;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        randomStorePopulator.fillStore(store);

        System.out.println(store);

        System.out.println(store.getSortedStore(ProductComparatorUtil.createComparator(XMLReader.getSortingRulesFromXML())));

        System.out.println(store.getTopFiveByPrice());
    }
}
