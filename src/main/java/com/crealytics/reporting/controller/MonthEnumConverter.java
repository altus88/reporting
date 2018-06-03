package com.crealytics.reporting.controller;

import com.crealytics.reporting.domain.Month;

import java.beans.PropertyEditorSupport;

public class MonthEnumConverter extends PropertyEditorSupport
{
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        Month month = Month.fromString(text);
        setValue(month);
    }
}