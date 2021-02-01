package com.zurcnanor.tinnovatest.vehicle.service;

import com.zurcnanor.tinnovatest.interfaces.IService;
import com.zurcnanor.tinnovatest.vehicle.domain.Vehicle;
import com.zurcnanor.tinnovatest.vehicle.dto.SearchSpecification;
import com.zurcnanor.tinnovatest.vehicle.exception.SearchingDateInvalidException;
import com.zurcnanor.tinnovatest.vehicle.exception.VehicleNotFoundException;
import com.zurcnanor.tinnovatest.vehicle.repository.VehicleRepository;
import com.zurcnanor.tinnovatest.vehicle.service.validator.VehicleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

@Service
public class VehicleService implements IService<Vehicle, UUID> {

    @Autowired
    private VehicleRepository repository;

    @Autowired
    private VehicleValidator validator;

    @Override
    public List<Vehicle> getAll(SearchSpecification spec) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime startDateTime, endDateTime = null;
        try {
            if (null != spec.getStartDate())
                startDateTime = LocalDate.parse(spec.getStartDate(), formatter).atTime(LocalTime.MIN);
            else
                startDateTime = LocalDateTime.of(LocalDate.of(1800, 01, 01), LocalTime.MIN);
            if (null != spec.getEndDate())
                endDateTime = LocalDate.parse(spec.getEndDate(), formatter).atTime(LocalTime.MAX);
            else
                endDateTime = LocalDateTime.of(LocalDate.of(9999, 01, 01), LocalTime.MAX);
        } catch (DateTimeParseException exception) {
            throw new SearchingDateInvalidException(exception.getParsedString());
        }

        return repository.findByQuery(spec.getQ(), startDateTime, endDateTime);
    }

    @Override
    public Vehicle getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(VehicleNotFoundException::new);
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        validator.validate(vehicle);

        vehicle.setId(randomUUID());
        vehicle.setCreatedAt(now());

        return repository.save(vehicle);
    }

    @Override
    public Vehicle edit(Vehicle vehicle) {
        validator.validate(vehicle);

        Vehicle found = getById(vehicle.getId());

        found.setName(vehicle.getName());
        found.setBrand(vehicle.getBrand());
        found.setDescription(vehicle.getDescription());
        found.setYear(vehicle.getYear());
        found.setSold(vehicle.getSold());
        found.setUpdatedAt(now());

        return repository.saveAndFlush(found);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        Vehicle found = getById(vehicle.getId());

        if (null != vehicle.getName() && !found.getName().equals(vehicle.getName()))
            found.setName(vehicle.getName());

        if (null != vehicle.getBrand() && !found.getBrand().equals(vehicle.getBrand()))
            found.setBrand(vehicle.getBrand());

        if (null != vehicle.getDescription() && !found.getDescription().equals(vehicle.getDescription()))
            found.setDescription(vehicle.getDescription());

        if (null != vehicle.getYear() && !found.getYear().equals(vehicle.getYear()))
            found.setYear(vehicle.getYear());

        if (null != found.getSold() && !found.getSold().equals(vehicle.getSold()))
            found.setSold(vehicle.getSold());

        found.setUpdatedAt(now());

        validator.validate(found);

        return repository.saveAndFlush(found);
    }

    @Override
    public void deleteById(UUID id) {
        repository.delete(getById(id));
    }

}
