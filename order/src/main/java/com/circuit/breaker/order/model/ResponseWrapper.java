package com.circuit.breaker.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper<T> {
    private T data;
    private String responseMessage;
    private boolean success;

    public ResponseWrapper(T data) {
        this.data = data;
        this.success = true;
    }

    public ResponseWrapper(String responseMessage) {
        this.responseMessage = responseMessage;
        this.success = false;
    }
}
