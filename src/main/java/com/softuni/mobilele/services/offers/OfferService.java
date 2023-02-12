package com.softuni.mobilele.services.offers;

import com.softuni.mobilele.models.dtos.model.OfferServiceModel;
import com.softuni.mobilele.models.dtos.view.OfferViewDto;
import com.softuni.mobilele.services.init.DataBaseInitServiceService;

import java.util.List;

public interface OfferService extends DataBaseInitServiceService {
    public List<OfferViewDto> getAllOffers();

    Long saveOffer(OfferServiceModel offerServiceModel);

    void delete(Long id);
}
