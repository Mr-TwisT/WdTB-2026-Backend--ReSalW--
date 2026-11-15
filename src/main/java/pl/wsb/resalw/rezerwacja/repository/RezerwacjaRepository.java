package pl.wsb.resalw.rezerwacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.resalw.rezerwacja.entity.Rezerwacja;

import java.util.List;

public interface RezerwacjaRepository extends JpaRepository<Rezerwacja, Long> {

    List<Rezerwacja> findBySala_NazwaSali(String nazwaSali);

    List<Rezerwacja> findByKlient_Email(String email);
}