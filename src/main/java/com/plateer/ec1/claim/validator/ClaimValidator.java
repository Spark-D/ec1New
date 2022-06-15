package com.plateer.ec1.claim.validator;

import com.plateer.ec1.claim.dto.ClaimDto;
import org.springframework.stereotype.Component;

@Component
public class ClaimValidator {
    public void validate(ClaimDto dto) throws Exception {
        System.out.println("validate");
    };
}
