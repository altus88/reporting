package com.crealytics.reporting;


import com.crealytics.reporting.domain.Month;
import com.crealytics.reporting.domain.ReportEntity;
import com.crealytics.reporting.domain.Site;
import com.crealytics.reporting.service.ReportService;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class Application
{
    @Autowired
    ReportService reportService;

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Profile("prod")
    InitializingBean importReportData()
	{
		return () ->
        {
            readAndSaveDataFromCSV("/2018_01_report.csv", Month.JANUARY);
            readAndSaveDataFromCSV("/2018_02_report.csv", Month.FEBRUARY);
		};
	}

	private void readAndSaveDataFromCSV(String csvFile, Month month)
    {
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(csvFile)))
        {
            scanner.nextLine(); //skip the header
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] report = line.split(",");
                saveReport(report, month);
            }
            scanner.close();
        }
    }

    private void saveReport(String[] report, Month month)
    {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setMonth(month);
        reportEntity.setSite(Site.fromString(report[0]));
        reportEntity.setRequests(Integer.parseInt(report[1].trim()));
        reportEntity.setImpressions(Integer.parseInt(report[2].trim()));
        reportEntity.setClicks(Integer.parseInt(report[3].trim()));
        reportEntity.setConversions(Integer.parseInt(report[4].trim()));
        reportEntity.setRevenue(Double.parseDouble(report[5].trim()));
        reportService.save(reportEntity);
    }
}
