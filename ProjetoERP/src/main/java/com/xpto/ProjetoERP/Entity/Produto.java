package com.xpto.ProjetoERP.Entity;

import com.xpto.ProjetoERP.dto.ProdutoDTO;

public class Produto {
    private String sku;
    private String nome;
    private float valorUnitario;
    private String dataCadastro;
    private float quantidadeEstoque;

    public Produto(ProdutoDTO dto) {
        this.sku = dto.getSku();
        this.nome = dto.getNome();
        this.valorUnitario = dto.getValorUnitario();
        this.dataCadastro = dto.dataCadastro();
        this.quantidadeEstoque = dto.quantidadeEstoque();
    }

    public ProdutoDTO infos(){
        ProdutoDTO dto = new ProdutoDTO(sku, nome, valorUnitario, dataCadastro, quantidadeEstoque);

        return dto;
    }

    public boolean debitar(float qtd){
        if(quantidadeEstoque < qtd){
            System.err.println("Estoque insuficiente"); //Passar esse teste para o service
            return false;
        } else{
            quantidadeEstoque = quantidadeEstoque - qtd; //Produto faz só isso
            
            return true;
        }
    }
}