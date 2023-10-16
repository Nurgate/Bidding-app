package com.resellerapp.model;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.enums.ConditionName;

public class OtherOffersDTO extends MyOffersDTO{

    private String sellerUsername;

    public OtherOffersDTO() {
    }



    public OtherOffersDTO(Offer offer) {
        super(offer);
        sellerUsername = offer.getCreateBy().getUsername();
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }
}
