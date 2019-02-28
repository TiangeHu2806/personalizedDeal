package de.otto.personlizedDeal.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonalizedDealRepository extends CrudRepository<Bestand, Long> {

    List<Bestand> findAll();
}
