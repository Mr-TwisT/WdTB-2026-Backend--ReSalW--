-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('s950751@student.wroclaw.merito.pl',   'Patryk',   'USER',    current_timestamp),
    ('s227660@student.wroclaw.merito.pl',  'Mikolaj',  'USER',    current_timestamp),
    ('s345303@student.wroclaw.merito.pl',       'Nazar', 'USER', current_timestamp);

INSERT INTO Sala
(nazwa_sali, typ_sali, liczba_miejsc, dostepna, cena_za_godzine)
VALUES
    ('Sala A', 'KONFERENCYJNA', 30, TRUE, 120.00),
    ('Sala B', 'SZKOLENIOWA', 20, TRUE, 90.00),
    ('Sala C', 'KOMPUTEROWA', 15, FALSE, 150.00);


INSERT INTO Klient
(imie, nazwisko, email, telefon)
VALUES
    ('Patryk', 'Kowalski', 'patryk.kowalski@example.com', '501123456'),
    ('Mikolaj', 'Nowak', 'mikolaj.nowak@example.com', '502234567'),
    ('Nazar', 'Wisniewski', 'nazar.wisniewski@example.com', '503345678');


INSERT INTO Zajecia
(nazwa_zajec, data_zajec, godzina_rozpoczecia,
 godzina_zakonczenia, cena)
VALUES
    ('Język angielski C1', '2026-11-01', '10:00:00',
     '11:00:00', 40.00),
    ('Język angielski B2', '2026-11-02', '08:00:00',
     '09:00:00', 35.00),
    ('Język angielski C2', '2026-11-03', '17:00:00',
     '18:00:00', 45.00);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);
