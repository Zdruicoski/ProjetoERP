package com.xpto.ProjetoERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xpto.ProjetoERP.Entity.MovimentacaoBaixa;
import com.xpto.ProjetoERP.Entity.MovimentacaoReposicao;
import com.xpto.ProjetoERP.Entity.Produto;
import com.xpto.ProjetoERP.dto.MovimentacaoDTO;
import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Service
public class MovimentacaoService {
    private static List<MovimentacaoDTO> lista = new ArrayList<>();


    public List<MovimentacaoDTO> listar(){
        return lista;
    }


    public boolean debitar(@RequestBody PedidoMovimentacaoDTO dto){
        if (ProdutoService.verificarDebitar(dto)){
            MovimentacaoDTO baixaDTO;

            Produto produto = ProdutoService.buscarProduto(dto);
            MovimentacaoBaixa baixa = new MovimentacaoBaixa(dto, produto);
            baixaDTO = baixa.executar();

            lista.add(baixaDTO);

        }
        
        return true;
    }
  
    public boolean repor(@RequestBody PedidoMovimentacaoDTO dto){
        if (ProdutoService.verificarSku(dto)){
            MovimentacaoDTO reposicaoDTO;

            Produto produto = ProdutoService.buscarProduto(dto);
            MovimentacaoReposicao reposicao = new MovimentacaoReposicao(dto, produto);
            reposicaoDTO = reposicao.executar();

            lista.add(reposicaoDTO);

        }
        return true;
    }

}
