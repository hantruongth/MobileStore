package edu.mum.wap.model;

public class User {
    private int id;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String address;
    private String phone;

    public User(int id, String userName, String password, String fullName, String email, String address, String phone) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String un){
        this.userName = un;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String pw){
        this.password = pw;
    }
}
