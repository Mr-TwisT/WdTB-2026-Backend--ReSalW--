package pl.wsb.resalw.sala.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazwa_sali", nullable = false, length = 60)
    private String nazwaSali;

    @Enumerated(EnumType.STRING)
    @Column(name = "typ_sali", nullable = false, length = 30)
    private TypSali typSali;

    @Column(name = "liczba_miejsc", nullable = false)
    private Integer liczbaMiejsc;

    @Column(name = "dostepna", nullable = false)
    private Boolean dostepna;

    @Column(name = "cena_za_godzine", nullable = false, precision = 10, scale = 2)
    private BigDecimal cenaZaGodzine;

    public Sala(String nazwaSali, TypSali typSali, Integer liczbaMiejsc,
                Boolean dostepna, BigDecimal cenaZaGodzine) {
        this.nazwaSali = nazwaSali;
        this.typSali = typSali;
        this.liczbaMiejsc = liczbaMiejsc;
        this.dostepna = dostepna;
        this.cenaZaGodzine = cenaZaGodzine;
    }

    public TypSali getTypSali() {
        return typSali;
    }

    public String getNazwaSali() {
        return nazwaSali;
    }

    public Integer getLiczbaMiejsc() {
        return liczbaMiejsc;
    }

    public Boolean getDostepna() {
        return dostepna;
    }

    public BigDecimal getCenaZaGodzine() {
        return cenaZaGodzine;
    }
}