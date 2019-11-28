package id.perpus.core.dao.impl;

import id.perpus.core.dao.AbstractGenericDAO;
import id.perpus.core.dao.KategoriDAO;
import id.perpus.core.entity.Kategori;
import id.perpus.core.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

@Repository
public class KategoriDAOImpl extends AbstractGenericDAO<Kategori> implements KategoriDAO {
    @Override
    public List<Kategori> find() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Kategori> query = builder.createQuery(Kategori.class);

        Root<Kategori> root = query.from(Kategori.class);
        query.distinct(true);
        query.orderBy(builder.asc(root.get("id")));

        return entityManager
                .createQuery(query)
                .getResultList();
    }

    @Override
    public Kategori findById(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Kategori> query = builder.createQuery(Kategori.class);

        Root<Kategori> root = query.from(Kategori.class);

        query.where(builder.equal(root.get("id"), id));

        return entityManager
                .createQuery(query)
                .getSingleResult();
    }

}
