package com.banar.labs.security;

import com.banar.labs.user.Role;
import com.banar.labs.user.User;
import com.banar.labs.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

     @PostConstruct
      void init() {
          User user = User.builder()
                  .firstName("John")
                  .lastName("Pork")
                  .email("johnpork@gmail.com")
                  .password(passwordEncoder.encode("password"))
                  .enabled(true)
                  .accountLocked(false)
                  .roles(List.of(Role.USER))
                  .build();
         User admin = User.builder()
                 .firstName("Bombardiro")
                 .lastName("Crocodilo")
                 .email("BombardiroCrocodilo@gmail.com")
                 .password(passwordEncoder.encode("password"))
                 .enabled(true)
                 .accountLocked(false)
                 .roles(List.of(Role.ADMIN))
                 .build();
         User superadmin = User.builder()
                 .firstName("Bobrito")
                 .lastName("Bandito")
                 .email("BobritoBandito@gmail.com")
                 .password(passwordEncoder.encode("password"))
                 .enabled(true)
                 .accountLocked(false)
                 .roles(List.of(Role.SUPERADMIN))
                 .build();
         repository.deleteAll();
         repository.save(user);
         repository.save(admin);
         repository.save(superadmin);

     }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return repository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
