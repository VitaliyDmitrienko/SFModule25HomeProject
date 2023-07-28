// MAIN old implementation from Module 24.9 intermediate project (Student/University builder)
package org.example;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class XLSXFileReaderOld {
    public static ArrayList<Student> getStudentData() throws IOException {

        ArrayList<Student> studentDataStorage = new ArrayList<>();

        //read file "universityInfo.xlsx" from directory: \root\src\main\resources\
        FileInputStream fileXLSX = null;
        try {
            String fileName = "src\\main\\resources\\universityInfo.xlsx";
            fileXLSX = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

        // получаем экземпляр XSSFWorkbook для обработки xlsx файла
        XSSFWorkbook workbook = new XSSFWorkbook(fileXLSX);

        // выбираем первый лист для обработки
        // нумерация начинается из 0
        XSSFSheet sheet = workbook.getSheet("Студенты");

        // получаем Iterator по всем строкам в листе
//        Iterator<Row> rowIterator = sheet.rowIterator();
        Iterator<Row> iterator = sheet.rowIterator();

//        // получаем Iterator по всем ячейкам в строке
//        Iterator<Cell> cellIterator = row.cellIterator();

//        пропускаем заголовок таблицы 0-строку
        iterator.next();

//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//            // Get iterator to all cells of current row
//            Iterator<Cell> cellIterator = row.cellIterator();
//            Cell cells = cellIterator.next();
//
//            while (cellIterator.hasNext()) {

        while (iterator.hasNext()) {
            Row cells = iterator.next();
            if (cells.getCell(0) == null) {
                break;
            }

            if (cells.getCell(0) == null) {
                break;
            }

//            add new Student to List by abstract class
//            studentDataStorage.add(new Student(
//                    cells.getCell(1).getStringCellValue(),
//                    cells.getCell(0).getStringCellValue(),
//                    (int) cells.getCell(2).getNumericCellValue(),
//                    (float) cells.getCell(3).getNumericCellValue()));

//            add new Student to List by pattern "StudentBuilder" (class creator)
            studentDataStorage.add(new StudentBuilder ().setFullName ( cells.getCell(1).getStringCellValue() ).
                    setUniversityId ( cells.getCell(0).getStringCellValue() ).
                    setCurrentCourseNumber ( (int) cells.getCell(2).getNumericCellValue() ).
                    setAvgExamScore ( (float) cells.getCell(3).getNumericCellValue() ).
                    createStudent ());


        }

//                List<E> student = new ArrayList<E>();
//                result = null;
//                Cell cell = cellIterator.next();
//
//                // Change to getCellType() if using POI 4.x
//                CellType cellType = cell.getCellType();
//
//                switch (cellType) {
//                    case _NONE:
//                        System.out.print("");
//                        System.out.print("\t");
//                        break;
//                    case BOOLEAN:
//                        result += (cell.getBooleanCellValue());
//                        System.out.print(cell.getBooleanCellValue());
//                        System.out.print("\t");
//                        break;
//                    case BLANK:
//                        System.out.print("");
//                        System.out.print("\t");
//                        break;
//                    case FORMULA:
//                        // Formula
//                        System.out.print(cell.getCellFormula());
//                        System.out.print("\t");
//
//                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//                        // Print out value evaluated by formula
//                        System.out.print(evaluator.evaluate(cell).getNumberValue());
//                        break;
//                    case NUMERIC:
//                        result += (cell.getNumericCellValue());
////                        student.add(cell.getNumericCellValue());
//                        System.out.print("\t");
//                        break;
//                    case STRING:
//                        result += (cell.getStringCellValue());
//
//                        System.out.print(cell.getStringCellValue());
//                        System.out.print("\t");
//                        break;
//                    case ERROR:
//                        System.out.print("!");
//                        System.out.print("\t");
//                        break;
//                }
//
//            }
//
//            student.add(result);
//            System.out.println("");






        fileXLSX.close();
        System.out.println();

        return studentDataStorage;


    }



    public static ArrayList<University> getUniversityData () throws IOException {
        ArrayList<University> universityDataStorage = new ArrayList<>();

        //read file "universityInfo.xlsx" from directory: \root\src\main\resources\
        FileInputStream fileXLSX = null;
        try {
            String fileName = "src\\main\\resources\\universityInfo.xlsx";
            fileXLSX = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

        // получаем экземпляр XSSFWorkbook для обработки xlsx файла
        XSSFWorkbook workbook = new XSSFWorkbook(fileXLSX);

        // выбираем первый лист для обработки
        // нумерация начинается из 0
        XSSFSheet sheet = workbook.getSheet("Университеты");

        // получаем Iterator по всем строкам в листе
//        Iterator<Row> rowIterator = sheet.rowIterator();
        Iterator<Row> iterator = sheet.rowIterator();

//        // получаем Iterator по всем ячейкам в строке
//        Iterator<Cell> cellIterator = row.cellIterator();

//        пропускаем заголовок таблицы (0-строку)
        iterator.next();

        while (iterator.hasNext()) {
            Row cells = iterator.next();
            if (cells.getCell(0) == null) {
                break;
            }

            if (cells.getCell(0) == null) {
                break;
            }


//            add new University to List by abstract class
//            universityDataStorage.add(new University(
//                    cells.getCell(0).getStringCellValue(),
//                    cells.getCell(1).getStringCellValue(),
//                    cells.getCell(2).getStringCellValue(),
//                    (int) cells.getCell(3).getNumericCellValue(),
//                    StudyProfile.valueOf(cells.getCell(4).getStringCellValue())));

//            add new University to List by pattern "UniversityBuilder" (class creator)
            universityDataStorage.add(new UniversityBuilder().
                    setFullName(cells.getCell(1).getStringCellValue()).
                    setId(cells.getCell(0).getStringCellValue()).
                    setShortName(cells.getCell(2).getStringCellValue()).
                    setYearOfFoundation((int) cells.getCell(3).getNumericCellValue()).
                    setMainProfile(StudyProfile.valueOf(cells.getCell(4).getStringCellValue())).
                    createUniversity());

//            UniversityBuilder example creator from Module 24.9 Project
//                  University university1 = new UniversityBuilder ().setId ("1").
//                  setFullName ("University of Harvard").
//                  setShortName ("Harvard").
//                    setYearOfFoundation (1890).
//                    setMainProfile (StudyProfile.JURISPRUDENCE).createUniversity ();





        }

        fileXLSX.close();
        System.out.println();

        return universityDataStorage;

    }

}
