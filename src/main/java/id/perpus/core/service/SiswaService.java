package id.perpus.core.service;

import id.perpus.core.dao.SiswaDAO;
import id.perpus.core.entity.Siswa;
import id.perpus.core.service.generic.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class SiswaService extends AbstractGenericService<Siswa> {

    private final SiswaDAO siswaDAO;

    @Autowired
    public SiswaService(SiswaDAO siswaDAO) {
        this.siswaDAO = siswaDAO;
    }

    @Override
    @Transactional
    public Siswa save(Siswa entity) {
        if (entity.getId() != null){
            Siswa siswa = siswaDAO.findReference(entity.getId());
            siswa.setName(entity.getName());
            siswa.setNisn(entity.getNisn());
            siswa.setGender(entity.getGender());
            siswa.setReligion(entity.getReligion());
            siswa.setTempatLahir(entity.getTempatLahir());
            siswa.setTglLahir(entity.getTglLahir());
            siswa.setAddress(entity.getAddress());
            siswa.setTelp(entity.getTelp());
            siswa.setImage(entity.getImage());
        }else{
            siswaDAO.save(entity);
        }

        return null;
    }

    @Override
    @Transactional
    public Siswa delete(Siswa entity) {
        Siswa siswa = siswaDAO.findReference(entity.getId());
        siswaDAO.delete(siswa);
        return null;
    }

    @Override
    @Transactional
    public Siswa findById(Long id) {
        return siswaDAO.findById(id);
    }

    @Override
    @Transactional
    public Collection<Siswa> find() {
        return siswaDAO.find();
    }
}
