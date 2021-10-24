package com.yannicl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeteoController {

    @Autowired
    MeteoService meteoService;

    @GetMapping("api/meteo/observations/station")
    public ObservationsRessource observationsParStation(@RequestParam(value = "nom", defaultValue = "Montreal", required = false) String nomStation) {
        return meteoService.getObservations(nomStation);
    }

}
