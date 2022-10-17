package com.formation.velo.api.data;

@lombok.Data
public class Parameters {
    private String[] dataset;
    private long rows;
    private long start;
    private String[] facet;
    private String format;
    private String timezone;
}
