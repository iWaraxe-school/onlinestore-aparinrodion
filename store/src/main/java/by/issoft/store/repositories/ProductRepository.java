package by.issoft.store.repositories;

import by.issoft.domain.Product;
import by.issoft.store.db.DatabaseConnection;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final static String GET_ALL_PRODUCTS_BY_CATEGORY =
            "SELECT * FROM Products WHERE category=?";
    private final static String GET_PRODUCT_BY_NAME =
            "SELECT * FROM Products WHERE name=?";
    private final static String ADD_PRODUCT =
            "INSERT INTO Products(name, rate, price, category) values (?,?,?,?)";
    private final static String GET_ALL_PRODUCTS = "SELECT * FROM Products";


    @SneakyThrows
    public List<Product> getAllProductsByCategory(String categoryName) {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection
                .prepareStatement(GET_ALL_PRODUCTS_BY_CATEGORY);
        preparedStatement.setString(1, categoryName);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Product> resultList = getListOfProductsFromResultSet(resultSet);
        connection.close();
        return resultList;
    }

    @SneakyThrows
    public void addProduct(Product product, String category) {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection
                .prepareStatement(ADD_PRODUCT);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getRate());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setString(4, category);
        preparedStatement.executeUpdate();
        connection.close();
    }

    @SneakyThrows
    public Product getProductByName(String productName) {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection
                .prepareStatement(GET_PRODUCT_BY_NAME);
        preparedStatement.setString(1, productName);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String name = resultSet.getString("name");
        Double rate = resultSet.getDouble("rate");
        Double price = resultSet.getDouble("price");
        connection.close();
        return new Product(name, rate, price);
    }


    @SneakyThrows
    public List<Product> getAllProducts() {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_ALL_PRODUCTS);
        List<Product> resultList = getListOfProductsFromResultSet(resultSet);
        connection.close();
        return resultList;
    }

    private List<Product> getListOfProductsFromResultSet(ResultSet resultSet) throws SQLException {
        List<Product> productList = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            Double rate = resultSet.getDouble("rate");
            Double price = resultSet.getDouble("price");
            productList.add(new Product(name, rate, price));
        }
        return productList;
    }

}
