package br.com.zupedu.casadocodigo.controller.dto;

import java.time.LocalDateTime;

public class AutorResponse {

    private Long id;
    private String nome;
    private String email;
    private int DiadoCadastro;
    private String msg;

    public AutorResponse(Long id, String nome, String email, int localDateTime, String msg) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.DiadoCadastro = localDateTime;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getMsg() {
        return msg;
    }

    public int getDiadoCadastro() {
        return DiadoCadastro;
    }
}
