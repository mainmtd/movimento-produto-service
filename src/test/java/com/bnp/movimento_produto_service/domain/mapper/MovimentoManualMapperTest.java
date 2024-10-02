package com.bnp.movimento_produto_service.domain.mapper;

import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualRequestDTO;
import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualResponseDTO;
import com.bnp.movimento_produto_service.domain.model.MovimentoManual;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovimentoManualMapperTest {

    private final MovimentoManualMapper mapper = Mappers.getMapper(MovimentoManualMapper.class);

    @Test
    void testToEntity() {
        MovimentoManualRequestDTO requestDTO = new MovimentoManualRequestDTO();
        requestDTO.setDatMes(10);
        requestDTO.setDatAno(2023);
        requestDTO.setNumLancamento(1L);
        requestDTO.setCodProduto("P001");
        requestDTO.setCodCosif("C001");
        requestDTO.setDescricao("Test");
        requestDTO.setDataMovimento(LocalDateTime.now());
        requestDTO.setCodUsuario("user01");
        requestDTO.setValor(BigDecimal.valueOf(100.0));

        MovimentoManual entity = mapper.toEntity(requestDTO);

        assertEquals(requestDTO.getDatMes(), entity.getDatMes());
        assertEquals(requestDTO.getDatAno(), entity.getDatAno());
        assertEquals(requestDTO.getCodProduto(), entity.getCodProduto());
        assertEquals(requestDTO.getCodCosif(), entity.getCodCosif());
        assertEquals(requestDTO.getDescricao(), entity.getDescricao());
        assertEquals(requestDTO.getValor(), entity.getValor());
    }

    @Test
    void testToResponseDto() {
        MovimentoManual movimentoManual = new MovimentoManual();
        movimentoManual.setDatMes(10);
        movimentoManual.setDatAno(2023);
        movimentoManual.setNumLancamento(1L);
        movimentoManual.setCodProduto("P001");
        movimentoManual.setDescricao("Test");
        movimentoManual.setValor(BigDecimal.valueOf(100.0));

        MovimentoManualResponseDTO responseDTO = mapper.toResponseDto(movimentoManual);

        assertEquals(movimentoManual.getDatMes(), responseDTO.getDatMes());
        assertEquals(movimentoManual.getDatAno(), responseDTO.getDatAno());
        assertEquals(movimentoManual.getNumLancamento(), responseDTO.getNumLancamento());
        assertEquals(movimentoManual.getCodProduto(), responseDTO.getCodProduto());
        assertEquals(movimentoManual.getDescricao(), responseDTO.getDescricao());
        assertEquals(movimentoManual.getValor(), responseDTO.getValor());
    }
}
