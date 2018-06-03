package com.crealytics.reporting.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class SiteTest
{
    @Test
    public void testFromString()
    {
        Site site = Site.fromString("ios");
        assertTrue(site.equals(Site.IOS));

        site = Site.fromString("desktop_web");
        assertTrue(site.equals(Site.DESKTOP_WEB));

        site = Site.fromString("Desktop_web");
        assertTrue(site.equals(Site.DESKTOP_WEB));

        site = Site.fromString("Desktop web");
        assertTrue(site.equals(Site.DESKTOP_WEB));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromStringUnknown()
    {
        Site.fromString("Desktopweb");
    }
}
