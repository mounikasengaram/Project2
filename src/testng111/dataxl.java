package testng111;

import java.io.FileOutputStream;

import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class dataxl {
	@Test
	public void dataExport() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("E:\\selenium\\testresults\\DataExport_JXL.xls");
		WritableWorkbook wwb = Workbook.createWorkbook(fos);
		WritableSheet ws1=wwb.createSheet("Results1",0);
		WritableSheet ws2=wwb.createSheet("Results2",0);
		Label l1=new Label(0,0,"Selenium");
		ws1.addCell(l1);
		Label l2=new Label(0,1,"Appium");
		ws1.addCell(l2);
		wwb.write();
		wwb.close();
	}
}