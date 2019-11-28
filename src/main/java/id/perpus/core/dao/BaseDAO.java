package id.perpus.core.dao;

import java.util.Collection;
import java.util.List;

/**
 * @Date 12/11/2019
 * @param <T>
 */

public interface BaseDAO<T> {

    T save(final T entity);

    T update(final T entity);

    T delete(final T entity);

    Collection<T> find();

    T findById(Long id);

    T findReference(Long id);
}
