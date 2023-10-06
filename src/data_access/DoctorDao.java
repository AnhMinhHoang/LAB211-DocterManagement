/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access;

import common.Validation;
import java.util.HashMap;
import java.util.Set;
import model.DoctorData;

/**
 *
 * @author GoldCandy
 */
public class DoctorDao {

    private static DoctorDao instance = null;
    private Validation valid = new Validation();

    public static DoctorDao Instance() {
        if (instance == null) {
            synchronized (DoctorDao.class) {
                if (instance == null) {
                    instance = new DoctorDao();
                }
            }
        }
        return instance;
    }

    public boolean addDoctor(DoctorData doctor, HashMap<String, DoctorData> hashMap) {
        String code = valid.inputString("Enter Code");
        if (valid.checkID(hashMap, code)) {
            return false;
        }
        doctor.setCode(code);
        doctor.setName(valid.inputString("Enter Name"));
        doctor.setSpecialization(valid.inputString("Enter Specialization"));
        doctor.setAvailability(valid.inputInt("Enter Availability"));
        hashMap.put(code, doctor);
        return true;
    }

    public boolean updateDoctor(HashMap<String, DoctorData> hashMap) {
        String code = valid.inputString("Enter Code");
        if (!valid.checkID(hashMap, code)) {
            return false;
        }
        String name = valid.inputString("Enter Name(leave blank for unchange)");
        if (!valid.checkBlank(name)) {
            hashMap.get(code).setName(name);
        }
        String specialize = valid.inputString("Enter Specialization(leave blank for unchange)");
        if(!valid.checkBlank(specialize)){
            hashMap.get(code).setSpecialization(specialize);
        }
        String availability = valid.inputBlankableInt("Enter Availability(leave blank for unchange)");
        if(!valid.checkBlank(availability)){
            hashMap.get(code).setAvailability(Integer.parseInt(availability));
        }
        return true;
    }
    
    public boolean deleteDoctor(HashMap<String, DoctorData> hashMap){
        String code = valid.inputString("Enter Code");
        if (!valid.checkID(hashMap, code)) {
            return false;
        }
        hashMap.remove(code);
        return true;
    }
    
    public HashMap<String, DoctorData> searchDoctor(HashMap<String, DoctorData> hashMap){
        HashMap<String, DoctorData> newHashMap = new HashMap();
        Set<String> keySet = hashMap.keySet();
        String name = valid.inputNonBlankString("Enter name");
        for(String key: keySet){
            if(hashMap.get(key).getName().toLowerCase().contains(name.toLowerCase())){
                newHashMap.put(hashMap.get(key).getCode(), hashMap.get(key));
            }
        }
        return newHashMap;
    }
}
