/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import model.DoctorData;

/**
 *
 * @author GoldCandy
 */
public class Validation {
    public String inputNonBlankString(String title) {
        String s = "";
        while (checkBlank(s)) {
            Scanner sc = new Scanner(System.in);
            System.out.print(title + ": ");
            s = sc.nextLine();
        }
        return s.trim();
    }
    
    public String inputString(String title){
        Scanner sc = new Scanner(System.in);
        System.out.print(title+": ");
        return sc.nextLine().trim();
    }
    
    public boolean checkBlank(String s){
        return s.isBlank() || s.isEmpty();
    }
    
    public String inputBlankableInt(String title){
        Scanner sc = new Scanner(System.in);
        String s;
        while(true){
            try{
                System.out.print(title+": ");
                s = sc.nextLine();
                if(checkBlank(s)) return s;
                int a = Integer.parseInt(s);
                return s.trim();
            }
            catch(NumberFormatException e){
                System.err.println("Enter digit or blank for unchange");
            }
        }
    }

    public int inputInt(String title) {
        int a = -1;
        while (a < 0) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(title + ": ");
                a = sc.nextInt();
            } catch (Exception e) {
                System.err.println("Please input integer");
                a = -1;
            }
        }
        return a;
    }
    
    public boolean checkID(HashMap<String, DoctorData> hashMap, String iD){
        Set<String> keySet = hashMap.keySet();
        for(String key: keySet){
            if(iD.matches(hashMap.get(key).getCode())) return true;
        }
        return false;
    }
}
