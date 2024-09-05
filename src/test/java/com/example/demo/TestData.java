package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.example.demo.constants.CaseStatus;
import com.example.demo.domain.Case;
import com.example.demo.domain.CaseEntity;

public final class TestData {

    private TestData() {

    }

    public static Case testCase() {
        // Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2024-08-01");
        // Date currenDate = new Date();
        return Case.builder()
                .id("3")
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

    public static CaseEntity testCaseEntity() throws ParseException {
        // Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2024-08-01");
        // LocalDate date = LocalDate.parse("2018-05-05");
        // Date currenDate = new Date();
        return CaseEntity.builder()
                .id("3")
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
