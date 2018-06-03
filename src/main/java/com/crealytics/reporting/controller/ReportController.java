package com.crealytics.reporting.controller;

import com.crealytics.reporting.domain.Month;
import com.crealytics.reporting.domain.Site;
import com.crealytics.reporting.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "${api.url_base}")
public class ReportController
{
    @Autowired
    ReportService reportService;

    @RequestMapping(method = RequestMethod.GET, value = "/{month}/{site}")
    @ResponseBody
    public ResponseEntity<List<ReportDTO>> getReport(@PathVariable(value = "month") Month month,
                                                     @PathVariable(value = "site") Site site)
    {
        List<ReportDTO> reportDTOs = new ArrayList<>();
        reportService.getByMonthAndSite(month, site).stream().forEach(reportEntity -> reportDTOs.add(new ReportDTO(reportEntity)));
        return new ResponseEntity<>(reportDTOs, HttpStatus.OK);
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
        dataBinder.registerCustomEditor(Month.class, new MonthEnumConverter());
        dataBinder.registerCustomEditor(Site.class, new SiteEnumConverter());
    }
}
