package br.com.elson.client_server.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class ClientController {
    WebClient webClient;

    public  ClientController(WebClient.Builder builder) {
        webClient = builder
        .baseUrl("http://127.0.0.1:9090")
        .build();
    }

    @GetMapping("home")
    public Mono<String> home(
        @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client, 
        @AuthenticationPrincipal OidcUser oidcUser){

        return Mono.just("""
                <h2> Access token: %s</h2>
                <h2> Refresh token: %s</h2>
                <h2> ID token: %s</h2>
                <h2> Claims: %s</h2>
                """.formatted(client.getAccessToken().getTokenValue(), 
                client.getRefreshToken().getTokenValue(), 
                oidcUser.getIdToken().getTokenValue(),
                oidcUser.getClaims()));
    }

    @GetMapping("tasks")
    public Mono<String> getTasks(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client) {
        return webClient
        .get()
        .uri("tasks")
        .header("Authorization", "Bearer %s".formatted(
            client.getAccessToken().getTokenValue()
        ))
        .retrieve()
        .bodyToMono(String.class);

    }

}
