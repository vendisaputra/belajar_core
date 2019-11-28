package id.perpus.core.dao;

import id.perpus.core.entity.Kategori;

import java.util.List;

public interface KategoriDAO extends BaseDAO<Kategori> {
    List<Kategori> find();
}
