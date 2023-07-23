package org.example;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class XLSXFileReader {
    public static ArrayList<Student> getStudentData() throws IOException {

        ArrayList<String> student = new ArrayList<String>();
        //read file "universityInfo.xlsx" from directory: \root\main\resources\
        String fileName = "src\\main\\resources\\universityInfo.xlsx";
        FileInputStream fileXLSX = new FileInputStream(fileName);

        // получаем экземпляр XSSFWorkbook для обработки xlsx файла
        XSSFWorkbook workbook = new XSSFWorkbook (fileXLSX);

        // выбираем первый лист для обработки
        // нумерация начинается из 0
        XSSFSheet sheet = workbook.getSheet("Студенты");

        // получаем Iterator по всем строкам в листе
        Iterator<Row> rowIterator = sheet.iterator();

//        // получаем Iterator по всем ячейкам в строке
//        Iterator<Cell> cellIterator = row.cellIterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();

            String result = null;
            while (cellIterator.hasNext()) {

//                List<E> student = new ArrayList<E>();
                result = null;
                Cell cell = cellIterator.next();

                // Change to getCellType() if using POI 4.x
                CellType cellType = cell.getCellType();

                switch (cellType) {
                    case _NONE:
//                        System.out.print("");
//                        System.out.print("\t");
                        break;
                    case BOOLEAN:
                        result += (cell.getBooleanCellValue());
//                        System.out.print(cell.getBooleanCellValue());
//                        System.out.print("\t");
                        break;
                    case BLANK:
//                        System.out.print("");
//                        System.out.print("\t");
                        break;
//                    case FORMULA:
//                        // Formula
//                        System.out.print(cell.getCellFormula());
//                        System.out.print("\t");
//
//                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
//                        // Print out value evaluated by formula
//                        System.out.print(evaluator.evaluate(cell).getNumberValue());
//                        break;
                    case NUMERIC:
                        result += (cell.getNumericCellValue());
//                        student.add(cell.getNumericCellValue());
//                        System.out.print("\t");
                        break;
                    case STRING:
                        result += (cell.getStringCellValue());

//                        System.out.print(cell.getStringCellValue());
//                        System.out.print("\t");
                        break;
                    case ERROR:
                        System.out.print("!");
                        System.out.print("\t");
                        break;
                }

            }
            student.add(result);
//            System.out.println("");
        }




        fileXLSX.close();
        System.out.println();

        return (Student)student;


    }



    public void getUniversityData () {

    }

}
