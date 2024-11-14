package com.gestion_clinic.gestion_clinic.controllers;

import com.gestion_clinic.gestion_clinic.dtos.Medecindtos;
import com.gestion_clinic.gestion_clinic.entities.Medecin;
import com.gestion_clinic.gestion_clinic.services.MedecinService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medecin")
@CrossOrigin("*")
public class MedecinController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final MedecinService medecinService;

    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;

}

    @GetMapping
    public List<Medecindtos> getAllPatients() {
        return medecinService.getAll().stream().map(Medecin-> modelMapper.map(Medecin, Medecindtos.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medecindtos> getById(@PathVariable Long id) {
        Optional<Medecin> c = medecinService.getById(id);
        Medecindtos medecindtos = modelMapper.map(c.get(), Medecindtos.class);
        return ResponseEntity.ok().body(medecindtos);
    }

    @PostMapping
    public ResponseEntity<Medecindtos>create(@RequestBody Medecindtos medecindtos) {
        Medecin r = modelMapper.map(medecindtos, Medecin.class);
        Medecin medecin = medecinService.save(r);
        Medecindtos response = modelMapper.map(medecin, Medecindtos.class);
        return new ResponseEntity<Medecindtos>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medecindtos> update(@PathVariable Long id, @RequestBody Medecindtos medecindtos) {
        Optional<Medecin> medecin = medecinService.getById(id);

        if (!medecin.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Medecin classeRequest = modelMapper.map(medecindtos,Medecin.class);
        Medecin e = medecinService.Update(classeRequest);
       Medecindtos classeResponse = modelMapper.map(e, Medecindtos.class);
        return ResponseEntity.ok().body(classeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id){
        Optional<Medecin> medecin=medecinService.getById(id);
        if (medecin.isEmpty()){
            return ResponseEntity.unprocessableEntity().build();
        }
        medecinService.deleById(id);
        ApiResponse apiResponse=null;
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }
}






