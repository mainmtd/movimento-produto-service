package com.bnp.movimento_produto_service.domain.service;

import com.bnp.movimento_produto_service.application.controller.dto.ProdutoResponseDTO;
import com.bnp.movimento_produto_service.domain.mapper.ProdutoMapper;
import com.bnp.movimento_produto_service.domain.model.Produto;
import com.bnp.movimento_produto_service.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    public List<ProdutoResponseDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAllWithCosifs();
        return produtos.stream()
                .map(produtoMapper::toProdutoDto)
                .collect(Collectors.toList());
    }
}
