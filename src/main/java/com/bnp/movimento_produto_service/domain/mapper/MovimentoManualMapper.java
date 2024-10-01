package com.bnp.movimento_produto_service.domain.mapper;

import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualRequestDTO;
import com.bnp.movimento_produto_service.application.controller.dto.MovimentoManualResponseDTO;
import com.bnp.movimento_produto_service.domain.model.MovimentoManual;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimentoManualMapper {

    @Mapping(target = "produtoCosif", ignore = true)
    MovimentoManual toEntity(MovimentoManualRequestDTO dto);

    @Mapping(target = "descricaoProduto", source = "produtoCosif.produto.desProduto")
    @Mapping(target = "classificacaoCosif", source = "produtoCosif.codClassificacao")
    MovimentoManualResponseDTO toResponseDto(MovimentoManual entity);

    MovimentoManualRequestDTO toDto(MovimentoManual entity);
}
