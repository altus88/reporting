package com.crealytics.reporting.service;

import com.crealytics.reporting.Application;
import com.crealytics.reporting.domain.Month;
import com.crealytics.reporting.domain.ReportEntity;
import com.crealytics.reporting.domain.Site;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
public class ReportServiceIT
{
    @Autowired
    ReportService reportService;

    @Test
    public void testSave()
    {
        ReportEntity reportEntity1 = new ReportEntity();
        reportEntity1.setMonth(Month.JANUARY);
        reportEntity1.setSite(Site.ANDROID);

        reportEntity1 = reportService.save(reportEntity1);
        Optional<ReportEntity> reportEntityFromDB1 = reportService.findById(reportEntity1.getId());

        assertTrue(reportEntityFromDB1.isPresent());
        assertEquals(new Double(0.0),reportEntityFromDB1.get().getRevenue());

        ReportEntity reportEntity2 = new ReportEntity();
        reportEntity2.setMonth(Month.JANUARY);
        reportEntity2.setSite(Site.DESKTOP_WEB);
        reportEntity2.setRequests(100);
        reportEntity2.setImpressions(407);
        reportEntity2.setClicks(200);
        reportEntity2.setConversions(13);
        reportEntity2.setRevenue(21.3);
        reportEntity2 = reportService.save(reportEntity2);
        Optional<ReportEntity> reportEntityFromDB2Opt = reportService.findById(reportEntity2.getId());
        assertTrue(reportEntityFromDB2Opt.isPresent());

        ReportEntity reportEntityFromDB2 = reportEntityFromDB2Opt.get();

        assertEquals(100, reportEntityFromDB2.getRequests().intValue());
        assertEquals(407, reportEntityFromDB2.getImpressions().intValue());
        assertEquals(200, reportEntityFromDB2.getClicks().intValue());
        assertEquals(13, reportEntityFromDB2.getConversions().intValue());
        assertEquals(new Double(21.3), reportEntityFromDB2.getRevenue());

        ReportUtils.verifyCalculatedValues(reportEntityFromDB2,49.14, 3.19, 407.0, 52.33);

        assertEquals(2, reportService.findAll().size());
    }

    @Test(expected = ConstraintViolationException.class)
    public void testValidationSaveWithSiteNull()
    {
        ReportEntity reportEntity = new ReportEntity();
        reportService.save(reportEntity);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testValidationSaveWithNegative()
    {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setSite(Site.ANDROID);
        reportEntity.setConversions(-1);
        reportService.save(reportEntity);
    }
}
