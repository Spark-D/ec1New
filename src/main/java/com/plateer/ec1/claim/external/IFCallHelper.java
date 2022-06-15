package com.plateer.ec1.claim.external;
import org.springframework.stereotype.Component;

@Component
public class IFCallHelper {

    public void callRestoreCouponIF() throws ProductException {
        System.out.println("쿠폰 복원 API 호출");
    }

    public void callPaymentIF() throws PaymentException {
        System.out.println("결제 IF 호출");
    }

}
