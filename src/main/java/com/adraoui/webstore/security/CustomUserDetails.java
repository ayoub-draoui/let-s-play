package com.adraoui.webstore.security;


import lombok.*;
import com.adraoui.webstore.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomUserDetails implements UserDetails {

    private User user;
    public String getId(){
        return user.getId();
    }

    @Override
    public Collection< ? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority());
    }

    @Override 
    public String getPasswors(){
        return user.getPassword();
    }

     @Override
   public String getUsername(){
    return user.getUsername();
   }

   @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
