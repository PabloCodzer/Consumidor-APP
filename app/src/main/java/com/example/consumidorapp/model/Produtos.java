package com.example.consumidorapp.model;

public class Produtos {
    private String NomeProduto;
    private String ValorProduto;
    private String DescicaoProduto;

    public Produtos(String nomeProduto, String precoProduto, String descicaoProduto) {
        NomeProduto = nomeProduto;
        ValorProduto = precoProduto;
        DescicaoProduto = descicaoProduto;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }

    public String getValorProduto() {
        return ValorProduto;
    }

    public void setValorProduto(String precoProduto) {
        ValorProduto = precoProduto;
    }

    public String getDescicaoProduto() {
        return DescicaoProduto;
    }

    public void setDescicaoProduto(String descicaoProduto) {
        DescicaoProduto = descicaoProduto;
    }
}
