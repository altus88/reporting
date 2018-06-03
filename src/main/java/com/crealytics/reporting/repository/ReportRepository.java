package com.crealytics.reporting.repository;

import com.crealytics.reporting.domain.Month;
import com.crealytics.reporting.domain.ReportEntity;
import com.crealytics.reporting.domain.Site;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportRepository  extends CrudRepository<ReportEntity, Long>
{
    List<ReportEntity> getByMonthAndSite(Month month, Site site);
}
