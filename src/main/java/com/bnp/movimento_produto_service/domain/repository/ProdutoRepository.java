package com.bnp.movimento_produto_service.domain.repository;

import com.bnp.movimento_produto_service.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    @Query("SELECT p FROM Produto p LEFT JOIN FETCH p.produtoCosifs")
    List<Produto> findAllWithCosifs();
}
