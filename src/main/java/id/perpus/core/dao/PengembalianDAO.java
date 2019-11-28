package id.perpus.core.dao;

import id.perpus.core.entity.Pengembalian;

import java.util.List;

public interface PengembalianDAO extends BaseDAO<Pengembalian> {
    List<Pengembalian> find();
}
