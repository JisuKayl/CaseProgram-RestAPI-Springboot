package com.example.domain;

import java.sql.Date;

import com.example.constants.CaseStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Case {

    private String id;
    private String fileNumber;
    private String caseTitle;
    private Integer caseNumber;
    @Enumerated(EnumType.STRING)
        private CaseStatus caseStatus;
    private String kindOfCase;
    private String courtCase;
    private Date engagedDate;
    private String location;
    private String clientName;
}
