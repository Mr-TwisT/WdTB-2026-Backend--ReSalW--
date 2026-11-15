# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 7 (w tym tabele łączące @ManyToMany: grupa_klient) · kolumny: 39 · relacje: 3 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 1 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| GrupaJezykowa | GrupaJezykowa | 6 | — |
| Klient | Klient | 7 | user_account_id |
| Rezerwacja | Rezerwacja | 8 | klient_id, sala_id |
| Sala | Sala | 6 | — |
| Zajecia | Zajecia | 7 | grupa_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    GrupaJezykowa {
        Long id PK
        String jezyk
        String lektor
        Integer maks_uczestnikow
        String nazwa_grupy
        String poziom
    }
    Klient {
        Long id PK
        String adres
        String email
        String imie
        String nazwisko
        String telefon
        Long user_account_id FK
    }
    Rezerwacja {
        Long id PK
        String cel
        LocalDate data_rezerwacji
        LocalTime godzina_do
        LocalTime godzina_od
        Long klient_id FK
        Long sala_id FK
        StatusRezerwacji status
    }
    Sala {
        Long id PK
        BigDecimal cena_za_godzine
        Boolean dostepna
        Integer liczba_miejsc
        String nazwa_sali
        TypSali typ_sali
    }
    Zajecia {
        Long id PK
        BigDecimal cena
        LocalDate data_zajec
        LocalTime godzina_rozpoczecia
        LocalTime godzina_zakonczenia
        Long grupa_id FK
        String nazwa_zajec
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    GrupaJezykowa ||--o{ Zajecia : "grupa_id"
    Klient ||--o{ Rezerwacja : "klient_id"
    Klient }o--o{ GrupaJezykowa : "grupa_klient"
    Sala ||--o{ Rezerwacja : "sala_id"
    user_account |o--o| Klient : "user_account_id"
```
