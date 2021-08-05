package br.com.mercadoLivre.security;

import br.com.mercadoLivre.model.User;
import br.com.mercadoLivre.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override public UserDetails loadUserByUsername (String login ) throws UsernameNotFoundException {
        Optional<User> result = repository.findByLogin(login);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("NOT FOUND usuário não encontrado para o login informado: " + login);
        }
        return  result.get();
    }
}