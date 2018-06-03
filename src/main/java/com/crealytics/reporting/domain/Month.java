package com.crealytics.reporting.domain;

import org.springframework.util.StringUtils;

public enum Month
{
    JANUARY("January", "1", "jan"),
    FEBRUARY("February", "2", "feb"),
    MARCH("March", "3", "mar"),
    APRIL("April", "4", "apr"),
    MAY("May", "5", "may"),
    JUNE("June", "6", "jun"),
    JULY("July", "7", "jul"),
    AUGUST("August", "8", "aug"),
    SEPTEMBER("September", "9", "sep"),
    OCTOBER("October" ,"10", "oct"),
    NOVEMBER("November", "11", "nov"),
    DECEMBER("December", "12", "dec");

    private String name;
    private String monthNumber;
    private String shortName;

    Month(String name, String monthNumber, String shortName)
    {
        this.name = name;
        this.monthNumber = monthNumber;
        this.shortName = shortName;
    }

    public static Month fromString(String input)
    {
        if(StringUtils.isEmpty(input))
        {
            throw new IllegalArgumentException("Month value should not be null");
        }

        String inputLowerCase = input.toLowerCase();
        for (Month month : Month.values())
        {
            if (month.getMonthNumber().equals(inputLowerCase) || month.getShortName().equals(inputLowerCase))
            {
                return month;
            }
        }

        throw new IllegalArgumentException("Unknown month value '" + input + "'");
    }

    public String getMonthNumber()
    {
        return monthNumber;
    }

    public void setMonthNumber(String monthNumber)
    {
        this.monthNumber = monthNumber;
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public String getName()
    {
        return name;
    }
}
