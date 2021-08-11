package br.com.mercadoLivre.repositories;

import br.com.mercadoLivre.model.OpiniaoUsuarioProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpiniaoUsuarioProdutoRepository extends JpaRepository<OpiniaoUsuarioProduto, Long> {
}
