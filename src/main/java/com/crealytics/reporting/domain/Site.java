package com.crealytics.reporting.domain;

public enum Site
{
    DESKTOP_WEB("desctop web"),
    MOBILE_WEB("mobile web"),
    ANDROID("android"),
    IOS("iOS");

    private String name;

    Site(String name)
    {
        this.name = name;
    }
}
