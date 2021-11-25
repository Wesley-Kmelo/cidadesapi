package com.dio.projectsearch.citiesapi.entities;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name ="cidade")
@TypeDefs(value =  {
        @TypeDef(name = "point", typeClass = PointType.class)
})


public class Cidade {

    @Id
    private  Long id;

    @Column(name = "nome")
    private String nCidade;

    @Column(name = "uf")
    private Integer codEstado;


    //para referenciar esta coluna com a coluna de estado de forma que ao receber o código UF em cidade
    //faça a correspondencia correta em estado apresentadno assim o nome do estado. Os parametros de Join querem dizer
    // qual coluna da tabela deve ser consultada("uf") e por qual indice deve ser localizada ("id")
   @ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id", insertable = false, updatable = false)
    private  Estado estado;

    private Integer ibge;

  /*  @Column(name= "lat_lon")
    private  String geolocalizacao;
*/
    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
   private Point geolocation;

    @Column(name="latitude")
    private Double latCidade;

    @Column(name = "longitude")
    private Double lonCidade;

    @Column(name = "cod_tom")
    private Integer codTomCidade;

    public Cidade() {
    }


    public Long getId() {
        return id;
    }

    public String getnCidade() {
        return nCidade;
    }

    /*public Integer getCodEstado() {
        return codEstado;
    }*/

    public String getEstado(){
        return  estado.getNomeEstado();
    }

    public Integer getIbge() {
        return ibge;
    }

   /* public Point getGeolocalizacao() {
        return geolocalizacao;
    }*/

     public Point getGeolocalizacao(){
        return  geolocation;
    }

    public Double getLatCidade() {
        return latCidade;
    }

    public Double getLonCidade() {
        return lonCidade;
    }

    public Integer getCodTomCidade() {
        return codTomCidade;
    }
}
