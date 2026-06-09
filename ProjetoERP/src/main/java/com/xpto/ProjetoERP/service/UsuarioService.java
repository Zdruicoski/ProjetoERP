package com.xpto.ProjetoERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.xpto.ProjetoERP.dto.UsuarioDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class UsuarioService {

    public List<UsuarioDTO> listar(){
        List<UsuarioDTO> lista = new ArrayList<>();
        
        UsuarioDTO user1 = new UsuarioDTO();
        user1.setId(1);
        user1.setLogin("login");
        user1.setNome("Renan");
        user1.setSenha("senha");

        lista.add(user1);
        
        return lista;
    }

    
    @PostMapping
    public boolean salvar(@RequestBody UsuarioDTO dto){
        System.out.println("Salvando Usuário");
        return true;
    }

}
