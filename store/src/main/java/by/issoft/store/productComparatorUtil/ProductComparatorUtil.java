package by.issoft.store.productComparatorUtil;

import by.issoft.domain.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ProductComparatorUtil {
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String RATE = "rate";
    public static final String DESCENDING = "desc";

    public static Comparator<Product> createComparator(Map<String, String> sortingRules) {
        List<Map.Entry<String, String>> listOfRules = new ArrayList<>();
        sortingRules.entrySet().forEach(listOfRules::add);
        Comparator<Product> comparator = createComparator(listOfRules.get(0));
        for (int i = 1; i < listOfRules.size(); i++) {
            comparator = createComparatorFromExisting(comparator, listOfRules.get(i));
        }
        return comparator;
    }

    private static Comparator<Product> createComparator(Map.Entry<String, String> firstElement) {
        String field = firstElement.getKey();
        String order = firstElement.getValue();
        Comparator<Product> comparator;
        switch (field) {
            case NAME: {
                comparator = (DESCENDING.equals(order)) ?
                        Comparator.comparing(Product::getName, Comparator.reverseOrder()) :
                        Comparator.comparing(Product::getName);
                break;
            }
            case PRICE: {
                comparator = (DESCENDING.equals(order)) ?
                        Comparator.comparing(Product::getPrice, Comparator.reverseOrder()) :
                        Comparator.comparing(Product::getPrice);
                break;
            }
            case RATE: {
                comparator = (DESCENDING.equals(order)) ?
                        Comparator.comparing(Product::getRate, Comparator.reverseOrder()) :
                        Comparator.comparing(Product::getRate);
                break;
            }
            default:
                return Comparator.comparing(Product::getName);
        }
        return comparator;
    }

    private static Comparator<Product> createComparatorFromExisting(Comparator<Product> comparator, Map.Entry<String, String> element) {
        String field = element.getKey();
        String order = element.getValue();
        switch (field) {
            case NAME: {
                comparator = (DESCENDING.equals(order)) ?
                        comparator.thenComparing(Product::getName, Comparator.reverseOrder()) :
                        comparator.thenComparing(Product::getName);
                break;
            }
            case PRICE: {
                comparator = (DESCENDING.equals(order)) ?
                        comparator.thenComparing(Product::getPrice, Comparator.reverseOrder()) :
                        comparator.thenComparing(Product::getPrice);
                break;
            }
            case RATE: {
                comparator = (DESCENDING.equals(order)) ?
                        comparator.thenComparing(Product::getRate, Comparator.reverseOrder()) :
                        comparator.thenComparing(Product::getRate);
                break;
            }
            default:
                return comparator;
        }
        return comparator;
    }
}

