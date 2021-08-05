package br.com.mercadoLivre.repositories;

import br.com.mercadoLivre.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    Optional<User> findById(Long id);
}
