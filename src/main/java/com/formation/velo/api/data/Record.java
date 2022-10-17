package com.formation.velo.api.data;

@lombok.Data
public class Record {
    private String datasetid;
    private String recordid;
    private Fields fields;
    private Geometry geometry;
}
