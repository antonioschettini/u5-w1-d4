package antonioschettini.u5_w1_d4.services;

import antonioschettini.u5_w1_d4.entities.Topping;
import antonioschettini.u5_w1_d4.exceptions.ItemNotFoundException;
import antonioschettini.u5_w1_d4.repositories.ToppingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ToppingService {
    private final ToppingRepository toppingRepository;

    public ToppingService(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }

    // Metodo save con controllo sul prezzo
    public void saveTopping(Topping topping) {
        if (topping.getPrezzo() <= 0) {
            throw new ItemNotFoundException("Impossibile salvare il topping: " + topping.getNome() + " il prezzo deve essere maggiore di 0");
        }
        toppingRepository.save(topping);
        log.info("Topping " + topping.getNome() + " salvato con successo");
    }

    // Metodo ricerca con l'id con controllo sull optional
    public Topping findById(Long id) {
        return toppingRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    // Metodo findall
    public List<Topping> findAll() {
        return toppingRepository.findAll();
    }

    //Metodo ottieni lista ordinata decrerscente per calorie
    public List<Topping> ottieniToppingPerCalorie() {
        List<Topping> listaTopping = toppingRepository.cercaTuttiToppingOrdinatiPerCalorie();
        if (listaTopping.isEmpty()) {
            log.info("Nessun ingrediente trovato per il calcolo delle calorie");
        }
        return listaTopping;
    }

}
