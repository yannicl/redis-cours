package com.yannicl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MeteoService {

    @Cacheable("observations")
    public ObservationsRessource getObservations(String station) {
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ObservationsRessource(station);
    }

}
