package com.crealytics.reporting.service;

import com.crealytics.reporting.domain.Month;
import com.crealytics.reporting.domain.ReportEntity;
import com.crealytics.reporting.domain.Site;
import com.crealytics.reporting.repository.ReportRepository;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService
{
    @Autowired
    ReportRepository reportRepository;

    private static final int DECIMAL_PRECISION = 2;

    public Optional<ReportEntity> findById(Long id)
    {
        return reportRepository.findById(id);
    }

    public List<ReportEntity> findAll()
    {
        List<ReportEntity> reportEntities = new ArrayList<>();
        reportRepository.findAll().forEach(reportEntities::add);
        return reportEntities;
    }

    public List<ReportEntity> getByMonth(Month month)
    {
        return reportRepository.getByMonth(month);
    }

    public List<ReportEntity> getByMonthAndSite(Month month, Site site)
    {
        return reportRepository.getByMonthAndSite(month, site);
    }

    /**
     *  Save report entity. CTR, CR, Fill rate and eCPM values are recalculated before the save.
     *  If a value can not be recalculated because of division by 0, this value is set to 0
     *  Report entity should be saved only via this method call, to make sure the consistency of
     *  CTR, CR, Fill rate and eCPM values
     */
    public ReportEntity save(ReportEntity reportEntity)
    {
        setCTR(reportEntity);
        setCR(reportEntity);
        setFillRate(reportEntity);
        setECPM(reportEntity);
        return reportRepository.save(reportEntity);
    }

    private void setCTR(ReportEntity reportEntity)
    {
        if (reportEntity.getImpressions() != 0)
        {
            Double ctr = (double)reportEntity.getClicks() / reportEntity.getImpressions() * 100;
            reportEntity.setCtr(Precision.round(ctr, DECIMAL_PRECISION));
        } else
        {
            reportEntity.setCtr(0.0);
        }
    }

    private void setCR(ReportEntity reportEntity)
    {
        if (reportEntity.getImpressions() != 0)
        {
            Double cr = (double)reportEntity.getConversions() / reportEntity.getImpressions() * 100;
            reportEntity.setCr(Precision.round(cr, DECIMAL_PRECISION));
        } else
        {
            reportEntity.setCr(0.0);
        }
    }

    private void setFillRate(ReportEntity reportEntity)
    {
        if (reportEntity.getRequests() != 0)
        {
            Double fillRate = (double)reportEntity.getImpressions() / reportEntity.getRequests() * 100;
            reportEntity.setFillRate(Precision.round(fillRate, DECIMAL_PRECISION));
        } else
        {
            reportEntity.setFillRate(0.0);
        }
    }

    private void setECPM(ReportEntity reportEntity)
    {
        if (reportEntity.getImpressions() != 0)
        {
            Double eCPM = (reportEntity.getRevenue() * 1000) / reportEntity.getImpressions();
            reportEntity.seteCPM(Precision.round(eCPM, DECIMAL_PRECISION));
        } else
        {
            reportEntity.seteCPM(0.0);
        }
    }
}
