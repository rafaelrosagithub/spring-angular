package org.example.customers.rest.exception;

public class RegisteredUserException extends RuntimeException {

    public RegisteredUserException(String login) {
        super("User already registered for login: " + login);
    }
}
