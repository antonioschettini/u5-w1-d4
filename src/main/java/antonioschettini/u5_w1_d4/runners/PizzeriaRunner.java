package antonioschettini.u5_w1_d4.runners;

import antonioschettini.u5_w1_d4.entities.Menu;
import antonioschettini.u5_w1_d4.services.DrinkService;
import antonioschettini.u5_w1_d4.services.PizzaService;
import antonioschettini.u5_w1_d4.services.ToppingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PizzeriaRunner implements CommandLineRunner {
    private final ToppingService toppingService;
    private final DrinkService drinkService;
    private final PizzaService pizzaService;
    @Autowired
    private Menu menuCompleto;

    public PizzeriaRunner(ToppingService toppingService, DrinkService drinkService, PizzaService pizzaService) {
        this.toppingService = toppingService;
        this.drinkService = drinkService;
        this.pizzaService = pizzaService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Verifica Stato db");

        // popolo il db solo se è vuoto
        if (toppingService.findAll().isEmpty() && drinkService.findAll().isEmpty() && pizzaService.findAll().isEmpty()) {
            log.info("Db vuoto, inizio il salvataggio");
            // Salvo prima i toppings per assegnare un id, e successivamente collegarli alle pizze
            menuCompleto.getToppings().forEach(topping -> toppingService.saveTopping(topping));

            //Salvo i drinks
            menuCompleto.getDrinks().forEach(drink -> drinkService.saveDrink(drink));

            //Salvo le pizze
            menuCompleto.getPizzas().forEach(pizza -> pizzaService.savePizza(pizza));
        } else {
            log.info("Il db contiene già dei dati salto il ripopolamento per evitare duplicati");
        }
        menuCompleto.stampaMenu();

        //testo le due query
        log.info("Test query personalizzata pizze economiche a meno di 8 euro");
        pizzaService.trovaPizzeEconomiche(8.00).forEach(pizza -> log.info("Pizza trovata Nome: " + pizza.getNome() + "al prezzo di : " + pizza.getPrezzo() + " €S"));

        System.out.println();

        log.info("Test query custom ordinamento ingredienti per calorie in modo decrescente");
        toppingService.ottieniToppingPerCalorie().forEach(topping -> log.info("Topping ordinato: " + topping.getNome() + " calorie totali: " + topping.getCalorie() + " kcal"));
    }
}
