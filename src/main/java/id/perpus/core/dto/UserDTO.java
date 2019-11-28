package id.perpus.core.dto;

import id.perpus.core.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
public class UserDTO implements BaseDTO<UserDTO, User> {

    private Long id;

    private String name;

    private String username;

    private String password;

    public UserDTO(Long id){
        this.id = id;
    }

    @Override
    public UserDTO toDTO(User object) {
        UserDTO dto = new UserDTO();
        dto.setId(object.getId());
        dto.setName(object.getName());
        dto.setUsername(object.getUsername());
        dto.setPassword(object.getPassword());
        return dto;
    }

    @Override
    public Collection<UserDTO> toDTO(Collection<User> collection) {
        List<UserDTO> dtos = new ArrayList<>();

        for (User object : collection) {
            dtos.add(toDTO(object));
        }
        return dtos;
    }

    @Override
    public User toEntity(UserDTO dto) {
        User object = new User();
        object.setId(dto.getId());
        object.setName(dto.getName());
        object.setUsername(dto.getUsername());
        object.setPassword(dto.getPassword());
        return object;
    }

    @Override
    public User toParam(UserDTO dto) {
        User object = new User();
        object.setId(dto.getId());
        return object;
    }
}
