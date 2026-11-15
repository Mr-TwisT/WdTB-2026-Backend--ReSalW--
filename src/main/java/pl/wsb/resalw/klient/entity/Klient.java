package pl.wsb.resalw.klient.entity;

import jakarta.persistence.*;
import pl.wsb.resalw.account.domain.UserAccount;
import pl.wsb.resalw.grupa.entity.GrupaJezykowa;

import java.util.HashSet;
import java.util.Set;

@Embeddable
class InformacjeKontaktowe {

    @Column(name = "adres", nullable = false, length = 150)
    private String adres;

    @Column(name = "telefon", nullable = false, length = 15)
    private String telefon;

    protected InformacjeKontaktowe() {
    }

    public InformacjeKontaktowe(String adres, String telefon) {
        this.adres = adres;
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public String getTelefon() {
        return telefon;
    }
}

@Entity
@Table(name = "Klient")
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imie", nullable = false, length = 50)
    private String imie;

    @Column(name = "nazwisko", nullable = false, length = 60)
    private String nazwisko;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Embedded
    private InformacjeKontaktowe informacjeKontaktowe;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id", unique = true)
    private UserAccount account;

    @ManyToMany
    @JoinTable(name = "grupa_klient",
            joinColumns = @JoinColumn(name = "klient_id"),
            inverseJoinColumns = @JoinColumn(name = "grupa_id"))
    private Set<GrupaJezykowa> grupy = new HashSet<>();

    protected Klient() {
    }

    public Klient(String imie, String nazwisko, String email,
                  String adres, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.informacjeKontaktowe = new InformacjeKontaktowe(adres, telefon);
    }

    public Long getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public InformacjeKontaktowe getInformacjeKontaktowe() {
        return informacjeKontaktowe;
    }

    public UserAccount getAccount() {
        return account;
    }

    public Set<GrupaJezykowa> getGrupy() {
        return grupy;
    }
}