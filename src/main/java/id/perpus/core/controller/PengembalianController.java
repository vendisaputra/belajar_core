package id.perpus.core.controller;

import id.perpus.core.dto.PengembalianDTO;
import id.perpus.core.entity.Pengembalian;
import id.perpus.core.service.PengembalianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PengembalianController extends AbstractController<PengembalianDTO, Pengembalian> {

    private final PengembalianService service;

    @Autowired
    public PengembalianController(PengembalianService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/pengembalian")
    public ResponseEntity<Pengembalian> save(@RequestBody PengembalianDTO dto) {
        return ResponseEntity.ok(service.save(new PengembalianDTO().toEntity(dto)));
    }

    @Override
    @GetMapping("/pengembalian")
    public ResponseEntity<Collection<Pengembalian>> find() {
        return ResponseEntity.ok(service.find());
    }

    @Override
    @DeleteMapping("/pengembalian/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        PengembalianDTO dto = new PengembalianDTO(id);
        service.delete(dto.toParam(dto));
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping("/pengembalian")
    public ResponseEntity<Pengembalian> update(@RequestBody PengembalianDTO dto) {
        return ResponseEntity.ok(service.save(new PengembalianDTO().toEntity(dto)));
    }
}
