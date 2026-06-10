package com.xpto.ProjetoERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.xpto.ProjetoERP.Entity.Produto;
import com.xpto.ProjetoERP.dto.ProdutoDTO;

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

    @PostMapping
    public static boolean cadastrar(@RequestBody ProdutoDTO dto){
        System.out.println("Cadastrando Produto");
        Produto produto = new Produto(dto);
        lista.add(produto);
        return true;
    }

    public boolean debitar(float qtd){
        return true;
    }



}
