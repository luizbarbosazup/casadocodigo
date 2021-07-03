package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.controller.dto.Livrorequest;
import br.com.zupedu.casadocodigo.model.Livro;
import br.com.zupedu.casadocodigo.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<Livro> buscaLivros(){
        return repository.findAll();
    }

}
