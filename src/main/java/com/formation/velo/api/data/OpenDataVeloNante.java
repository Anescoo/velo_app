package com.formation.velo.api.data;

@lombok.Data
public class OpenDataVeloNante {
    private long nhits;
    private Parameters parameters;
    private Record[] records;
    private String[] facetGroups;
}
