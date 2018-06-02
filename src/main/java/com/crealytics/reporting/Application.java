package com.crealytics.reporting;


import com.crealytics.reporting.domain.ReportEntity;
import com.crealytics.reporting.domain.Site;
import com.crealytics.reporting.service.ReportService;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

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
            ReportEntity reportEntity = new ReportEntity();
            reportEntity.setSite(Site.ANDROID);
            reportEntity.setRequests(-1);
            reportEntity.setImpressions(407);
            reportEntity.setClicks(200);
            reportEntity.setConversions(13);
            reportEntity.setRevenue(21.3);
            reportService.save(reportEntity);
            System.out.println(reportEntity.getCtr());
		};
	}
}
