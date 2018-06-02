package com.crealytics.reporting.service;

import com.crealytics.reporting.domain.ReportEntity;

import static org.junit.Assert.assertEquals;

public class ReportUtils
{
    public static void verifyCalculatedValues(ReportEntity reportEntity, Double expectedCtr, Double expectedCr, Double expectedFillRate, Double expectedECPM)
    {
        assertEquals(expectedCtr, reportEntity.getCtr());
        assertEquals(expectedCr, reportEntity.getCr());
        assertEquals(expectedFillRate, reportEntity.getFillRate());
        assertEquals(expectedECPM, reportEntity.geteCPM());
    }
}
