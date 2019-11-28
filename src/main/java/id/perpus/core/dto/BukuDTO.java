package id.perpus.core.dto;

import id.perpus.core.entity.Buku;
import id.perpus.core.entity.Kategori;
import id.perpus.core.entity.Publiser;
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
public class BukuDTO implements BaseDTO<BukuDTO, Buku>{

    private Long id;

    private String judul;

    private KategoriDTO kategori;

    private PubliserDTO publiser;

    private String isbn;

    private String pengarang;

    private Integer halaman;

    private Date thn_terbit;

    private String image;

    private String sinopsis;

    private String barcode;

    public BukuDTO(Long id) {
        this.id = id;
    }

    @Override
    public BukuDTO toDTO(Buku object) {
        BukuDTO dto = new BukuDTO();
        dto.setId(object.getId());
        dto.setJudul(object.getJudul());
        if (object.getKategori() != null) {
            dto.setKategori(new KategoriDTO().toDTO(object.getKategori()));
        }
        if (dto.getPubliser() != null) {
            dto.setPubliser(new PubliserDTO().toDTO(object.getPubliser()));
        }
        dto.setIsbn(object.getIsbn());
        dto.setPengarang(object.getPengarang());
        dto.setHalaman(object.getHalaman());
        dto.setThn_terbit(object.getThn_terbit());
        dto.setImage(object.getImage());
        dto.setSinopsis(object.getSinopsis());
        dto.setBarcode(object.getBarcode());
        return dto;
    }

    @Override
    public Collection<BukuDTO> toDTO(Collection<Buku> collection) {
        List<BukuDTO> dtos = new ArrayList<>();

        for (Buku object : collection){
            dtos.add(toDTO(object));
        }
        return dtos;
    }

    @Override
    public Buku toEntity(BukuDTO dto) {
        Buku object = new Buku();
        object.setId(dto.id);
        object.setJudul(dto.judul);
        object.setIsbn(dto.getIsbn());
        object.setPengarang(dto.getPengarang());
        object.setHalaman(dto.getHalaman());
        object.setThn_terbit(dto.getThn_terbit());
        object.setImage(dto.getImage());
        object.setSinopsis(dto.getSinopsis());
        object.setBarcode(dto.getBarcode());
        if (dto.getPubliser() != null) {
            object.setPubliser(new PubliserDTO().toEntity(dto.getPubliser()));
        }

        if (object.getKategori() != null) {
            object.setKategori(new KategoriDTO().toEntity(dto.getKategori()));
        }

        return object;
    }

    @Override
    public Buku toParam(BukuDTO dto) {
        Buku obect = new Buku();
        obect.setId(dto.getId());
        return obect;
    }
}
