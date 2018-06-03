package com.crealytics.reporting.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "report")
public class ReportEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Month for which reporting data was collected
     */
    @NotNull(message = "Month should not be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "month", nullable = false)
    private Month month;

    /**
     * The site type where creatives were served
     */
    @NotNull(message = "Site should not be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "site", nullable = false)
    private Site site;

    /**
     * Number of requests for a creative or ad tag
     */
    @NotNull(message = "Requests should not be null")
    @PositiveOrZero(message = "Requests should not be negative")
    @Column(name = "requests", nullable = false)
    private Integer requests = 0;

    /**
     * Number of impressions (a creative served to a single user at a single point in time)
     */
    @NotNull(message = "Impressions should not be null")
    @PositiveOrZero(message = "Impressions should not be negative")
    @Column(name = "impressions", nullable = false)
    private Integer impressions = 0;

    /**
     * Number of clicks from users on served creatives
     */
    @NotNull(message = "Clicks should not be null")
    @PositiveOrZero(message = "Clicks should not be negative")
    @Column(name = "clicks", nullable = false)
    private Integer clicks = 0;

    /**
     * Number of conversions (when a user makes a purchase, or performs some other desired action in response to an ad)
     */
    @NotNull(message = "Conversions should not be null")
    @PositiveOrZero(message = "Conversions should not be negative")
    @Column(name = "conversions", nullable = false)
    private Integer conversions = 0;

    /**
     * Amount of money a publisher earned from ads showing. In US dollars
     */
    @NotNull(message = "Revenue should not be null")
    @PositiveOrZero(message = "Revenue should not be negative")
    @Column(name = "revenue", nullable = false)
    private Double revenue = 0.0;

    /**
     * Click-through rate.  Expressed as a percentage. Literally, the ratio of users who click on a specific
     * link to the number of total users who view an advertisement
     * (clicks ÷ impressions) × 100%
     */
    @NotNull(message = "Ctr should not be null")
    @PositiveOrZero(message = "Ctr should not be negative")
    @Column(name = "ctr")
    private Double ctr = 0.0;

    /**
     * Conversion rate. The ratio of conversions to the number of impressions
     * (conversions ÷ impressions) × 100%
     */
    @NotNull(message = "Cr should not be null")
    @PositiveOrZero(message = "Cr should not be negative")
    @Column(name = "cr", nullable = false)
    private Double cr = 0.0;

    /*
     * The ratio of impressions to the number of requests
     * (impressions ÷ requests) × 100%
     */
    @NotNull(message = "Fill rate should not be null")
    @PositiveOrZero(message = "Fill rate should not be negative")
    @Column(name = "fill_rate", nullable = false)
    private Double fillRate = 0.0;

    /*
     * Effective Cost Per Thousand. A translation from CPM, expressed as such from a publisher's point of view
     * (revenue × 1000) ÷ impressions
     */
    @NotNull(message = "eCPM should not be null")
    @PositiveOrZero(message = "eCPM should not be negative")
    @Column(name = "e_cpm", nullable = false)
    private Double eCPM = 0.0;



    public ReportEntity()
    {
        this.id = -1L;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Month getMonth()
    {
        return month;
    }

    public void setMonth(Month month)
    {
        this.month = month;
    }

    public Site getSite()
    {
        return site;
    }

    public void setSite(Site site)
    {
        this.site = site;
    }

    public Integer getRequests()
    {
        return requests;
    }

    public void setRequests(Integer requests)
    {
        this.requests = requests;
    }

    public Integer getImpressions()
    {
        return impressions;
    }

    public void setImpressions(Integer impressions)
    {
        this.impressions = impressions;
    }

    public Integer getClicks()
    {
        return clicks;
    }

    public void setClicks(Integer clicks)
    {
        this.clicks = clicks;
    }

    public Integer getConversions()
    {
        return conversions;
    }

    public void setConversions(Integer conversions)
    {
        this.conversions = conversions;
    }

    public Double getRevenue()
    {
        return revenue;
    }

    public void setRevenue(Double revenue)
    {
        this.revenue = revenue;
    }

    public Double getCtr()
    {
        return ctr;
    }

    public void setCtr(Double ctr)
    {
        this.ctr = ctr;
    }

    public Double getCr()
    {
        return cr;
    }

    public void setCr(Double cr)
    {
        this.cr = cr;
    }

    public Double getFillRate()
    {
        return fillRate;
    }

    public void setFillRate(Double fillRate)
    {
        this.fillRate = fillRate;
    }

    public Double geteCPM()
    {
        return eCPM;
    }

    public void seteCPM(Double eCPM)
    {
        this.eCPM = eCPM;
    }
}
