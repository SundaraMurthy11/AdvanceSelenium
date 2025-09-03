package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readMultipleDataFromExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis= new FileInputStream("D:\\MyWorkSpace\\ninzaCRM\\src\\test\\resources\\MultipleData.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet("Sheet1");
	 int row=sh.getLastRowNum();
	 System.out.println(row);
	 
	 for(int i=1;i<=row;i++) {
		 
		String mobile=sh.getRow(i).getCell(0).getStringCellValue();
		String brand= sh.getRow(i).getCell(1).getStringCellValue(); 
		 System.out.println(mobile +"---->"+brand);
	 }
}
}
