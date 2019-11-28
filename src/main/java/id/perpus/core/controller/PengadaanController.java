package id.perpus.core.controller;

import id.perpus.core.dto.PengadaanDTO;
import id.perpus.core.entity.Pengadaan;
import id.perpus.core.service.PengadaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PengadaanController extends AbstractController<PengadaanDTO, Pengadaan> {

    private final PengadaanService service;

    @Autowired
    public PengadaanController(PengadaanService service) {
        this.service = service;
    }

    @Override
    @PostMapping(value = "/pengadaan")
    public ResponseEntity<Pengadaan> save(@RequestBody PengadaanDTO dto) {
        return ResponseEntity.ok(service.save(new PengadaanDTO().toEntity(dto)));
    }

    @Override
    @GetMapping(value = "/pengadaan")
    public ResponseEntity<Collection<Pengadaan>> find() {
        return ResponseEntity.ok(service.find());
    }

    @Override
    @DeleteMapping(value = "/pengadaan/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        PengadaanDTO dto = new PengadaanDTO(id);
        service.delete(dto.toParam(dto));
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping(value = "/pengadaan")
    public ResponseEntity<Pengadaan> update(@RequestBody PengadaanDTO dto) {
        return ResponseEntity.ok(service.save(new PengadaanDTO().toEntity(dto)));
    }
}
