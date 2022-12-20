package com.tbd.bank_backend.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * A Data Transfer Object utility for use as a REST API response.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class DataTransferObject<T> extends ResponseObject {

    /**
     * Any data meant to be returned to the client making the request.
     */
    private T data;

    public DataTransferObject(int code, String message, T data) {
        this.setResponseCode(code);
        this.setMessage(message);
        this.setData(data);
    }

}
