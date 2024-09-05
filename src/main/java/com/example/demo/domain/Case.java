package com.example.demo.domain;

import java.util.Date;

import com.example.demo.constants.CaseStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date engagedDate;
    private String location;
    private String clientName;
}
