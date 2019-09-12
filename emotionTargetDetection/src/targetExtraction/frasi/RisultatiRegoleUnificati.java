package targetExtraction.frasi;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.stanford.nlp.util.StringUtils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.io.FileInputStream;
 
public class RisultatiRegoleUnificati
{
	//public static void main(String args[]) throws Exception
	public static void targetUnificati(String nome_fileInput,String nomeFileOutput) throws Exception
    {
    	
 	/* codice che scrive un valore in una determinata cella
    	InputStream inp = new FileInputStream("C:/Users/giuli/Desktop/workbook.xlsx");
    	//InputStream inp = new FileInputStream("workbook.xlsx");
    	 
    	XSSFWorkbook workbook = new XSSFWorkbook(inp);
    	XSSFSheet sheet = workbook.getSheet("Risultati Regole");
    	XSSFRow row = sheet.getRow(0);
    	Cell cell = row.getCell(10);
    	if (cell == null)
    	    cell = row.createCell(10);
    	cell.setCellValue("a test");
    	 
    	// Write the output to a file
    	FileOutputStream fileOut = new FileOutputStream("C:/Users/giuli/Desktop/workbook.xlsx");
    	workbook.write(fileOut);
    	fileOut.close();*/
		
		//String nome_fileInput="TargetRiconosciutiDaRegole_preprocessed.xlsx"; //
		File fout = new File("risultatiRegoleUnificati/"+nome_fileInput); //
     	FileInputStream fis = new FileInputStream(fout);//
    	
		
    	//FileInputStream fis = new FileInputStream("risultatiRegoleUnificati/"+nome_fileInput);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Risultati Regole");
        XSSFRow row = sheet.getRow(0);
        
        File dir = new File("periodi");
		File[] directoryListing = dir.listFiles();
		System.out.println("Numero file: "+directoryListing.length);
 
        int col_targetMajority = -1;
        int col_Rule4 = -1; ///
        int col_Rule1 = -1;
        int col_Rule5 = -1;
        int col_Rule3 = -1;
        int col_Rule2 = -1;
        int col_Output = -1;
        String value_targetMajority=" ";
        String valueRule4=" "; ///
        String valueRule1=" ";
        String valueRule5=" ";
        String valueRule3=" ";
        String valueRule2=" ";
        String[] targetRule4;///
        String[] targetRule1;
        String[] targetRule5;
        String[] targetRule3;
        String[] targetRule2;
        String[] targetMajority;
        
       // String nomeFileOutput="TargetRiconosciutiDaRegole_preprocessed.xlsx";
        String percorsoFileOutput="risultatiRegoleUnificati/"+nomeFileOutput;
        String valoreDaInserire="";
       
 
        for(int i=0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals("Target - majority"))
            	col_targetMajority = i;
            if(row.getCell(i).getStringCellValue().trim().equals("R4"))///
            	col_Rule4 = i; ///
            if(row.getCell(i).getStringCellValue().trim().equals("R1"))
            	col_Rule1 = i;
            if(row.getCell(i).getStringCellValue().trim().equals("R5"))
            	col_Rule5 = i;
            if(row.getCell(i).getStringCellValue().trim().equals("R3"))
            	col_Rule3 = i;
            if(row.getCell(i).getStringCellValue().trim().equals("R2"))
            	col_Rule2 = i;
            if(row.getCell(i).getStringCellValue().trim().equals("Output"))
            	col_Output = i;
          
        }
     
        /*for(int g=1; g <= directoryListing.length; g++)  	
        {
        	 eliminaValoreCella(workbook,sheet,nomeFileOutput,g,col_Output);
        }*/
        
        
        
       for(int io=1; io <= directoryListing.length; io++)  	
        {
    	     
    	     row = sheet.getRow(io);
             XSSFCell cell = row.getCell(col_targetMajority);
             XSSFCell cellRule4 = row.getCell(col_Rule4); ///
             XSSFCell cellRule1 = row.getCell(col_Rule1);
             XSSFCell cellRule5 = row.getCell(col_Rule5);
             XSSFCell cellRule3 = row.getCell(col_Rule3);
             XSSFCell cellRule2 = row.getCell(col_Rule2);
             value_targetMajority = cell.getStringCellValue();   
             valueRule4= cellRule4.getStringCellValue();    
             valueRule1= cellRule1.getStringCellValue(); 
             valueRule5= cellRule5.getStringCellValue(); 
             valueRule3= cellRule3.getStringCellValue(); 
             valueRule2= cellRule2.getStringCellValue();
             
             eliminaValoreCella(workbook,sheet,percorsoFileOutput,io,col_Output);
             
             /*if(valueRule1!= value_targetMajority)
        	 scritturaValore(workbook,sheet,nomeFileOutput,"",io,col_Output);*/ 
             
             //contieneVirgola=primaStringa.contains(secondaStringa);
             targetRule4 = valueRule4.split(" "); ///
             targetRule1 = valueRule1.split(" ");
             targetRule5 = valueRule5.split(" ");
             targetRule3 = valueRule3.split(" ");
             targetRule2 = valueRule2.split(" ");
             //targetMajority = value_targetMajority.split(" "); 
             //targetMajority = value_targetMajority.split("[\\s.,\\(\\)\\...\\|]+");
             targetMajority = value_targetMajority.split("[\\s\\,\\(\\)\\|\\’]+");
            // boolean contieneVirgola=false;
             
           
             risultatiRegoleUnificati(workbook,sheet,percorsoFileOutput,col_Output,targetMajority,targetRule4,io,valoreDaInserire); ///
             
             
                /*for(int jo=0; jo <targetMajority.length ; jo++)   
                 { 
            		  for(int j=0; j <targetRule1.length ; j++) 
            	 	  			 
            		 {
            		        		 
            	
            		   if(targetMajority[jo].equals(targetRule1[j]))            			
            			{ 
               				 //System.out.println(io+","+targetMajority[jo]); 
                  		     //System.out.println(io+","+targetRule[j]); 
              			      //System.out.println(io+","+target_conVirgola);
                            System.out.println(io+","+targetRule1[j]+","+"R1");
               				valoreDaInserire=targetRule1[j];
               			    scritturaValore(workbook,sheet,nomeFileOutput,valoreDaInserire,io,col_Output);  
            			} */
            		//else   /////////////////vedere un po' come risolvere il problema creato che mi restituisce ora sia i target di R1 che di R4          			 
            		 
            		  /* XSSFRow row2 = sheet.getRow(io);
            	       Cell cell2 = row2.getCell(col_Output);
         
            	       if(!targetMajority[jo].equals(targetRule1[j])&&(cell2==null || cell2.getStringCellValue().equals("")|| cell2.getStringCellValue().equals(" "))&&j==targetRule1.length-1)  
            	       {
            	    	   scritturaValore(workbook,sheet,nomeFileOutput,"ciao",io,col_Output);  
            	       }*/
            	       
            	       
            	       
            	       /* if(cell2.getStringCellValue().equals(""))  
            	       //if(!targetMajority[jo].equals(targetRule1[j]) && (cell2==null || cell2.getStringCellValue().equals("")|| cell2.getStringCellValue().equals(" ")))  
            		   
            	       {
            			 for(int je=0; je <targetRule4.length ; je++)  	  			 
                		 {
            				 //System.out.println(io+","+"vuoto"); 
                			 if(targetMajority[jo].equals(targetRule4[je]))            			
                 			{ 
                				 //System.out.println(io+","+targetMajority[jo]); 
                       		     //System.out.println(io+","+targetRule[j]); 
                   			     // System.out.println(io+","+target_conVirgola);
                                 System.out.println(io+","+targetRule4[je]+","+"R4");
                      		     valoreDaInserire=targetRule4[je];
                      			 scritturaValore(workbook,sheet,nomeFileOutput,valoreDaInserire,io,col_Output);     
                      			
		
                 			}
                			 
                		 }
            		 }*/
            	  
     
                
            	 
            	  XSSFRow row2 = sheet.getRow(io);
        	      Cell cell2 = row2.getCell(col_Output);
     
        	       if(cell2==null || cell2.getStringCellValue().equals("")|| cell2.getStringCellValue().equals(" "))  
        	       {
        	    	   
        	    	   risultatiRegoleUnificati(workbook,sheet,percorsoFileOutput,col_Output,targetMajority,targetRule1,io,valoreDaInserire);
        	    	   
        	    	   //scritturaValore(workbook,sheet,nomeFileOutput,"ciao",io,col_Output); 
        	    	  /* for(int jo=0; jo <targetMajority.length ; jo++)   
                       {
        	    		   for(int je=0; je <targetRule4.length ; je++)  	  			 
                 		    {
             				 //System.out.println(io+","+"vuoto"); 
                 			 if(targetMajority[jo].equals(targetRule4[je]))            			
                  			{ 
                 				 //System.out.println(io+","+targetMajority[jo]); 
                        		     //System.out.println(io+","+targetRule[j]); 
                    			     // System.out.println(io+","+target_conVirgola);
                                  System.out.println(io+","+targetRule4[je]+","+"R4");
                       		     valoreDaInserire=targetRule4[je];
                       			 scritturaValore(workbook,sheet,nomeFileOutput,valoreDaInserire,io,col_Output);     
                            }
 
           	             }  
                       }*/
        	    	   
        	    	   
            	 
                     } 
        	       
        	       if(cell2==null || cell2.getStringCellValue().equals("")|| cell2.getStringCellValue().equals(" "))  
        	       {
        	    	   
        	    	   //scritturaValore(workbook,sheet,nomeFileOutput,"ciao",io,col_Output); 
        	    	   risultatiRegoleUnificati(workbook,sheet,percorsoFileOutput,col_Output,targetMajority,targetRule5,io,valoreDaInserire);
            	 
                     } 
        	       
        	       if(cell2==null || cell2.getStringCellValue().equals("")|| cell2.getStringCellValue().equals(" "))  
        	       {
        	    	   
        	    	   //scritturaValore(workbook,sheet,nomeFileOutput,"ciao",io,col_Output); 
        	    	   risultatiRegoleUnificati(workbook,sheet,percorsoFileOutput,col_Output,targetMajority,targetRule3,io,valoreDaInserire);
            	 
                     } 
        	       
        	       if(cell2==null || cell2.getStringCellValue().equals("")|| cell2.getStringCellValue().equals(" "))  
        	       {
        	    	   
        	    	//scritturaValore(workbook,sheet,nomeFileOutput,"ciao",io,col_Output,false); 
        	    	   risultatiRegoleUnificati(workbook,sheet,percorsoFileOutput,col_Output,targetMajority,targetRule2,io,valoreDaInserire);
        	    	   
                     } 
         } 
            	 
       }	
            

	public static void scritturaValore(XSSFWorkbook workbook, XSSFSheet sheet, String percorsoFileOutput, String valoreDaInserire,int numeroRiga, int numeroColonna,boolean contieneVirgola) throws IOException
	{
		

		//System.out.println(numeroRiga);
    	XSSFRow row2 = sheet.getRow(numeroRiga);
    	Cell cell2 = row2.getCell(numeroColonna);
    	String valorefinale;
    	if (cell2 == null)
    	    cell2 = row2.createCell(numeroColonna);
    	
    	
    		 if(cell2==null || cell2.getStringCellValue().equals("")|| cell2.getStringCellValue().equals(" "))
    		 {
    			// valoreDaInserire=valoreDaInserire.replace(" ","");
    			  cell2.setCellValue(valoreDaInserire);
    		 }
        	 else
        	 {
        		if(contieneVirgola==true)
        		{
        			
        			valorefinale=cell2.getStringCellValue()+","+" "+valoreDaInserire;
           		    cell2.setCellValue(valorefinale);
        		}
        		else
        		{
        		    //valorefinale="ciao"+"  "+valoreDaInserire;
        			valorefinale=cell2.getStringCellValue()+" "+valoreDaInserire;
             		cell2.setCellValue(valorefinale);
        		}
        	  
    	  }
    	
    	 
    	// Write the output to a file
    	//FileOutputStream fileOut = new FileOutputStream("C:/Users/giuli/Desktop/workbook.xlsx");
    	FileOutputStream fileOut = new FileOutputStream(percorsoFileOutput);
    	workbook.write(fileOut);
    	fileOut.close();
	}
	
	public static void eliminaValoreCella(XSSFWorkbook workbook, XSSFSheet sheet, String percorsoFileOutput,int numeroRiga, int numeroColonna) throws IOException
	{
		

		//System.out.println(numeroRiga);
    	XSSFRow row2 = sheet.getRow(numeroRiga);
    	Cell cell2 = row2.getCell(numeroColonna);
    	String valorefinale;
    	if (cell2 == null)
    	    cell2 = row2.createCell(numeroColonna);
         //cell2.setCellValue("");
         cell2.setBlank();
        
         //cell2.set.setCellValue(null);
    	//cell2.setCellValue();
    	
    	//valorefinale=cell2.getStringCellValue();
    
    	
    	
    	// Write the output to a file
    	//FileOutputStream fileOut = new FileOutputStream("C:/Users/giuli/Desktop/workbook.xlsx");
    	FileOutputStream fileOut = new FileOutputStream(percorsoFileOutput);
    	workbook.write(fileOut);
    	fileOut.close();
	}
	
	public static void risultatiRegoleUnificati(XSSFWorkbook workbook,XSSFSheet sheet,String percorsoFileOutput,int col_Output,String[] targetMajority,String[] targetRule,int io,String valoreDaInserire) throws IOException
	{

		String[] targetRuleSplit;
		boolean contieneVirgola;
		
		for(int jo=0; jo <targetMajority.length ; jo++)   
        { 
   		  for(int j=0; j <targetRule.length ; j++) 			 
   		 {
   		   //contieneVirgola=false;
   		   contieneVirgola=targetRule[j].contains(","); 
   		   targetRuleSplit=targetRule[j].split(",");
   		   
   		 for(int k=0; k <targetRuleSplit.length ; k++) 			 
   		 {
   			 
   			/*if(io==173)
			       
		    {
		    	System.out.println(io+","+valoreDaInserire);   
		    	System.out.println(targetMajority[jo]);
		    	System.out.println(targetRule[j]);
		    	System.out.println(targetRuleSplit[k]);
		    }*/
   			 
   			
   			if(targetMajority[jo].equals(targetRuleSplit[k]) && !targetRuleSplit[k].isEmpty() )            			
   			 { 
       				 //System.out.println(io+","+targetMajority[jo]); 
          		     //System.out.println(io+","+targetRule[j]); 
      			      //System.out.println(io+","+target_conVirgola);
    			        
    			    //valoreDaInserire=targetRuleSplit[k];
   				     valoreDaInserire=targetRuleSplit[k];
   		
    			    System.out.println(io+","+valoreDaInserire);   
     
    			    scritturaValore(workbook,sheet,percorsoFileOutput,valoreDaInserire,io,col_Output,contieneVirgola);
 
    			    
    			        } 
   		       }
   		   
   		   
   			}
	     }
       }
}
	
	
	

    

    	
    	
    	
    	
    	
    	
    	/* 
         * CODICE BUONO PER LEGGERE ELEMENTI DAL FOGLIO EXEL
         * FileInputStream fis = new FileInputStream("C:/Users/giuli/Desktop/prova.xlsx");
         XSSFWorkbook workbook = new XSSFWorkbook(fis);
         XSSFSheet sheet = workbook.getSheet("Risultati Regole");
         XSSFRow row = sheet.getRow(0);
         File dir = new File("periodi");
 		File[] directoryListing = dir.listFiles();
 		System.out.println("Numero file: "+directoryListing.length);
  
         int col_targetMajority = -1;
         int col_Rule = -1;
         String value_targetMajority="";
         String valueRule="";
         boolean isFound;
         boolean contieneVirgola;
         boolean target_conVirgola;
         String[] targetRule;
         String[] targetMajority;
         
         for(int i=0; i < row.getLastCellNum(); i++)
         {
             if(row.getCell(i).getStringCellValue().trim().equals("Target - majority"))
             	col_targetMajority = i;
           
         }
         
         for(int i=0; i < row.getLastCellNum(); i++)
         {
             if(row.getCell(i).getStringCellValue().trim().equals("R1"))
             	col_Rule = i;
           
         }
         
         for(int io=1; io <= directoryListing.length; io++)  	
         {
         	 row = sheet.getRow(io);
              XSSFCell cell = row.getCell(col_targetMajority);
              XSSFCell cellRule = row.getCell(col_Rule);
              value_targetMajority = cell.getStringCellValue();   
              valueRule= cellRule.getStringCellValue(); 
              targetRule = valueRule.split(","); 
              targetMajority = value_targetMajority.split(" "); 
              for(int j=0; j <targetRule.length ; j++)  	
                  {
             	   for(int jo=0; jo <targetMajority.length ; jo++)           			 
             		 {
             			 
             			 if(targetMajority[jo].equals(targetRule[j]))            			
             			{ 
                				 //System.out.println(io+","+targetMajority[jo]); 
                   		     //System.out.println(io+","+targetRule[j]); 
               			     // System.out.println(io+","+target_conVirgola);
                				System.out.println(io+","+targetRule[j]);  
             			}
             		 }                 
                  } 
             	 
             	
             
         }    
     }*/  
    	    
    
   
    	

    

	
	
	
	
  
	
 
