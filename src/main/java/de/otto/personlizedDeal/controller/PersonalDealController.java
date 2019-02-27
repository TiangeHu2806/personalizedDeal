package de.otto.personlizedDeal.controller;

import de.otto.personlizedDeal.service.PersonalizedDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static de.otto.personlizedDeal.controller.PersonalDealController.PERSONAL_DEAL;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(PERSONAL_DEAL)
public class PersonalDealController extends AbstractBaseApiController {
    public static final String PERSONAL_DEAL = "/personalizedDeal";

    private final PersonalizedDealService personalizedDealService;

    @Autowired
    public PersonalDealController(final PersonalizedDealService personalizedDealService) {
        this.personalizedDealService = personalizedDealService;
    }

    @GetMapping(value = "/{visitorId}")
    public Object getProduct(@PathVariable final String visitorId) {
        return personalizedDealService.getPersonalizedDeals(visitorId)
                .orElse(new ResponseEntity<>(NOT_FOUND));
    }
}
