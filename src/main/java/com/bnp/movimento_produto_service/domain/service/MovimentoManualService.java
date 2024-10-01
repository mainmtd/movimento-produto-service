package com.bnp.movimento_produto_service.domain.service;

import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualRequestDTO;
import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualResponseDTO;

import java.util.List;

public interface MovimentoManualService {
    void criarMovimentoManual(MovimentoManualRequestDTO movimentoManualRequestDTO);
    List<MovimentoManualResponseDTO> listarMovimentosManuais();
}
