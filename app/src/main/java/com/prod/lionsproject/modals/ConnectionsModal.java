package com.prod.lionsproject.modals;

public class ConnectionsModal {
    private int id_project;
    private int id_contact;

    public int getId_project() { return id_project; }

    public void setId_project(int id_project) { this.id_project = id_project; }

    public int getId_contact() { return id_contact; }

    public void setId_contact(int id_contact) { this.id_contact = id_contact; }

    public ConnectionsModal(int id_project, int id_contact){
        this.id_project = id_project;
        this.id_contact = id_contact;
    }
}


