package com.bnp.movimento_produto_service.application.controller.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MovimentoManualRequestDTO {
    private Integer datMes;
    private Integer datAno;
    private Long numLancamento;
    private String codProduto;
    private String codCosif;
    private String descricao;
    private LocalDateTime dataMovimento;
    private String codUsuario;
    private BigDecimal valor;
}
