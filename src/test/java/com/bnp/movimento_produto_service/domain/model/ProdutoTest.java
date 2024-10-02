package com.bnp.movimento_produto_service.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdutoTest {

    @Test
    void testProduto() {
        Produto produto = new Produto();
        produto.setCodProduto("P001");
        produto.setDesProduto("Produto Teste");
        produto.setStaStatus("A");

        ProdutoCosif cosif = new ProdutoCosif();
        cosif.setId(new ProdutoCosif.ProdutoCosifId());
        cosif.getId().setCodCosif("C001");
        cosif.setCodClassificacao("Class1");

        produto.setProdutoCosifs(new ArrayList<>());
        produto.getProdutoCosifs().add(cosif);

        assertEquals("P001", produto.getCodProduto());
        assertEquals("Produto Teste", produto.getDesProduto());
        assertEquals("A", produto.getStaStatus());
        assertEquals(1, produto.getProdutoCosifs().size());
        assertEquals("C001", produto.getProdutoCosifs().get(0).getId().getCodCosif());
    }
}

