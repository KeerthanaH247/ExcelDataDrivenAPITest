import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	//1. Identify Testcase column by scanning the entire row.
	//2. Once column is identified then scan entire test cases column to identify purchase testcase.
	//3. After we grab purchase testcase row, pull all the data of that row and feed it into test. 
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Spoorthi\\Documents\\DemoDataAPI");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for(int i=0; i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);			}
			//1. Identify Testcase column by scanning the entire row.
			Iterator<Row> rows=sheet.iterator();
			rows.next();
		}
	}

}
