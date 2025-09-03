package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDataFromExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("D:\\MyWorkSpace\\ninzaCRM\\src\\test\\resources\\TestData.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh= wb.getSheet("Sheet1");
	Row row= sh.getRow(1);
	Cell cell= row.getCell(0);
	String UN=cell.getStringCellValue();
	
	Cell cell2=row.getCell(1);
	String PW=cell2.getStringCellValue();
	System.out.println(UN);
	System.out.println(PW);
}
}
