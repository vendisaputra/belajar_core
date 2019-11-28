package id.perpus.core.service.generic;

import java.util.Collection;
import java.util.List;

public interface BaseService<T> {
    T save(final T entity);

    T delete(final T entity);

    T findById(final Long id);

    Collection<T> find();
}
