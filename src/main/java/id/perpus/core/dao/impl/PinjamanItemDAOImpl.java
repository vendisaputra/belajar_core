package id.perpus.core.dao.impl;

import id.perpus.core.dao.AbstractGenericDAO;
import id.perpus.core.dao.PinjamanItemDAO;
import id.perpus.core.entity.PinjamanItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class PinjamanItemDAOImpl extends AbstractGenericDAO<PinjamanItem> implements PinjamanItemDAO {
    @Override
    public List<PinjamanItem> find() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<PinjamanItem> query = builder.createQuery(PinjamanItem.class);

        Root<PinjamanItem> root = query.from(PinjamanItem.class);
        //root.fetch("buku", JoinType.INNER);

        EntityGraph<PinjamanItem> graph = entityManager.createEntityGraph(PinjamanItem.class);

        Subgraph buku = graph.addSubgraph("buku");
        buku.addSubgraph("kategori");
        buku.addSubgraph("publiser");


        Subgraph peminjaman = graph.addSubgraph("peminjaman");
        peminjaman.addSubgraph("user");
        peminjaman.addSubgraph("siswa");


        TypedQuery<PinjamanItem> typedQuery = entityManager.createQuery(query);
        typedQuery.setHint("javax.persistence.loadgraph", graph);

        return typedQuery.getResultList();

    }
}
