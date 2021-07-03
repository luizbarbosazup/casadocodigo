package br.com.zupedu.casadocodigo.controller;

import br.com.zupedu.casadocodigo.controller.dto.EstadoRequest;
import br.com.zupedu.casadocodigo.model.Estado;
import br.com.zupedu.casadocodigo.repository.EstadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/estados")
public class EstadoController {

    private EstadoRepository repository;

    public EstadoController(EstadoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Estado> salvaEstado(@RequestBody @Valid EstadoRequest estadoRequest){

        Optional<Estado> temEstado =
                repository.findByNomeAndPaisId(
                        estadoRequest.getNome(),
                        estadoRequest.getPais().getId());

        if(temEstado.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        Estado estadoSalvo = repository.save(estadoRequest.toEstado());

        return ResponseEntity.ok(estadoSalvo);
    }



}
