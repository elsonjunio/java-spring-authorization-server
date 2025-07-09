package br.com.elson.auth_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
public class SecurityFilterConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
    	OAuth2AuthorizationServerConfigurer authorizationServerConfigurer =
    			OAuth2AuthorizationServerConfigurer.authorizationServer();

        authorizationServerConfigurer.oidc(Customizer.withDefaults());

    	http
    		.securityMatcher(authorizationServerConfigurer.getEndpointsMatcher())
            .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
            .csrf(csrf -> csrf.ignoringRequestMatchers(authorizationServerConfigurer.getEndpointsMatcher()))
    		.with(authorizationServerConfigurer, (authorizationServer) ->
    			authorizationServer
    				.oidc(Customizer.withDefaults())	// Initialize `OidcConfigurer`
    		)
            .exceptionHandling(exceptions -> exceptions
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
            );

        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

    	return http.build();
    }

    @Bean
    @Order(2)
    SecurityFilterChain defauSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
        .formLogin(Customizer.withDefaults());

        return http.build();
    }

}
