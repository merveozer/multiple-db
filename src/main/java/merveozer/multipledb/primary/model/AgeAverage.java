package merveozer.multipledb.primary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "age_average")
@AllArgsConstructor
@NoArgsConstructor
public class AgeAverage {
    @Id
    @Column(name = "id")
    private int id;

    @Id
    @Column(name = "age_avg")
    private int ageAverage;
}
