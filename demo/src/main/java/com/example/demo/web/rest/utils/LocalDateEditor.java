package com.example.demo.web.rest.utils;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateEditor extends PropertyEditorSupport {
        public String DATE_PATTERN() { return "MM-dd-yyyy"; }
        public LocalDate getLocalDateFromString(String date) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN());
                return !date.equals("") && !date.toLowerCase().equals("null") ? LocalDate.parse(date, formatter) : null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public String getAsText() throws IllegalArgumentException {
            return getValue().toString();
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(getLocalDateFromString(text));
        }
    }
