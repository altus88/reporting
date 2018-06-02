package com.crealytics.reporting.repository;

import com.crealytics.reporting.domain.ReportEntity;

import org.springframework.data.repository.CrudRepository;

public interface ReportRepository  extends CrudRepository<ReportEntity, Long>
{
    ReportEntity getById(Long id);
}
