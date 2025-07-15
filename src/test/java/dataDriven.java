import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class dataDriven {
	// 1. Identify Testcase column by scanning the entire row.
	// 2. Once column is identified then scan entire test cases column to identify
	// purchase testcase.
	// 3. After we grab purchase testcase row, pull all the data of that row and
	// feed it into test.
	public ArrayList<String> getData(String testcaseName) throws IOException 
	{
		ArrayList<String> a=new ArrayList<>(); 
		FileInputStream fis = new FileInputStream("C://Users//Spoorthi//Documents//DemoDataAPI.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// 1. Identify Testcase column by scanning the entire row.
				Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows
				Row firstRow = rows.next();
				Iterator<Cell> ce = firstRow.cellIterator(); // row is collection of cells
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						// Desired column
						coloumn = k;
					}
					k++;
				}
				System.out.println(coloumn);

				// 2. Once column is identified then scan entire test cases column to identify
				// purchase testcase.
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						// 3. After we grab purchase testcase row, pull all the data of that row and feed it into test.
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
						Cell c	=cv.next();
						if(c.getCellType()==CellType.STRING)
						{
						a.add(c.getStringCellValue());
						}
						else {
						a.add(	NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
		return a;
	}
}
