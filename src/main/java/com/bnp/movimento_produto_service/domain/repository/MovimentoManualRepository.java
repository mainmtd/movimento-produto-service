package com.bnp.movimento_produto_service.domain.repository;

import com.bnp.movimento_produto_service.domain.model.MovimentoManual;
import com.bnp.movimento_produto_service.domain.model.MovimentoManualId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovimentoManualRepository extends JpaRepository<MovimentoManual, MovimentoManualId> {
    @Query("SELECT COALESCE(MAX(m.numLancamento), 0) FROM MovimentoManual m WHERE m.datMes = :mes AND m.datAno = :ano")
    Long findMaxNumLancamentoByMesAndAno(@Param("mes") Integer mes, @Param("ano") Integer ano);
}
