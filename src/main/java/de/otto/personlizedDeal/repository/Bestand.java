package de.otto.personlizedDeal.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bestand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer artikelnummer;
    private Integer bestand;

    public Bestand() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBestand() {
        return bestand;
    }

    public void setBestand(Integer bestand) {
        this.bestand = bestand;
    }

    public Integer getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(Integer artikelnummer) {
        this.artikelnummer = artikelnummer;
    }
}
