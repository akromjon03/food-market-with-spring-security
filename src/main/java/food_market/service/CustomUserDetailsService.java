package food_market.service;

import food_market.config.CustomUserDetails;
import food_market.model.ProfileEntity;
import food_market.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ProfileEntity profile = profileRepository.findByPhoneNumberAndVisibleTrue(username).orElseThrow(()
                -> new UsernameNotFoundException(username));

        return new CustomUserDetails(profile);
    }
}
