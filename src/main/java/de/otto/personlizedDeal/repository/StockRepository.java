package de.otto.personlizedDeal.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, Long> {

    List<Stock> findAll();
}
