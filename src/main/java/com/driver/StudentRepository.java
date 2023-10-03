package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashMap = new HashMap<>();
    HashMap<String,Teacher> teacherHashMap = new HashMap<>();
    HashMap<String, List<String>> pairHashMap = new HashMap<>();

    public void addStudent(Student student){
        studentHashMap.put(student.getName() , student);
    }
    public void addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName() , teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        List<String> list;
        if (pairHashMap.containsKey(teacher)) {
            list=pairHashMap.get(teacher);
        }else{
            list = new ArrayList<>();
        }
        list.add(student);
        pairHashMap.put(teacher,list);
    }
    public List<Student> getAllStudents(){
        List<Student> list = new ArrayList<>();
        for (Student student : studentHashMap.values()) {
            list.add(student);
        }
        return list;
    }
    public List<Teacher> getAllTeachers(){
        List<Teacher> list = new ArrayList<>();
        for (Teacher teacher : teacherHashMap.values()) {
            list.add(teacher);
        }
        return list;
    }
    public List<String> getAllStudentTeacherPairs(String name){
        //List<String> list = new ArrayList<>();
        for (List<String> strings : pairHashMap.values()) {
            if(pairHashMap.containsKey(name)){
                return pairHashMap.get(name);
            }
        }
        return null;
    }

    public void deleteTeacherByName(String teacher) {
        for(String key : teacherHashMap.keySet()){
            if(teacherHashMap.containsKey(teacher)){
                teacherHashMap.remove(key);
            }
        }
    }

}
