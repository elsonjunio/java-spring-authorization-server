package br.com.elson.auth_server.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "oauth2_authorization_consent")
@Data
@IdClass(AuthorizationConsentEntity.PK.class)
public class AuthorizationConsentEntity {
    @Id
    @Column(name = "registered_client_id", length = 100, nullable = false)
    private String registeredClientId;

    @Id
    @Column(name = "principal_name", length = 200, nullable = false)
    private String principalName;

    @Column(length = 1000, nullable = false)
    private String authorities;

    /**
     * Classe de chave composta (PK)
     */
    @Data
    public static class PK implements Serializable {
        private String registeredClientId;
        private String principalName;
    }
}
