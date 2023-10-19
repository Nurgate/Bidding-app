package com.resellerapp.model;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.enums.ConditionName;

import java.util.UUID;

public class MyOfferDTO extends BoughtOffersDTO {
    private ConditionName condition;
    private UUID id;

    public MyOfferDTO() {

    }

    public MyOfferDTO(Offer offer) {
        super(offer);
        id = offer.getId();
        condition = offer.getCondition().getName();

    }

    public ConditionName getCondition() {
        return condition;
    }

    public void setCondition(ConditionName condition) {
        this.condition = condition;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
