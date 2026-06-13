package com.xpto.ProjetoERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xpto.ProjetoERP.Entity.Produto;
import com.xpto.ProjetoERP.dto.ProdutoDTO;
import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;


import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Service
public class ProdutoService {
    private static List<Produto> lista = new ArrayList<>();


    public List<ProdutoDTO> listar(){
        List<ProdutoDTO> listaDTO = new ArrayList<>();
        for (Produto produto : lista) {
            listaDTO.add(produto.infos());
        }


        return listaDTO;
    }

    public static boolean cadastrar(@RequestBody ProdutoDTO dto){
        System.out.println("Cadastrando Produto");
        Produto produto = new Produto(dto);
        lista.add(produto);
        return true;
    }

    public boolean debitar(){
        return true;
    }

    /**Verifica o sku passado.
     * @return Retorna true se encontrar e false se não encontrar */
    public static boolean verificarSku(String sku){ //Vai pra um utilitário de teste
        for (Produto produto : lista) {
            if(produto.infos().getSku().equals(sku)){
                return true;
            }
        }
        return false;
    }

    public static boolean verificarDebitar(PedidoMovimentacaoDTO dto){
        if(verificarSku(dto.getSkuProduto())){
            for (Produto produto : lista) {
                if(produto.infos().getQuantidadeEstoque() == dto.getQuantidade()){
                    return true;
                }
            }
        }else {
            return false;
        }
    }



    public static boolean verificarDisponibilidade(float qtd){ //Vai pra um utilitário depois


    }

}
