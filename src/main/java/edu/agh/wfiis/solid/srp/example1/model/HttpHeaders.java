package edu.agh.wfiis.solid.srp.example1.model;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class HttpHeaders {

    protected Constraints validationConstraints;
    private Map<String, Object> headers = new HashMap<>();


    HttpHeaders(Constraints validationConstraints){
        this.validationConstraints = validationConstraints;
    }

    public String getHeader(String headerName) {
        return (String) headers.get(headerName);
    }

    public void setHeader(String headerName, String headerValue) throws InvalidHeaderException {
        if(!validationConstraints.validateIsHeaderRequired(headerName, getHeader(headerName))){
            throw new InvalidHeaderException("Required header " + headerName + " not specified");
        }
        if (!validationConstraints.checkWhetherOverwriteByDefaultValue(headerName, headerValue)) {
            headerValue = validationConstraints.getDefaultValue(headerName);
        }
        if (!validationConstraints.validatePattern(headerName, headerValue)) {
            throw new InvalidHeaderException(MessageFormat.format("Invalid value format for header {0}.", headerName));
        }
        headers.put(headerName, headerValue);
    }




}
