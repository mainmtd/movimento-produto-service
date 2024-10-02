package com.bnp.movimento_produto_service.application.controller;

import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualRequestDTO;
import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualResponseDTO;
import com.bnp.movimento_produto_service.domain.service.MovimentoManualService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(MovimentoManualController.class)
class MovimentoManualControllerTest {
    @MockBean
    private MovimentoManualService movimentoManualService;

    @Autowired
    private MovimentoManualController movimentoManualController;

    @Test
    void testCriarMovimentosManuais() {
        MovimentoManualRequestDTO request = new MovimentoManualRequestDTO();
        Mockito.doNothing().when(movimentoManualService).criarMovimentoManual(request);

        ResponseEntity<String> response = movimentoManualController.criarMovimentosManuais(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Movimento Manual criado com sucesso", response.getBody());
    }

    @Test
    void testListarMovimentosManuais() {
        List<MovimentoManualResponseDTO> mockResponse = Collections.singletonList(new MovimentoManualResponseDTO());
        Mockito.when(movimentoManualService.listarMovimentosManuais()).thenReturn(mockResponse);

        ResponseEntity<List<MovimentoManualResponseDTO>> response = movimentoManualController.listarMovimentosManuais();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
    }
}