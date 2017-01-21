package testng111;

	import java.io.FileOutputStream;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.testng.annotations.Test;

	public class poiexp {
		@Test
		public void dataExport() throws Exception
		{
			FileOutputStream fos=new FileOutputStream("E:\\selenium\\testresults\\DataExport_POI.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook();
			XSSFSheet s=wb.createSheet("Results");
			Row r=s.createRow(0);
			r.createCell(0).setCellValue("Selenium");
			Row r1=s.createRow(1);
			r1.createCell(1).setCellValue("mouni");
			Row r2=s.createRow(2);
			r2.createCell(2).setCellValue("sing");
			wb.write(fos);
			fos.close();
		}

	}


