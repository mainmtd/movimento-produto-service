package com.bnp.movimento_produto_service.domain.service;

import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualRequestDTO;
import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualResponseDTO;
import com.bnp.movimento_produto_service.domain.mapper.MovimentoManualMapper;
import com.bnp.movimento_produto_service.domain.model.MovimentoManual;
import com.bnp.movimento_produto_service.domain.repository.MovimentoManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimentoManualServiceImpl implements MovimentoManualService{
    @Autowired
    private MovimentoManualRepository movimentoManualRepository;
    @Autowired
    private MovimentoManualMapper movimentoManualMapper;

    @Override
    public void criarMovimentoManual(MovimentoManualRequestDTO movimentoManualRequestDTO) {
        Long maxLancamento = movimentoManualRepository.findMaxNumLancamentoByMesAndAno(movimentoManualRequestDTO.getDatMes(), movimentoManualRequestDTO.getDatAno());
        movimentoManualRequestDTO.setNumLancamento(maxLancamento + 1);

        MovimentoManual movimentoManual = movimentoManualMapper.toEntity(movimentoManualRequestDTO);
        movimentoManualRepository.save(movimentoManual);
    }

    @Override
    public List<MovimentoManualResponseDTO> listarMovimentosManuais() {
        List<MovimentoManual> movimentos = movimentoManualRepository.findAll();
        return movimentos.stream()
                .map(movimentoManualMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
