package id.perpus.core.dto;

import id.perpus.core.entity.Peminjaman;
import id.perpus.core.entity.Publiser;
import id.perpus.core.entity.Siswa;
import id.perpus.core.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PinjamanDTO implements SimpleDTO<PinjamanDTO, Peminjaman> {

    private Long id;

    private Date tgl_pinjam;

    private SiswaDTO siswa;

    private String keterangan;

    private Integer lama_pinjam;

    private String status;

    private UserDTO user;


    @Override
    public PinjamanDTO toDTO(Peminjaman object) {
            PinjamanDTO dto = new PinjamanDTO();
            dto.setId(object.getId());
            dto.setTgl_pinjam(object.getTglPinjaman());
            dto.setSiswa(new SiswaDTO().toDTO(object.getSiswa()));
            dto.setKeterangan(object.getKeterangan());
            dto.setLama_pinjam(object.getLamaPinjaman());
            dto.setStatus(object.getStatus());
            dto.setUser(new UserDTO().toDTO(object.getUser()));

        return dto;
    }

    @Override
    public Collection<PinjamanDTO> toDTO(Collection<Peminjaman> collection) {
        List<PinjamanDTO> dtos = new ArrayList<>();

        for (Peminjaman object : collection){
            dtos.add(toDTO(object));
        }
        return dtos;
    }

    @Override
    public Peminjaman toEntity(PinjamanDTO dto) {
        Peminjaman object = new Peminjaman();
        object.setId(dto.getId());
        object.setTglPinjaman(dto.getTgl_pinjam());
        object.setSiswa(new SiswaDTO().toEntity(dto.getSiswa()));
        object.setKeterangan(dto.getKeterangan());
        object.setLamaPinjaman(dto.getLama_pinjam());
        object.setStatus(dto.getStatus());
        object.setUser(new UserDTO().toEntity(dto.getUser()));

        return object;

    }

    @Override
    public Peminjaman toParam(PinjamanDTO dto) {
        Peminjaman object = new Peminjaman();
        object.setId(dto.getId());
        return object;
    }

    @Override
    public PinjamanDTO toSimpleDTO(Peminjaman object) {
        return null;
    }

    @Override
    public Peminjaman toSimpleEntity(PinjamanDTO object) {
        return new Peminjaman(object.getId());
    }
}
