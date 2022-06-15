package com.plateer.ec1.claim.processor;

import com.plateer.ec1.claim.dto.ClaimDto;
import com.plateer.ec1.claim.dto.ClaimProcessDto;
import com.plateer.ec1.claim.util.MonitoringLogHelper;
import com.plateer.ec1.claim.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
abstract public class ClaimProcessor {

    protected final ClaimValidator claimValidator;
    protected final MonitoringLogHelper monitoringLogHelper;

    public Long insertLog(ClaimDto dto) {
        return monitoringLogHelper.insertLog(dto);
    }

    public void updateLog(Long logkey, ClaimProcessDto regData, ClaimProcessDto modData) {
        monitoringLogHelper.updateLog(logkey, regData, modData);
    }

    protected void validate(ClaimDto dto) throws Exception {
        claimValidator.validate(dto);
    }

    public abstract void doProcess(ClaimDto dto);



}
