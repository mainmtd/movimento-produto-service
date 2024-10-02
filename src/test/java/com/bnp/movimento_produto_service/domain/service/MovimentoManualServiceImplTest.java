package com.bnp.movimento_produto_service.domain.service;

import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualRequestDTO;
import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualResponseDTO;
import com.bnp.movimento_produto_service.domain.mapper.MovimentoManualMapper;
import com.bnp.movimento_produto_service.domain.model.MovimentoManual;
import com.bnp.movimento_produto_service.domain.repository.MovimentoManualRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MovimentoManualServiceImplTest {

    @Mock
    private MovimentoManualRepository movimentoManualRepository;

    @Mock
    private MovimentoManualMapper movimentoManualMapper;

    @InjectMocks
    private MovimentoManualServiceImpl movimentoManualService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarMovimentoManual() {
        MovimentoManualRequestDTO requestDTO = new MovimentoManualRequestDTO();
        requestDTO.setDatMes(10);
        requestDTO.setDatAno(2023);
        requestDTO.setCodProduto("P001");
        requestDTO.setCodCosif("C001");
        requestDTO.setDescricao("Test");
        requestDTO.setValor(BigDecimal.valueOf(100.0));

        MovimentoManual movimentoManual = new MovimentoManual();
        movimentoManual.setDatMes(10);
        movimentoManual.setDatAno(2023);
        movimentoManual.setCodProduto("P001");
        movimentoManual.setCodCosif("C001");
        movimentoManual.setNumLancamento(2L);
        movimentoManual.setDescricao("Test");
        movimentoManual.setValor(BigDecimal.valueOf(100.0));

        when(movimentoManualRepository.findMaxNumLancamentoByMesAndAno(10, 2023)).thenReturn(1L);
        when(movimentoManualMapper.toEntity(requestDTO)).thenReturn(movimentoManual);

        movimentoManualService.criarMovimentoManual(requestDTO);

        ArgumentCaptor<MovimentoManual> captor = ArgumentCaptor.forClass(MovimentoManual.class);
        verify(movimentoManualRepository).save(captor.capture());

        MovimentoManual savedMovimento = captor.getValue();
        assertEquals(2L, savedMovimento.getNumLancamento());
        assertEquals("P001", savedMovimento.getCodProduto());
        assertEquals("C001", savedMovimento.getCodCosif());
        assertEquals("Test", savedMovimento.getDescricao());
        assertEquals(BigDecimal.valueOf(100.0), savedMovimento.getValor());
    }

    @Test
    void testListarMovimentosManuais() {
        MovimentoManual movimentoManual = new MovimentoManual();
        movimentoManual.setDatMes(10);
        movimentoManual.setDatAno(2023);
        movimentoManual.setCodProduto("P001");
        movimentoManual.setCodCosif("C001");
        movimentoManual.setDescricao("Test");
        movimentoManual.setValor(BigDecimal.valueOf(100.0));

        List<MovimentoManual> movimentos = new ArrayList<>();
        movimentos.add(movimentoManual);

        when(movimentoManualRepository.findAll()).thenReturn(movimentos);
        when(movimentoManualMapper.toResponseDto(movimentoManual)).thenReturn(new MovimentoManualResponseDTO());

        List<MovimentoManualResponseDTO> responseDTOs = movimentoManualService.listarMovimentosManuais();

        assertEquals(1, responseDTOs.size());
        verify(movimentoManualRepository).findAll();
    }
}
