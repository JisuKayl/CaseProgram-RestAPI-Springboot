package com.example.demo.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.*;

import static com.example.demo.TestData.testCase;
import static com.example.demo.TestData.testCaseEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.constants.CaseStatus;
import com.example.demo.domain.Case;
import com.example.demo.domain.CaseEntity;
import com.example.demo.repositories.CaseRepository;
import com.example.demo.services.Impl.CaseServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CaseServiceImplTest {

    @Mock
    private CaseRepository caseRepository;

    @InjectMocks
    private CaseServiceImpl underTest;

    @Test
    public void testThatCaseIsSaved() throws ParseException {
        final Case case1 = testCase();

        final CaseEntity caseEntity = testCaseEntity();

        when(caseRepository.save(eq(caseEntity))).thenReturn(caseEntity);

        final Case result = underTest.save(case1);
        assertEquals(case1, result);
    }

    @Test
    public void testThatFindByIdReturnEmptyWhenNoCase() {
        final String id = "3";
        when(caseRepository.findById(eq(id))).thenReturn(Optional.empty());

        final Optional<Case> result = underTest.findById(id);
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void testThatFindByIdReturnCaseWhenExists() throws ParseException {
        final Case case1 = testCase();
        final CaseEntity caseEntity = testCaseEntity();

        when(caseRepository.findById(eq(case1.getId()))).thenReturn(Optional.of(caseEntity));

        final Optional<Case> result = underTest.findById(case1.getId());
        assertEquals(Optional.of(case1), result);
    }

    @Test
    public void testListCaseReturnsEmptyListWhenNoCaseExist() {
        when(caseRepository.findAll()).thenReturn(new ArrayList<CaseEntity>());
        final List<Case> result = underTest.listCase();
        assertEquals(0, result.size());
    }

    @Test
    public void testListCaseReturnsCaseWhenExist() throws ParseException {
        final CaseEntity caseEntity = testCaseEntity();
        when(caseRepository.findAll()).thenReturn(List.of(caseEntity));
        final List<Case> result = underTest.listCase();
        assertEquals(1, result.size());
    }

    @Test
    public void testIsCaseExistsReturnsFalseWhenCaseDoesntExist() {
        when(caseRepository.existsById(any())).thenReturn(false);
        final boolean result = underTest.isCaseExists(testCase());
        assertEquals(false, result);
    }

    @Test
    public void testDeleteCaseDeletesCase() {
        final String id = "3";
        underTest.deleteCaseById(id);
        verify(caseRepository, times(1)).deleteById(eq(id));
    }
}
