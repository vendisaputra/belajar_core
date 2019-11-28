package id.perpus.core.dao.impl;

import id.perpus.core.dao.AbstractGenericDAO;
import id.perpus.core.dao.UserDAO;
import id.perpus.core.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * create date 12/11/2019
 */
@Repository
public class UserDAOImpl extends AbstractGenericDAO<User> implements UserDAO {


    @Override
    public User findByUsername(String param) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> query = builder.createQuery(User.class);

        Root<User> root = query.from(User.class);

        query.where(builder.equal(root.get("username"), param));

        EntityGraph<User> graph = entityManager.createEntityGraph(User.class);

        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        typedQuery.setHint("javax.presistence.loadgraph", graph);

        try {
            return typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<User> find() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> query = builder.createQuery(User.class);

        Root<User> root = query.from(User.class);
        query.distinct(true);
        query.orderBy(builder.asc(root.get("id")));

        return entityManager
                .createQuery(query)
                .getResultList();
    }

    @Override
    public List<User> findById2() {
        return null;
    }

    @Override
    public User updatePassword(User param) {
        return null;
    }

    @Override
    public User delete(User entity) {
        return super.delete(entity);
    }
}
