package id.perpus.core.dto;

import id.perpus.core.entity.Kategori;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class KategoriDTO implements BaseDTO<KategoriDTO, Kategori> {

    private Long id;

    private String name;

    public KategoriDTO(Long id) {
        this.id = id;
    }

    @Override
    public KategoriDTO toDTO(Kategori object) {
        KategoriDTO dto = new KategoriDTO();
        dto.setId(object.getId());
        dto.setName(object.getName());
        return dto;
    }

    @Override
    public Collection<KategoriDTO> toDTO(Collection<Kategori> collection) {
        List<KategoriDTO> dtos = new ArrayList<>();

        for (Kategori object : collection) {
            dtos.add(toDTO(object));
        }
        return dtos;
    }

    @Override
    public Kategori toEntity(KategoriDTO dto) {
        Kategori object = new Kategori();
        object.setId(dto.getId());
        object.setName(dto.getName());
        return object;
    }

    @Override
    public Kategori toParam(KategoriDTO dto) {
        Kategori object = new Kategori();
        object.setId(dto.getId());
        return object;
    }
}
