package com.example.demo;

import com.example.constants.CaseStatus;
import com.example.domain.Case;
import com.example.domain.CaseEntity;

public final class TestData {

    private TestData() {

    }

    public static Case testCase() {
        return Case.builder()
                .id("1")
                .fileNumber("035-01-CA")
                .caseTitle("Complainant vs Respondent")
                .caseNumber(10)
                .caseStatus(CaseStatus.ACTIVE)
                .kindOfCase("Civil")
                .courtCase("Court of Appeals")
                .engagedDate(null)
                .location("CARMEN, AGUSAN DEL NORTE")
                .clientName("Sample Name")
                .build();
    }

    public static CaseEntity testCaseEntity() {
        return CaseEntity.builder()
                .id("1")
                .fileNumber("035-01-CA")
                .caseTitle("Complainant vs Respondent")
                .caseNumber(10)
                .caseStatus(CaseStatus.ACTIVE)
                .kindOfCase("Civil")
                .courtCase("Court of Appeals")
                .engagedDate(null)
                .location("CARMEN, AGUSAN DEL NORTE")
                .clientName("Sample Name")
                .build();
    }
}
