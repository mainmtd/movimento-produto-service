package com.bnp.movimento_produto_service.application.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProdutoResponseDTO {
    private String codProduto;
    private String desProduto;
    private List<ProdutoCosifResponseDTO> cosifs;
}
