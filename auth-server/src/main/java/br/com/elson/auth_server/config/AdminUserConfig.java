package br.com.elson.auth_server.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.elson.auth_server.entity.RoleEntity;
import br.com.elson.auth_server.entity.UserEntity;
import br.com.elson.auth_server.repository.RoleRepository;
import br.com.elson.auth_server.repository.UserRepository;
import jakarta.transaction.Transactional;

@Configuration
public class AdminUserConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'run'");


        List<RoleEntity> roles = new ArrayList<>();
        RoleEntity roleAdmin = new RoleEntity();
        roleAdmin.setName("ADMIN");
        
        RoleEntity roleUser = new RoleEntity();
		roleUser.setName("USER");
        
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

		roles.add(roleAdmin);
		roles.add(roleUser);

		UserEntity user = new UserEntity();
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("password"));
		user.setRoles(new HashSet<>(roles));

		userRepository.save(user);        

    }
}
