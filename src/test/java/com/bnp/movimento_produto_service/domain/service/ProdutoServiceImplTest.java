package com.bnp.movimento_produto_service.domain.service;

import com.bnp.movimento_produto_service.application.controller.dto.ProdutoResponseDTO;
import com.bnp.movimento_produto_service.domain.mapper.ProdutoMapper;
import com.bnp.movimento_produto_service.domain.model.Produto;
import com.bnp.movimento_produto_service.domain.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProdutoServiceImplTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ProdutoMapper produtoMapper;

    @InjectMocks
    private ProdutoServiceImpl produtoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarProdutos() {
        Produto produto = new Produto();
        produto.setCodProduto("P001");
        produto.setDesProduto("Produto Teste");

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto);

        when(produtoRepository.findAllWithCosifs()).thenReturn(produtos);
        when(produtoMapper.toProdutoDto(produto)).thenReturn(new ProdutoResponseDTO());

        List<ProdutoResponseDTO> responseDTOs = produtoService.listarProdutos();

        assertEquals(1, responseDTOs.size());
        verify(produtoRepository).findAllWithCosifs();
    }
}
