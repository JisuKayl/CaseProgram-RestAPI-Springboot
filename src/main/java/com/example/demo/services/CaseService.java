package com.example.demo.services;

import java.util.Optional;

import com.example.demo.domain.Case;

import java.util.List;

public interface CaseService {
    // Case create(Case case1);

    boolean isCaseExists(Case case1);

    Case save(Case case1);

    Optional<Case> findById(String id);

    void deleteCaseById(String id);

    List<Case> listCase();

}
