package id.perpus.core.controller;

import id.perpus.core.dto.PinjamanDTO;
import id.perpus.core.entity.Peminjaman;
import id.perpus.core.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PeminjamanController extends AbstractController<PinjamanDTO, Peminjaman> {

    private final PeminjamanService service;

    @Autowired
    public PeminjamanController(PeminjamanService service) {
        this.service = service;
    }

    @Override
    @PostMapping(value = "/peminjaman")
    public ResponseEntity<Peminjaman> save(@RequestBody PinjamanDTO dto) {
        return ResponseEntity.ok(service.save(new PinjamanDTO().toEntity(dto)));
    }

    @Override
    @GetMapping(value = "/peminjaman")
    public ResponseEntity<Collection<Peminjaman>> find() {
        return ResponseEntity.ok(service.find());
    }

    @Override
    @DeleteMapping(value = "/peminjaman/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        PinjamanDTO dto = new PinjamanDTO();
        service.delete(dto.toParam(dto));
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping(value = "/peminjaman")
    public ResponseEntity<Peminjaman> update(@RequestBody PinjamanDTO dto) {
        return ResponseEntity.ok(service.save(new PinjamanDTO().toEntity(dto)));
    }
}
