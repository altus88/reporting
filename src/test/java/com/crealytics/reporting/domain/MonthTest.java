package com.crealytics.reporting.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class MonthTest
{
    @Test
    public void testFromString()
    {
        Month month = Month.fromString("jan");
        assertTrue(Month.JANUARY.equals(month));

        month = Month.fromString("1");
        assertTrue(Month.JANUARY.equals(month));

        month = Month.fromString("JAN");
        assertTrue(Month.JANUARY.equals(month));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromStringValueNotExist()
    {
       Month.fromString("JANURY");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromStringNull()
    {
        Month.fromString(null);
    }
}
