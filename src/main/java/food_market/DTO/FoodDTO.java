package food_market.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FoodDTO {
    @NotEmpty(message = "name required")
    private String name;
    @NotNull(message = "categoryId required")
    private Integer categoryId;
    @NotEmpty(message = "description required")
    private String description;
    @NotEmpty(message = "photo required")
    private String photoURL;
    @NotNull(message = "price required")
    private double price;
}
