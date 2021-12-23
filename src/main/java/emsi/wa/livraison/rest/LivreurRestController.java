package emsi.wa.livraison.rest;


import emsi.wa.livraison.domaine.LivreurVO;
import emsi.wa.livraison.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivreurRestController {


    @Autowired
    private IService service;

    @GetMapping(value = "/rest/emp", produces = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public List<LivreurVO> getAll() {
        return service.getLivreurs();
    }

    @GetMapping(value = "/rest/livreur/{id}")
    public ResponseEntity<Object> getEmpById(@PathVariable(value = "id") Long livreurVoId)
    {
        LivreurVO empVoFound = service.getLivreurById(livreurVoId);
        if (empVoFound == null)
            return new ResponseEntity<>("livreur nexiste pas", HttpStatus.OK);
        return new ResponseEntity<>(empVoFound, HttpStatus.OK);
    }

    @PostMapping(value = "/rest/livreur")
//    public ResponseEntity<Object> createEmp(@Valid @RequestBody LivreurVO livreurVO) {
      public ResponseEntity<Object> createEmp(@RequestBody LivreurVO livreurVO) {
        service.save(livreurVO);
        return new ResponseEntity<>("Livreur is created successfully",
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/rest/livreur/{id}")
    public ResponseEntity<Object> updateEmp(@PathVariable(name = "id") Long empVoId,
                                            @RequestBody LivreurVO livreurVO) {
        LivreurVO livreurVoFound = service.getLivreurById(empVoId);
        if (livreurVoFound == null)
            return new ResponseEntity<>("Livreur doen't exist", HttpStatus.OK);
        livreurVO.setLivreurID(empVoId);
        service.save(livreurVO);
        return new ResponseEntity<>("Livreur is updated successsfully",
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/rest/livreur/{id}")
    public ResponseEntity<Object> deleteEmp(@PathVariable(name = "id") Long empVoId) {
        LivreurVO empVoFound = service.getLivreurById(empVoId);
        if (empVoFound == null)
            return new ResponseEntity<>("Livreur doen't exist", HttpStatus.OK);
        service.delete(empVoId);
        return new ResponseEntity<>("Livreur is deleted successsfully",
                HttpStatus.OK);
    }

    @GetMapping(value = "/rest/sort/{fieldName}", produces = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<LivreurVO> sortBy(@PathVariable String fieldName) {
        return service.sortBy(fieldName);
    }

    @GetMapping("/rest/pagination/{pageid}/{size}")
    public List<LivreurVO> pagination(@PathVariable int pageid, @PathVariable int size,
                                  Model m) {
        return service.findAll(pageid, size);
    }
}
