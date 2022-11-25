package com.prod.lionsproject.modals;

import java.util.Date;

public class ImpairmentsModal {
    private int id;
    private int project_id;
    private int visit_id;
    private String date;
    private int day;
    private int month;
    private int year;
    private String description;
    private String impairment;
    private int contact_id_1;
    private int contact_id_2;
    private boolean sent;
    private boolean done;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(int visit_id) {
        this.visit_id = visit_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() { return description; }
    public void setDescription( String description ) {this.description = description; }

    public int getContact_id_1() {
        return contact_id_1;
    }

    public String getImpairment() { return impairment; }
    public void setImpairment( String impairment ) { this.impairment = impairment; }

    public void setContact_id_1(int contact_id_1) {
        this.contact_id_1 = contact_id_1;
    }

    public int getContact_id_2() {
        return contact_id_2;
    }

    public void setContact_id_2(int contact_id_2) {
        this.contact_id_2 = contact_id_2;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public ImpairmentsModal(int id, int project_id, int visit_id, String date, int day, int month, int year, String description, String impairment, int contact_id_1, int contact_id_2, boolean sent, boolean done){
        this.id = id;
        this.project_id = project_id;
        this.visit_id = visit_id;
        this.date = date;
        this.day = day;
        this.month = month;
        this.year = year;
        this.description = description;
        this.impairment = impairment;
        this.contact_id_1 = contact_id_1;
        this.contact_id_2 = contact_id_2;
        this.sent = sent;
        this.done = done;
    }
}
