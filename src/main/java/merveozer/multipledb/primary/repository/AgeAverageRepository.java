package merveozer.multipledb.primary.repository;

import merveozer.multipledb.primary.model.AgeAverage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeAverageRepository extends JpaRepository<AgeAverage, Integer> {
}
