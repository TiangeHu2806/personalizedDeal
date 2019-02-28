package de.otto.personlizedDeal.service;

import de.otto.personlizedDeal.repository.Bestand;
import de.otto.personlizedDeal.repository.PersonalizedDealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalizedDealService {

    @Autowired
    private PersonalizedDealRepository repository;

    public List<Bestand> getBestand() {
        return repository.findAll();
    }

    public Optional<Object> getPersonalizedDeals(final String visitorId) {
        return Optional.of(visitorId);
    }
}
