package edu.agh.wfiis.solid.srp.example1.model;

import java.text.MessageFormat;

public class Constraint {

    private boolean required;

    private String pattern;

    private String defaultValue;

    private String name;


    public boolean validatePattern(String headerValue) {
        return pattern == null ? true : pattern.matches(headerValue);
    }
    public boolean validateIsHeaderRequired(String headerValue) {
        return headerValue == null && isHeaderRequired();
    }

    public boolean checkWhetherOverwriteByDefaultValue(String headerValue){
       return  headerValue == null && getDefaultValue() != null;
    }


    public String getDefaultValue() {
        return defaultValue;
    }

    public String getHeaderName() {
        return name;
    }

    public boolean isHeaderRequired() {
        return required;
    }

    public void setHeaderRequired(boolean required) {
        this.required = required;
    }

    public void setHeaderName(String name) {
        this.name = name;
    }
}
