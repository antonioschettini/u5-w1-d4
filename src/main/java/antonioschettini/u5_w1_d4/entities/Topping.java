package antonioschettini.u5_w1_d4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // con il data mi crea automaticamente getter setter e tostrin
@NoArgsConstructor
@Entity
@Table(name = "toppings")
@ToString(callSuper = true)
public class Topping extends ElementoMenu {
    public Topping(String nome, int calorie, double prezzo) {
        super(nome, prezzo, calorie);
    }
}
