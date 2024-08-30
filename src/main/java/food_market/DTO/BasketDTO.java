package food_market.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class BasketDTO {
    @NotNull(message = "Required userId")
    Integer userId;
}
