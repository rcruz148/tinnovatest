package com.zurcnanor.tinnovatest.vehicle.domain;

import com.zurcnanor.tinnovatest.interfaces.MyEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vehicle")
public class Vehicle extends MyEntity<UUID> implements Serializable {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "year")
    private Integer year;

    @Column(name = "description")
    private String description;

    @Column(name = "sold")
    private Boolean sold;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
