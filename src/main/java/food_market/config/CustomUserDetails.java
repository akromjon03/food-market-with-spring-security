package food_market.config;

import food_market.model.ProfileEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import food_market.model.enums.GeneralStatus;
import food_market.model.enums.ProfileRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
public class CustomUserDetails implements UserDetails {
    private String phone;
    private String password;
    private ProfileRole role;
    private GeneralStatus status;

    public CustomUserDetails(ProfileEntity profile){
        this.phone=profile.getPhoneNumber();
        this.password=profile.getPassword();
        this.role=profile.getRole();
        this.status=profile.getStatus();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roles=new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(role.name()));
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status.equals(GeneralStatus.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
