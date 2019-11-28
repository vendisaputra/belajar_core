package id.perpus.core.dto;

import id.perpus.core.common.EntityAware;

public interface SimpleDTO<T, E extends EntityAware> extends BaseDTO<T, E> {

    T toSimpleDTO(E object);

    E toSimpleEntity(T object);
}
