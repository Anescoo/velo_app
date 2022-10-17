package com.formation.velo.api.data;

import java.util.Date;

@lombok.Data
public class Fields {
    private long available_bike_stands;
    private long bike_stands;
    private long number;
    private String address;
    private String name;
    private String bonus;
    private String banking;
    private String contract_name;
    private String status;
    private long available_bikes;
    private double[] position;
    private Date last_update;
}
