package br.com.elson.auth_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elson.auth_server.entity.AuthorizationEntity;

public interface AuthorizationRepository extends JpaRepository<AuthorizationEntity, String> {
    // Você pode adicionar métodos de consulta aqui se quiser
}
