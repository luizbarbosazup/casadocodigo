package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.controller.dto.Livrorequest;
import br.com.zupedu.casadocodigo.repository.LivroRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/livros")
public class LivroController {

    private LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void salvaLivro(@RequestBody @Valid Livrorequest livrorequest){
        repository.save(livrorequest.toLivro());
    }

}
