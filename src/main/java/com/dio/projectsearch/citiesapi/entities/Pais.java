package com.dio.projectsearch.citiesapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//informado ao Spring que essa classe representa uma tabela do banco de dados e por isso é uma entidade.
//depois de especificado qual o nome da tabela do database, devera ser informado quais os campos existem nessa tabela
//Por retornar os valores de um database existente deve-se criar um construtor vazio e depois os getters dos atributos da classe


@Entity
@Table(name =  "pais")
public class Pais {

    @Id
    private Long id ;

    @Column(name="nome")
    private String nomeExterior;

    @Column(name = "nome_pt")
    private String nomeNacional;

    @Column(name = "sigla")
    private String codPais;

    private int bacen;

    public Pais() {
    }

    public Long getId() {
        return id;
    }

    public String getNomeExterior() {
        return nomeExterior;
    }

    public String getNomeNacional() {
        return nomeNacional;
    }

    public String getCodPais() {
        return codPais;
    }

    public int getBacen() {
        return bacen;
    }
}
