package edu.agh.wfiis.solid.srp.example1.model;

import java.util.ArrayList;
import java.util.List;

public class Constraints {

    private List<Constraint> headersConstraints = new ArrayList<>();

    public List<Constraint> getHeaderConstraints() {
        return headersConstraints;
    }

    public void add(List<Constraint> constraints) {
        headersConstraints.addAll(constraints);
    }

    public boolean validatePattern(String headerName, String headerValue) {
        for (Constraint constraint : headersConstraints) {
            if(headerName == constraint.getHeaderName() && constraint.validatePattern(headerValue) == false){
                return false;
            }
        }
        return true;
    }

    public boolean validateIsHeaderRequired(String headerName, String headerValue) {
        for (Constraint constraint : headersConstraints) {
            if(headerName == constraint.getHeaderName() && constraint.validateIsHeaderRequired(headerValue) == false){
                return false;
            }
        }
        return true;
    }
    public boolean checkWhetherOverwriteByDefaultValue(String headerName, String headerValue){
        for (Constraint constraint : headersConstraints) {
            if(headerName == constraint.getHeaderName() && constraint.checkWhetherOverwriteByDefaultValue(headerValue) == false){
                return false;
            }
        }
        return true;
    }
    public String getDefaultValue(String headerName){
        for (Constraint constraint : headersConstraints) {
            if(headerName == constraint.getHeaderName()){
                return constraint.getDefaultValue();
            }
        }
        return "";
    }

}