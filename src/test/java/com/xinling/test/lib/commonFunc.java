package com.xinling.test.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class commonFunc {
	
	private String filepath = "testdata/TestData.xlsx";
	
	public List<POIExcel> read(){
		
		List<POIExcel> list = new ArrayList<POIExcel>();
		
		try {  
            FileInputStream file = new FileInputStream(filepath);  
            //Get sheet
            @SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);  
            XSSFSheet sheet = workbook.getSheetAt(0);  
            //Total Count of row
            int rowCount = sheet.getPhysicalNumberOfRows();
            
            //row loop, 
            for(int i=1; i<rowCount; i++){
            	Row row=sheet.getRow(i);
            	POIExcel excelObj=new POIExcel();
            	
            	excelObj.setNumber(row.getCell(0).getStringCellValue());
            	excelObj.setResult(row.getCell(1).getStringCellValue());
            	//System.out.println("-------------\n" +row.getCell(0).getStringCellValue()+"-"+row.getCell(1).getStringCellValue()+"\n");
            	list.add(excelObj);
            }
            file.close();
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
		return list;
	  
	}

//	public static void main(String[] args) {
//		commonFunc pwe = new commonFunc();
//		List<POIExcel> list = pwe.read();
//		for(POIExcel po:list){
//			System.out.print(po.getNumber());
//			System.out.println(po.getResult());
//		}
//	}
	 

}
