package com.crealytics.reporting.controller;

import com.crealytics.reporting.domain.Month;
import com.crealytics.reporting.domain.Site;

public class ReportNotFoundException extends RuntimeException
{
    public ReportNotFoundException(Month month, Site site)
    {
        super("Could not find report for '" + month.getName() + "' and '" + site.getName() + "'.");
    }
}
