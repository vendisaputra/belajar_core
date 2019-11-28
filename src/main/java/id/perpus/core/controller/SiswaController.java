package id.perpus.core.controller;

import id.perpus.core.dto.SiswaDTO;
import id.perpus.core.entity.Siswa;
import id.perpus.core.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class SiswaController extends AbstractController<SiswaDTO, Siswa> {

    private final SiswaService service;

    @Autowired
    public SiswaController(SiswaService service) {
        this.service = service;
    }

    @Override
    @PostMapping(value = "/siswa")
    public ResponseEntity<Siswa> save(@RequestBody SiswaDTO dto) {
        return ResponseEntity.ok(service.save(new SiswaDTO().toEntity(dto)));
    }

    @Override
    @GetMapping(value = "/siswa")
    public ResponseEntity<Collection<Siswa>> find() {
        return ResponseEntity.ok(service.find());
    }

    @Override
    @DeleteMapping(value = "/siswa/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        SiswaDTO dto = new SiswaDTO(id);
        service.delete(dto.toParam(dto));
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping(value = "/siswa")
    public ResponseEntity<Siswa> update(@RequestBody SiswaDTO dto) {
        return ResponseEntity.ok(service.save(new SiswaDTO().toEntity(dto)));
    }
}
