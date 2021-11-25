package com.dio.projectsearch.citiesapi.controllers;

import com.dio.projectsearch.citiesapi.entities.Cidade;
import com.dio.projectsearch.citiesapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cidades")

public class cidadesResource {

    @Autowired
    private CidadeRepository repository;

    @GetMapping
    public Page<Cidade>cidadesPaginadas(Pageable pagina){
        return  repository.findAll(pagina);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity cidadePorId(@PathVariable Long id){
        Optional<Cidade> optionalCidade = repository.findById(id);
        if (optionalCidade.isPresent()){
            return ResponseEntity.ok().body(optionalCidade.get());
        }else{
            return ResponseEntity.notFound().build();
            //return  ResponseEntity.ok().body("O ID digitado não está no banco de dados");

        }
    }


}
