package food_market.DTO;

import food_market.model.enums.ProfileRole;
import lombok.Data;

@Data
public class ProfileDTO {
    private Integer id;
    private String phone;
    private String password;
}
