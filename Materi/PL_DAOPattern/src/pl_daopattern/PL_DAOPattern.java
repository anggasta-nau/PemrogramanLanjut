/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pl_daopattern;

import java.util.Scanner;

/**
 *
 * @author Anggasta
 */
public class PL_DAOPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       
        Scanner myObj = new Scanner(System.in);  
         String userName = myObj.nextLine(); 
        StudentDaoImpl studentDao = new StudentDaoImpl();
        for(Student student : studentDao.getAllStudents()){
            System.out.println("No. " + student.getRollNo()+" Student : " + student.getName());
        }
        
        
        
        Student student = studentDao.getStudent(2);
        student.setName(userName);
        studentDao.updateStudent(student);
        
        studentDao.getStudent(2);
        System.out.println("Update jadi : " + student.getName());
        System.out.println("No. " + student.getRollNo()+" Student : " + student.getName());
        
    }
    
}
