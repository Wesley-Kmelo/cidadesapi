package com.dio.projectsearch.citiesapi.repository;

import com.dio.projectsearch.citiesapi.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// os dois métodos criados serão adicionados a classe já existente de JPARepository. Em seus parametros são passados comandoSQL
// que irão executar operações no banco de dados PostGres. Lembrando que para wue esses comandos funcionem é necessário ativar
//as extensões CUBE e EARTHDISTANCE no banco de dados antes de executar as querys.


public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query(value = "select ((select lat_lon from cidade where id = ?1) <@> (select lat_lon from cidade where id=?2)) as distance;" , nativeQuery = true)
    Double distanciaPoints(Long cid1, Long cid2);

    @Query(value = "select earth_distance(\n" +
            "    ll_to_earth(?1,?2), \n" +
            "    ll_to_earth(?3,?4)\n" +
            ") as distance;\n", nativeQuery = true)
    Double distanciaCube(double x, double y, double x1, double y1);
}
