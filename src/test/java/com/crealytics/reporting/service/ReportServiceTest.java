package com.crealytics.reporting.service;

import com.crealytics.reporting.domain.ReportEntity;
import com.crealytics.reporting.domain.Site;
import com.crealytics.reporting.repository.ReportRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ReportServiceTest
{
    @InjectMocks
    ReportService reportService;

    @Mock
    ReportRepository reportRepository;

    @Test
    public void testSave()
    {
        ReportEntity reportEntity = new ReportEntity();
        reportService.save(reportEntity);
        verifyValues(reportEntity,0.0, 0.0, 0.0, 0.0);

        reportEntity.setRequests(100);
        reportEntity.setImpressions(407);
        reportEntity.setClicks(200);
        reportEntity.setConversions(13);
        reportEntity.setRevenue(21.3);
        reportService.save(reportEntity);
        verifyValues(reportEntity,49.14, 3.19, 407.0, 52.33);
    }

    private void verifyValues(ReportEntity reportEntity, Double expectedCtr, Double expectedCr, Double expectedFillRate, Double expectedECPM)
    {
        assertEquals(expectedCtr, reportEntity.getCtr());
        assertEquals(expectedCr, reportEntity.getCr());
        assertEquals(expectedFillRate, reportEntity.getFillRate());
        assertEquals(expectedECPM, reportEntity.geteCPM());
    }
}
