package com.siit.finalproject.lria.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airplanes")
public class AirplaneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idairplanes")
    private Integer id;

    private String airplane_name;

    private String equipment;

    private String manufacturer;

    private Integer age;

    private Integer first_class_seats;

    private Integer bussiness_class_seats;

    private Integer economic_class_seats;

}
