package br.com.elson.resource_server.controller;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/automation")
public class AutomationController {

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_read:tasks')")
    public String getTasksForAutomation(@AuthenticationPrincipal Jwt jwt) {
        return "Automated tasks for client: " + jwt.getSubject();
    }

}
