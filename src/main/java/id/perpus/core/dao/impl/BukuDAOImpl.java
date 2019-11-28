package id.perpus.core.dao.impl;

import id.perpus.core.dao.AbstractGenericDAO;
import id.perpus.core.dao.BukuDAO;
import id.perpus.core.entity.Buku;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BukuDAOImpl extends AbstractGenericDAO<Buku> implements BukuDAO {
    @Override
    public List<Buku> find() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Buku> query = builder.createQuery(Buku.class);

        Root<Buku> root = query.from(Buku.class);
        root.fetch("publiser", JoinType.INNER);
        root.fetch("kategori", JoinType.INNER);
        query.distinct(true);
        query.orderBy(builder.asc(root.get("id")));

        return entityManager
                .createQuery(query)
                .getResultList();
    }
}
