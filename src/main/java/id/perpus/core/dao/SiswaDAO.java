package id.perpus.core.dao;

import id.perpus.core.entity.Siswa;

import java.util.List;

public interface SiswaDAO extends BaseDAO<Siswa> {
    List<Siswa> find();
}
