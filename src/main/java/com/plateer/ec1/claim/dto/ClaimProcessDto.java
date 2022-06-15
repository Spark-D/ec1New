package com.plateer.ec1.claim.dto;

import com.plateer.ec1.claim.model.OrderBenefit;
import com.plateer.ec1.claim.model.OrderBenefitRelation;
import com.plateer.ec1.claim.model.OrderClaim;
import com.plateer.ec1.claim.model.OrderCost;
import lombok.Data;

import java.util.List;

@Data
public class ClaimProcessDto {

    private String clmNo;
    private Long trNo;

    private List<OrderClaim> orderClaimList;
    private List<OrderCost> orderCostList;
    private List<OrderBenefitRelation> orderBenefitRelationList;
    private List<OrderBenefit> orderBenefits;

}
