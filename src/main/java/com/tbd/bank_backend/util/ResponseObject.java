package com.tbd.bank_backend.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An object for encapsulating the HTTP response code and user-friendly message
 * in an HTTP response.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {

    /**
     * The HTTP responseCode (i.e. 200, 403, 500).
     */
    private int responseCode;

    /**
     * The user-friendly message associated with the response.
     */
    private String message;

}
