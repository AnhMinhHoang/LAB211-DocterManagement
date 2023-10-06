/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import data_access.DoctorDao;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;   
import model.DoctorData;

/**
 *
 * @author GoldCandy
 */
public class DoctorRepository implements IDoctorRepository{
    
    @Override
    public void addDoctor(DoctorData doctor, HashMap<String, DoctorData> hashMap){
        if(DoctorDao.Instance().addDoctor(doctor, hashMap)){
            System.out.println("Successful");
        }
        else{
            System.out.println("Code exist");
        }
    }
    
    @Override
    public void updateDoctor(HashMap<String, DoctorData> hashMap){
        if(hashMap.isEmpty()){
            System.out.println("No data on the list!");
            return;
        }
        display(hashMap);
        if(DoctorDao.Instance().updateDoctor(hashMap)){
            System.out.println("Succesful");
        }
        else{
            System.out.println("Code not found");
        }
    }
    
    @Override
    public void deleteDoctor(HashMap<String, DoctorData> hashMap){
        if(hashMap.isEmpty()){
            System.out.println("No data on the list!");
            return;
        }
        display(hashMap);
        if(DoctorDao.Instance().deleteDoctor(hashMap)){
            System.out.println("Successful");
        }
        else{
            System.out.println("Code not found");
        }
    }
    
    @Override
    public void searchDoctor(HashMap<String, DoctorData> hashMap){
        if(hashMap.isEmpty()){
            System.out.println("No data on the list!");
            return;
        }
        HashMap<String, DoctorData> newHashMap = DoctorDao.Instance().searchDoctor(hashMap);
        if(newHashMap.isEmpty()){
            System.out.println("Not found");
        }
        else{
            display(newHashMap);
        }
    }
    
    @Override
    public void display(HashMap<String, DoctorData> hashMap){
        Set<String> keySet = hashMap.keySet();
        System.out.printf("%-20s%-20s%-30s%s\n","Code","Name",
                            "Specialization","Availability");
        for(String key: keySet){
            System.out.printf("%-20s%-20s%-35s%d\n",hashMap.get(key).getCode()
                                    ,hashMap.get(key).getName(),
                                    hashMap.get(key).getSpecialization(),
                                    hashMap.get(key).getAvailability());
        }
    }
}
