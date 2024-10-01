package com.bnp.movimento_produto_service.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "MOVIMENTO_MANUAL")
@IdClass(MovimentoManualId.class)
@Data
public class MovimentoManual {

    @Id
    @Column(name = "DAT_MES")
    private Integer datMes;

    @Id
    @Column(name = "DAT_ANO")
    private Integer datAno;

    @Id
    @Column(name = "NUM_LANCAMENTO")
    private Long numLancamento;

    @Id
    @Column(name = "COD_PRODUTO", length = 4)
    private String codProduto;

    @Id
    @Column(name = "COD_COSIF", length = 11)
    private String codCosif;

    @Column(name = "DES_DESCRICAO", length = 50)
    private String descricao;

    @Column(name = "DAT_MOVIMENTO")
    private LocalDateTime dataMovimento;

    @Column(name = "COD_USUARIO", length = 15)
    private String codUsuario;

    @Column(name = "VAL_VALOR")
    private BigDecimal valor;

    @ManyToOne
    @MapsId("id")
    @JoinColumns({
            @JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO", insertable = false, updatable = false),
            @JoinColumn(name = "COD_COSIF", referencedColumnName = "COD_COSIF", insertable = false, updatable = false)
    })
    private ProdutoCosif produtoCosif;
}
