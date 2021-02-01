package com.zurcnanor.tinnovatest.brand.service;

import com.zurcnanor.tinnovatest.brand.domain.Brand;
import com.zurcnanor.tinnovatest.brand.exception.BrandAlreadyExistsException;
import com.zurcnanor.tinnovatest.brand.exception.BrandNotFoundException;
import com.zurcnanor.tinnovatest.brand.repository.BrandRepository;
import com.zurcnanor.tinnovatest.interfaces.IService;
import com.zurcnanor.tinnovatest.vehicle.dto.SearchSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

@Service
public class BrandService implements IService<Brand, UUID> {

    @Autowired
    private BrandRepository repository;

    @Override
    public List<Brand> getAll(SearchSpecification spec) {
        return repository.findAll();
    }

    @Override
    public Brand getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(BrandNotFoundException::new);
    }

    @Override
    public Brand create(Brand brand) {
        exists(brand);

        brand.setId(randomUUID());
        brand.setCreatedAt(now());

        return repository.save(brand);
    }

    @Override
    public Brand edit(Brand brand) {
        Brand found = getById(brand.getId());

        found.setName(brand.getName());
        found.setUpdatedAt(now());

        return repository.saveAndFlush(found);
    }

    @Override
    public Brand update(Brand brand) {
        Brand found = getById(brand.getId());

        if (null != brand.getName() && !found.getName().equals(brand.getName()))
            found.setName(brand.getName());

        found.setUpdatedAt(now());

        return repository.saveAndFlush(found);
    }

    @Override
    public void deleteById(UUID id) {
        repository.delete(getById(id));
    }

    public Brand getByName(String name) {
        return findByName(name)
                .orElseThrow(BrandNotFoundException::new);
    }

    private void exists(Brand brand) {
        if (findByName(brand.getName()).isPresent())
            throw new BrandAlreadyExistsException();
    }

    private Optional<Brand> findByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }

}
