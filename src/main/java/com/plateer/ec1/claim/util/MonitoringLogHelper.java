package com.plateer.ec1.claim.util;

import com.plateer.ec1.claim.dto.ClaimDto;
import com.plateer.ec1.claim.dto.ClaimProcessDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MonitoringLogHelper {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Long insertLog(ClaimDto dto) {
        System.out.println("로그 인서트");
        return 0L;
    }

    public void updateLog(Long logkey, ClaimProcessDto regData, ClaimProcessDto modData) {
        System.out.println("로그 업데이트");
    }
}
