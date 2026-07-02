package antonioschettini.u5_w1_d4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // con il data mi crea automaticamente getter setter e tostring
@Entity
@Table(name = "drinks")
@NoArgsConstructor
@ToString(callSuper = true)
public class Drink extends ElementoMenu {

    public Drink(String nome, int calorie, double prezzo) {
        super(nome, prezzo, calorie);
    }
}
