package com.example.demo.constants;

public enum CaseStatus {
    ACTIVE, RESOLVED, TERMINATED, ARCHIVED, CANCELLED;

    public static CaseStatus getCaseStatus(String caseStatus) {
        for (CaseStatus eachValue : CaseStatus.values()) {
            if (eachValue.name().equalsIgnoreCase(caseStatus)) {
                return eachValue;
            }
        }
        return null;
    }
}
