package pl.wsb.resalw.grupa.entity;

import jakarta.persistence.*;
import pl.wsb.resalw.zajecia.entity.Zajecia;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GrupaJezykowa")
public class GrupaJezykowa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nazwa_grupy", nullable = false, length = 60)
    private String nazwaGrupy;

    @Column(name = "jezyk", nullable = false, length = 40)
    private String jezyk;

    @Column(name = "poziom", nullable = false, length = 10)
    private String poziom;

    @Column(name = "lektor", length = 80)
    private String lektor;

    @Column(name = "maks_uczestnikow", nullable = false)
    private Integer maksUczestnikow;

    @OneToMany(mappedBy = "grupa")
    private List<Zajecia> zajecia = new ArrayList<>();

    protected GrupaJezykowa() {
    }

    public GrupaJezykowa(String nazwaGrupy, String jezyk, String poziom,
                         String lektor, Integer maksUczestnikow) {
        this.nazwaGrupy = nazwaGrupy;
        this.jezyk = jezyk;
        this.poziom = poziom;
        this.lektor = lektor;
        this.maksUczestnikow = maksUczestnikow;
    }

    public Long getId() {
        return id;
    }

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public String getJezyk() {
        return jezyk;
    }

    public String getPoziom() {
        return poziom;
    }

    public String getLektor() {
        return lektor;
    }

    public Integer getMaksUczestnikow() {
        return maksUczestnikow;
    }

    public List<Zajecia> getZajecia() {
        return zajecia;
    }
}