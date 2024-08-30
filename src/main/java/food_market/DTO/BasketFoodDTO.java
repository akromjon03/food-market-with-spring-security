package food_market.DTO;

import jakarta.validation.constraints.NotNull;

public record BasketFoodDTO(
        @NotNull(message = "required foodId")
        Integer foodId,
        @NotNull(message = "required count")
        int count,
        @NotNull(message = "required basketId")
        Integer basketId
        ) {
}
