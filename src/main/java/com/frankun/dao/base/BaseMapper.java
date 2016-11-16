package com.frankun.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 2016/10/14
 *
 * @author frankun
 */
public interface BaseMapper<T, PK extends Serializable> {

    public T get(PK id);

    public T getAndFetch(PK id, String... fields);

    public List<T> getAll();

    public List<T> getAllAndFetchEntity(String... fields);

    public boolean queryExistByProperty(String property, Object value);

    public boolean queryExistByProperties(Map<String, Object> map, boolean isAnd);

    public void update(T obj);

    public void save(T obj);

    public void saveOrUpdate(T obj);

    public void merge(T obj);

    public void delete(T obj);

    public void delete(PK id);

    public void updateProperty(String property, Object value, PK id);

    public void updateProperties(Map<String, Object> map, PK id);

    public T getOneByProperty(String property, Object value);

    public T getOneByProperties(Map<String, Object> map);

    public List<T> getByProperty(String property, Object value);

    public List<T> getByProperties(Map<String, Object> map);

    public List<T> getByProperty(String property, Object value, String orderProperty, Boolean asc);

    public List<T> getByProperties(Map<String, Object> map, String orderProperty, Boolean asc);

    public List<T> getByProperty(String property, Object value, String orderProperty, Boolean asc, Integer limit);

    public List<T> getByProperties(Map<String, Object> map, String orderProperty, Boolean asc, Integer limit);

    public T update(T obj, String... updateProperties);

    public T save(T obj, String... saveProperties);
}
