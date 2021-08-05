package br.com.mercadoLivre.repositories;

import br.com.mercadoLivre.model.CaracteristicaProduto;
import br.com.mercadoLivre.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaracteristicaProdutoRepository extends JpaRepository<CaracteristicaProduto, Long> {

    List<CaracteristicaProduto> findAllByProduto(Produto produto);
}
