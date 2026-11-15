-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.

-- ===== LAB 01 · user_account =====
INSERT INTO user_account (email, display_name, role, created_at) VALUES
                                                                     ('s950751@student.wroclaw.merito.pl', 'Patryk', 'USER', current_timestamp),
                                                                     ('s227660@student.wroclaw.merito.pl', 'Mikolaj', 'USER', current_timestamp),
                                                                     ('s345303@student.wroclaw.merito.pl', 'Nazar', 'USER', current_timestamp);

-- ===== LAB 02 · Sala =====
INSERT INTO Sala
(nazwa_sali, typ_sali, liczba_miejsc, dostepna, cena_za_godzine)
VALUES
    ('Sala A', 'KONFERENCYJNA', 30, TRUE, 120.00),
    ('Sala B', 'SZKOLENIOWA', 20, TRUE, 90.00),
    ('Sala C', 'KOMPUTEROWA', 15, FALSE, 150.00);

-- ===== LAB 03 · GrupaJezykowa =====
INSERT INTO grupa_jezykowa
(nazwa_grupy, jezyk, poziom, lektor, maks_uczestnikow)
VALUES
    ('Angielski C1 - wieczorna', 'angielski', 'C1', 'Anna Zielinska', 12),
    ('Angielski B2 - poranna', 'angielski', 'B2', 'Piotr Maj', 10),
    ('Angielski C2 - weekendowa', 'angielski', 'C2', 'Ewa Krol', 8);

-- ===== LAB 02 + LAB 03 · Klient =====
INSERT INTO Klient
(imie, nazwisko, email, adres, telefon, user_account_id)
VALUES
    ('Patryk', 'Kowalski', 'patryk.kowalski@example.com',
     'Wroclaw, ul. Kwiatowa 10', '501123456', 1),

    ('Mikolaj', 'Nowak', 'mikolaj.nowak@example.com',
     'Wroclaw, ul. Sloneczna 15', '502234567', 2),

    ('Nazar', 'Wisniewski', 'nazar.wisniewski@example.com',
     'Wroclaw, ul. Lipowa 20', '503345678', 3);

-- ===== LAB 02 + LAB 03 · Zajecia =====
INSERT INTO Zajecia
(nazwa_zajec, data_zajec, godzina_rozpoczecia,
 godzina_zakonczenia, cena, grupa_id)
VALUES
    ('Język angielski C1', '2026-11-01', '10:00:00',
     '11:00:00', 40.00, 1),

    ('Język angielski B2', '2026-11-02', '08:00:00',
     '09:00:00', 35.00, 2),

    ('Język angielski C2', '2026-11-03', '17:00:00',
     '18:00:00', 45.00, 3);

-- ===== LAB 03 · Rezerwacja =====
INSERT INTO Rezerwacja
(data_rezerwacji, godzina_od, godzina_do, status, cel, sala_id, klient_id)
VALUES
    ('2026-11-20', '09:00:00', '11:00:00', 'POTWIERDZONA', 'Kurs angielskiego C1', 1, 1),
    ('2026-11-21', '12:00:00', '14:00:00', 'OCZEKUJACA', 'Warsztaty konwersacyjne', 2, 2),
    ('2026-11-22', '15:00:00', '16:30:00', 'POTWIERDZONA', 'Egzamin probny', 3, 3);

-- ===== LAB 03 · grupa_klient =====
INSERT INTO grupa_klient (klient_id, grupa_id) VALUES
    (1, 1),
    (2, 1),
    (3, 2);