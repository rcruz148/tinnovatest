package com.zurcnanor.tinnovatest.interfaces;

import com.zurcnanor.tinnovatest.vehicle.dto.SearchSpecification;

import java.util.List;

/**
 * Interface with basic functions for a C.R.U.D. service
 *
 * @param <TEntity> The manipulated entity
 * @param <SId> The entity identification type
 */
public interface IService<TEntity extends MyEntity, SId> {

    List<TEntity> getAll(SearchSpecification specification);

    TEntity getById(SId id);

    TEntity create(TEntity entity);

    TEntity edit(TEntity entity);

    TEntity update(TEntity entity);

    void deleteById(SId id);

}
