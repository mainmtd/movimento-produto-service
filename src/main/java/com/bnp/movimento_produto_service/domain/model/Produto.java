package com.bnp.movimento_produto_service.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "PRODUTO")
@Data
public class Produto {
    @Id
    @Column(name = "COD_PRODUTO", length = 4, nullable = false)
    private String codProduto;

    @Column(name = "DES_PRODUTO", length = 30)
    private String desProduto;

    @Column(name = "STA_STATUS", length = 1)
    private String staStatus;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProdutoCosif> produtoCosifs;
}
