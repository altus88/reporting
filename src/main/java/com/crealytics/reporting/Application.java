package com.crealytics.reporting;


import com.crealytics.reporting.domain.ReportEntity;
import com.crealytics.reporting.domain.Site;
import com.crealytics.reporting.service.ReportService;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
    InitializingBean importReportData()
	{
		return () ->
        {
            ReportEntity reportEntity = new ReportEntity();
            reportEntity.setSite(Site.ANDROID);
            reportEntity.setRevenue(100f);
            reportEntity.setConversions(300);
            reportEntity = reportService.save(reportEntity);
            System.out.println(reportEntity.getCtr());
		};
	}
}
