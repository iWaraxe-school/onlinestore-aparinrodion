package by.issoft.store.db;

import by.issoft.store.DatabasePopulator;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseUtil {
    private final static String DROP_IF_EXISTS_CATEGORIES = "DROP TABLE IF EXISTS Categories";
    private final static String DROP_IF_EXISTS_PRODUCTS = "DROP TABLE IF EXISTS Products";
    private final static String CREATE_CATEGORIES = "CREATE TABLE Categories(id INT PRIMARY KEY AUTO_INCREMENT" +
            ",name VARCHAR UNIQUE NOT NULL)";
    private final static String CREATE_PRODUCTS = "CREATE TABLE Products" +
            "(" +
            "    id INTEGER AUTO_INCREMENT PRIMARY KEY ," +
            "    name VARCHAR," +
            "    rate DOUBLE," +
            "    price DOUBLE," +
            "    category VARCHAR," +
            "    FOREIGN KEY (category) REFERENCES Categories(name)" +
            ")";

    @SneakyThrows
    public static void initDatabases() {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(DROP_IF_EXISTS_PRODUCTS);
        statement.executeUpdate(DROP_IF_EXISTS_CATEGORIES);
        statement.executeUpdate(CREATE_CATEGORIES);
        statement.executeUpdate(CREATE_PRODUCTS);
        DatabasePopulator databasePopulator = new DatabasePopulator();
        databasePopulator.fillDatabase();
    }
}
