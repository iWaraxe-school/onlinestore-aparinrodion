package by.issoft.store.productComparatorUtil;

import by.issoft.domain.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ProductComparatorUtilTest {
    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String RATE = "rate";
    private static final String DESCENDING = "desc";
    private static final String ASCENDING = "asc";

    private static final List<Product> productList = new ArrayList<>();
    private Comparator<Product> comparator;
    private Comparator<Product> myComparator;
    private Map<String, String> sortingRules;

    @BeforeAll
    static void fillProduct() {
        productList.add(new Product("a", 5.6, 50.));
        productList.add(new Product("a1", 5.6, 51.));
        productList.add(new Product("b", 5.4, 51.));
        productList.add(new Product("b1", 5.2, 53.));
        productList.add(new Product("c", 5.2, 52.));
        productList.add(new Product("c1", 5.1, 55.));
    }

    @Test
    void comparingByNameDescendingTest() {
        sortingRules = new LinkedHashMap<>();
        sortingRules.put(NAME, DESCENDING);
        myComparator = Comparator.comparing(Product::getName, Comparator.reverseOrder());
        comparator = ProductComparatorUtil.createComparator(sortingRules);
        assertEquals(productList.stream().sorted(myComparator).collect(Collectors.toList()),
                productList.stream().sorted(comparator).collect(Collectors.toList()));
    }

    @Test
    void comparingByNameAscendingTest() {
        sortingRules = new LinkedHashMap<>();
        sortingRules.put(NAME, ASCENDING);
        myComparator = Comparator.comparing(Product::getName);
        comparator = ProductComparatorUtil.createComparator(sortingRules);
        assertEquals(productList.stream().sorted(myComparator).collect(Collectors.toList()),
                productList.stream().sorted(comparator).collect(Collectors.toList()));
    }

    @Test
    void comparingByPriceDescendingTest() {
        sortingRules = new LinkedHashMap<>();
        sortingRules.put(PRICE, DESCENDING);
        myComparator = Comparator.comparing(Product::getPrice, Comparator.reverseOrder());
        comparator = ProductComparatorUtil.createComparator(sortingRules);
        assertEquals(productList.stream().sorted(myComparator).collect(Collectors.toList()),
                productList.stream().sorted(comparator).collect(Collectors.toList()));
    }

    @Test
    void comparingByPriceAscendingTest() {
        sortingRules = new LinkedHashMap<>();
        sortingRules.put(PRICE, ASCENDING);
        myComparator = Comparator.comparing(Product::getPrice);
        comparator = ProductComparatorUtil.createComparator(sortingRules);
        assertEquals(productList.stream().sorted(myComparator).collect(Collectors.toList()),
                productList.stream().sorted(comparator).collect(Collectors.toList()));
    }


    @Test
    void comparingByRateDescendingTest() {
        sortingRules = new LinkedHashMap<>();
        sortingRules.put(RATE, DESCENDING);
        myComparator = Comparator.comparing(Product::getRate, Comparator.reverseOrder());
        comparator = ProductComparatorUtil.createComparator(sortingRules);
        assertEquals(productList.stream().sorted(myComparator).collect(Collectors.toList()),
                productList.stream().sorted(comparator).collect(Collectors.toList()));
    }

    @Test
    void comparingByRateAscendingTest() {
        sortingRules = new LinkedHashMap<>();
        sortingRules.put(RATE, ASCENDING);
        myComparator = Comparator.comparing(Product::getRate);
        comparator = ProductComparatorUtil.createComparator(sortingRules);
        assertEquals(productList.stream().sorted(myComparator).collect(Collectors.toList()),
                productList.stream().sorted(comparator).collect(Collectors.toList()));
    }

    @Test
    void comparingByMultipleTest() {
        sortingRules = new LinkedHashMap<>();
        sortingRules.put(RATE, ASCENDING);
        sortingRules.put(PRICE, DESCENDING);
        myComparator = Comparator.comparing(Product::getRate)
                .thenComparing(Product::getPrice, Comparator.reverseOrder());
        comparator = ProductComparatorUtil.createComparator(sortingRules);
        assertEquals(productList.stream().sorted(myComparator).collect(Collectors.toList()),
                productList.stream().sorted(comparator).collect(Collectors.toList()));

        sortingRules.put(NAME, ASCENDING);
        myComparator = myComparator.thenComparing(Product::getName);
        comparator = ProductComparatorUtil.createComparator(sortingRules);
        assertEquals(productList.stream().sorted(myComparator).collect(Collectors.toList()),
                productList.stream().sorted(comparator).collect(Collectors.toList()));
    }

    @Test
    void when_map_is_wrong() {
        sortingRules = new LinkedHashMap<>();
        sortingRules.put("wrong", ASCENDING);
        myComparator = Comparator.comparing(Product::getName);
        comparator = ProductComparatorUtil.createComparator(sortingRules);
        assertEquals(productList.stream().sorted(myComparator).collect(Collectors.toList()),
                productList.stream().sorted(comparator).collect(Collectors.toList()));
    }

}