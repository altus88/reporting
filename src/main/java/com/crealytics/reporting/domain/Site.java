package com.crealytics.reporting.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Site
{
    DESKTOP_WEB("desktop web"),
    MOBILE_WEB("mobile web"),
    ANDROID("android"),
    IOS("iOS");

    private String name;

    Site(String name)
    {
        this.name = name;
    }

    @JsonCreator
    public static Site fromString(String input) {

        if(input == null)
        {
            throw new IllegalArgumentException("Site value should not be null");
        }

        for (Site site : Site.values())
        {
            if (site.toString().toLowerCase().equals(input))
            {
                return site;
            }
        }

        throw new IllegalArgumentException("Unknown site value: '" + input + "'");
    }

    public String getName()
    {
        return name;
    }
}
