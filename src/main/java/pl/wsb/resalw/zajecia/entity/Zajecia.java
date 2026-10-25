package pl.wsb.resalw.zajecia.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Zajecia")
public class Zajecia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazwa_zajec", nullable = false, length = 100)
    private String nazwaZajec;

    @Column(name = "data_zajec", nullable = false)
    private LocalDate dataZajec;

    @Column(name = "godzina_rozpoczecia", nullable = false)
    private LocalTime godzinaRozpoczecia;

    @Column(name = "godzina_zakonczenia", nullable = false)
    private LocalTime godzinaZakonczenia;

    @Column(name = "cena", nullable = false, precision = 10, scale = 2)
    private BigDecimal cena;

    public Zajecia(String nazwaZajec, LocalDate dataZajec, LocalTime godzinaRozpoczecia, LocalTime godzinaZakonczenia, BigDecimal cena) {
        this.nazwaZajec = nazwaZajec;
        this.dataZajec = dataZajec;
        this.godzinaRozpoczecia = godzinaRozpoczecia;
        this.godzinaZakonczenia = godzinaZakonczenia;
        this.cena = cena;
    }

    protected Zajecia() {
    }

    public String getNazwaZajec() {
        return nazwaZajec;
    }

    public LocalDate getDataZajec() {
        return dataZajec;
    }

    public LocalTime getGodzinaRozpoczecia() {
        return godzinaRozpoczecia;
    }

    public LocalTime getGodzinaZakonczenia() {
        return godzinaZakonczenia;
    }

    public BigDecimal getCena() {
        return cena;
    }
}