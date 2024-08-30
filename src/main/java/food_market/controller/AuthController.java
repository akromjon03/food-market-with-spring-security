package food_market.controller;


import food_market.DTO.AuthRequestDTO;
import food_market.DTO.AuthResponseDTO;
import food_market.DTO.ProfileDTO;
import food_market.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/evos/auth")
public class AuthController {
    private final ProfileService profileService;

    @PostMapping("/signUp")
    public ResponseEntity<ProfileDTO> create(@RequestBody ProfileDTO dto) {
        ProfileDTO result = profileService.registration(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/signIn")
    public ResponseEntity<AuthResponseDTO> authorization(@RequestBody AuthRequestDTO dto) {
        AuthResponseDTO result = profileService.authorization(dto);
        return ResponseEntity.ok(result);
    }
}
