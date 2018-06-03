package com.crealytics.reporting.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import org.springframework.util.StringUtils;

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

        if(StringUtils.isEmpty(input))
        {
            throw new IllegalArgumentException("Site value should not be empty");
        }

        String inputLowerCase = input.toLowerCase();

        for (Site site : Site.values())
        {
            if (site.toString().toLowerCase().equals(inputLowerCase) || site.getName().toLowerCase().equals(inputLowerCase))
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
