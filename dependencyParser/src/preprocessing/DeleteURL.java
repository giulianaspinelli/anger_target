package preprocessing;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

import edu.stanford.nlp.patterns.Pattern;

/**
 * Permette di eliminare gli URL dalle frasi. Il metoddo della classe prende in input: 
 * -il path dove si trovano i files contenti le frasi da dare in input(path_input),
 * -il path dove si trovano i failes dove verranno inserite le frasi senza URL(path_output)
 * 
 * @author Giuliana Spinelli 
 * 
 *
 */

public class DeleteURL {
	
	public static void preprocessing_deleteURL(String path_input,String path_output)  throws Exception { 
	  
		ArrayList<String> frasi=new ArrayList<String>(); 
		String s;

		int i= 1;
		//String path_input="periodi_lowercase";
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
					s=s.replaceAll("\\S+://\\S+", "");
					System.out.println(i+","+s);
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
	    	   
	    	 //String path_output="periodi_preprocessed_lowercase";
	    	 FileWriter fileWriter = new FileWriter(path_output+"/periodo"+"_"+i+".txt");
		       PrintWriter printWriter = new PrintWriter(fileWriter);
	    	   //System.out.println(io+","+frasi.get(io));
	    	  
	    	   printWriter.print(frasi.get(io));
	    	   printWriter.close();
	    	i++;   
	       }
		
		System.out.println("DONE");
		
		
		
		
		/*String description= "Not the only ones who've hit this nasty: http://dev.rubyonrails.org/ticket/7895";
       System.out.println(description.replaceAll("\\S+://\\S+", ""));*/
       
	}
	

	
  
	   
	
}
