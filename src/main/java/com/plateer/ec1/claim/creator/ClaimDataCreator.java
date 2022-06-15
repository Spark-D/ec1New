package com.plateer.ec1.claim.creator;

import com.plateer.ec1.claim.dto.ClaimDto;
import com.plateer.ec1.claim.dto.ClaimProcessDto;
import com.plateer.ec1.claim.model.OrderBenefit;
import com.plateer.ec1.claim.model.OrderBenefitRelation;
import com.plateer.ec1.claim.model.OrderClaim;
import com.plateer.ec1.claim.model.OrderCost;

import java.util.List;

abstract public class ClaimDataCreator {

    public void getClamNo(ClaimDto dto) {
        System.out.println("클레임번호 채번");
//        dto.setClmNo("C202206150001");
    }

    public ClaimProcessDto makeCreateData(ClaimDto dto) {
        List<OrderClaim> orderClaimList = makeInsertOrderClaim(dto);
        List<OrderCost> orderCostList = makeInsertOrderCost(dto);
        List<OrderBenefitRelation> orderBenefitRelationList = makeInsertOrderBenefitRelation(dto);
        return manipulateData(orderClaimList, orderCostList, orderBenefitRelationList, null);
    }

    /**
     * 주문클레임 테이블 insert 대상데이터를 만든다
     * */
    abstract protected List<OrderClaim> makeInsertOrderClaim(ClaimDto dto);

    /**
     * 주문비용 테이블 insert 대상데이터를 만든다
     * */
    abstract protected List<OrderCost> makeInsertOrderCost(ClaimDto dto);

    /**
     * 주문혜택관계 테이블 insert 대상데이터를 만든다
     * */
    abstract protected List<OrderBenefitRelation> makeInsertOrderBenefitRelation(ClaimDto dto);


    public ClaimProcessDto makeUpdateData(ClaimDto dto) {
        List<OrderClaim> orderClaimList = makeUpdateOrderClaim(dto);
        List<OrderCost> orderCostList = makeUpdateOrderCost(dto);
        List<OrderBenefit> orderBenefitList = makeUpdateOrderBenefit(dto);
        return manipulateData(orderClaimList, orderCostList, null, orderBenefitList);
    }

    /**
     * 주문클레임 테이블 update 대상데이터를 만든다
     * */
    protected abstract List<OrderClaim> makeUpdateOrderClaim(ClaimDto dto);
    /**
     * 주문비용 테이블 update 대상데이터를 만든다
     * */
    protected abstract List<OrderCost> makeUpdateOrderCost(ClaimDto dto);
    /**
     * 주문혜택 테이블 update 대상데이터를 만든다
     * */
    protected abstract List<OrderBenefit> makeUpdateOrderBenefit(ClaimDto dto);


    private ClaimProcessDto manipulateData(List<OrderClaim> orderClaimList, List<OrderCost> orderCostList, List<OrderBenefitRelation> orderBenefitRelationList, List<OrderBenefit> orderBenefitList) {
        ClaimProcessDto claimProcessDto = new ClaimProcessDto();
        claimProcessDto.setOrderClaimList(orderClaimList);
        claimProcessDto.setOrderCostList(orderCostList);
        claimProcessDto.setOrderBenefitRelationList(orderBenefitRelationList);
        claimProcessDto.setOrderBenefits(orderBenefitList);
        return claimProcessDto;
    }

    public void saveClaimData(ClaimProcessDto createDataTarget, ClaimProcessDto updateDataTarget){
        insertClaimData(createDataTarget);
        makeUpdateClaimData(updateDataTarget);
    }

    private void makeUpdateClaimData(ClaimProcessDto updateDataTarget) {
        System.out.println("update 수정데이터");
    }

    private void insertClaimData(ClaimProcessDto createDataTarget) {
        System.out.println("insert 생성데이터");
    }

}
