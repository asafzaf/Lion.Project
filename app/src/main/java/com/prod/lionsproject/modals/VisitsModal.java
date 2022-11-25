package com.prod.lionsproject.modals;

import java.sql.Time;
import java.util.Date;

public class VisitsModal {
    private int id;
    private int project_id;
    private String date;
    private int day;
    private int month;
    private int year;
    private String start_t;
    private String end_t;
    private int start_time_H;
    private int start_time_M;
    private int end_time_H;
    private int end_time_M;
    private String description;
    private String total_t;
    private int total_time_H;
    private int total_time_M;
    private Double total_time_combined;


    public int getId() { return id; }
    public void setId( int ID ) { this.id = ID; }

    public int getProject_id() { return project_id; }
    public void setProject_id( int project_id ) { this.project_id = project_id; }

    public String getDate() { return date; }
    public void setDate( String date ) { this.date = date; }

    public int getDay() { return day; }
    public void setDay( int day ) { this.day = day; }

    public int getMonth() { return month; }
    public void setMonth( int month ) { this.month = month; }

    public int getYear() { return year; }
    public void setYear( int year ) { this.year = year; }

    public String getStart_t() { return start_t; }
    public void setStart_t( String  start_t ) { this.start_t = start_t; }

    public String  getEnd_t() { return  end_t; }
    public void setEnd_t( String  end_t ) { this.end_t = end_t;}

    public int getStart_time_H() { return start_time_H; }
    public void setStart_time_H( int start_time_H ) { this.start_time_H = start_time_H; }

    public int getStart_time_M() { return start_time_M; }
    public void setStart_time_M( int start_time_M ) { this.start_time_M = start_time_M; }

    public int getEnd_time_H() { return end_time_H; }
    public void setEnd_time_H( int end_time_H ) { this.end_time_H = end_time_H; }

    public int getEnd_time_M() { return end_time_M; }
    public void setEnd_time_M(int end_time_M) { this.end_time_M = end_time_M; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTotal_t() { return total_t; }
    public void setTotal_t( String  total_t) { this.total_t = total_t; }

    public int getTotal_time_H() { return total_time_H; }
    public void setTotal_time_H( int total_time_H ) { this.total_time_H = total_time_H; }

    public int getTotal_time_M() { return total_time_M; }
    public void setTotal_time_M( int total_tikme_M ) { this.total_time_M = total_tikme_M; }

    public Double getTotal_time_combined() { return total_time_combined; }
    public void setTotal_time_combined(Double total_time_combined) { this.total_time_combined = total_time_combined; }

    public VisitsModal(int id, int project_id, String date, int day, int month, int year,
                       String start_t, String end_t, int start_time_H, int start_time_M, int end_time_H, int end_time_M,
                       String description, String total_t, int total_time_H, int total_time_M, Double total_time_combined){
        this.id = id;
        this.project_id = project_id;
        this.date = date;
        this.day = day;
        this.month = month;
        this.year = year;
        this.start_t = start_t;
        this.end_t = end_t;
        this.start_time_H = start_time_H;
        this.start_time_M = start_time_M;
        this.end_time_H = end_time_H;
        this.end_time_M = end_time_M;
        this.description = description;
        this.total_t = total_t;
        this.total_time_H = total_time_H;
        this.total_time_M = total_time_M;
        this.total_time_combined = total_time_combined;
    }
}
