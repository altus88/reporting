package com.crealytics.reporting.repository;

import com.crealytics.reporting.domain.Month;
import com.crealytics.reporting.domain.ReportEntity;
import com.crealytics.reporting.domain.Site;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReportRepository  extends CrudRepository<ReportEntity, Long>
{
    Optional<ReportEntity> getByMonthAndSite(Month month, Site site);
}
