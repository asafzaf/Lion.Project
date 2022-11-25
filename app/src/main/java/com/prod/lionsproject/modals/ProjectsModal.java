package com.prod.lionsproject.modals;

public class ProjectsModal {
    private int id;
    private String Name;
    private String Date;
    private int Date_day;
    private int Date_month;
    private int Date_year;
    private String Name_machon;
    private String Num_contract;
    private String Costumer_name;
    private String Costumer_phone;
    private String Costumer_email;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return Name; }

    public void  setName(String name) { this.Name = name; }

    public String getDate() { return Date; }

    public void setDate(String date) { this.Date = date; }

    public int getDate_day() { return  Date_day; }

    public void setDate_day(int date_day) { this.Date_day = date_day; }

    public int getDate_month() { return  Date_month; }

    public void setDate_month(int date_month) { this.Date_month = date_month; }

    public int getDate_year() { return  Date_year; }

    public void setDate_year(int date_year) { this.Date_year = date_year; }

    public String getName_machon() { return Name_machon; }

    public void setName_machon(String name_machon) { this.Name_machon = name_machon; }

    public String getNum_contract() { return Num_contract; }

    public void setNum_contract(String num_contract) { this.Num_contract = num_contract; }

    public String getCostumer_name() { return Costumer_name; }

    public void setCostumer_name(String costumer_name) { this.Costumer_name = costumer_name; }

    public String getCostumer_phone() { return Costumer_phone; }

    public void setCostumer_phone(String costumer_phone) { this.Costumer_phone = costumer_phone; }

    public String getCostumer_email() { return Costumer_email; }

    public void setCostumer_email(String costumer_email) { this.Costumer_email = costumer_email; }



    public ProjectsModal(int id, String name, String date, int date_day, int date_month, int date_year, String name_machon,  String num_contract, String costumer_name, String costumer_phone, String costumer_email){
        this.id = id;
        this.Name = name;
        this.Date = date;
        this.Date_day = date_day;
        this.Date_month = date_month;
        this.Date_year = date_year;
        this.Name_machon = name_machon;
        this.Num_contract = num_contract;
        this.Costumer_name = costumer_name;
        this.Costumer_phone = costumer_phone;
        this.Costumer_email = costumer_email;
    }

    public ProjectsModal(int id, String name){
        this.id = id;
        this.Name = name;
    }
}


