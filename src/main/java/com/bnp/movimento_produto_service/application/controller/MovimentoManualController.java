package com.bnp.movimento_produto_service.application.controller;

import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualRequestDTO;
import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualResponseDTO;
import com.bnp.movimento_produto_service.domain.service.MovimentoManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimento")
public class MovimentoManualController {

    @Autowired
    private MovimentoManualService movimentoManualService;

    @PostMapping
    public ResponseEntity<String> criarMovimentosManuais(@RequestBody MovimentoManualRequestDTO movimentoManual) {
        movimentoManualService.criarMovimentoManual(movimentoManual);
        return new ResponseEntity<>("Movimento Manual criado com sucesso", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MovimentoManualResponseDTO>> listarMovimentosManuais() {
        List<MovimentoManualResponseDTO> movimentos = movimentoManualService.listarMovimentosManuais();
        return ResponseEntity.ok(movimentos);
    }
}
