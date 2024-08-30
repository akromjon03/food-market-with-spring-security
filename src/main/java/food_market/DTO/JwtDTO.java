package food_market.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JwtDTO {
    private String phone;
    private String role;
}
