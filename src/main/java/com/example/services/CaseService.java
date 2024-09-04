package com.example.services;

import java.util.Optional;

import java.util.List;

import com.example.domain.Case;

public interface CaseService {
    // Case create(Case case1);

    boolean isCaseExists(Case case1);

    Case save(Case case1);

    Optional<Case> findById(String id);

    void deleteCaseById(String id);

    List<Case> listCase();

}
