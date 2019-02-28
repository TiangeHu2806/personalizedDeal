package de.otto.personlizedDeal.service;

import de.otto.personlizedDeal.repository.Stock;
import de.otto.personlizedDeal.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalizedDealService {

    @Autowired
    private StockRepository repository;

    public List<Stock> getBestand() {
        return repository.findAll();
    }

    public Optional<Object> getPersonalizedDeals(final String visitorId) {
        return Optional.of(visitorId);
    }
}
