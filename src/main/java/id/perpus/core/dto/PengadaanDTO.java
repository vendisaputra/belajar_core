package id.perpus.core.dto;

import id.perpus.core.entity.Buku;
import id.perpus.core.entity.Pengadaan;
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
public class PengadaanDTO implements BaseDTO<PengadaanDTO, Pengadaan> {

    private Long id;

    private Date tgl_pengadaan;

    private BukuDTO buku;

    private String asal_buku;

    private Integer jumlah;

    private String keterangan;

    public PengadaanDTO(Long id) {
        this.id = id;
    }


    @Override
    public PengadaanDTO toDTO(Pengadaan object) {
        PengadaanDTO dto = new PengadaanDTO();
        dto.setId(object.getId());
        dto.setTgl_pengadaan(object.getTgl_pengadaan());
        dto.setBuku(new BukuDTO().toDTO(object.getBuku()));
        dto.setAsal_buku(object.getAsal_buku());
        dto.setJumlah(object.getJumlah());
        dto.setKeterangan(object.getKeterangan());
        return dto;
    }

    @Override
    public Collection<PengadaanDTO> toDTO(Collection<Pengadaan> collection) {
        List<PengadaanDTO> dtos = new ArrayList<>();

        for(Pengadaan object : collection){
            dtos.add(toDTO(object));
        }

        return dtos;
    }

    @Override
    public Pengadaan toEntity(PengadaanDTO dto) {
        Pengadaan object = new Pengadaan();
        object.setId(dto.getId());
        object.setTgl_pengadaan(dto.getTgl_pengadaan());
        object.setBuku(new BukuDTO().toEntity(dto.getBuku()));
        object.setAsal_buku(dto.getAsal_buku());
        object.setJumlah(dto.getJumlah());
        object.setKeterangan(dto.getKeterangan());

        return object;
    }

    @Override
    public Pengadaan toParam(PengadaanDTO dto) {
        Pengadaan object = new Pengadaan();
        object.setId(dto.getId());
        return object;
    }
}
