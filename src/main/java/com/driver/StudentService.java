package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        studentRepository.addStudentTeacherPair(student,teacher);
        List<Teacher> list = studentRepository.getAllTeachers();

    }
    public Student getStudentByName(String name) {
        List<Student> list = studentRepository.getAllStudents();
        for(Student s : list){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }
    public Teacher getTeacherByName(String name) {
        List<Teacher> list = studentRepository.getAllTeachers();
        for(Teacher t: list){
            if(t.getName().equals(name)){
                return t;
            }
        }
        return null;
    }
    public List<String> getStudentList(String name){
        return studentRepository.getAllStudentTeacherPairs(name);
    }
    public List<String> getAllStudents(){
        List<Student> list = studentRepository.getAllStudents();
        List<String> studentList = new ArrayList<>();
        for(Student student : list){
            studentList.add(student.getName());
        }
        return studentList;
    }
    public void deleteTeacherByName(String teacher) {
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeacher() {
        studentRepository.deleteAllTeacher();
    }
}
