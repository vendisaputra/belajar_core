package id.perpus.core.dao.impl;

import id.perpus.core.dao.AbstractGenericDAO;
import id.perpus.core.dao.PengembalianDAO;
import id.perpus.core.entity.Pengembalian;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PengembalianDAOImpl extends AbstractGenericDAO<Pengembalian> implements PengembalianDAO {

    @Override
    public List<Pengembalian> find() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Pengembalian> query = builder.createQuery(Pengembalian.class);

        Root<Pengembalian> root = query.from(Pengembalian.class);


        query.distinct(true);
        query.orderBy(builder.asc(root.get("id")));

        EntityGraph<Pengembalian> graph = entityManager.createEntityGraph(Pengembalian.class);

        Subgraph user = graph.addSubgraph("user");

        Subgraph peminjaman = graph.addSubgraph("peminjaman");
        peminjaman.addSubgraph("user");
        peminjaman.addSubgraph("siswa");

        TypedQuery<Pengembalian> typedQuery = entityManager.createQuery(query);
        typedQuery.setHint("javax.persistence.loadgraph", graph);

        return typedQuery.getResultList();


    }
}
