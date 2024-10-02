package com.bnp.movimento_produto_service.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovimentoManualTest {

    @Test
    void testMovimentoManual() {
        MovimentoManual movimentoManual = new MovimentoManual();
        movimentoManual.setDatMes(10);
        movimentoManual.setDatAno(2023);
        movimentoManual.setNumLancamento(1L);
        movimentoManual.setCodProduto("P001");
        movimentoManual.setCodCosif("C001");
        movimentoManual.setDescricao("Teste");
        movimentoManual.setDataMovimento(LocalDateTime.now());
        movimentoManual.setCodUsuario("user01");
        movimentoManual.setValor(BigDecimal.valueOf(100.0));

        assertEquals(10, movimentoManual.getDatMes());
        assertEquals(2023, movimentoManual.getDatAno());
        assertEquals(1L, movimentoManual.getNumLancamento());
        assertEquals("P001", movimentoManual.getCodProduto());
        assertEquals("C001", movimentoManual.getCodCosif());
        assertEquals("Teste", movimentoManual.getDescricao());
        assertEquals("user01", movimentoManual.getCodUsuario());
        assertEquals(BigDecimal.valueOf(100.0), movimentoManual.getValor());
    }
}
