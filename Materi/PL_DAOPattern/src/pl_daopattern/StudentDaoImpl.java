/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl_daopattern;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anggasta
 */
public class StudentDaoImpl implements StudentDao{
    
    List<Student> students;
    
    StudentDaoImpl() {
        students = new ArrayList<Student>();
        students.add(new Student("Andre",0));
        students.add(new Student("Mario",1));
        students.add(new Student("Ifan",2));
    }

    
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudent(int rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void updateStudent(Student student) {
        students.get(student.getRollNo())
                .setName(student.getName());
        System.out.println("Update data succefuly !");
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student.getRollNo());
        System.out.println("Deleted From List !");
    }
    
}
