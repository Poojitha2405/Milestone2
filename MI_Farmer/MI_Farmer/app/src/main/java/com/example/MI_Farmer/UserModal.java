package com.example.MI_Farmer;

public class UserModal {

    private String userName;

    private String phone;
    private String email;
    private String password;

    private String date;
    private int id;

    // creating getter and setter methods
    public String getUserName() { return userName; }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail() { return email; }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getDate() { return date; }

    public void setDate(String date)
    {
        this.date = date;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public UserModal(String id, String userName,
                     String email,
                     String phone, String password, String date)
    {
        this.id = Integer.parseInt(id);
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.date = date;
    }
}
