package id.perpus.core.dao;

import id.perpus.core.dto.BaseDTO;
import id.perpus.core.entity.Peminjaman;

import java.util.List;

public interface PeminjamanDAO extends BaseDAO<Peminjaman> {
    List<Peminjaman> find();
}
