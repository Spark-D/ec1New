package com.plateer.ec1.claim.external;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductException extends Exception {
    ProductException(String message) {
        super(message);
    }
}
