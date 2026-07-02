package antonioschettini.u5_w1_d4.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data // con il data mi crea automaticamente getter setter e tostring
@NoArgsConstructor
@ToString(callSuper = true) // dice al to string di includere anche la superclasse
@Entity
@Table(name = "pizzas")
public class Pizza extends ElementoMenu {
    @ManyToMany
    @JoinTable(name = "pizza_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id"))
    private List<Topping> ingredienti;

    public Pizza(String nome, int calorie, double prezzo, List<Topping> ingredienti) {
        super(nome, prezzo, calorie);
        this.ingredienti = ingredienti;
    }

}
