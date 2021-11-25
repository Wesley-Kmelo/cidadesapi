package com.dio.projectsearch.citiesapi.controllers;

import com.dio.projectsearch.citiesapi.entities.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dio.projectsearch.citiesapi.repository.PaisRepository;

import java.util.List;
import java.util.Optional;

//informando ao Spring que essa classe é um controlador Rest onde vai ser confogurado os endpoints
//ou entradas desta api

@RestController
@RequestMapping("/paises")

public class paisesResource {

    //criar uma chamada para a interface de JpaRepository e depois
    //criando o método que vai buscar uma lista da classe pais criada no pacote Entities
    //não esquecer da anotaçao Autowired que vai servir pra dizer pro Spring injetar uma dependencia

    @Autowired
    private PaisRepository repository;


   /* @GetMapping
    public List<Pais> paises(){
        return repository.findAll();
    }*/

    // para criar uma resposta com paginação. Util quando tem muitos registros e para fornecer informações
    // ao time de frontend.
    // criando método Page que retorna um objeto do tipo Pais e passando parametro pagina para o comando de return

    @GetMapping
    public Page<Pais> paisesPaginado(Pageable pagina){
        return  repository.findAll(pagina);
    }


    // para buscar apenas um registro baseado em id que é passado como parametro
    /*@GetMapping
    @RequestMapping("/{id}")
    public Optional<Pais> umPais (@PathVariable Long id){
        return repository.findById(id);
    }*/

    // para tratar erros ao selecionar por id. Criado metodo ResponseEntity que detecta o status code do Get
    // e trata de acordo com a lógica de negócios...
    // cria objeto do tipo responseEntity e o retorno dele é tratado na regra de negocio ou seja lógica
    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity umPais (@PathVariable Long id){
        Optional<Pais> optionalPais = repository.findById(id);
            if (optionalPais.isPresent()){
                return ResponseEntity.ok().body(optionalPais.get());
            }else{
                return ResponseEntity.notFound().build();
            }
    }

}
