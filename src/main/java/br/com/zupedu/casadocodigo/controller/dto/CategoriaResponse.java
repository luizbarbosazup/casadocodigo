package br.com.zupedu.casadocodigo.controller.dto;

public class CategoriaResponse {
    private String descricao;

    public CategoriaResponse(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
