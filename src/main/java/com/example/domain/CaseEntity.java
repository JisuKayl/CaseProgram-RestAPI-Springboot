package com.example.domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.constants.CaseStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "case")
public class CaseEntity {

    @Id
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
