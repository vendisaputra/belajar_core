package id.perpus.core.controller;

import id.perpus.core.dto.BukuDTO;
import id.perpus.core.entity.Buku;
import id.perpus.core.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BukuController extends AbstractController<BukuDTO, Buku> {

    private  final BukuService bukuService;

    @Autowired
    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @Override
    @PostMapping(value = "/buku")
    public ResponseEntity<Buku> save(@RequestBody BukuDTO dto) {
        return ResponseEntity.ok(bukuService.save(new BukuDTO().toEntity(dto)));
    }

    @GetMapping(value = "/buku")
    public ResponseEntity<Collection<BukuDTO>> find2() {
        BukuDTO buku = new BukuDTO();
        return ResponseEntity.ok(buku.toDTO(bukuService.find()));
    }

    @Override
    @GetMapping(value = "/buku2")
    public ResponseEntity<Collection<Buku>> find() {
        BukuDTO buku = new BukuDTO();
        return ResponseEntity.ok(bukuService.find());
    }

    @Override
    @DeleteMapping(value = "/buku/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        BukuDTO dto = new BukuDTO(id);
        bukuService.delete(dto.toParam(dto));
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping(value = "/buku")
    public ResponseEntity<Buku> update(@RequestBody BukuDTO dto) {
        return ResponseEntity.ok(bukuService.save(new BukuDTO().toEntity(dto)));
    }


//    @PostMapping(value = "/buku")
//    public ResponseEntity<Buku> save(@RequestBody BukuDTO dto){
//        return ResponseEntity.ok(bukuService.save(new BukuDTO().toEntity(dto)));
//    }
//
//    @GetMapping(value = "/buku")
//    public ResponseEntity<Collection<BukuDTO>> find(){
//        BukuDTO buku = new BukuDTO();
//        return ResponseEntity.ok(buku.toDTO(bukuService.find()));
//    }
//
//    @DeleteMapping(value = "/buku/{id}")
//    public ResponseEntity delete(@PathVariable Long id){
//        BukuDTO dto = new BukuDTO(id);
//        bukuService.delete(dto.toParam(dto));
//        return ResponseEntity.ok().build();
//    }
}
