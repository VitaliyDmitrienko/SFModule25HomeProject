package org.example;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Student> studentDataStorage = new ArrayList<>(XLSXFileReader.getStudentData());
        List<University> universityDataStorage = new ArrayList<>();

        for (Student student: studentDataStorage) {
            System.out.println(studentDataStorage);
        }

//        XLSXFileReader.getStudentData();






    }
}