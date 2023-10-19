package com.resellerapp.service.impl;

import com.resellerapp.model.*;
import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final LoggedUser loggedUser;

    private final ConditionRepository conditionRepository;

    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, LoggedUser loggedUser, ConditionRepository conditionRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.loggedUser = loggedUser;
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public OfferHomeDTO getOfferForHomePage() {
        List<Offer> offers = offerRepository.findAll();

        List<MyOfferDTO> myOffers = new ArrayList<>();
        List<BoughtOffersDTO> boughtOffers = new ArrayList<>();
        List<OtherOffersDTO> otherOffers = new ArrayList<>();

        for (Offer offer : offers) {
            String loggedUsername = loggedUser.getUsername();

            if (offer.getBoughtBy() == null && offer.getCreatedBy() != null && offer.getCreateBy().getUsername().equals(loggedUsername)) {
                myOffers.add(new MyOfferDTO(offer));
            } else if (offer.getBoughtBy() != null && offer.getBoughtBy().getUsername().equals(loggedUsername)) {
                boughtOffers.add(new BoughtOffersDTO(offer));
            } else if (offer.getBoughtBy() == null) {
                otherOffers.add(new OtherOffersDTO(offer));
            }
        }

        return new OfferHomeDTO(myOffers, boughtOffers, otherOffers);
    }

    @Override
    public boolean create(OfferCreateBindingModel offerCreateBindingModel) {
        Condition condition = conditionRepository.findByName(offerCreateBindingModel.getCondition());

        User user = userRepository.findByUsername(loggedUser.getUsername());


        if (condition != null && user != null) {
            Offer offer = new Offer(offerCreateBindingModel, condition, user);
            offerRepository.save(offer);
            return true;
        }

        return false;
    }

    @Override
    public void buy(UUID id) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);

        if (optionalOffer.isPresent()) {
            User user = userRepository.findByUsername(loggedUser.getUsername());
            Offer offer = optionalOffer.get();

            offer.setBoughtBy(user);

            offerRepository.save(offer);
        }
    }
}

//    @Override
//    public void buy(UUID id) {
//        Optional<Offer> optionalOffer = offerRepository.findById(id);
//
//        if (optionalOffer.isPresent()) {
//            User user = userRepository.findByUsername(loggedUser.getUsername());
//            Offer offer = optionalOffer.get();
//
//            offer.setBoughtBy(user);
//
//            offerRepository.save(offer);
//        }
//    }
//}
