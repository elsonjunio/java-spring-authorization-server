package br.com.elson.auth_server.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "oauth2_authorization")
@Data
public class AuthorizationEntity {

    @Id
    @Column(length = 100)
    private String id;

    @Column(name = "registered_client_id", length = 100, nullable = false)
    private String registeredClientId;

    @Column(name = "principal_name", length = 200, nullable = false)
    private String principalName;

    @Column(name = "authorization_grant_type", length = 100, nullable = false)
    private String authorizationGrantType;

    @Column(name = "authorized_scopes", length = 1000)
    private String authorizedScopes;

    @Lob
    @Column(name = "attributes", columnDefinition="TEXT")
    private byte[] attributes;

    @Column(length = 500)
    private String state;

    @Lob
    @Column(name = "authorization_code_value", columnDefinition="TEXT")
    private byte[] authorizationCodeValue;

    private Instant authorizationCodeIssuedAt;
    private Instant authorizationCodeExpiresAt;

    @Lob
    @Column(columnDefinition="TEXT")
    private byte[] authorizationCodeMetadata;

    @Lob
    @Column(columnDefinition="TEXT")
    private byte[] accessTokenValue;

    private Instant accessTokenIssuedAt;
    private Instant accessTokenExpiresAt;

    @Lob
    @Column(columnDefinition="TEXT")
    private byte[] accessTokenMetadata;

    @Column(name = "access_token_type", length = 100)
    private String accessTokenType;

    @Column(name = "access_token_scopes", length = 1000)
    private String accessTokenScopes;

    @Lob
    @Column(columnDefinition="TEXT")
    private byte[] oidcIdTokenValue;

    private Instant oidcIdTokenIssuedAt;
    private Instant oidcIdTokenExpiresAt;

    @Lob
    @Column(columnDefinition="TEXT")
    private byte[] oidcIdTokenMetadata;

    @Lob
    @Column(columnDefinition="TEXT")
    private byte[] refreshTokenValue;

    private Instant refreshTokenIssuedAt;
    private Instant refreshTokenExpiresAt;

    @Lob
    @Column(columnDefinition="TEXT")
    private byte[] refreshTokenMetadata;

    @Lob
    @Column(columnDefinition="TEXT")
    private byte[] userCodeValue;

    private Instant userCodeIssuedAt;
    private Instant userCodeExpiresAt;

    @Lob
    @Column(columnDefinition="TEXT")
    private byte[] userCodeMetadata;

    @Lob
    @Column(columnDefinition="TEXT")
    private byte[] deviceCodeValue;

    private Instant deviceCodeIssuedAt;
    private Instant deviceCodeExpiresAt;

    @Lob
    @Column(columnDefinition="TEXT")
    private byte[] deviceCodeMetadata;
}