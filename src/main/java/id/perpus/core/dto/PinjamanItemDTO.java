package id.perpus.core.dto;

import id.perpus.core.entity.Buku;
import id.perpus.core.entity.Peminjaman;
import id.perpus.core.entity.PinjamanItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class PinjamanItemDTO implements SimpleDTO<PinjamanItemDTO, PinjamanItem> {

    private Long id;

    private PinjamanDTO peminjaman;

    private BukuDTO buku;

    private Integer jumlah;

    public PinjamanItemDTO(Long id) {
        this.id = id;
    }

    @Override
    public PinjamanItemDTO toSimpleDTO(PinjamanItem object) {
        return null;
    }

    @Override
    public PinjamanItem toSimpleEntity(PinjamanItemDTO object) {
        return new PinjamanItem(object.getId());
    }

    @Override
    public PinjamanItemDTO toDTO(PinjamanItem object) {
        PinjamanItemDTO dto = new PinjamanItemDTO();
        dto.setId(object.getId());
        if (object.getPeminjaman() != null) {
            dto.setPeminjaman(new PinjamanDTO().toDTO(object.getPeminjaman()));
        }
        if (object.getBuku() != null) {
            dto.setBuku(new BukuDTO().toDTO(object.getBuku()));
        }
        dto.setJumlah(object.getJumlah());
        return dto;
    }

    @Override
    public Collection<PinjamanItemDTO> toDTO(Collection<PinjamanItem> collection) {
        List<PinjamanItemDTO> dtos = new ArrayList<>();

        for (PinjamanItem object : collection) {
            dtos.add(toDTO(object));
        }
        return dtos;
    }

    @Override
    public PinjamanItem toEntity(PinjamanItemDTO dto) {
        PinjamanItem item = new PinjamanItem();
        item.setId(dto.getId());
        item.setPeminjaman(new PinjamanDTO().toEntity(dto.getPeminjaman()));
        item.setBuku(new BukuDTO().toEntity(dto.getBuku()));
        item.setJumlah(dto.getJumlah());
        return item;
    }

    @Override
    public PinjamanItem toParam(PinjamanItemDTO dto) {
        PinjamanItem object = new PinjamanItem();
        object.setId(dto.getId());
        return object;
    }
}
