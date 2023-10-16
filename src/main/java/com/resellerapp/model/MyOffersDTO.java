package com.resellerapp.model;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.enums.ConditionName;

import java.math.BigDecimal;

public class MyOffersDTO extends BoughtOffersDTO {
    private ConditionName condition;

    public MyOffersDTO() {
        this(new Offer()); // May to be removed
    }

    public MyOffersDTO(Offer offer) {
        super(offer);
        condition = offer.getCondition().getName();

    }

    public ConditionName getCondition() {
        return condition;
    }

    public void setCondition(ConditionName condition) {
        this.condition = condition;
    }
}
