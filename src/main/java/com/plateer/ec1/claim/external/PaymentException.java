package com.plateer.ec1.claim.external;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PaymentException extends Exception {
    PaymentException(String message) {
        super(message);
    }
}
