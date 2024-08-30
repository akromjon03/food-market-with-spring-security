package food_market.service;


import food_market.DTO.AuthRequestDTO;
import food_market.DTO.AuthResponseDTO;
import food_market.DTO.ProfileDTO;
import food_market.config.CustomUserDetails;
import food_market.model.ProfileEntity;
import food_market.repository.ProfileRepository;
import food_market.util.JwtUtil;
import food_market.util.MD5Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileService {
    private final ProfileRepository profileRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public ProfileDTO registration(ProfileDTO dto) {

        Optional<ProfileEntity> optional = profileRepository.findByPhoneNumberAndVisibleTrue(dto.getPhone());
        if (optional.isPresent()) {
            return null;
        }

        ProfileEntity entity = new ProfileEntity();
        entity.setPhoneNumber(dto.getPhone());
        entity.setPassword(MD5Util.getMd5(dto.getPassword()));


        profileRepository.save(entity);

        dto.setId(entity.getId());
        log.debug("New User signed up: {}", entity);
        return dto;


    }



    public AuthResponseDTO authorization(AuthRequestDTO auth){

//        try {
//            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getPhone(), auth.getPassword()));
//            if (authentication.isAuthenticated()) {
//                CustomUserDetails profile = (CustomUserDetails) authentication.getPrincipal();
//                AuthResponseDTO response = new AuthResponseDTO();
//                response.setPhone(profile.getPhone());
//                response.setRole(profile.getRole());
//                response.setJwtToken(JwtUtil.encode(profile.getPhone(), profile.getRole().name()));
//                return response;
//            }
//        } catch (BadCredentialsException e) {
//            throw new UsernameNotFoundException("Phone or password wrong");
//        }
//        throw new UsernameNotFoundException("Phone or password wrong");

        ProfileEntity profile = profileRepository.findByPhoneNumberAndVisibleTrue(auth.getPhone()).orElseThrow(
                () -> new UsernameNotFoundException("Phone or password wrong"));
        String passwordWithEncode = MD5Util.getMd5(auth.getPassword());

        if (!passwordWithEncode.equals(profile.getPassword()))
            throw new UsernameNotFoundException("Phone or password wrong");

        AuthResponseDTO response = new AuthResponseDTO();
                response.setPhone(profile.getPhoneNumber());
                response.setRole(profile.getRole());
                response.setJwtToken(JwtUtil.encode(profile.getPhoneNumber(), profile.getRole().name()));
                return response;
    }

}
