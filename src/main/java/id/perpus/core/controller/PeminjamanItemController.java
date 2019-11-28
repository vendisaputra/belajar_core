package id.perpus.core.controller;

import id.perpus.core.dto.PinjamanItemDTO;
import id.perpus.core.entity.PinjamanItem;
import id.perpus.core.service.PinjamanItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PeminjamanItemController extends AbstractController<PinjamanItemDTO, PinjamanItem> {

    private final PinjamanItemService service;

    @Autowired
    public PeminjamanItemController(PinjamanItemService service) {
        this.service = service;
    }

    @Override
    @PostMapping(value = "/pitem")
    public ResponseEntity<PinjamanItem> save(@RequestBody PinjamanItemDTO dto) {
        return ResponseEntity.ok(service.save(new PinjamanItemDTO().toEntity(dto)));
    }

    @Override
    @GetMapping(value = "/pitem")
    public ResponseEntity<Collection<PinjamanItem>> find() {
        Collection<PinjamanItem> result = service.find();

        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    public Map<String, Object> convertModel(Object data) {
        Map<String, Object> model = new HashMap<>();
        model.put("data", data);

        return model;
    }

    @GetMapping(value = "/pitem2")
    public Map<String, Object> find2() {
        Collection<PinjamanItem> result = service.find();

        return convertModel(new PinjamanItemDTO().toDTO(result));
    }

    @Override
    @DeleteMapping(value = "/pitem/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        PinjamanItemDTO dto = new PinjamanItemDTO(id);
        service.delete(dto.toParam(dto));
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping(value = "/pitem")
    public ResponseEntity<PinjamanItem> update(@RequestBody PinjamanItemDTO dto) {
        return ResponseEntity.ok(service.save(new PinjamanItemDTO().toEntity(dto)));
    }
}
