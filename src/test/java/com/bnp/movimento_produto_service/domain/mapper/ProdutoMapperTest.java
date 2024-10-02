package com.bnp.movimento_produto_service.domain.mapper;

import com.bnp.movimento_produto_service.application.controller.dto.ProdutoCosifResponseDTO;
import com.bnp.movimento_produto_service.application.controller.dto.ProdutoResponseDTO;
import com.bnp.movimento_produto_service.domain.model.Produto;
import com.bnp.movimento_produto_service.domain.model.ProdutoCosif;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdutoMapperTest {

    private final ProdutoMapper mapper = Mappers.getMapper(ProdutoMapper.class);

    @Test
    void testToProdutoDto() {
        Produto produto = new Produto();
        produto.setCodProduto("P001");
        produto.setDesProduto("Produto Teste");
        ProdutoCosif cosif = new ProdutoCosif();
        cosif.setId(new ProdutoCosif.ProdutoCosifId());
        cosif.getId().setCodCosif("C001");
        cosif.setCodClassificacao("Class1");
        produto.setProdutoCosifs(Arrays.asList(cosif));

        ProdutoResponseDTO responseDTO = mapper.toProdutoDto(produto);

        assertEquals(produto.getCodProduto(), responseDTO.getCodProduto());
        assertEquals(produto.getDesProduto(), responseDTO.getDesProduto());
        List<ProdutoCosifResponseDTO> cosifsDTO = responseDTO.getCosifs();
        assertEquals(produto.getProdutoCosifs().size(), cosifsDTO.size());
        assertEquals(produto.getProdutoCosifs().get(0).getId().getCodCosif(), cosifsDTO.get(0).getCodCosif());
    }

    @Test
    void testToCosifDto() {
        ProdutoCosif produtoCosif = new ProdutoCosif();
        produtoCosif.setId(new ProdutoCosif.ProdutoCosifId());
        produtoCosif.getId().setCodCosif("C001");
        produtoCosif.setCodClassificacao("Class1");

        ProdutoCosifResponseDTO responseDTO = mapper.toCosifDto(produtoCosif);

        assertEquals(produtoCosif.getId().getCodCosif(), responseDTO.getCodCosif());
        assertEquals(produtoCosif.getCodClassificacao(), responseDTO.getCodClassificacao());
    }
}
