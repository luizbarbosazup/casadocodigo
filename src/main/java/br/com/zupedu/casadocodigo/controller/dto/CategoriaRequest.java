package br.com.zupedu.casadocodigo.controller.dto;

import br.com.zupedu.casadocodigo.model.Categoria;

public class CategoriaRequest {
    private String descricao;

    public CategoriaRequest(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria toCategoria(){
        return new Categoria(descricao);
    }
}
