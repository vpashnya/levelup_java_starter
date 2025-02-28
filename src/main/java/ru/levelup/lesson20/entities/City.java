package ru.levelup.lesson20.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String code;

    @Column(name="name_rus")
    private String nameRus;

    @Column(name="name_eng")
    private String nameEng;

    @Column
    private int population;

    @ManyToOne
    @JoinColumn(name="region")
    private Region region;

}
