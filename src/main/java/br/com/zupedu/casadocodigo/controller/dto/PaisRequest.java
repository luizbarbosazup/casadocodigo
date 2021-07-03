package br.com.zupedu.casadocodigo.controller.dto;


import br.com.zupedu.casadocodigo.controller.validator.ValidaCampoDuplicado;
import br.com.zupedu.casadocodigo.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisRequest {
    @NotBlank @ValidaCampoDuplicado(atributo = "nome", aClass = Pais.class)
    private String nome;

//    @JsonCreator
//    public PaisRequest(@JsonProperty("nome") String nome) {
//        this.nome = nome;
//    }

    public String getNome() {
        return nome;
    }

    public Pais toPais(){
        return new Pais(nome);
    }
}
