/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashMap;

/**
 *
 * @author GoldCandy
 */
public class DoctorData {
    private String code;
    private String name;
    private String specialization;
    private int availability;
    private HashMap<String, DoctorData> hashMap = new HashMap();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public HashMap<String, DoctorData> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, DoctorData> hashMap) {
        this.hashMap = hashMap;
    }
}
