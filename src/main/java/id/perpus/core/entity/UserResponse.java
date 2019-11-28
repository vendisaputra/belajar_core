package id.perpus.core.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String Token;

    public UserResponse(String jwttoken) {
        this.Token = jwttoken;
    }
}
