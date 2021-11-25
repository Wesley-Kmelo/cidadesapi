package com.dio.projectsearch.citiesapi.controllers;

import com.dio.projectsearch.citiesapi.services.distanciaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distancia")

public class distanciaResource {

    Logger log = LoggerFactory.getLogger(distanciaResource.class);

    private  final distanciaService service;

    public distanciaResource(distanciaService service) {
        this.service = service;
    }

    @GetMapping("/points")
    public Double bypoints (@RequestParam (name = "from") final Long cid1,
                                            @RequestParam (name = "to") final Long cid2){

        log.info("by-points");
        return  service.distanciaEmMilhasPorPoints(cid1,cid2);
    }

    @GetMapping("/cube")
    public Double bycube(@RequestParam (name = "from") final Long cid1,
                                        @RequestParam (name = "to") final Long cid2){

        log.info("by cube");
        return service.distanciaEmMetrosPorCube(cid1,cid2);
    }
}
