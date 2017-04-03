package utility;
            import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import pageObjects.BaseClass;


    public class ExcelUtils {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                private static XSSFCell Cell;
                private static XSSFRow Row;
                
                static FormulaEvaluator evaluator ;
                
              
               
            //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
            public static void setExcelFile(String Path,String SheetName) throws Exception {
                   try {
                       // Open the Excel file
                    FileInputStream ExcelFile = new FileInputStream(Path);
                    // Access the required test data sheet
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
                    ExcelWSheet = ExcelWBook.getSheet(SheetName);
                    
                      evaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();
                    System.out.println(SheetName);
//                    Log.info("Excel sheet opened");
                    } catch (Exception e){
                     e.printStackTrace();
                     System.out.println(e.getMessage());
                    }
            }
            //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
            public static String getCellData(int RowNum, int ColNum) throws Exception{
                   try{
                	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                	  
                	  String CellData =" ";

//						Cell.setCellType(Cell.CELL_TYPE_STRING);
                       
                      int cellType = Cell.getCellType();
                      
					if (cellType == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC) {
						if(DateUtil.isCellDateFormatted(Cell)){
							
							
							SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
							
							CellData =  sdf.format(Cell.getDateCellValue());
							
							System.out.println(CellData+"into date");
							}
						else{
							double value= Cell.getNumericCellValue() ;
							
							CellData =value+"" ;

						}
					}
					else if (cellType == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING) {
								
						
						CellData= Cell.getStringCellValue() ;
						
								
					}
                      
                      return CellData;
                      }catch (Exception e){
//                    	  e.printStackTrace();
//                    	  System.out.println(e);
                        return"";
                      }
            }
            //This method is to write in the Excel cell, Row num and Col num are the parameters
            @SuppressWarnings("static-access")
			public static void setCellData(String Result,  int RowNum, int ColNum, String sheetname) throws Exception    {
                   try{
                	   
                	   ExcelWSheet = ExcelWBook.getSheet(sheetname);
                      Row  = ExcelWSheet.getRow(RowNum);
                    Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
                    if (Cell == null) {
                        Cell = Row.createCell(ColNum);
                        Cell.setCellValue(Result);
                        } else {
                            Cell.setCellValue(Result);
                        }
          // Constant variables Test Data path and Test Data file name
                          FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
                          ExcelWBook.write(fileOut);
//                          fileOut.flush();
                        fileOut.close();
                        ExcelWBook = new XSSFWorkbook(new FileInputStream(Constant.Path_TestData+Constant.File_TestData));
                        
                        }catch(Exception e){
                        	
                        	 BaseClass.bResult = false;
                        	 System.out.println("Class Utils | Method setExcelFile | setCellData : "+e.getMessage());
                        	 e.printStackTrace();
                    }
                }
            
        	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
        		int i,j=0;
        		
        		try {
        			int rowCount = ExcelUtils.getRowUsed();
        			
        			System.out.println("Into getRowContains"+sTestCaseName);
//        			int rowCount =	ExcelWSheet.getLastRowNum();
        			
        			System.out.println("row count="+rowCount);
        			 
        			for ( i=0 ; i<rowCount; i++){
        				if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
        					   j++;
        					break;
        				}
        				
        			}
        			if(j==0){
        				
        				System.out.println("test case not found");
        				return 0;
        			}
        			else{
        			
        				return i;
        				}
        			
        				}catch (Exception e){
        			Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
        			throw(e);
        			}
        		}
        //////////////////////////////////////
        	
        	
        	public static int getRowCount(String SheetName){
        		int iNumber=0;
        		try {
        			ExcelWSheet = ExcelWBook.getSheet(SheetName);
        			iNumber=ExcelWSheet.getLastRowNum()+1;
        		} catch (Exception e){
//        			Log_messaage.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
        			BaseClass.bResult = false;
        			}
        		return iNumber;
        		}
        	
        	
        	
        	public static void readSheetContent(XSSFSheet sheet){
        		
        		Iterator<Row> rowIterator = sheet.iterator(); // sh.rowIterator(); -- also works well
    			
    			while (rowIterator.hasNext()) 
    			{
    				Row row = rowIterator.next();
    				//For each row, iterate through all the columns
    				Iterator<Cell> cellIterator = row.cellIterator();
    				
    				while (cellIterator.hasNext()) 
    				{
    					Cell cell = cellIterator.next();
    					int cellType = cell.getCellType();
						if (cellType == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC) {
							
							System.out.print(cell.getNumericCellValue() + "\t");
						} else if (cellType == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING) {
							
							System.out.print(cell.getStringCellValue() + "\t");
						}
    				    else if (cellType == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA) {
						
						System.out.print(cell.getStringCellValue() + "\t");
				
    				    }
					
    				}
    				System.out.println("");
    			}
        		
        		}
        	
        	
        	
        	////////////////////////////////////////////
        	
        	public static  Object[][] retrieveTestData(String wsName)
        	{
        		int sheetIndex=ExcelWBook.getSheetIndex(wsName);
        		
        		if(sheetIndex==-1)
        			return null;
        		else{
        				int rowNum = getRowCount(wsName);
        				int colNum = retrieveNoOfCols(wsName);
        		
        				Object data[][] = new Object[rowNum-1][colNum-2];
        		
        				for (int i=0; i<rowNum-1; i++){
        				
        					XSSFRow row = ExcelWSheet.getRow(i+1);
        					
        					for(int j=0; j< colNum-2; j++){					
        						
        						if(row==null){
        							
        							data[i][j] = " ";
        						}
        						else{
        						
        							XSSFCell cell = row.getCell(j);	
        					     if(cell==null){
        								data[i][j] = "";							
        							}
        							
        					     else{
        								
        								cell.setCellType(Cell.CELL_TYPE_STRING);
        								
        								String value = cellToString(cell);
        								
        								data[i][j] = value;						
        							 }
        						}
        					}				
        				}					
        				return data;		
        		}
        	}
        	
  ////////////////////////////////////////////////////////////////
        	
        	public static String cellToString(XSSFCell cell2){
        		int type;
        		
        		Object result;
        		type = cell2.getCellType();			
        		switch (type){
        			case 0 :
        				result = cell2.getNumericCellValue();
        				break;
        				
        			case 1 : 
        				result = cell2.getStringCellValue();
        				break;
        				
        			default :
        				throw new RuntimeException("Unsupportd cell.");			
        		}
        		return result.toString();
        	}
        	//////////////////////////////////
        	
        	public static int retrieveNoOfCols(String wsName){
        		int sheetIndex=ExcelWBook.getSheetIndex(wsName);
        		if(sheetIndex==-1){
        			return 0;
        		}
        			
        		else{
        			ExcelWSheet = ExcelWBook.getSheetAt(sheetIndex);
        			int colCount=ExcelWSheet.getRow(0).getLastCellNum();			
        			return colCount;
        		}
        	}

        	////////////////////////////////
        	
        	public static int getRowUsed() throws Exception {
        		try{
        			
        			int RowCount = ExcelWSheet.getLastRowNum();
        			Log.info("Total number of Row used return as < " + RowCount + " >.");		
        			return RowCount;
        			
        		}catch (Exception e){
        			Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());
        			System.out.println(e.getMessage());
        			throw (e);
        		}

        	}
    }