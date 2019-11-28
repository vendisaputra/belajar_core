package id.perpus.core.dto;

import id.perpus.core.entity.Pengembalian;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PengembalianDTO implements BaseDTO<PengembalianDTO, Pengembalian> {

    private Long id;

    private PinjamanDTO peminjaman;

    private Date tglKembali;

    private int denda;

    private UserDTO user;

    public PengembalianDTO(Long id) {
        this.id = id;
    }

    @Override
    public PengembalianDTO toDTO(Pengembalian object) {
        PengembalianDTO dto = new PengembalianDTO();
        dto.setId(object.getId());
        dto.setTglKembali(object.getTglKembali());
        dto.setDenda(object.getDenda());

        if (object.getPeminjaman() != null) {
            dto.setPeminjaman(new PinjamanDTO().toDTO(object.getPeminjaman()));
        }

        if (object.getUser() != null) {
            dto.setUser(new UserDTO().toDTO(object.getUser()));
        }
        return dto;
    }

    @Override
    public Collection<PengembalianDTO> toDTO(Collection<Pengembalian> collection) {
        List<PengembalianDTO> dtos = new ArrayList<>();

        for (Pengembalian object : collection) {
            dtos.add(toDTO(object));
        }
        return dtos;
    }

    @Override
    public Pengembalian toEntity(PengembalianDTO dto) {
        Pengembalian object = new Pengembalian();
        object.setId(dto.getId());
        object.setTglKembali(object.getTglKembali());
        object.setDenda(object.getDenda());

        if (dto.getPeminjaman() != null) {
            object.setPeminjaman(new PinjamanDTO().toEntity(dto.getPeminjaman()));
        }

        if (dto.getUser() != null) {
            object.setUser(new UserDTO().toEntity(dto.getUser()));
        }
        return object;

    }

    @Override
    public Pengembalian toParam(PengembalianDTO dto) {
        Pengembalian object = new Pengembalian();
        object.setId(dto.getId());
        return object;
    }


}
