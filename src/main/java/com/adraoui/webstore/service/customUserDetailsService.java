package com.adraoui.webstore.service;

import com.adraoui.webstore.model.User;
import lombok.data;
import com.adraoui.webstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class customUserDetailsService implements UserDetails {
    private UserRepository userRepository;

    @Override

    public UserDetails loadUserByUserName(String UsernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(UsernameOrEmail, UsernameOrEmail)
        .orElseThrow(() -> new UsernameNotFoundException("there is no username or email matching: " + UsernameOrEmail));
        return new CustomUserDetails(user);
    }
    
}


