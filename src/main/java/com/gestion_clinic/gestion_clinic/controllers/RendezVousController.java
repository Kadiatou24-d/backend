package com.gestion_clinic.gestion_clinic.controllers;

import com.gestion_clinic.gestion_clinic.dtos.RendezVousdtos;
import com.gestion_clinic.gestion_clinic.entities.RendezVous;
import com.gestion_clinic.gestion_clinic.services.RendezVousService;
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
@RequestMapping("/api/rendezvous")
@CrossOrigin("*")
public class RendezVousController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final RendezVousService rendezVousService;

    public RendezVousController(RendezVousService rendezVousService) {
        this.rendezVousService = rendezVousService;

    }

    @GetMapping

    public List<RendezVousdtos> getAllRendezVous() {
        return rendezVousService.getAll().stream().map(RendezVous -> modelMapper.map(RendezVous, RendezVousdtos.class))
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<RendezVousdtos> getById(@PathVariable Long id) {
        Optional<RendezVous> c = rendezVousService.getById(id);
        RendezVousdtos rendezVousdtos = modelMapper.map(c.get(), RendezVousdtos.class);
        return ResponseEntity.ok().body(rendezVousdtos);
    }

    @PostMapping
    public ResponseEntity<RendezVousdtos> create(@RequestBody RendezVousdtos rendezVousdtos) {
        RendezVous r = modelMapper.map(rendezVousdtos, RendezVous.class);
        RendezVous rendezVous = rendezVousService.save(r);
        RendezVousdtos response = modelMapper.map(rendezVous, RendezVousdtos.class);
        return new ResponseEntity<RendezVousdtos>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RendezVousdtos> update(@PathVariable Long id, @RequestBody RendezVousdtos rendezVousdtos) {
        Optional<RendezVous> rendezVous = rendezVousService.getById(id);

        if (!rendezVous.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        RendezVous classeRequest = modelMapper.map(rendezVousdtos, RendezVous.class);
        RendezVous e = rendezVousService.Update(classeRequest);
        RendezVousdtos classeResponse = modelMapper.map(e, RendezVousdtos.class);
        return ResponseEntity.ok().body(classeResponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id){
        Optional<RendezVous> rendezVous=rendezVousService.getById(id);
        if (rendezVous.isEmpty()){
            return ResponseEntity.unprocessableEntity().build();
        }
        rendezVousService.deleById(id);
        ApiResponse apiResponse=null;
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }
}


