package com.softuni.mobilele.services.offers;

import com.softuni.mobilele.models.dtos.model.OfferServiceModel;
import com.softuni.mobilele.models.dtos.view.OfferViewDto;
import com.softuni.mobilele.models.entities.Offer;
import com.softuni.mobilele.models.enums.EngineType;
import com.softuni.mobilele.models.enums.TransmissionType;
import com.softuni.mobilele.repositories.ModelRepository;
import com.softuni.mobilele.repositories.OfferRepository;
import com.softuni.mobilele.repositories.UserRepository;
import com.softuni.mobilele.security.CurrentUser;
import com.softuni.mobilele.services.init.DataBaseInitServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OfferServiceImpl implements OfferService, DataBaseInitServiceService {
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final CurrentUser currentUser;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository, UserRepository userRepository, ModelMapper mapper, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.currentUser = currentUser;
    }

    @Override
    public List<OfferViewDto> getAllOffers() {

        List<OfferViewDto> offerViews = new ArrayList<>();

        this.offerRepository.findAll().forEach(offer -> {

            final OfferViewDto offerViewDto = new OfferViewDto();
            mapper.map(offer, offerViewDto);
            offerViewDto.setBrand(offer.getModel().getBrand().getName());
            offerViewDto.setModel(offer.getModel().getName());

            offerViews.add(offerViewDto);
        });

        return offerViews;

    }

    @Override
    public Long saveOffer(OfferServiceModel offerServiceModel) {
        Offer offer = saveToDb(offerServiceModel);
        Offer newEntity = this.offerRepository.saveAndFlush(offer);
        return newEntity.getId();
    }

    @Override
    public void delete(Long id) {
        offerRepository.deleteById(id);
    }

    private Offer saveToDb(OfferServiceModel offerServiceModel) {
        Offer offer = new Offer();
        this.mapper.map(offerServiceModel, offer);
        offer.setModel(this.modelRepository.findById(offerServiceModel.getId()).get());
        offer.setSeller(this.userRepository.findFirstByUsername(this.currentUser.getName()).get());
        offer.setYear(Year.of(offerServiceModel.getYear()));
        offer.setCreated(Instant.now());
        offer.setModified(Instant.now());
        while (checkId(offer)){
           offer.setId(offer.getId() + 1);
        }
        return offer;
    }

    private boolean checkId(Offer offer){
        return this.offerRepository.findById(offer.getId()).isPresent();
    }




    @Override
    public void dbInit() {

        if (!isDbInit()) {
            List<Offer> offers = new ArrayList<>();
            offers.add(new Offer()
                    .setMileage(120000)
                    .setYear(Year.of(2005))
                    .setEngine(EngineType.DIESEL)
                    .setPrice(BigDecimal.valueOf(4500.00))
                    .setDescription("Колата е перфектна, само баба ми е ходила до болницата с нея! Нов внос, АГУ")
                    .setTransmission(TransmissionType.MANUAL)
                    .setImageUrl("https://frankfurt.apollo.olxcdn.com/v1/files/p9wrrxcxf4bd-BG/image;s=4000x3000")
                    .setModel(this.modelRepository.findFirstByName("Clio").orElseThrow(NoSuchElementException::new))
                    .setSeller(this.userRepository.findFirstByUsername("boboev").orElseThrow(NoSuchElementException::new)));

            offers.add(new Offer()
                    .setMileage(67000)
                    .setYear(Year.of(2012))
                    .setEngine(EngineType.GASOLINE)
                    .setPrice(BigDecimal.valueOf(9800.00))
                    .setDescription("Колата е като нова, върната е от лизинг")
                    .setTransmission(TransmissionType.MANUAL)
                    .setImageUrl("https://bbcrentacar.com/wp-content/uploads/2018/11/254.png")
                    .setModel(this.modelRepository.findFirstByName("208").orElseThrow(NoSuchElementException::new))
                    .setSeller(this.userRepository.findFirstByUsername("pesho").orElseThrow(NoSuchElementException::new)));

            this.offerRepository.saveAllAndFlush(offers);
        }
    }

    @Override
    public boolean isDbInit() {
        return this.offerRepository.count() > 0;
    }


}
