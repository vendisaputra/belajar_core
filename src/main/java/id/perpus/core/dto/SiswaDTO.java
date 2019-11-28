package id.perpus.core.dto;

import id.perpus.core.entity.Siswa;
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
public class SiswaDTO implements BaseDTO<SiswaDTO, Siswa> {

    private Long id;

    private String name;

    private String nisn;

    private String gender;

    private String religion;

    private String tempatLahir;

    private Date tglLahir;

    private String address;

    private String telp;

    private String image;

    public SiswaDTO(Long id) {
        this.id = id;
    }

    @Override
    public SiswaDTO toDTO(Siswa object) {
        SiswaDTO dto = new SiswaDTO();
        dto.setId(object.getId());
        dto.setName(object.getName());
        dto.setNisn(object.getNisn());
        dto.setGender(object.getGender());
        dto.setReligion(object.getReligion());
        dto.setTempatLahir(object.getTempatLahir());
        dto.setTglLahir(object.getTglLahir());
        dto.setAddress(object.getAddress());
        dto.setTelp(object.getTelp());
        dto.setImage(object.getImage());
        return dto;
    }

    @Override
    public Collection<SiswaDTO> toDTO(Collection<Siswa> collection) {

        List<SiswaDTO> dtos = new ArrayList<>();

        for (Siswa object : collection){
            dtos.add(toDTO(object));
        }

        return dtos;
    }

    @Override
    public Siswa toEntity(SiswaDTO dto) {
        Siswa object = new Siswa();
        object.setId(dto.getId());
        object.setName(dto.getName());
        object.setNisn(dto.getNisn());
        object.setGender(dto.getGender());
        object.setReligion(dto.getReligion());
        object.setTempatLahir(dto.getTempatLahir());
        object.setTglLahir(dto.getTglLahir());
        object.setAddress(dto.getAddress());
        object.setTelp(dto.getTelp());
        object.setImage(dto.getImage());

        return object;
    }

    @Override
    public Siswa toParam(SiswaDTO dto) {
        Siswa object = new Siswa();
        object.setId(dto.getId());
        return object;
    }
}
