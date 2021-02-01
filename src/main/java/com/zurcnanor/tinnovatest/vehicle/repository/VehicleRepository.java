package com.zurcnanor.tinnovatest.vehicle.repository;

import com.zurcnanor.tinnovatest.vehicle.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

    @Query("SELECT v FROM Vehicle v " +
            " WHERE (LOWER(v.name) LIKE LOWER(CONCAT('%', :q,'%'))" +
            "        OR LOWER(v.brand) LIKE LOWER(CONCAT('%', :q,'%'))" +
            "        OR LOWER(v.description) LIKE LOWER(CONCAT('%', :q,'%'))" +
            "        OR LOWER(v.year) LIKE LOWER(CONCAT('%', :q,'%')))" +
            " AND v.createdAt BETWEEN :startDateTime AND :endDateTime")
    List<Vehicle> findByQuery(@Param("q") String q,
                              @Param("startDateTime") LocalDateTime startDateTime,
                              @Param("endDateTime") LocalDateTime endDateTime);

}
