package org.westpac.util;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.*;


public class Read_TDExcel {


    public String actualvalue;
    public FileInputStream inputStream;
    public Workbook wb;
    public  Sheet sh;
    public  Row getSchool ;


//Read the row
    public void read(int rn) throws IOException, InvalidFormatException {

        inputStream = new FileInputStream(new File(Environment_Properties.work_book));
        wb = WorkbookFactory.create(inputStream);
        sh = wb.getSheet(Environment_Properties.work_sheet);
        getSchool = sh.getRow(rn);
    }

//Read the cell
    public String columnName(String a) throws EncryptedDocumentException {


        Row row = sh.getRow(0);
        int cellNum = row.getPhysicalNumberOfCells();
        for (int i = 0; i < cellNum; i++) {
            if ((row.getCell(i).toString()).equals(a)) {
                actualvalue = getSchool.getCell(i).toString();
            }
        }

        return actualvalue;
    }
}
