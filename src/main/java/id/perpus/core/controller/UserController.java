package id.perpus.core.controller;

import id.perpus.core.dto.UserDTO;
import id.perpus.core.entity.User;
import id.perpus.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UserController extends AbstractController<UserDTO, User> {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @Override
    @PostMapping(value = "/user")
    public ResponseEntity<User> save(UserDTO dto) {
        return ResponseEntity.ok(service.save(new UserDTO().toEntity(dto)));
    }

    @Override
    @GetMapping(value = "/user")
    public ResponseEntity<Collection<User>> find() {
        return ResponseEntity.ok(service.find());
    }

    @Override
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity delete(Long id) {
        UserDTO dto = new UserDTO(id);
        service.delete(dto.toParam(dto));
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping(value = "/user")
    public ResponseEntity<User> update(UserDTO dto) {
        return ResponseEntity.ok(service.save(new UserDTO().toEntity(dto)));
    }
}
