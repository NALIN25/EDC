package com.example.everydropcounts;



public class Donor {
    String name;
    String contactNumber;
    String city;
    String bloodGroup;
    public Donor(String name, String contactNumber, String bloodGroup, String city, String lat, String lng) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.bloodGroup = bloodGroup;
        this.city = city;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
