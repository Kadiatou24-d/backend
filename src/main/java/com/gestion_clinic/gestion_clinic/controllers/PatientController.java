package com.gestion_clinic.gestion_clinic.controllers;



import com.gestion_clinic.gestion_clinic.dtos.Patientdtos;
import com.gestion_clinic.gestion_clinic.entities.Patient;
import com.gestion_clinic.gestion_clinic.services.PatientService;
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
@RequestMapping("/api/patient")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping
    public List<Patientdtos> getAllPatients() {
        return patientService.getAll().stream().map(Patient -> modelMapper.map(Patient,Patientdtos.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patientdtos> getById(@PathVariable Long id) {
        Optional<Patient> c = patientService.getById(id);
        Patientdtos patientdtos = modelMapper.map(c.get(), Patientdtos.class);
        return ResponseEntity.ok().body(patientdtos);
    }

    @PostMapping
    public ResponseEntity<Patientdtos>create(@RequestBody Patientdtos patientdtos) {
        Patient r = modelMapper.map(patientdtos, Patient.class);
       Patient patient = patientService.save(r);
      Patientdtos response = modelMapper.map(patient, Patientdtos.class);
        return new ResponseEntity<Patientdtos>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patientdtos> update(@PathVariable Long id, @RequestBody Patientdtos patientdtos) {
        Optional<Patient> patient = patientService.getById(id);

        if (!patient.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Patient classeRequest = modelMapper.map(patientdtos,Patient.class);
        Patient e = patientService.Update(classeRequest);
       Patientdtos classeResponse = modelMapper.map(e, Patientdtos.class);
        return ResponseEntity.ok().body(classeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id){
        Optional<Patient> patient=patientService.getById(id);
        if (patient.isEmpty()){
            return ResponseEntity.unprocessableEntity().build();
        }
        patientService.deleById(id);
        ApiResponse apiResponse=null;
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }
}
