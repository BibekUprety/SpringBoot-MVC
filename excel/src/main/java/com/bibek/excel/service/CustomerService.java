package com.bibek.excel.service;

import com.bibek.excel.UserExcelImporter;
import com.bibek.excel.dto.CustomerDTO;
import com.bibek.excel.model.Customer;
import com.bibek.excel.repo.CustomerRepo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author bibek
 * @project excel
 * @project 30/11/2021 - 11:59 AM
 **/
@Service
public class CustomerService {

    private UserExcelImporter userExcelImporter;
    private CustomerRepo customerRepo;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<CustomerDTO> customerDTOList;

    public CustomerService(CustomerRepo customerRepo,UserExcelImporter userExcelImporter,

                           List<CustomerDTO> customerDTOList) {
        this.customerRepo = customerRepo;
        this.userExcelImporter=userExcelImporter;
        this.customerDTOList = customerDTOList;
        workbook = new XSSFWorkbook();
    }

    public void writeHeaderLines(CustomerDTO customerDTO) {
        sheet = workbook.createSheet("customer");
        Row row = sheet.createRow(0);

        createCell(row, 0, "id");
        createCell(row, 1, "name");
        createCell(row, 2, "customerAccountDTOList");


    }

    private void createCell(Row row, int columnCount, Object value) {

        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }

    }


    public void export(HttpServletResponse response) throws IOException {

        ServletOutputStream servletOutputStream = response.getOutputStream();
        workbook.write(servletOutputStream);
        workbook.close();


    }

    public Customer save(CustomerDTO customerDTO) {

        return null;
    }

    public void saveCustomerSS(MultipartFile file,String sheet) throws IOException {


        List<Customer> customers= userExcelImporter.excelSave(file.getInputStream(),sheet);
        System.out.println(customers);

        customerRepo.saveAll(customers);
    }

}
