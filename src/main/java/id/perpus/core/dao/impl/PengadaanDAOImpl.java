package id.perpus.core.dao.impl;

import id.perpus.core.dao.AbstractGenericDAO;
import id.perpus.core.dao.PengadaanDAO;
import id.perpus.core.entity.Pengadaan;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PengadaanDAOImpl extends AbstractGenericDAO<Pengadaan> implements PengadaanDAO {
    @Override
    public List<Pengadaan> find() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Pengadaan> query = builder.createQuery(Pengadaan.class);

        Root<Pengadaan> root = query.from(Pengadaan.class);
        root.fetch("buku", JoinType.INNER);
        query.distinct(true);
        query.orderBy(builder.asc(root.get("id")));

        return entityManager
                .createQuery(query)
                .getResultList();

    }
}
