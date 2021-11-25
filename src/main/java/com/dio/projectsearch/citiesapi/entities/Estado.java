package com.dio.projectsearch.citiesapi.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

// para criação desta entidade além do básico foi adicionada a anotação @typeDefs que define como o Hibernate vai tratar
// dados que vem como forma de lista , como é o caso do campo DDD. Pra essa anotação funcionar é preciso que seja
// baixada uma dependencia nos properties chamada "com.vladmihalcea". Depois na coluna ddd,no caso, deve ser
// definida o tipo de dado("jsonb") e como ela vai ser populada na lista...no caso só quando for chamada. E por ser uma
// lista, deve ser criado o atributo correspondente.

@Entity
@Table(name="estado")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})

public class Estado {

    @Id
    private Long Id;

    @Column(name = "nome")
    private String nomeEstado;

    @Column(name = "uf")
    private String siglaEstado;

    @Column(name= "ibge")
    private Integer numIbge;

   /* @Column(name="pais")
    private Integer numPais;*/

    // formas de relacionamento entre as tabelas, onde é dito que muitos registros(Many)compartilham um registro
    // em outra tabela(One). Dessa forma em vez de apenas obter o numero do pais na tabela, é possivel
    // obter a qual resgitro corresponde na tabela de pais e se preferir buscar a entidade inteira ou se desejar só o nome
    // conforme detalhado no método getPais  lá embaixo
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private  Pais pais;


    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd" , columnDefinition = "jsonb")
    private List <Integer> listaDDD;


    // CONSTRUTOR DA TABELA
    public Estado() {
    }

    // GETTERS
    public Long getId() {
        return Id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public Integer getNumIbge() {
        return numIbge;
    }

    /*public Integer getNumPais() {
        return numPais;
    }*/

    public String getPais (){
        return pais.getNomeNacional() +" ,código: "+ pais.getCodPais();
    }

    public List<Integer> getListaDDD() {
        return listaDDD;
    }
}
