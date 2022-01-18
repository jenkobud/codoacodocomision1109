package models;

import java.sql.Date;

public class Partaker {
    private String names, lastnames, email, address, province;
    private Date registeredDate;
    private Integer id, age;

    public Partaker(int id, String names, String lastnames, int age, Date rDate, String province, String email, String address) {
        this.id = id;
        this.names = names;
        this.lastnames = lastnames;
        this.age = age;
        this.registeredDate = rDate;
        this.province = province;
        this.email = email;
        this.address = address;
    }

    public Partaker(){
        this.id = -1;
        this.names = "";
        this.lastnames = "";
        this.age = -1;
        this.registeredDate = null;
        this.province = "";
        this.email = "";
        this.address = "";
    }

    public String getProvince() { return province; }

    public void setProvince(String province) { this.province = province; }

    public Date getRegisteredDate() { return registeredDate; }

    public void setRegisteredDate(Date registeredDate) { this.registeredDate = registeredDate; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public String getNames() { return names; }

    public void setNames(String names) { this.names = names; }

    public String getLastnames() { return lastnames; }

    public void setLastnames(String lastnames) { this.lastnames = lastnames; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }
}
