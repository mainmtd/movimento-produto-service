package com.bnp.movimento_produto_service.domain.mapper;

import com.bnp.movimento_produto_service.application.controller.dto.ProdutoCosifResponseDTO;
import com.bnp.movimento_produto_service.application.controller.dto.ProdutoResponseDTO;
import com.bnp.movimento_produto_service.domain.model.Produto;
import com.bnp.movimento_produto_service.domain.model.ProdutoCosif;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(source = "id.codCosif", target = "codCosif")
    @Mapping(source = "codClassificacao", target = "codClassificacao")
    ProdutoCosifResponseDTO toCosifDto(ProdutoCosif produtoCosif);

    @Mapping(source = "codProduto", target = "codProduto")
    @Mapping(source = "desProduto", target = "desProduto")
    @Mapping(source = "produtoCosifs", target = "cosifs")
    ProdutoResponseDTO toProdutoDto(Produto produto);
}
