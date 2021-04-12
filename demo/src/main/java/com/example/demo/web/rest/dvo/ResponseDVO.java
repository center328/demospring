package com.example.demo.web.rest.dvo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class ResponseDVO<T> {

    private HttpStatus status;
    private String message;
    private int statusCode;
    private T data;

    public ResponseDVO(HttpStatus status) {
        this.status = status;
    }

    public ResponseDVO message(String message) {
        this.message = message;
        return this;
    }

    public ResponseDVO data(T data) {
        this.data = data;
        return this;
    }

    public static ResponseDVO ok() {
        return new ResponseDVO(HttpStatus.OK);
    }
    public static ResponseDVO badRequest() {
        return new ResponseDVO(HttpStatus.BAD_REQUEST);
    }
    public static ResponseDVO notFound() {
        return new ResponseDVO(HttpStatus.NOT_FOUND);
    }
    public static ResponseDVO failed() {
        return new ResponseDVO(HttpStatus.EXPECTATION_FAILED);
    }
}