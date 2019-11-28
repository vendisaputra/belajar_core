package id.perpus.core.controller;

import id.perpus.core.dto.PubliserDTO;
import id.perpus.core.entity.Publiser;
import id.perpus.core.service.PubliserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PubliserController extends AbstractController<PubliserDTO, Publiser> {

    private final PubliserService service;

    @Autowired
    public PubliserController(PubliserService service) {
        this.service = service;
    }

    @Override
    @GetMapping(value = "/publiser")
    public ResponseEntity<Collection<Publiser>> find(){
        PubliserDTO publiser = new PubliserDTO();
        return ResponseEntity.ok(service.find());
    }

    @Override
    @PostMapping(value = "/publiser")
    public ResponseEntity<Publiser> save(@RequestBody PubliserDTO dto){
        return ResponseEntity.ok(service.save(new PubliserDTO().toEntity(dto)));
    }

    @Override
    @DeleteMapping(value = "/publiser/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        PubliserDTO dto = new PubliserDTO(id);
        service.delete(dto.toParam(dto));
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping(value = "/publiser")
    public ResponseEntity<Publiser> update(PubliserDTO dto) {
        return ResponseEntity.ok(service.save(new PubliserDTO().toEntity(dto)));
    }
}
