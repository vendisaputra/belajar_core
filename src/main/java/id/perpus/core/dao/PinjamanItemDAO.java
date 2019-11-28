package id.perpus.core.dao;

import id.perpus.core.entity.PinjamanItem;

import java.util.List;

public interface PinjamanItemDAO extends BaseDAO<PinjamanItem> {
    List<PinjamanItem> find();
}
