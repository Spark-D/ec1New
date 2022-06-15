package com.plateer.ec1.claim.processor;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.dto.ClaimDto;
import com.plateer.ec1.claim.dto.ClaimProcessDto;
import com.plateer.ec1.claim.enums.ClaimType;
import com.plateer.ec1.claim.util.MonitoringLogHelper;
import com.plateer.ec1.claim.validator.ClaimValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class AcceptWithdrawalProcessor extends ClaimProcessor {

    private static AcceptWithdrawalProcessor acceptWithdrawalProcessor;

    public AcceptWithdrawalProcessor(ClaimValidator claimValidator, MonitoringLogHelper monitoringLogHelper) {

        super(claimValidator, monitoringLogHelper);
    }

    @PostConstruct
    private void initialize() {
        acceptWithdrawalProcessor = this;
    }

    public static AcceptWithdrawalProcessor getInstance() {

        return acceptWithdrawalProcessor;
    }

    @Override
    public void doProcess(ClaimDto dto) {
        ClaimDataCreator claimDataCreator = ClaimType.findCreator(dto.getClaimType().name());
        Long logKey = null;
        ClaimProcessDto createDataTarget = null;
        ClaimProcessDto updateDataTarget = null;

        try{
            claimDataCreator.getClamNo(dto);
            logKey = insertLog(dto);
            validate(dto);
            createDataTarget = claimDataCreator.makeCreateData(dto);
            updateDataTarget = claimDataCreator.makeUpdateData(dto);
            claimDataCreator.saveClaimData(createDataTarget, updateDataTarget);

        }catch (Exception e){
             log.error("AcceptWithdrawalProcess error occur  : {}", e);
        }finally {
            updateLog(logKey,createDataTarget,updateDataTarget);
        }
    }
}
