package com.bnp.movimento_produto_service.application.controller;

import com.bnp.movimento_produto_service.application.controller.dto.ProdutoResponseDTO;
import com.bnp.movimento_produto_service.domain.repository.ProdutoCosifRepository;
import com.bnp.movimento_produto_service.domain.repository.ProdutoRepository;
import com.bnp.movimento_produto_service.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoCosifRepository produtoCosifRepository;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos() {
        List<ProdutoResponseDTO> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }
}
