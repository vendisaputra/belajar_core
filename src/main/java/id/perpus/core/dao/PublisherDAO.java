package id.perpus.core.dao;

import id.perpus.core.entity.Publiser;

import java.util.List;

public interface PublisherDAO extends  BaseDAO<Publiser> {
    List<Publiser> find();
}
