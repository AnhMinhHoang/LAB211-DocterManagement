/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.HashMap;
import model.DoctorData;

/**
 *
 * @author GoldCandy
 */
public interface IDoctorRepository {
    
    public void addDoctor(DoctorData doctor, HashMap<String, DoctorData> hashMap);
    
    public void updateDoctor(HashMap<String, DoctorData> hashMap);
    
    public void deleteDoctor(HashMap<String, DoctorData> hashMap);
    
    public void searchDoctor(HashMap<String, DoctorData> hashMap);
    
    public void display(HashMap<String, DoctorData> hashMap);
}
