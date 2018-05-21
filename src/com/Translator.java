package com;


import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
public class Translator {
private static final String FILE_NAME = "C:\\Personal\\SVMX\\FileToConvert.xlsx";
private static final String FILE_NAME_CONVERTED = "C:\\Personal\\SVMX\\FileConvert.xlsx";
	 public static void main(String[] args) throws Exception 
	 {
		 try {

			 FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			 Workbook workbook = new XSSFWorkbook(excelFile);
			 XSSFWorkbook workbookr = new XSSFWorkbook();
			XSSFSheet sheetr = workbookr.createSheet("Datatypes in Java");
			 Sheet datatypeSheet = workbook.getSheetAt(0);
			 Iterator<Row> iterator = datatypeSheet.iterator();
			 DevClass varDev = new DevClass();
			 int rowNum = 0;
			 while (iterator.hasNext()) {

				 Row currentRow = iterator.next();
				 Iterator<Cell> cellIterator = currentRow.iterator();
				
				 while (cellIterator.hasNext()) {

					 Cell currentCell = cellIterator.next();
					 //getCellTypeEnum shown as deprecated for version 3.15
					 //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
					 
						 System.out.print(currentCell.getStringCellValue() + "--");
						 String word = varDev.callUrlAndParseResult("en", "da", currentCell.getStringCellValue());
						 Row row = sheetr.createRow(rowNum++);
						int colNum = 0;
					
						Cell cell = row.createCell(colNum++);
						
							cell.setCellValue(currentCell.getStringCellValue());
						Cell cell2 = row.createCell(colNum++);
							if(rowNum==1){
							cell2.setCellValue("Converted Value");	
							}else{
							cell2.setCellValue(word);
							}
						
					}

				 }
				try {
					FileOutputStream outputStream = new FileOutputStream(FILE_NAME_CONVERTED);
					workbookr.write(outputStream);
					workbookr.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				 System.out.println();

			 
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 ArrayList<String> al=new ArrayList<String>(); 
		 al.add("fr");
		 al.add("da");
	  DevClass varDev = new DevClass();
		  for(String languageVal:al){
			  //String word = varDev.callUrlAndParseResult("en", languageVal, "These Go code samples show you how to detect the language of text input and translate text using the Cloud Translation API.");
			  
			  //System.out.println(word);
		  }
	 }
 

}
