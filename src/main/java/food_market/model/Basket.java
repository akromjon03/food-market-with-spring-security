package food_market.model;


import food_market.model.enums.BasketStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "baskets")
@Setter
@Getter
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private BasketStatus basketStatus;
    @ManyToOne
    private ProfileEntity profileEntity;
    private Double total;
}

