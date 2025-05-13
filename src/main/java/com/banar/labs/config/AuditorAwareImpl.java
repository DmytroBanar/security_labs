package com.banar.labs.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//       UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//       String username = userDetails.getUsername();
        return Optional.of(System.getProperty("user.name"));
    }
}
