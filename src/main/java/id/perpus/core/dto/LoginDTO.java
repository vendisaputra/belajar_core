package id.perpus.core.dto;

import id.perpus.core.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class LoginDTO implements BaseDTO<LoginDTO, User> {

    private String username;

    private String password;

    @Override
    public LoginDTO toDTO(User object) {
        return null;
    }

    @Override
    public Collection<LoginDTO> toDTO(Collection<User> collection) {
        return null;
    }

    @Override
    public User toEntity(LoginDTO dto) {
        User object = new User();
        object.setUsername(dto.getUsername());
        object.setPassword(dto.getPassword());

        return object;
    }

    @Override
    public User toParam(LoginDTO dto) {
        return null;
    }
}
