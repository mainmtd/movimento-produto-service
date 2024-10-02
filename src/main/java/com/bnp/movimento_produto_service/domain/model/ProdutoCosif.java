package com.bnp.movimento_produto_service.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PRODUTO_COSIF")
@Data
public class ProdutoCosif {

    @EmbeddedId
    private ProdutoCosifId id;

    @Column(name = "COD_CLASSIFICACAO", length = 6)
    private String codClassificacao;

    @Column(name = "STA_STATUS", length = 1)
    private String staStatus;

    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO", insertable = false, updatable = false)
    private Produto produto;

    @Embeddable
    @Data
    public static class ProdutoCosifId implements Serializable {
        @Column(name = "COD_PRODUTO", length = 4, nullable = false)
        private String codProduto;

        @Column(name = "COD_COSIF", length = 11, nullable = false)
        private String codCosif;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ProdutoCosifId that)) return false;
            return codProduto.equals(that.codProduto) && codCosif.equals(that.codCosif);
        }

        @Override
        public int hashCode() {
            return Objects.hash(codProduto, codCosif);
        }
    }
}
