package com.crealytics.reporting.controller;

import com.crealytics.reporting.domain.ReportEntity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ReportDTO
{
    private String month;

    private String site;

    private String request;

    private String impressions;

    private String clicks;

    private String conversions;

    private String revenue;

    private String ctr;

    private String cr;

    private String fillRate;

    private String eCPM;

    /**
     * Double values should have 2-digit precision
     */
    static DecimalFormat formatter;
    static
    {
        DecimalFormatSymbols separator = new DecimalFormatSymbols();
        separator.setDecimalSeparator('.');
        formatter = new DecimalFormat("#0.00", separator);
    }

    public ReportDTO(ReportEntity reportEntity)
    {
        this.month = reportEntity.getMonth().getName();
        this.site = reportEntity.getSite().getName();
        this.request = reportEntity.getRequests().toString();
        this.impressions = reportEntity.getImpressions().toString();
        this.clicks = reportEntity.getClicks().toString();
        this.conversions = reportEntity.getConversions().toString();
        this.revenue = formatter.format(reportEntity.getRevenue());
        this.ctr = formatter.format(reportEntity.getCtr());
        this.cr = formatter.format(reportEntity.getCr());
        this.fillRate = formatter.format(reportEntity.getFillRate());
        this.eCPM = formatter.format(reportEntity.geteCPM());
    }

    public String getMonth()
    {
        return month;
    }

    public void setMonth(String month)
    {
        this.month = month;
    }

    public String getSite()
    {
        return site;
    }

    public void setSite(String site)
    {
        this.site = site;
    }

    public String getRequest()
    {
        return request;
    }

    public void setRequest(String request)
    {
        this.request = request;
    }

    public String getImpressions()
    {
        return impressions;
    }

    public void setImpressions(String impressions)
    {
        this.impressions = impressions;
    }

    public String getClicks()
    {
        return clicks;
    }

    public void setClicks(String clicks)
    {
        this.clicks = clicks;
    }

    public String getConversions()
    {
        return conversions;
    }

    public void setConversions(String conversions)
    {
        this.conversions = conversions;
    }

    public String getRevenue()
    {
        return revenue;
    }

    public void setRevenue(String revenue)
    {
        this.revenue = revenue;
    }

    public String getCtr()
    {
        return ctr;
    }

    public void setCtr(String ctr)
    {
        this.ctr = ctr;
    }

    public String getCr()
    {
        return cr;
    }

    public void setCr(String cr)
    {
        this.cr = cr;
    }

    public String getFillRate()
    {
        return fillRate;
    }

    public void setFillRate(String fillRate)
    {
        this.fillRate = fillRate;
    }

    public String geteCPM()
    {
        return eCPM;
    }

    public void seteCPM(String eCPM)
    {
        this.eCPM = eCPM;
    }
}
