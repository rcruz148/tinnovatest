package com.zurcnanor.tinnovatest.vehicle.service;

import com.zurcnanor.tinnovatest.vehicle.domain.Vehicle;
import com.zurcnanor.tinnovatest.vehicle.dto.SearchSpecification;
import com.zurcnanor.tinnovatest.vehicle.exception.SearchingDateInvalidException;
import com.zurcnanor.tinnovatest.vehicle.exception.VehicleNotFoundException;
import com.zurcnanor.tinnovatest.vehicle.repository.VehicleRepository;
import com.zurcnanor.tinnovatest.vehicle.service.validator.VehicleValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class VehicleServiceTest {

    @Mock
    private VehicleRepository repository;

    @Mock
    private VehicleValidator validator;

    @InjectMocks
    private VehicleService service;

    @Test
    public void shouldGetAllVehiclesBySpecification() {
        service.getAll(new SearchSpecification());

        verify(repository).findByQuery("",
                LocalDateTime.of(LocalDate.of(1800, 01, 01), LocalTime.MIN),
                LocalDateTime.of(LocalDate.of(9999, 01, 01), LocalTime.MAX));
    }

    @Test
    public void shouldGetAllVehiclesWithoutSpecification() {
        SearchSpecification specification = new SearchSpecification();
        specification.setStartDate("2021-01-24");
        specification.setEndDate("2021-02-01");
        service.getAll(specification);

        verify(repository).findByQuery("",
                LocalDateTime.of(LocalDate.of(2021, 01, 24), LocalTime.MIN),
                LocalDateTime.of(LocalDate.of(2021, 02, 01), LocalTime.MAX));
    }

    @Test(expected = SearchingDateInvalidException.class)
    public void shouldNotFindVehiclesWhenSearchingDateIsInvalid() {
        SearchSpecification specification = new SearchSpecification();
        specification.setStartDate("24/01/2021");
        specification.setEndDate("2021-02-01");
        service.getAll(specification);

        verify(repository, never()).findByQuery(any(), any(), any());
    }

    @Test
    public void shouldGetVehicleById() {
        Vehicle vehicle = mockVehicle();
        when(repository.findById(vehicle.getId())).thenReturn(Optional.of(vehicle));

        assertEquals(vehicle, service.getById(vehicle.getId()));
    }

    @Test(expected = VehicleNotFoundException.class)
    public void shouldNotFindVehicleById() {
        UUID id = randomUUID();
        when(repository.findById(id)).thenReturn(Optional.empty());

        service.getById(id);
    }

    @Test
    public void shouldCreateVehicle() {
        Vehicle vehicle = Vehicle.builder().build();
        service.create(vehicle);

        assertNotNull(vehicle.getId());
        assertNotNull(vehicle.getCreatedAt());

        verify(validator).validate(vehicle);
        verify(repository).save(vehicle);
    }

    @Test
    public void shouldEditVehicle() {
        Vehicle original = mockVehicle();

        Vehicle updated = Vehicle.builder()
                .id(original.getId())
                .name("Astra Sedan")
                .brand("GM")
                .year(2011)
                .description("Sedan medium 2.0")
                .sold(true)
                .build();

        service.edit(updated);

        assertEquals(updated.getName(), original.getName());
        assertEquals(updated.getBrand(), original.getBrand());
        assertEquals(updated.getYear(), original.getYear());
        assertEquals(updated.getDescription(), original.getDescription());
        assertEquals(updated.getSold(), original.getSold());
        assertNotNull(original.getUpdatedAt());

        verify(validator).validate(updated);
        verify(repository).saveAndFlush(original);

    }

    @Test
    public void shouldUpdateVehicle() {
        Vehicle original = mockVehicle();

        Vehicle updated = Vehicle.builder()
                .id(original.getId())
                .name("Astra Sedan")
                .brand("GM")
                .year(2011)
                .description("Sedan medium 2.0")
                .sold(true)
                .build();

        service.update(updated);

        assertEquals(updated.getName(), original.getName());
        assertEquals(updated.getBrand(), original.getBrand());
        assertEquals(updated.getYear(), original.getYear());
        assertEquals(updated.getDescription(), original.getDescription());
        assertEquals(updated.getSold(), original.getSold());
        assertNotNull(original.getUpdatedAt());

        verify(validator).validate(original);
        verify(repository).saveAndFlush(original);

    }

    @Test
    public void shouldDeleteVehicleById() {
        Vehicle vehicle = mockVehicle();
        service.deleteById(vehicle.getId());

        verify(repository).delete(vehicle);
    }

    private Vehicle mockVehicle() {
        Vehicle vehicle = Vehicle.builder()
                .id(randomUUID())
                .name("Astra")
                .brand("Chevrolet")
                .year(2006)
                .description("Hatchback medium 2.0")
                .sold(false)
                .createdAt(now())
                .build();

        when(repository.findById(vehicle.getId())).thenReturn(Optional.of(vehicle));

        return vehicle;
    }

}
