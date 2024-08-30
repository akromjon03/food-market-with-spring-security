package food_market.DTO;

import food_market.model.enums.ProfileRole;
import lombok.Data;

@Data
public class AuthResponseDTO {
    private String phone;
    private ProfileRole role;
    private String jwtToken;
}
