package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.controller.dto.AutorRequest;
import br.com.zupedu.casadocodigo.controller.dto.AutorResponse;
import br.com.zupedu.casadocodigo.model.Autor;
import br.com.zupedu.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {

    private AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<AutorResponse> salvaAutor(@RequestBody @Valid AutorRequest autorRequest){

        Boolean existeEmail = repository.existsByEmail(autorRequest.getEmail());

        if(existeEmail){
            return ResponseEntity.badRequest().build();
        }

        Autor autorSalvo = repository.save(autorRequest.toAutor());

        AutorResponse resposta = new AutorResponse(
                autorSalvo.getId(),
                autorSalvo.getNome(),
                autorSalvo.getEmail(),
                autorSalvo.getCreateAt().getDayOfMonth(),
                "Salvo no banco de dados"
        );

        return ResponseEntity.ok(resposta);
    }

}
