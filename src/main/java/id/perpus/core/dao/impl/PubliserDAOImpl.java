package id.perpus.core.dao.impl;

import id.perpus.core.dao.AbstractGenericDAO;
import id.perpus.core.dao.PublisherDAO;
import id.perpus.core.entity.Kategori;
import id.perpus.core.entity.Publiser;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PubliserDAOImpl extends AbstractGenericDAO<Publiser> implements PublisherDAO {
    @Override
    public List<Publiser> find() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Publiser> query = builder.createQuery(Publiser.class);

        Root<Publiser> root = query.from(Publiser.class);
        query.distinct(true);
        query.orderBy(builder.asc(root.get("id")));

        return entityManager
                .createQuery(query)
                .getResultList();

    }
}
