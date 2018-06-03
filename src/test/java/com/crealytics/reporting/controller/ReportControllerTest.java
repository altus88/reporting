package com.crealytics.reporting.controller;

import com.crealytics.reporting.domain.Month;
import com.crealytics.reporting.domain.ReportEntity;
import com.crealytics.reporting.domain.Site;
import com.crealytics.reporting.service.ReportService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.text.html.parser.Entity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ReportControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReportService reportService;

    @Before
    public void init()
    {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setMonth(Month.JANUARY);
        reportEntity.setSite(Site.IOS);
        reportEntity.setRequests(100);
        reportEntity.setImpressions(407);
        reportEntity.setClicks(200);
        reportEntity.setConversions(13);
        reportEntity.setRevenue(21.3);
        reportService.save(reportEntity);
    }

    @Test
    public void testGetReport() throws Exception
    {
        mockMvc.perform(
                get("/report/1/ios"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"month\":\"January\",\"site\":\"iOS\",\"request\":\"100\",\"impressions\":\"407\",\"clicks\":\"200\",\"conversions\":\"13\",\"revenue\":\"21.30\",\"ctr\":\"49.14\",\"cr\":\"3.19\",\"fillRate\":\"407.00\",\"eCPM\":\"52.33\"}]"));

        mockMvc.perform(
                get("/report/13/ios"))
                .andExpect(status().isBadRequest());

        mockMvc.perform(
                get("/report//"))
                .andExpect(status().isNotFound());
    }
}
