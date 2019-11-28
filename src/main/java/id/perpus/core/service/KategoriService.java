package id.perpus.core.service;

import id.perpus.core.dao.KategoriDAO;
import id.perpus.core.entity.Kategori;
import id.perpus.core.service.generic.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class KategoriService extends AbstractGenericService<Kategori> {

    private final KategoriDAO kategoriDAO;

    @Autowired
    public KategoriService(KategoriDAO kategoriDAO) {
        this.kategoriDAO = kategoriDAO;
    }

    @Override
    @Transactional
    public Kategori save(Kategori entity) {
        if(entity.getId() != null) {
            Kategori kategori = kategoriDAO.findReference(entity.getId());
            kategori.setName(entity.getName());
        }else{
            kategoriDAO.save(entity);
        }
        return null;
    }

    @Override
    @Transactional
    public Kategori delete(Kategori entity) {
        Kategori kategori = kategoriDAO.findReference(entity.getId());
        kategoriDAO.delete(kategori);
        return null;
    }

    @Override
    @Transactional
    public Kategori findById(Long id) {
        return kategoriDAO.findById(id);
    }

    @Override
    @Transactional
    public Collection<Kategori> find() {
        return kategoriDAO.find();
    }
}
