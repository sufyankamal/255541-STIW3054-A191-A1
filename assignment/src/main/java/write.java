
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class write {

    public void writeToexcel() {
        
        String excelFile = "excel file.xlsx";
        try {
            getlist list = new getlist();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("student");
            Row rowHeader = sheet.createRow(0);
            rowHeader.createCell(0).setCellValue("no");
            rowHeader.createCell(1).setCellValue("matric");
            rowHeader.createCell(2).setCellValue("name");

            for (int i = 0; i <= 2; i++) {
                CellStyle style = workbook.createCellStyle();
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                rowHeader.getCell(i).setCellStyle(style);
            }
            int j = 1;
            for (set info : list.getlist()) {
                Row row = sheet.createRow(j);
                Cell Column1 = row.createCell(0);
                Column1.setCellValue(info.getColumn1());
                Cell Column2 = row.createCell(1);
                Column2.setCellValue(info.getColumn2());
                Cell Column3 = row.createCell(2);
                Column3.setCellValue(info.getColumn3());
                j++;
            }
            for (int i = 1; i <= 35; i++) {
                sheet.autoSizeColumn(i);
            }
            FileOutputStream out = new FileOutputStream(new File("E:\\excel file.xls"));
            workbook.write(out);
            out.close();
            workbook.close();
            System.out.println(excelFile + " is written successfully.");
            
            
        } catch (IOException e) {
             System.out.println("Failed to write");

        }
    }
}
