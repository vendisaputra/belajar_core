package id.perpus.core.dao;

import id.perpus.core.entity.Buku;

import javax.validation.constraints.Pattern;
import java.util.List;

public interface BukuDAO extends BaseDAO<Buku> {
    List<Buku> find();
}
