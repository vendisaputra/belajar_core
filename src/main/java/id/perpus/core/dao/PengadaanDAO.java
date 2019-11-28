package id.perpus.core.dao;

import id.perpus.core.entity.Pengadaan;

import java.util.Collection;
import java.util.List;

public interface PengadaanDAO  extends BaseDAO<Pengadaan> {
    List<Pengadaan> find();
}
