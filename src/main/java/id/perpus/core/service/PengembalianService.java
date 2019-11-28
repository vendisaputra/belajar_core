package id.perpus.core.service;

import id.perpus.core.dao.PengembalianDAO;
import id.perpus.core.entity.Pengembalian;
import id.perpus.core.service.generic.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PengembalianService extends AbstractGenericService<Pengembalian> {

    private final PengembalianDAO pengembalianDAO;

    @Autowired
    public PengembalianService(PengembalianDAO pengembalianDAO) {
        this.pengembalianDAO = pengembalianDAO;
    }

    @Override
    public Pengembalian save(Pengembalian entity) {
        if (entity.getId() != null) {
            Pengembalian dto = new Pengembalian();
            dto.setPeminjaman(entity.getPeminjaman());
            dto.setTglKembali(entity.getTglKembali());
            dto.setDenda(entity.getDenda());
            dto.setUser(entity.getUser());
        }else{
            pengembalianDAO.save(entity);
        }
        return null;

    }

    @Override
    public Pengembalian delete(Pengembalian entity) {
        Pengembalian pengembalian = pengembalianDAO.findReference(entity.getId());
        pengembalianDAO.delete(pengembalian);
        return null;
    }

    @Override
    public Pengembalian findById(Long id) {
        return null;
    }

    @Override
    public Collection<Pengembalian> find() {
        return pengembalianDAO.find();
    }
}
