package food_market.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "foods")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Food{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Category category;
    private String description;
    private String photoURL;
    private double price;
}
