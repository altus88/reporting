package com.crealytics.reporting.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class ReportEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "site", nullable = false)
    private Site site;

    @Column(name = "requests", nullable = false)
    private Integer requests = 0;

    @Column(name = "impressions", nullable = false)
    private Integer impressions = 0;

    @Column(name = "clicks", nullable = false)
    private Integer clicks = 0;

    @Column(name = "conversions", nullable = false)
    private Integer conversions = 0;

    @Column(name = "revenue", nullable = false)
    private Float revenue = 0.0F;

    @Column(name = "ctr")
    private Float ctr = 0.0F;

    @Column(name = "cr", nullable = false)
    private Float cr = 0.0F;

    @Column(name = "fill_rate", nullable = false)
    private Float fillRate = 0.0F;

    @Column(name = "e_cpm", nullable = false)
    private Float eCPM = 0.0F;

    public ReportEntity()
    {
        this.id = -1L;
    }

    public Long getId()
    {
        return id;
    }

    public Site getSite()
    {
        return site;
    }

    public Integer getRequests()
    {
        return requests;
    }

    public Integer getImpressions()
    {
        return impressions;
    }

    public Integer getClicks()
    {
        return clicks;
    }

    public Integer getConversions()
    {
        return conversions;
    }

    public Float getRevenue()
    {
        return revenue;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setSite(Site site)
    {
        this.site = site;
    }

    public void setRequests(Integer requests)
    {
        this.requests = requests;
    }

    public void setImpressions(Integer impressions)
    {
        this.impressions = impressions;
    }

    public void setClicks(Integer clicks)
    {
        this.clicks = clicks;
    }

    public void setConversions(Integer conversions)
    {
        this.conversions = conversions;
    }

    public void setRevenue(Float revenue)
    {
        this.revenue = revenue;
    }

    public Float getCtr()
    {
        return ctr;
    }

    public void setCtr(Float ctr)
    {
        this.ctr = ctr;
    }

    public Float getCr()
    {
        return cr;
    }

    public void setCr(Float cr)
    {
        this.cr = cr;
    }

    public Float getFillRate()
    {
        return fillRate;
    }

    public void setFillRate(Float fillRate)
    {
        this.fillRate = fillRate;
    }

    public Float geteCPM()
    {
        return eCPM;
    }

    public void seteCPM(Float eCPM)
    {
        this.eCPM = eCPM;
    }
}
