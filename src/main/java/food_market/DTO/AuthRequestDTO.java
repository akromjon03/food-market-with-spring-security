package food_market.DTO;

import lombok.Data;
import lombok.Setter;

@Data
public class AuthRequestDTO {
    private String phone;
    private String password;
}
