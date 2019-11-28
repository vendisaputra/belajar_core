package id.perpus.core.controller;

import id.perpus.core.common.EntityAware;
import id.perpus.core.dto.BaseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public abstract class AbstractController<T extends BaseDTO, U extends EntityAware> {

    @PostMapping
    public abstract ResponseEntity<U> save(@RequestBody T dto);

    @GetMapping
    public abstract ResponseEntity<Collection<U>> find();

    @DeleteMapping
    public abstract ResponseEntity delete(@PathVariable Long id);

    @PutMapping
    public abstract ResponseEntity<U> update(@RequestBody T dto);


}
