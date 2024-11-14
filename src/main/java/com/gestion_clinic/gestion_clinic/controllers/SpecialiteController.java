package com.gestion_clinic.gestion_clinic.controllers;

import com.gestion_clinic.gestion_clinic.dtos.Patientdtos;
import com.gestion_clinic.gestion_clinic.dtos.Specialitedtos;
import com.gestion_clinic.gestion_clinic.entities.Patient;
import com.gestion_clinic.gestion_clinic.entities.Specialite;
import com.gestion_clinic.gestion_clinic.services.PatientService;
import com.gestion_clinic.gestion_clinic.services.SpecialiteService;
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
@RequestMapping("/api/specialite")
@CrossOrigin("*")
public class SpecialiteController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired

    private final SpecialiteService specialiteService;

    public SpecialiteController(SpecialiteService specialiteService) {
        this.specialiteService = specialiteService;
    }

    @GetMapping
    public List<Specialitedtos> getAllSpecialite() {
        return specialiteService.getAll().stream().map(Specialite -> modelMapper.map(Specialite, Specialitedtos.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialitedtos> getById(@PathVariable Long id) {
        Optional<Specialite> c = specialiteService.getById(id);
        Specialitedtos specialitedtos = modelMapper.map(c.get(), Specialitedtos.class);
        return ResponseEntity.ok().body(specialitedtos);
    }


    @PostMapping
    public ResponseEntity<Specialitedtos> create(@RequestBody Specialitedtos specialitedtos) {
        Specialite r = modelMapper.map(specialitedtos, Specialite.class);
        Specialite specialite = specialiteService.save(r);
        Specialitedtos response = modelMapper.map(specialite, Specialitedtos.class);
        return new ResponseEntity<Specialitedtos>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialitedtos> update(@PathVariable Long id, @RequestBody Specialitedtos specialitedtos) {
        Optional<Specialite> specialite = specialiteService.getById(id);

        if (!specialite.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Specialite classeRequest = modelMapper.map(specialitedtos, Specialite.class);
        Specialite e = specialiteService.Update(classeRequest);
        Specialitedtos classeResponse = modelMapper.map(e, Specialitedtos.class);
        return ResponseEntity.ok().body(classeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        Optional<Specialite> specialite = specialiteService.getById(id);
        if (specialite.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        specialiteService.deleById(id);
        ApiResponse apiResponse = null;
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

}



