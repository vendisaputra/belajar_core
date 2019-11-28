package id.perpus.core.service;

import id.perpus.core.dao.PinjamanItemDAO;
import id.perpus.core.entity.PinjamanItem;
import id.perpus.core.service.generic.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class PinjamanItemService extends AbstractGenericService<PinjamanItem> {

    private final PinjamanItemDAO pinjamanItemDAO;

    @Autowired
    public PinjamanItemService(PinjamanItemDAO pinjamanItemDAO) {
        this.pinjamanItemDAO = pinjamanItemDAO;
    }

    @Override
    @Transactional
    public PinjamanItem save(PinjamanItem entity) {
        if (entity.getId() != null) {
            PinjamanItem item = new PinjamanItem();
            item.setPeminjaman(entity.getPeminjaman());
            item.setBuku(entity.getBuku());
            item.setJumlah(entity.getJumlah());
        }else{
            pinjamanItemDAO.save(entity);
        }

        return null;
    }

    @Override
    @Transactional
    public PinjamanItem delete(PinjamanItem entity) {
        PinjamanItem item = pinjamanItemDAO.findReference(entity.getId());
        pinjamanItemDAO.delete(item);
        return null;
    }

    @Override
    @Transactional
    public PinjamanItem findById(Long id) {
        return pinjamanItemDAO.findById(id);
    }

    @Override
    @Transactional
    public Collection<PinjamanItem> find() {
        return pinjamanItemDAO.find();
    }
}
