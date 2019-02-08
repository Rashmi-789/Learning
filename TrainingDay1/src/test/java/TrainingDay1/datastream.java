package TrainingDay1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class datastream {
	@Test
	public void testreadExcel()
	{
		
		File file = new File("src\\test\\resources\\testdata.xlsx");
		try
		{
			InputStream is= new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet1 = workbook.getSheet("Sheet1");
			for(int i = 1; i<=sheet1.getLastRowNum();i++)
			{
				for(int j= 0; j<sheet1.getRow(i).getPhysicalNumberOfCells();j++)
				{
					System.out.println(sheet1.getRow(i).getCell(j).getStringCellValue()+"\t\t");		
				}
				//System.out.println();
				//System.out.println(testdata.getRow(i).getCell(0).getStringCellValue());
				//System.out.println(testdata.getRow(i).getCell(1).getStringCellValue());
			}
			workbook.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

	


