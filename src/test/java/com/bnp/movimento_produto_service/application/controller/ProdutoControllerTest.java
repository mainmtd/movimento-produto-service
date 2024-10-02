package com.bnp.movimento_produto_service.application.controller;

import com.bnp.movimento_produto_service.application.controller.dto.ProdutoResponseDTO;
import com.bnp.movimento_produto_service.domain.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoService produtoService;

    @Test
    void testListarProdutos() throws Exception {
        List<ProdutoResponseDTO> mockResponse = Collections.singletonList(new ProdutoResponseDTO());
        Mockito.when(produtoService.listarProdutos()).thenReturn(mockResponse);

        mockMvc.perform(get("/api/produto"))
                .andExpect(status().isOk());
    }
}