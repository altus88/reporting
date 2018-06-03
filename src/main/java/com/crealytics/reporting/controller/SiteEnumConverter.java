package com.crealytics.reporting.controller;

import com.crealytics.reporting.domain.Month;
import com.crealytics.reporting.domain.Site;

import java.beans.PropertyEditorSupport;

public class SiteEnumConverter extends PropertyEditorSupport
{
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        Site site = Site.fromString(text);
        setValue(site);
    }
}