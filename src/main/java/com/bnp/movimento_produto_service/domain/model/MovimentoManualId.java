package com.bnp.movimento_produto_service.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Data
public class MovimentoManualId implements Serializable {

    private Integer datMes;
    private Integer datAno;
    private Long numLancamento;
    private String codProduto;
    private String codCosif;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovimentoManualId)) return false;
        MovimentoManualId that = (MovimentoManualId) o;
        return Objects.equals(datMes, that.datMes) &&
                Objects.equals(datAno, that.datAno) &&
                Objects.equals(numLancamento, that.numLancamento) &&
                Objects.equals(codProduto, that.codProduto) &&
                Objects.equals(codCosif, that.codCosif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datMes, datAno, numLancamento, codProduto, codCosif);
    }
}
