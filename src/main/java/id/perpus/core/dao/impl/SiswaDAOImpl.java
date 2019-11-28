package id.perpus.core.dao.impl;

import id.perpus.core.dao.AbstractGenericDAO;
import id.perpus.core.dao.SiswaDAO;
import id.perpus.core.entity.Kategori;
import id.perpus.core.entity.Siswa;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class SiswaDAOImpl extends AbstractGenericDAO<Siswa> implements SiswaDAO {
    @Override
    public List<Siswa> find() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Siswa> query = builder.createQuery(Siswa.class);

        Root<Siswa> root = query.from(Siswa.class);
        query.distinct(true);
        query.orderBy(builder.asc(root.get("id")));

        return entityManager
                .createQuery(query)
                .getResultList();
    }
}
