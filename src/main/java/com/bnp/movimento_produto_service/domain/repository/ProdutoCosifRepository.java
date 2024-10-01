package com.bnp.movimento_produto_service.domain.repository;

import com.bnp.movimento_produto_service.domain.model.ProdutoCosif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoCosifRepository extends JpaRepository<ProdutoCosif, ProdutoCosif.ProdutoCosifId> {
}
