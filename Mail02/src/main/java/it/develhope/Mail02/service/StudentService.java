package it.develhope.Mail02.service;

import it.develhope.Mail02.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    static List<Student> studentList = Arrays.asList(
            new Student(1, "Antonio", "Quatrale", "antonio.quatrale93@gmail.com"),
            new Student(2, "Federica", "Di Feo", "federica.di.feo01@gmail.com"),
            new Student(3, "Mattia", "Mastromarco", "mattia@gmail.com"),
            new Student(4, "Enzo", "Verdi", "enzo@gmail.com")
    );

    public Student getById(Long id) {
        for (Student singleStudent : studentList) {
            if (singleStudent.getId() == id) {
                return singleStudent;
            }
        }
        return null;
    }


}





