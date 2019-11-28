package id.perpus.core.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;
}
