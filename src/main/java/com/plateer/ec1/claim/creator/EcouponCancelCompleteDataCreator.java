package com.plateer.ec1.claim.creator;

import com.plateer.ec1.claim.dto.ClaimDto;
import com.plateer.ec1.claim.model.OrderBenefit;
import com.plateer.ec1.claim.model.OrderBenefitRelation;
import com.plateer.ec1.claim.model.OrderClaim;
import com.plateer.ec1.claim.model.OrderCost;
import org.springframework.stereotype.Component;

import java.util.List;


public class EcouponCancelCompleteDataCreator extends ClaimDataCreator{
    @Override
    protected List<OrderClaim> makeInsertOrderClaim(ClaimDto dto) {

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
        System.out.println("이쿠폰 취소완료 데이터 만듬");
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
