package id.perpus.core.service;

import id.perpus.core.dao.BukuDAO;
import id.perpus.core.entity.Buku;
import id.perpus.core.service.generic.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class BukuService extends AbstractGenericService<Buku> {

    private final BukuDAO bukuDAO;

    @Autowired
    public BukuService(BukuDAO bukuDAO) {
        this.bukuDAO = bukuDAO;
    }

    @Override
    @Transactional
    public Buku save(Buku entity) {
        if(entity.getId() != null){
            Buku buku = bukuDAO.findReference(entity.getId());
            buku.setJudul(entity.getJudul());
            buku.setKategori(entity.getKategori());
            buku.setPubliser(entity.getPubliser());
            buku.setIsbn(entity.getIsbn());
            buku.setPengarang(entity.getPengarang());
            buku.setHalaman(entity.getHalaman());
            buku.setThn_terbit(entity.getThn_terbit());
            buku.setImage(entity.getImage());
            buku.setSinopsis(entity.getSinopsis());
            buku.setBarcode(entity.getBarcode());
        }else{
            bukuDAO.save(entity);
        }
        return null;
    }

    @Override
    @Transactional
    public Buku delete(Buku entity) {
        Buku buku = bukuDAO.findReference(entity.getId());
        bukuDAO.delete(buku);
        return null;
    }

    @Override
    @Transactional
    public Buku findById(Long id) {
        return bukuDAO.findById(id);
    }

    @Override
    @Transactional
    public Collection<Buku> find() {
        return bukuDAO.find();
    }
}
