package br.com.elson.auth_server.config;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import br.com.elson.auth_server.entity.RoleEntity;
import br.com.elson.auth_server.entity.UserEntity;
import br.com.elson.auth_server.repository.UserRepository;

@Configuration
public class UserStoreConfig {

    @Autowired
    private  UserRepository userRepository;

    @Bean
    @Transactional
    public UserDetailsService userDetailsService() {
        return username -> {
            UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // LOGANDO AS ROLES
        System.out.println("Usuário encontrado: " + user.getUsername());
        System.out.println("Roles: " + user.getRoles().stream()
            .map(RoleEntity::getName)
            .collect(Collectors.toList()));


            return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .disabled(!user.isEnabled())
                .authorities(user.getRoles().stream()
                    .map(role -> "ROLE_" + role.getName()) // Spring exige prefixo ROLE_ para roles
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList()))
                .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
