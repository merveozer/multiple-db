package merveozer.multipledb.primary.controller;

import merveozer.multipledb.primary.repository.AgeAverageEntityManager;
import merveozer.multipledb.primary.repository.AgeAverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeAverageController {
    @Autowired
    AgeAverageEntityManager ageAverageEntityManager;
    @Autowired
    AgeAverageRepository ageAverageRepository;

    @GetMapping("/average")
    public int getAgeAverage() {
        ageAverageEntityManager.calculateAgeAverage();
        int ageAverage = this.ageAverageRepository.getById(1).getAgeAverage();
        return ageAverage;
    }
}

