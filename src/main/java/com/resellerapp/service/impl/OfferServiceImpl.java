package com.resellerapp.service.impl;

import com.resellerapp.model.BoughtOffersDTO;
import com.resellerapp.model.MyOffersDTO;
import com.resellerapp.model.OfferHomeDTO;
import com.resellerapp.model.OtherOffersDTO;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final LoggedUser loggedUser;

    public OfferServiceImpl(OfferRepository offerRepository, LoggedUser loggedUser) {
        this.offerRepository = offerRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public OfferHomeDTO getOfferForHomePage() {
        List<Offer> offers = offerRepository.findAll();

        List<MyOffersDTO> myOffers = new ArrayList<>();
        List<BoughtOffersDTO> boughtOffers = new ArrayList<>();
        List<OtherOffersDTO> otherOffers = new ArrayList<>();

        for (int i = 0; i < offers.size(); i++) {
            Offer offer = offers.get(i);

            String loggedUsername = loggedUser.getUsername();

            if (offer.getCreateBy().getUsername().equals(loggedUsername)) {
                myOffers.add(new MyOffersDTO(offer));
            } else if (offer.getBoughtBy().getUsername().equals(loggedUsername)) {
                boughtOffers.add(new BoughtOffersDTO(offer));
            } else {
                otherOffers.add(new OtherOffersDTO(offer));
            }
        }

        OfferHomeDTO dto = new OfferHomeDTO();

        return null;
    }
}
