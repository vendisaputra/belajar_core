package id.perpus.core.service;

import id.perpus.core.dao.PeminjamanDAO;
import id.perpus.core.entity.Peminjaman;
import id.perpus.core.service.generic.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class PeminjamanService extends AbstractGenericService<Peminjaman> {

    private final PeminjamanDAO peminjamanDAO;

    @Autowired
    public PeminjamanService(PeminjamanDAO peminjamanDAO) {
        this.peminjamanDAO = peminjamanDAO;
    }

    @Override
    @Transactional
    public Peminjaman save(Peminjaman entity) {
        if (entity.getId() != null){
            Peminjaman peminjaman = peminjamanDAO.findReference(entity.getId());
            peminjaman.setTglPinjaman(entity.getTglPinjaman());
            peminjaman.setSiswa(entity.getSiswa());
            peminjaman.setKeterangan(entity.getKeterangan());
            peminjaman.setLamaPinjaman(entity.getLamaPinjaman());
            peminjaman.setStatus(entity.getStatus());
            peminjaman.setUser(entity.getUser());
        }else {
            peminjamanDAO.save(entity);
        }
        return null;
    }

    @Override
    @Transactional
    public Peminjaman delete(Peminjaman entity) {
        Peminjaman peminjaman = peminjamanDAO.findReference(entity.getId());
        peminjamanDAO.delete(peminjaman);
        return null;
    }

    @Override
    @Transactional
    public Peminjaman findById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Collection<Peminjaman> find() {
        return peminjamanDAO.find();
    }
}
