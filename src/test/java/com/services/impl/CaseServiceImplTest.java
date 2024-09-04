package com.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;

import static com.example.demo.TestData.testCase;
import static com.example.demo.TestData.testCaseEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.constants.CaseStatus;
import com.example.domain.Case;
import com.example.domain.CaseEntity;
import com.example.repositories.CaseRepository;
import com.example.services.Impl.CaseServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CaseServiceImplTest {

    @Mock
    private CaseRepository caseRepository;

    @InjectMocks
    private CaseServiceImpl underTest;

    @Test
    public void testThatCaseIsSaved() {
        final Case case1 = testCase();

        final CaseEntity caseEntity = testCaseEntity();

        when(caseRepository.save(eq(caseEntity))).thenReturn(caseEntity);

        final Case result = underTest.save(case1);
        assertEquals(case1, result);
    }

    @Test
    public void testThatFindByIdReturnEmptyWhenNoCase() {
        final String id = "1";
        when(caseRepository.findById(eq(id))).thenReturn(Optional.empty());

        final Optional<Case> result = underTest.findById(id);
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void testThatFindByIdReturnCaseWhenExists() {
        final Case book = testCase();
        final CaseEntity bookEntity = testCaseEntity();

        when(caseRepository.findById(eq(book.getId()))).thenReturn(Optional.of(bookEntity));

        final Optional<Case> result = underTest.findById(book.getId());
        assertEquals(Optional.of(book), result);
    }

    @Test
    public void testListCaseReturnsEmptyListWhenNoCaseExist() {
        when(caseRepository.findAll()).thenReturn(new ArrayList<CaseEntity>());
        final List<Case> result = underTest.listCase();
        assertEquals(0, result.size());
    }

    @Test
    public void testListCaseReturnsCaseWhenExist() {
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
        final String isbn = "13123213";
        underTest.deleteCaseById(isbn);
        verify(caseRepository, times(1)).deleteById(eq(isbn));
    }
}
