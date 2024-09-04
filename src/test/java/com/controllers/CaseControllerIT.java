package com.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;

import com.example.demo.TestData;
import com.example.domain.Case;
import com.example.services.CaseService;
import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.persistence.criteria.CriteriaBuilder.Case;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class CaseControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CaseService caseService;

    @Test
    public void testThatCaseIsCreatedReturnsHTTP200() throws Exception {
        final Case case1 = TestData.testCase();
        final ObjectMapper objectMapper = new ObjectMapper();
        final String caseJson = objectMapper.writeValueAsString(case1);

        mockMvc.perform(MockMvcRequestBuilders.put("/case/" + case1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(caseJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(case1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fileNumber").value(case1.getFileNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseTitle").value(case1.getCaseTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseNumber").value(case1.getCaseNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseStatus").value(case1.getCaseStatus()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.kindOfCase").value(case1.getKindOfCase()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courtCase").value(case1.getCourtCase()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.engagedDate").value(case1.getEngagedDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.location").value(case1.getLocation()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value(case1.getClientName()));
    }

    @Test
    public void testThatCaseIsUpdatedReturnsHTTP201() throws Exception {
        final Case case1 = TestData.testCase();
        caseService.save(case1);

        case1.setFileNumber("035-01-CA");

        final ObjectMapper objectMapper = new ObjectMapper();
        final String caseJson = objectMapper.writeValueAsString(case1);

        mockMvc
                .perform(
                        MockMvcRequestBuilders.put("/case/" + case1.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(caseJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(case1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fileNumber").value(case1.getFileNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseTitle").value(case1.getCaseTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseNumber").value(case1.getCaseNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseStatus").value(case1.getCaseStatus()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.kindOfCase").value(case1.getKindOfCase()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courtCase").value(case1.getCourtCase()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.engagedDate").value(case1.getEngagedDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.location").value(case1.getLocation()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value(case1.getClientName()));
    }

    @Test
    public void testThatRetrieveCaseReturns404WhenCaseNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/case/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testThatRetrieveCaseReturns200AndCaseWhenExists() throws Exception {
        final Case case1 = TestData.testCase();
        caseService.save(case1);

        mockMvc.perform(MockMvcRequestBuilders.get("case" + case1.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(case1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fileNumber").value(case1.getFileNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseTitle").value(case1.getCaseTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseNumber").value(case1.getCaseNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseStatus").value(case1.getCaseStatus()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.kindOfCase").value(case1.getKindOfCase()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courtCase").value(case1.getCourtCase()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.engagedDate").value(case1.getEngagedDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.location").value(case1.getLocation()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value(case1.getClientName()));
    }

    @Test
    public void testThatListCaseReturnsHttp200EmptyListWhenNoCaseExist() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/case"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void testThatListCaseReturnsHttp200AndCaseWhenCaseExist() throws Exception {
        final Case case1 = TestData.testCase();
        caseService.save(case1);

        mockMvc
                .perform(MockMvcRequestBuilders.get("/case"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(case1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fileNumber").value(case1.getFileNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseTitle").value(case1.getCaseTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseNumber").value(case1.getCaseNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.caseStatus").value(case1.getCaseStatus()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.kindOfCase").value(case1.getKindOfCase()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.courtCase").value(case1.getCourtCase()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.engagedDate").value(case1.getEngagedDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.location").value(case1.getLocation()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.clientName").value(case1.getClientName()));
    }

    @Test
    public void testThatHttp204IsReturnedWhenCaseDoesntExist() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.delete("/case/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testThatHttp204IsReturnedWhenExistingCaseIsDeleted() throws Exception {
        final Case case1 = TestData.testCase();
        caseService.save(case1);

        mockMvc
                .perform(MockMvcRequestBuilders.delete("/case/" + case1.getId()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
