package br.com.elson.auth_server.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elson.auth_server.entity.AuthorizationConsentEntity;
import br.com.elson.auth_server.entity.AuthorizationConsentEntity.PK;

public interface AuthorizationConsentRepository extends JpaRepository<AuthorizationConsentEntity, PK> {
    // Métodos de busca podem ser adicionados conforme necessidade
}
