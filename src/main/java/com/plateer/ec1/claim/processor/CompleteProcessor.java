package com.plateer.ec1.claim.processor;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.dto.ClaimDto;
import com.plateer.ec1.claim.dto.ClaimProcessDto;
import com.plateer.ec1.claim.enums.ClaimType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CompleteProcessor implements ClaimProcessor {

    private static CompleteProcessor completeProcessor;

    @PostConstruct
    private void initialize() {
        completeProcessor = this;
    }

    public static CompleteProcessor getInstance() {
        return completeProcessor;
    }

    @Override
    public void doProcess(ClaimDto dto) {
        ClaimDataCreator claimDataCreator = ClaimType.findCreator(dto.getClaimType().name());

        try{

            ClaimProcessDto createDataTarget = claimDataCreator.makeCreateData(dto);
            ClaimProcessDto updateDataTarget = claimDataCreator.makeUpdateData(dto);

        }catch (Exception e){

        }finally {

        }
    }
}
