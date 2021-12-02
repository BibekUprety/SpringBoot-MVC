package com.bibek.excel;

import com.bibek.excel.model.Customer;
import com.bibek.excel.model.CustomerAccount;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author bibek
 * @project excel
 * @project 30/11/2021 - 2:06 PM
 **/
@Service
@ToString
public class UserExcelImporter {

//   static String SHEET = "customer";

    public  List<Customer> excelSave(InputStream inputStream,String SHEET) throws IOException {
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheet(SHEET);
        Iterator<Row> rows = sheet.iterator();

        List<Customer> customers = new ArrayList<>();
        int rowNumber = 0;
        while (rows.hasNext()) {
            Row currentRow = rows.next();

            // skip header
            if (rowNumber == 0) {
                rowNumber++;
                continue;
            }

            Iterator<Cell> cellsInRow = currentRow.iterator();

            
            Customer customer = new Customer();
            CustomerAccount customerAccount = new CustomerAccount();
            int cellIdx = 0;
            while (cellsInRow.hasNext()) {
                Cell currentCell = cellsInRow.next();

                switch (cellIdx) {
                    case 0:
//                        customer.setId((int) currentCell.getNumericCellValue());
                        break;
                    case 1:
                        customer.setName(currentCell.getStringCellValue());
                        break;
                    case 2:
                        customer.setAddress(currentCell.getStringCellValue());
                        break;

                    default:
                        break;
                }
                cellIdx++;
                customers.add(customer);
            }
            workbook.close();

        }
        return customers;
    }
}
