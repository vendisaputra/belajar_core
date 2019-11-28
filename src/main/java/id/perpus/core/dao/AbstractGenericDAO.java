package id.perpus.core.dao;

import id.perpus.core.common.EntityAware;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * @Date 29/11/2019
 * Taken from plunq.id
 */

public abstract class AbstractGenericDAO<T extends EntityAware> implements BaseDAO<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> type;

    {
        this.type = (Class<T>)
                ((ParameterizedType) getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public T delete(T entity) {
        entityManager.remove(entity);
        return entity;
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(type, id);

    }

    @Override
    public T findReference(Long id) {
        return (T) Hibernate.unproxy(entityManager.getReference(type, id));
    }
}
