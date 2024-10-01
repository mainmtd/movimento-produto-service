package com.bnp.movimento_produto_service.application.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovimentoManualResponseDTO {

    private Integer datMes;
    private Integer datAno;
    private Long numLancamento;
    private String codProduto;
    private String descricaoProduto;
    private String codCosif;
    private String classificacaoCosif;
    private String descricao;
    private BigDecimal valor;
}
