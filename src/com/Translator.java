package com;
/*
 * This can support https://cloud.google.com/translate/docs/languages many languages
 * */

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
private static final String FILE_NAME_CONVERTED = "C:\\Personal\\SVMX\\";
	
	 public static void main(String[] args) throws Exception 
	 {
		 String convertedFileName="";
		 ArrayList<String> al=new ArrayList<String>(); 
		 
		 /*al.add("fr");//French
		 al.add("fi");//Finnish
		 al.add("es");//Spanish
		 al.add("de");//German
		 al.add("nl");//Dutch
		 al.add("ko");//Korean
		 al.add("ja");//Japanese
		 al.add("it");//Italian
		 al.add("sv");//Swedish
		 al.add("pt");//Portuguese (Portugal, Brazil)
		 al.add("zh-CN");//Chinese (Simplified)
		 al.add("zh-TW");//Chinese (Traditional)*/
		 for(String languageVal:al){
		 try {
			if(languageVal=="fr"){
				convertedFileName = "Converted French Values";
			}else if(languageVal=="fi"){
				convertedFileName = "Converted Finnish Values";
			}else if(languageVal=="es"){
				convertedFileName = "Converted Spanish Values";
			}else if(languageVal=="de"){
				convertedFileName = "Converted German Values";
			}else if(languageVal=="nl"){
				convertedFileName = "Converted Dutch Values";
			}else if(languageVal=="ko"){
				convertedFileName = "Converted Korean Values";
			}else if(languageVal=="ja"){
				convertedFileName = "Converted Japanese Values";
			}else if(languageVal=="it"){
				convertedFileName = "Converted Italian Values";
			}else if(languageVal=="sv"){
				convertedFileName = "Converted Swedish Values";
			}else if(languageVal=="pt"){
				convertedFileName = "Converted Portuguese Values";
			}else if(languageVal=="zh-CN"){
				convertedFileName = "Converted Chinese Simplified Values";
			}else if(languageVal=="zh-TW"){
				convertedFileName = "Converted Chinese Traditional Values";
			}else{
				convertedFileName = "Converted Values";
			}
			 FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			 Workbook workbook = new XSSFWorkbook(excelFile);
			 XSSFWorkbook workbookr = new XSSFWorkbook();
			XSSFSheet sheetr = workbookr.createSheet(convertedFileName);
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
						 String word = varDev.callUrlAndParseResult("en", languageVal, currentCell.getStringCellValue());
						 Row row = sheetr.createRow(rowNum++);
						int colNum = 0;
					
						Cell cell = row.createCell(colNum++);
						
							cell.setCellValue(currentCell.getStringCellValue());
						Cell cell2 = row.createCell(colNum++);
							if(rowNum==1){
							cell2.setCellValue(convertedFileName);	
							}else{
							cell2.setCellValue(word);
							}
						
					}

				 }
				try {
					FileOutputStream outputStream = new FileOutputStream(FILE_NAME_CONVERTED+convertedFileName+".xlsx");
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
	 }
	  
	 }
 

}
