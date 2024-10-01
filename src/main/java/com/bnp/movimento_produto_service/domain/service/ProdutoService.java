package com.bnp.movimento_produto_service.domain.service;

import com.bnp.movimento_produto_service.application.controller.dto.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoService {
    List<ProdutoResponseDTO> listarProdutos();
}
