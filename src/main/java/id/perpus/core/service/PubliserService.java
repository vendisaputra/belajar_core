package id.perpus.core.service;

import id.perpus.core.dao.PublisherDAO;
import id.perpus.core.entity.Publiser;
import id.perpus.core.service.generic.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class PubliserService extends AbstractGenericService<Publiser> {

    private final PublisherDAO publisherDAO;

    @Autowired
    public PubliserService(PublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }


    @Override
    @Transactional
    public Publiser save(Publiser entity) {
        if (entity.getId() != null){
            Publiser publiser = publisherDAO.findReference(entity.getId());
            publiser.setName(entity.getName());
        }else{
            publisherDAO.save(entity);
        }

        return null;
    }

    @Override
    @Transactional
    public Publiser delete(Publiser entity) {
        Publiser publiser = publisherDAO.findReference(entity.getId());
        publisherDAO.delete(publiser);
        return null;
    }

    @Override
    @Transactional
    public Publiser findById(Long id) {
        return publisherDAO.findById(id);
    }

    @Override
    @Transactional
    public Collection<Publiser> find() {
        return publisherDAO.find();
    }
}
