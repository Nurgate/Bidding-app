package com.resellerapp.model;

import com.resellerapp.model.entity.Offer;

public class OtherOffersDTO extends MyOfferDTO {

    private String sellerUsername;

//    public OtherOffersDTO() {
//        super();
//    }



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
