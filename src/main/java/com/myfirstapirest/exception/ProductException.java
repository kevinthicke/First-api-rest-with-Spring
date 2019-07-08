package com.myfirstapirest.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class NotFound extends RuntimeException {

        public NotFound() {
            super("There are no products in the database");
        }
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    public static class ErrorComparingProductNames extends RuntimeException {

        public ErrorComparingProductNames() {
            super("Error comparing product names length");
        }
    }
}

