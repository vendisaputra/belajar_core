package id.perpus.core.dao.impl;

import id.perpus.core.dao.AbstractGenericDAO;
import id.perpus.core.dao.PeminjamanDAO;
import id.perpus.core.entity.Peminjaman;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PeminjamanDAOImpl extends AbstractGenericDAO<Peminjaman> implements PeminjamanDAO {
    @Override
    public List<Peminjaman> find() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Peminjaman> query = builder.createQuery(Peminjaman.class);

        Root<Peminjaman> root = query.from(Peminjaman.class);
        root.fetch("siswa", JoinType.INNER);
        root.fetch("user", JoinType.INNER);
        query.distinct(true);
        query.orderBy(builder.asc(root.get("id")));

        return entityManager
                .createQuery(query)
                .getResultList();
    }
}
