package br.com.elson.auth_server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elson.auth_server.entity.ClientEntity;

@Repository
public interface ClientEntityRepository extends JpaRepository<ClientEntity, String> {
    Optional<ClientEntity> findByClientId(String clientId);
}
