package com.dio.projectsearch.citiesapi.controllers;

import com.dio.projectsearch.citiesapi.entities.Estado;
import com.dio.projectsearch.citiesapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")

public class estadosResource {

    //criar uma chamada para a interface de JpaRepository e depois
    //criando o método que vai buscar uma lista da classe pais criada no pacote Entities
    //não esquecer da anotaçao Autowired que vai servir pra dizer pro Spring injetar uma dependencia
    @Autowired
    private EstadoRepository repository;

    // pesquisar todos os estados sem paginação
   /* @GetMapping
    public List <Estado> listaEstado(){
        return repository.findAll();
    }*/

    // pesquisar um estado passando o numero do pais
    @GetMapping
    @RequestMapping("/{id}")
    public Optional <Estado> umEst(@PathVariable Long id){
          return  repository.findById(id);
        }

    //pesquisar os dados com paginação
    @GetMapping
    public Page<Estado> estPaginado(Pageable pagina){
        return  repository.findAll(pagina);
    }


}
