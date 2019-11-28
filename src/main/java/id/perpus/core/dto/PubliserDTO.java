package id.perpus.core.dto;


import id.perpus.core.entity.Publiser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PubliserDTO implements  SimpleDTO<PubliserDTO, Publiser> {

    private Long id;

    private String name;

    public PubliserDTO(Long id) {
        this.id = id;
    }

    @Override
    public PubliserDTO toDTO(Publiser object) {
        PubliserDTO dto = new PubliserDTO();
        dto.setId(object.getId());
        dto.setName(object.getName());
        return dto;
    }

    @Override
    public Collection<PubliserDTO> toDTO(Collection<Publiser> collection) {
        List<PubliserDTO> dtos = new ArrayList<>();

        for (Publiser object : collection){
            dtos.add(toDTO(object));
        }
        return dtos;
    }

    @Override
    public Publiser toEntity(PubliserDTO dto) {
        Publiser object = new Publiser();
        object.setId(dto.getId());
        object.setName(dto.getName());
        return object;
    }

    @Override
    public Publiser toParam(PubliserDTO dto) {
        Publiser object = new Publiser();
        object.setId(dto.getId());
        return object;
    }


    @Override
    public PubliserDTO toSimpleDTO(Publiser object) {

        PubliserDTO dto = new PubliserDTO();
        dto.setId(object.getId());
        dto.setName(object.getName());

        return dto;

    }

    @Override
    public Publiser toSimpleEntity(PubliserDTO object) {
        return new Publiser(object.getId());
    }
}
