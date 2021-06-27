package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.controller.dto.CategoriaRequest;
import br.com.zupedu.casadocodigo.controller.dto.CategoriaResponse;
import br.com.zupedu.casadocodigo.model.Categoria;
import br.com.zupedu.casadocodigo.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cadastros")
public class CategoriaController {

    private CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public CategoriaResponse salvaCadastro(@RequestBody CategoriaRequest categoriaRequest){

        Categoria categoria = repository.save(categoriaRequest.toCategoria());
        return new CategoriaResponse(categoria.getDescricao());

    }

}
