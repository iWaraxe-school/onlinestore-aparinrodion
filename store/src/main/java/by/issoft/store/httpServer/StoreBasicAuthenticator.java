package by.issoft.store.httpServer;

import com.sun.net.httpserver.BasicAuthenticator;

public class StoreBasicAuthenticator extends BasicAuthenticator {
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";

    /**
     * Creates a BasicAuthenticator for the given HTTP realm
     *
     * @param realm The HTTP Basic authentication realm
     * @throws NullPointerException if the realm is an empty string
     */
    public StoreBasicAuthenticator(String realm) {
        super(realm);
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}
