package com.plateer.ec1.claim.processor;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.dto.ClaimDto;
import com.plateer.ec1.claim.dto.ClaimProcessDto;
import com.plateer.ec1.claim.enums.ClaimType;
import com.plateer.ec1.claim.external.IFCallHelper;
import com.plateer.ec1.claim.util.MonitoringLogHelper;
import com.plateer.ec1.claim.validator.ClaimValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class CompleteProcessor extends ClaimProcessor {

    private static CompleteProcessor completeProcessor;
    private final IFCallHelper ifCallHelper;

    public CompleteProcessor(ClaimValidator claimValidator, MonitoringLogHelper monitoringLogHelper, IFCallHelper ifCallHelper) {
        super(claimValidator, monitoringLogHelper);
        this.ifCallHelper = ifCallHelper;
    }

    @PostConstruct
    private void initialize() {
        completeProcessor = this;
    }

    public static CompleteProcessor getInstance() {
        return completeProcessor;
    }

    @Override
    @Transactional
    public void doProcess(ClaimDto dto) {
        ClaimDataCreator claimDataCreator = ClaimType.findCreator(dto.getClaimType().name());
        Long logKey = null;
        ClaimProcessDto createDataTarget = null;
        ClaimProcessDto updateDataTarget = null;

        try{
            claimDataCreator.getClamNo(dto);
            logKey = insertLog(dto);
            validate(dto);
            updateDataTarget = claimDataCreator.makeUpdateData(dto);
            claimDataCreator.saveClaimData(null, updateDataTarget);
            ifCallHelper.callPaymentIF();
        }catch (Exception e){
            log.error("AcceptWithdrawalProcess error occur  : {}", e);
        }finally {
            updateLog(logKey,createDataTarget,updateDataTarget);
        }
    }
}
