package pl.wsb.resalw.rezerwacja.entity;

import jakarta.persistence.*;
import pl.wsb.resalw.klient.entity.Klient;
import pl.wsb.resalw.sala.entity.Sala;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Rezerwacja")
public class Rezerwacja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_rezerwacji", nullable = false)
    private LocalDate dataRezerwacji;

    @Column(name = "godzina_od", nullable = false)
    private LocalTime godzinaOd;

    @Column(name = "godzina_do", nullable = false)
    private LocalTime godzinaDo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private StatusRezerwacji status;

    @Column(name = "cel", length = 120)
    private String cel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "klient_id", nullable = false)
    private Klient klient;

    protected Rezerwacja() {
    }

    public Rezerwacja(LocalDate dataRezerwacji, LocalTime godzinaOd, LocalTime godzinaDo,
                      StatusRezerwacji status, String cel, Sala sala, Klient klient) {
        this.dataRezerwacji = dataRezerwacji;
        this.godzinaOd = godzinaOd;
        this.godzinaDo = godzinaDo;
        this.status = status;
        this.cel = cel;
        this.sala = sala;
        this.klient = klient;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataRezerwacji() {
        return dataRezerwacji;
    }

    public LocalTime getGodzinaOd() {
        return godzinaOd;
    }

    public LocalTime getGodzinaDo() {
        return godzinaDo;
    }

    public StatusRezerwacji getStatus() {
        return status;
    }

    public String getCel() {
        return cel;
    }

    public Sala getSala() {
        return sala;
    }

    public Klient getKlient() {
        return klient;
    }
}