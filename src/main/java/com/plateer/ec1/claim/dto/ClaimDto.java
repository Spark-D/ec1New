package com.plateer.ec1.claim.dto;

import com.plateer.ec1.claim.enums.ClaimType;
import lombok.Data;
import lombok.Getter;

@Getter
public class ClaimDto {
    private String clmNo;
    private ClaimType claimType;

}
