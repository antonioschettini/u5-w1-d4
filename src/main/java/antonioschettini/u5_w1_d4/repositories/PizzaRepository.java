package antonioschettini.u5_w1_d4.repositories;

import antonioschettini.u5_w1_d4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    //query derived significa che sping capisce dal nome della query cosa intendiamo fare
    // è come scrivere SELECT + FROM piZZAS WHERE prezzo < valore
    List<Pizza> findByPrezzoLessThan(double prezzoMassimo);
}
