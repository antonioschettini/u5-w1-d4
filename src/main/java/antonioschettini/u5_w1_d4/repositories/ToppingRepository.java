package antonioschettini.u5_w1_d4.repositories;

import antonioschettini.u5_w1_d4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Long> {

    //Query custom scritta in jpql
    // ordino i topping in modo decrescente per calorie
    @Query("SELECT t FROM Topping t ORDER BY t.calorie DESC")
    List<Topping> cercaTuttiToppingOrdinatiPerCalorie();
}
