package id.perpus.core.service;

import id.perpus.core.dao.PengadaanDAO;
import id.perpus.core.entity.Pengadaan;
import id.perpus.core.service.generic.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class PengadaanService extends AbstractGenericService<Pengadaan> {

    private final PengadaanDAO pengadaanDAO;

    @Autowired
    public PengadaanService(PengadaanDAO pengadaanDAO) {
        this.pengadaanDAO = pengadaanDAO;
    }

    @Override
    @Transactional
    public Pengadaan save(Pengadaan entity) {
        if (entity.getId() != null){
            Pengadaan pengadaan = pengadaanDAO.findReference(entity.getId());
            pengadaan.setTgl_pengadaan(entity.getTgl_pengadaan());
            pengadaan.setBuku(entity.getBuku());
            pengadaan.setAsal_buku(entity.getAsal_buku());
            pengadaan.setJumlah(entity.getJumlah());
            pengadaan.setKeterangan(entity.getKeterangan());
        }else{
            pengadaanDAO.save(entity);
        }
        return null;
    }

    @Override
    @Transactional
    public Pengadaan delete(Pengadaan entity) {
        Pengadaan pengadaan = pengadaanDAO.findReference(entity.getId());
        pengadaanDAO.delete(pengadaan);
        return null;
    }

    @Override
    @Transactional
    public Pengadaan findById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Collection<Pengadaan> find() {
        return pengadaanDAO.find();
    }
}
