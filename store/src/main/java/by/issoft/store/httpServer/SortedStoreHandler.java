package by.issoft.store.httpServer;

import by.issoft.store.Store;
import by.issoft.store.productComparatorUtil.ProductComparatorUtil;
import by.issoft.store.xmlReader.XMLReader;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class SortedStoreHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) {
        String sortedStore = Store.getInstance().getSortedStore(ProductComparatorUtil
                .createComparator(XMLReader.getSortingRulesFromXML()));
        HttpResponseUtil.sendResponse(exchange, sortedStore);
    }
}
