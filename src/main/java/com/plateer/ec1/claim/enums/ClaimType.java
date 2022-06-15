package com.plateer.ec1.claim.enums;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.creator.EcouponCancelAcceptDataCreator;
import com.plateer.ec1.claim.creator.GeneralCancelDataCreator;
import com.plateer.ec1.claim.dto.ClaimDto;
import com.plateer.ec1.claim.processor.AcceptWithdrawalProcessor;
import com.plateer.ec1.claim.processor.ClaimProcessor;
import com.plateer.ec1.claim.processor.CompleteProcessor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.function.Supplier;

@RequiredArgsConstructor
@Getter
public enum ClaimType {
    CG(CompleteProcessor::getInstance, ()-> new GeneralCancelDataCreator()),
    CE(AcceptWithdrawalProcessor::getInstance, ()-> new EcouponCancelAcceptDataCreator()),
    CC(CompleteProcessor::getInstance, ()-> new GeneralCancelDataCreator()),
    RA(CompleteProcessor::getInstance, ()-> new GeneralCancelDataCreator()),
    RC(CompleteProcessor::getInstance, ()-> new GeneralCancelDataCreator()),
    RW(CompleteProcessor::getInstance, ()-> new GeneralCancelDataCreator()),
    XA(CompleteProcessor::getInstance, ()-> new GeneralCancelDataCreator()),
    XW(CompleteProcessor::getInstance, ()-> new GeneralCancelDataCreator());

    private final Supplier<ClaimProcessor> claimProcess;
    private final Supplier<ClaimDataCreator> creator;

    public static ClaimDataCreator findCreator(String name) {
        return Arrays.stream(ClaimType.values())
                .filter(type -> type.name().equals(name))
                .findFirst()
                .map(claimType -> claimType.getCreator().get())
                .orElseThrow(()-> new IllegalArgumentException("클레임유형 요청이 잘못되었습니다."));
    }

    public static ClaimProcessor findProcessor(String name) {
        return Arrays.stream(ClaimType.values())
                .filter(type -> type.name().equals(name))
                .findFirst()
                .map(claimType -> claimType.getClaimProcess().get())
                .orElseThrow(()-> new IllegalArgumentException("클레임유형 요청이 잘못되었습니다."));
    }

}
