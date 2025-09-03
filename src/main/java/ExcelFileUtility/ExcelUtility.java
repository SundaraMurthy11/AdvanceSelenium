package ExcelFileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getExcelCellData(String sheetName,int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		
		
		FileInputStream fis= new FileInputStream("./TestData/TestScriptDatas.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
		
	}
}
