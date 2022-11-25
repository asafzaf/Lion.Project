package com.prod.lionsproject.modals;

public class ContactsModal {
    private int id;
    private String Name;
    private String Profession;
    private String Phone;
    private String Email;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return Name; }

    public void setName(String name) { this.Name = name; }

    public String getProfession() { return Profession; }

    public void setProfession(String profession) { this.Profession = profession; }

    public String getPhone() { return Phone; }

    public void setPhone(String phone) { this.Phone = phone; }

    public String getEmail() { return Email; }

    public void setEmail(String email) { this.Email = email; }

    public ContactsModal(int id, String name, String profession, String phone, String email){
        this.id = id;
        this.Name = name;
        this.Profession = profession;
        this.Phone = phone;
        this.Email = email;
    }
}
