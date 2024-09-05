package com.example.demo.controllers;

import java.util.Optional;

// import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.Case;
import com.example.demo.services.CaseService;

@RestController
public class CaseController {

    private final CaseService caseService;

    public CaseController(final CaseService caseService) {
        this.caseService = caseService;
    }

    @PutMapping(path = "/case/{id}")
    public ResponseEntity<Case> createCase(
            @PathVariable final String id,
            @RequestBody final Case case1) {
        case1.setId(id);
        final Case savedCase = caseService.save(case1);
        final ResponseEntity<Case> response = new ResponseEntity<Case>(savedCase, HttpStatus.CREATED);
        return response;
    }

    @GetMapping(path = "/case/{id}")
    public ResponseEntity<Case> retrieveCase(@PathVariable final String id) {
        final Optional<Case> foundCase = caseService.findById(id);
        return foundCase.map(case1 -> new ResponseEntity<Case>(case1, HttpStatus.OK))
                .orElse(new ResponseEntity<Case>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/case")
    public ResponseEntity<List<Case>> listCase() {
        return new ResponseEntity<List<Case>>(caseService.listCase(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/case/{id}")
    public ResponseEntity<Case> deleteCase(@PathVariable final String id) {
        caseService.deleteCaseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
