package preprocessing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import edu.stanford.nlp.io.EncodingPrintWriter.out;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;

/**
 * Permette di trasformare le frasi in minuscolo. Il metoddo della classe prende in input: 
 * -il path dove si trovano i files contenti le frasi da dare in input(path_input),
 * -il path dove si trovano i failes dove verranno inserite le frasi in minuscolo(path_output)
 * 
 * @author Giuliana Spinelli 
 * 
 *
 */



public class SentencesLowercase {

	public static void preprocessing_sentencesLowercase(String path_input,String path_output) throws Exception { 
		  
		ArrayList<String> frasi=new ArrayList<String>(); 
		String s;

		int i= 1;
		//String path_input = "periodi";
		File dir = new File(path_input);
		File[] directoryListing = dir.listFiles();
		System.out.println("Numero file: "+directoryListing.length);

		if (directoryListing != null) {
			for (File child : directoryListing) {
				
				//PrintWriter out = new PrintWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
				
			 			
				String path = path_input+"/periodo_"+i+".txt";
				Scanner sca= new Scanner(new File(path));//
				while(sca.hasNextLine()) //
				{
					s=sca.nextLine();
					s=s.toLowerCase();
					System.out.println(s);
					frasi.add(s);
					//printWriter.print(s);
					//printWriter.close();
					//out.print(s);
					//out.close();
						
				}//
				//out.close();
				 i++;
			}

				
			}		
	       i=1;
	       for(int io = 0; io < frasi.size(); io++)
		   				   
	       {
	    	   //String path_output="periodi_lowercase";
	    	   FileWriter fileWriter = new FileWriter(path_output+"/periodo"+"_"+i+".txt");
	   	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    	   //System.out.println(io+","+frasi.get(io));
	    	  
	    	   printWriter.print(frasi.get(io));
	    	   printWriter.close();
	    	i++;   
	       }	
	    
	    
	    System.out.println("DONE");
	       
		}

	
	
	/*public static void preprocessing_sentencesLowercase(String path) throws Exception {

	
	String s;

	int i= 1;

	File dir = new File("periodi");
	File[] directoryListing = dir.listFiles();
	System.out.println("Numero file: "+directoryListing.length);

	if (directoryListing != null) {
		for (File child : directoryListing) {
			
			//PrintWriter out = new PrintWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
			FileWriter fileWriter = new FileWriter("periodi_preprocessed_lowercase/periodo"+"_"+i+".txt");
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		 			
			//String path = "periodi/periodo_"+i+".txt";
			Scanner sca= new Scanner(new File(path));//
			while(sca.hasNextLine()) //
			{
				s=sca.nextLine();
				s=s.toLowerCase();
				System.out.println(s);
				printWriter.print(s);
				printWriter.close();
				//out.print(s);
				//out.close();
					
			}//
			//out.close();
			 i++;
		}

			//demoDP(lp,"C:/Users/Antonio/Desktop/sentence.txt");
		}
		System.out.println("DONE");
	}*/	
	
	
	
	
	
	

}