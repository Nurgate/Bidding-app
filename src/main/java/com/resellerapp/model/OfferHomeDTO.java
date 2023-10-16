package com.resellerapp.model;

import java.util.List;

public class OfferHomeDTO {

    private List<MyOffersDTO> myOffers;
    private List<BoughtOffersDTO> boughtOffers;

    private List<OtherOffersDTO> otherOffers;

    private long totalOffers;

    public List<MyOffersDTO> getMyOffers() {
        return myOffers;
    }

    public void setMyOffers(List<MyOffersDTO> myOffers) {
        this.myOffers = myOffers;
    }

    public List<BoughtOffersDTO> getBoughtOffers() {
        return boughtOffers;
    }

    public void setBoughtOffers(List<BoughtOffersDTO> boughtOffers) {
        this.boughtOffers = boughtOffers;
    }

    public List<OtherOffersDTO> getOtherOffers() {
        return otherOffers;
    }

    public void setOtherOffers(List<OtherOffersDTO> otherOffers) {
        this.otherOffers = otherOffers;
    }

    public long getTotalOffers() {
        return totalOffers;
    }

    public void setTotalOffers(long totalOffers) {
        this.totalOffers = totalOffers;
    }
}
