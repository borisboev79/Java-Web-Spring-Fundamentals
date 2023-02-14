package com.softuni.mobilele.services.offers;

import com.softuni.mobilele.models.dtos.model.OfferServiceModel;
import com.softuni.mobilele.models.dtos.view.OfferViewDto;
import com.softuni.mobilele.models.entities.Offer;
import com.softuni.mobilele.services.init.DataBaseInitServiceService;

import java.util.List;

public interface OfferService extends DataBaseInitServiceService {
    List<OfferViewDto> getAllOffers();

    Offer findById(Long id);

    Long saveOffer(OfferServiceModel offerServiceModel);

    void delete(Long id);
}
