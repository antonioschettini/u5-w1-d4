package antonioschettini.u5_w1_d4.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@MappedSuperclass // serve per jpa per effettuare tabelle distinte per tutte le classi figlie che la implementeranno
public abstract class ElementoMenu {
    protected String nome;
    protected double prezzo;
    protected int calorie;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    //Costruttore personalizzato per i figli
    public ElementoMenu(String nome, double prezzo, int calorie) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.calorie = calorie;
    }
}
