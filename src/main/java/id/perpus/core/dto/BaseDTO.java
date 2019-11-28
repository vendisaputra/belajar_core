package id.perpus.core.dto;

import id.perpus.core.common.EntityAware;

import java.io.Serializable;
import java.util.Collection;

public interface BaseDTO<D, E extends EntityAware> extends Serializable {

    D toDTO(E object);

    Collection<D> toDTO(Collection<E> collection);

    E toEntity(D dto);

    E toParam(D dto);
}
