package antonioschettini.u5_w1_d4.services;

import antonioschettini.u5_w1_d4.entities.Pizza;
import antonioschettini.u5_w1_d4.exceptions.ItemNotFoundException;
import antonioschettini.u5_w1_d4.repositories.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    //Save
    public void savePizza(Pizza pizza) {
        if (pizza.getPrezzo() <= 0) {
            throw new ItemNotFoundException("Impossibile salvare la pizza " + pizza.getNome() + " il prezzo deve essere maggiore di 0");
        }
        if (pizza.getIngredienti() == null || pizza.getIngredienti().isEmpty()) {
            throw new ItemNotFoundException("impossibile salvare la pizza " + pizza.getNome() + " deve contenere almeno un ingrediente");
        }
        pizzaRepository.save(pizza);
        log.info("Pizza: " + pizza.getNome() + " salvata con successo");
    }

    //findbyid
    public Pizza findById(Long id) {
        return pizzaRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    //FindAll
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    //Trova pizzeeconomiche
    public List<Pizza> trovaPizzeEconomiche(double prezzo) {
        if (prezzo < 0) {
            throw new IllegalArgumentException("Il prezzo di ricerca deve essere positivo");
        }
        return pizzaRepository.findByPrezzoLessThan(prezzo);
    }
}
