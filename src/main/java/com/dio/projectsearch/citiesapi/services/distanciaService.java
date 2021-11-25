package com.dio.projectsearch.citiesapi.services;

import com.dio.projectsearch.citiesapi.entities.Cidade;
import com.dio.projectsearch.citiesapi.repository.CidadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.data.geo.Point;
import java.util.Arrays;
import java.util.List;

// esse serviço foi criado para criar os métodos que irão calcular a distancia entre os dados geolocalização das cidades
// por isso é criado uma instancia do repository de cidade por conter os métodos necessarios além dos que foram
// adicionados.


@Service
public class distanciaService {

    Logger log = LoggerFactory.getLogger(distanciaService.class);

    private  final CidadeRepository cidadeRepository;

    public distanciaService(final CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }


    public Double distanciaEmMilhasPorPoints(final Long cid1, final Long cid2) {
        log.info("nativePostgresInMIles({}, {}) ", cid1, cid2);
        return  cidadeRepository.distanciaPoints(cid1, cid2);
    }

    public Double distanciaEmMetrosPorCube(Long cid1, Long cid2) {
        log.info("distanceByCubeInMeters({}, {}) ", cid1, cid2);
        final List<Cidade>cidades = cidadeRepository.findAllById(Arrays.asList(cid1, cid2));

        Point p1 = cidades.get(0).getGeolocalizacao();
        Point p2 =  cidades.get(1).getGeolocalizacao();

        return  cidadeRepository.distanciaCube(p1.getX(), p1.getY(), p2.getX(),p2.getY());
    }
}
