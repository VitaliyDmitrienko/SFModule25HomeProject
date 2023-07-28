// Module 25.9 intermediate project (XLSX-file reader)
package org.example;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Student> studentDataStorage = new ArrayList<>(XLSXFileReader.getStudentData());
        List<University> universityDataStorage = new ArrayList<>(XLSXFileReader.getUniversityData());

        for (Student student: studentDataStorage) {
            System.out.println(student);
        }
        System.out.println();

        for (University university: universityDataStorage) {
            System.out.println(university);
        }
        System.out.println();

    }
}