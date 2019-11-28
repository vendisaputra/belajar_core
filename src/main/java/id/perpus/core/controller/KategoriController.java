package id.perpus.core.controller;

import id.perpus.core.dto.KategoriDTO;
import id.perpus.core.dto.UserDTO;
import id.perpus.core.entity.Kategori;
import id.perpus.core.entity.User;
import id.perpus.core.service.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class KategoriController extends AbstractController<KategoriDTO, Kategori> {

    private final KategoriService service;

    @Autowired
    public KategoriController(KategoriService service) {
        this.service = service;
    }

    @Override
    @PostMapping(value = "/kategori")
    public ResponseEntity<Kategori> save(@RequestBody KategoriDTO dto) {
        return ResponseEntity.ok(service.save(new KategoriDTO().toEntity(dto)));
    }

    @Override
    @GetMapping(value = "/kategori")
    public ResponseEntity<Collection<Kategori>> find() {
        return ResponseEntity.ok(service.find());
    }

    @Override
    @DeleteMapping(value = "/kategori/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        KategoriDTO dto = new KategoriDTO(id);
        service.delete(dto.toParam(dto));
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping(value = "/kategori")
    public ResponseEntity<Kategori> update(@RequestBody KategoriDTO dto) {
        return ResponseEntity.ok(service.save(new KategoriDTO().toEntity(dto)));
    }

}
