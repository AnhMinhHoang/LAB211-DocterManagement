/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DoctorData;
import repository.DoctorRepository;
import view.Menu;

/**
 *
 * @author GoldCandy
 */
public class DoctorController extends Menu{
    protected static String[] mc = {"Add Doctor", "Update Doctor", 
                                    "Delete Doctor", "Search Doctor","Exit"};
    protected DoctorData doctor;
    protected DoctorRepository doctorRepository;
    
    public DoctorController(){
        super("========= Doctor Management ==========", mc);
        doctor = new DoctorData();
        doctorRepository = new DoctorRepository();
    }

    @Override
    public void execute(int choice) {
        switch(choice){
            case 1:{
                System.out.println("--------- Add Doctor ----------");
                doctorRepository.addDoctor(new DoctorData(), doctor.getHashMap());
                break;
            }
            case 2:{
                System.out.println("--------- Update Doctor -------");
                doctorRepository.updateDoctor(doctor.getHashMap());
                break;
            }
            case 3:{
                System.out.println("--------- Delete Doctor -------");
                doctorRepository.deleteDoctor(doctor.getHashMap());
                break;
            }
            case 4:{
                System.out.println("---------- Search Doctor --------");
                doctorRepository.searchDoctor(doctor.getHashMap());
                break;
            }
            case 5:{
                System.out.println("EXIT...");
                System.exit(0);
            }
            default:{
                System.out.println("No such choice!");
            }
        }
    }
}
