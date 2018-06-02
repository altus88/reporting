package com.crealytics.reporting.service;

import com.crealytics.reporting.domain.ReportEntity;
import com.crealytics.reporting.repository.ReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportService
{
    @Autowired
    ReportRepository reportRepository;

    public Optional<ReportEntity> getById(Long id)
    {
        return Optional.of(reportRepository.getById(id));
    }

    public ReportEntity save(ReportEntity reportEntity)
    {
        return reportRepository.save(reportEntity);
    }
}
