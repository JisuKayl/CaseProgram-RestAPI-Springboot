package com.example.demo.services.Impl;

import java.util.Optional;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Case;
import com.example.demo.domain.CaseEntity;
import com.example.demo.repositories.CaseRepository;
import com.example.demo.services.CaseService;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;

    @Autowired
    public CaseServiceImpl(final CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public Case save(final Case case1) {
        final CaseEntity caseEntity = caseToCaseEntity(case1);
        final CaseEntity savedCaseEntity = caseRepository.save(caseEntity);
        return caseEntityToCase(savedCaseEntity);
    }

    // @Override
    // public Case create(final Case case1) {
    // final CaseEntity caseEntity = caseToCaseEntity(case1);
    // final CaseEntity savedCaseEntity = caseRepository.save(caseEntity);
    // return caseEntityToCase(savedCaseEntity);
    // }

    private CaseEntity caseToCaseEntity(Case case1) {
        return CaseEntity.builder()
                .id(case1.getId())
                .fileNumber(case1.getFileNumber())
                .caseTitle(case1.getCaseTitle())
                .caseNumber(case1.getCaseNumber())
                .caseStatus(case1.getCaseStatus())
                .kindOfCase(case1.getKindOfCase())
                .courtCase(case1.getCourtCase())
                .engagedDate(case1.getEngagedDate())
                .location(case1.getLocation())
                .clientName(case1.getClientName())
                .build();
    }

    private Case caseEntityToCase(CaseEntity caseEntity) {
        return Case.builder()
                .id(caseEntity.getId())
                .fileNumber(caseEntity.getFileNumber())
                .caseTitle(caseEntity.getCaseTitle())
                .caseNumber(caseEntity.getCaseNumber())
                .caseStatus(caseEntity.getCaseStatus())
                .kindOfCase(caseEntity.getKindOfCase())
                .courtCase(caseEntity.getCourtCase())
                .engagedDate(caseEntity.getEngagedDate())
                .location(caseEntity.getLocation())
                .clientName(caseEntity.getClientName())
                .build();
    }

    @Override
    public Optional<Case> findById(String id) {
        final Optional<CaseEntity> foundCase = caseRepository.findById(id);
        return foundCase.map(case1 -> caseEntityToCase(case1));
    }

    @Override
    public List<Case> listCase() {
        final List<CaseEntity> foundCase = caseRepository.findAll();
        return foundCase.stream().map(case1 -> caseEntityToCase(case1)).collect(Collectors.toList());
    }

    @Override
    public boolean isCaseExists(Case case1) {
        return caseRepository.existsById(case1.getId());
    }

    @Override
    public void deleteCaseById(String id) {
        try {
            caseRepository.deleteById(id);

        } catch (final EmptyResultDataAccessException ex) {
            log.debug("Attempted to delete non-existing case", ex);
        }
    }
}
