package com.kodacars.qa.uilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static Workbook workbook;

	public ExcelUtility(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(Paths.get(filePath).toFile());
		workbook = new XSSFWorkbook(fis);
	}

	public static String getCellData(String sheetName, int rowNumber, int cellNumber) {
		Sheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the Excel file.");
		}

		Row row = sheet.getRow(rowNumber);
		if (row == null) {
			throw new IllegalArgumentException("Row " + rowNumber + " does not exist in the sheet.");
		}

		Cell cell = row.getCell(cellNumber);
		if (cell == null) {
			throw new IllegalArgumentException(
					"Cell at row " + rowNumber + ", column " + cellNumber + " does not exist.");
		}

		// Handle different cell types
	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue();
	        case NUMERIC:
	            return String.valueOf(cell.getNumericCellValue()); // Convert numeric to string
	         case BLANK:
	            return ""; // Return an empty string if the cell is blank
	        default:
	            return "Unsupported Cell Type"; // Handle unexpected types
	    }
	}

	public static void close() throws IOException {
		workbook.close();
	}
	
	// Method to get the total number of rows in a sheet
    public static int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
        }
        return sheet.getLastRowNum(); // Returns the zero-based index of the last row
    }
    
    // Method to get the total number of columns in the first row of the sheet
    public static int getColumnCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
        }
        
        // Get the first row (usually contains headers)
        Row firstRow = sheet.getRow(0); // The first row is at index 0
        if (firstRow == null) {
            return 0; // No columns if there is no row
        }
        
        // Returns the number of cells in the first row
        return firstRow.getPhysicalNumberOfCells();
    }

    public static Object[][] getAllRows(String sheetName) {
	    try {
	      //  ExcelFileReader excelReader = new ExcelFileReader(ConfigFileReader.getExcelPath());
	    	//ConfigFileReader.getExcelPath();
	        int rowCount = getRowCount(sheetName);
	        int colCount = getColumnCount(sheetName);

	        Object[][] data = new Object[rowCount][1]; // Each row is a Map

	        for (int i = 1; i <= rowCount; i++) { // Assuming row 0 is the header
	            Map<String, String> rowData = new HashMap<>();
	            for (int j = 0; j < colCount; j++) {
	                String columnName = getCellData(sheetName, 0, j); // Column header
	                String cellValue = getCellData(sheetName, i, j); // Cell value
	                rowData.put(columnName, cellValue);
	            }
	            data[i - 1][0] = rowData; // Each row in the Object[][] array contains a Map
	        }
	        close();
	        return data;
	    } catch (IOException e) {
	        LoggerLoad.error("Failed to read data from Excel");
	        throw new RuntimeException("Failed due to IO error", e);
	    }
	}
    
    
    
}
