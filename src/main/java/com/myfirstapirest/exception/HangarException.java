package com.myfirstapirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class HangarException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class NotFound extends RuntimeException {

        public NotFound() {
            super("There are no hangars in the database");
        }

        public NotFound(String name) {
            super(String.format("There are no hangars with name %s", name));
        }

        public NotFound(long id) {
            super(String.format("There are no hangars with id %d", id));
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class AlreadyExists extends RuntimeException {

        public AlreadyExists(String name) {
            super(String.format("Hangar %s already exists in DB", name));
        }
    }
}
