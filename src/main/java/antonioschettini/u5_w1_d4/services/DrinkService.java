package antonioschettini.u5_w1_d4.services;

import antonioschettini.u5_w1_d4.entities.Drink;
import antonioschettini.u5_w1_d4.exceptions.ItemNotFoundException;
import antonioschettini.u5_w1_d4.repositories.DrinkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DrinkService {
    private final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    //Metodo save
    public void saveDrink(Drink drink) {
        if (drink.getPrezzo() <= 0) {
            throw new ItemNotFoundException("impossibile salvare il drink: " + drink.getNome() + " non può avere il prezzo minore uguale a 0");
        }
        drinkRepository.save(drink);
        log.info("Drink " + drink.getNome() + " salvato con successo");
    }

    //Findbyid
    public Drink findById(Long id) {
        return drinkRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    //FIndall
    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }
}
