package com.plateer.ec1.claim.creator;

import com.plateer.ec1.claim.dto.ClaimDto;
import com.plateer.ec1.claim.model.OrderBenefit;
import com.plateer.ec1.claim.model.OrderBenefitRelation;
import com.plateer.ec1.claim.model.OrderClaim;
import com.plateer.ec1.claim.model.OrderCost;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneralCancelDataCreator extends ClaimDataCreator{

    @Override
    protected List<OrderClaim> makeInsertOrderClaim(ClaimDto dto) {
        System.out.println("일반상품 취소 클레임 데이터 만든다");
        return null;
    }

    @Override
    protected List<OrderCost> makeInsertOrderCost(ClaimDto dto) {
        return null;
    }

    @Override
    protected List<OrderBenefitRelation> makeInsertOrderBenefitRelation(ClaimDto dto) {
        return null;
    }

    @Override
    protected List<OrderClaim> makeUpdateOrderClaim(ClaimDto dto) {
        return null;
    }

    @Override
    protected List<OrderCost> makeUpdateOrderCost(ClaimDto dto) {
        return null;
    }

    @Override
    protected List<OrderBenefit> makeUpdateOrderBenefit(ClaimDto dto) {
        return null;
    }
}
