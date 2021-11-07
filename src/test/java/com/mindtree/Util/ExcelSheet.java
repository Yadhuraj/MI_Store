package com.mindtree.Util;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;


import com.mindtree.ResuableComponents.BaseClass;

public class ExcelSheet extends BaseClass {
	
	public static String Excelread(int rownum,int cellnum) throws IOException
	{
		
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = null;
		if(cell.getCellType()==CellType.STRING)
		{
			value= cell.getStringCellValue();
		}
		
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			value= ((int)cell.getNumericCellValue()+"");
		}
		return value;
	}
}
