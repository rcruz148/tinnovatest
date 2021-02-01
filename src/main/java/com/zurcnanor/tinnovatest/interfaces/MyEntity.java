package com.zurcnanor.tinnovatest.interfaces;

/**
 * Abstract class for application entities
 *
 * @param <T> The entity identification type
 */
public abstract class MyEntity<T> {

    public abstract void setId(T id);

    public abstract T getId();

}
