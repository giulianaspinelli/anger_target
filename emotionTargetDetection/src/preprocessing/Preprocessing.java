package preprocessing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Il metodo sentencesLowercase permette di trasformare le frasi in minuscolo. Il metodo della classe prende in input: 
 * -il nome della cartella dove si trovano i files contenti le frasi da dare in input(path_input),
 * -il nome della cartella dove si trovano i files dove verranno inserite le frasi in minuscolo(path_output)
 * 
 * Il metodo deleteURL permette di eliminare gli URL dalle frasi. Il metodo della classe prende in input: 
 * -il nome della cartella dove si trovano i files contenti le frasi da dare in input(path_input),
 * -il nome della cartella dove si trovano i files dove verranno inserite le frasi senza URL(path_output)
 * 
 * Il metodo minus_one permette di sostituire -1 con minus_one nelle frasi. Il metodo della classe prende in input: 
 * -il nome della cartella dove si trovano i files contenti le frasi da dare in input(path_input),
 * -il nome della cartella dove si trovano i files dove verranno inserite le frasi dove si è sostituito -1 con minus_one(path_output)
 * 
 * Il metodo deleteDash permette di eliminare - nelle frasi. Il metodo della classe prende in input: 
 * -il nome della cartella dove si trovano i files contenti le frasi da dare in input(path_input),
 * -il nome della cartella dove si trovano i files dove verranno inserite le frasi dove si è eliminato - (path_output)
 * 
 * Il metodo deleteParentesiGraffe permette di eliminare {} nelle frasi. Il metodo della classe prende in input: 
 * -il nome della cartella dove si trovano i files contenti le frasi da dare in input(path_input),
 * -il nome della cartella dove si trovano i files dove verranno inserite le frasi dove si è eliminato {} (path_output)
 *
 * Il metodo deleteParentesiQuadre permette di eliminare [] nelle frasi. Il metodo della classe prende in input: 
 * -il nome della cartella dove si trovano i files contenti le frasi da dare in input(path_input),
 * -il nome della cartella dove si trovano i files dove verranno inserite le frasi dove si è eliminato [] (path_output)
 * 
 * Il metodo deleteParentesiTonde permette di eliminare () nelle frasi. Il metodo della classe prende in input: 
 * -il nome della cartella dove si trovano i files contenti le frasi da dare in input(path_input),
 * -il nome della cartella dove si trovano i files dove verranno inserite le frasi dove si è eliminato () (path_output)
 * 
 * @author Giuliana Spinelli 
 * 
 *
 */


public class Preprocessing {
	
	public static String sentencesLowercase(String nomeCartella_input,String nomeCartella_output) throws Exception { 
		  
		ArrayList<String> frasi=new ArrayList<String>(); 
		String s;

		int i= 1;
		//String path_input = "periodi";
		File dir = new File(nomeCartella_input);
		File[] directoryListing = dir.listFiles();
		System.out.println("Numero file: "+directoryListing.length);

		if (directoryListing != null) {
			for (File child : directoryListing) {
				
				//PrintWriter out = new PrintWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
				
			 			
				String path = nomeCartella_input+"/periodo_"+i+".txt";
				Scanner sca= new Scanner(new File(path));//
				while(sca.hasNextLine()) //
				{
					s=sca.nextLine();
					s=s.toLowerCase();
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
	    	   //String path_output="periodi_lowercase";
	    	   FileWriter fileWriter = new FileWriter(nomeCartella_output+"/periodo"+"_"+i+".txt");
	   	       PrintWriter printWriter = new PrintWriter(fileWriter);
	    	   //System.out.println(io+","+frasi.get(io));
	    	  
	    	   printWriter.print(frasi.get(io));
	    	   printWriter.close();
	    	i++;   
	       }	
	    
	    
	    System.out.println("DONE");
	    return nomeCartella_output;     
		}
	
	
	public static String deleteURL(String nomeCartella_input,String nomeCartella_output)  throws Exception { 
		  
		ArrayList<String> frasi=new ArrayList<String>(); 
		String s;

		int i= 1;
		//String path_input="periodi_lowercase";
		File dir = new File(nomeCartella_input);
		File[] directoryListing = dir.listFiles();
		System.out.println("Numero file: "+directoryListing.length);

		if (directoryListing != null) {
			for (File child : directoryListing) {
				
				//PrintWriter out = new PrintWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
					 			
				String path = nomeCartella_input+"/periodo_"+i+".txt";
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
	    	 FileWriter fileWriter = new FileWriter(nomeCartella_output+"/periodo"+"_"+i+".txt");
		       PrintWriter printWriter = new PrintWriter(fileWriter);
	    	   //System.out.println(io+","+frasi.get(io));
	    	  
	    	   printWriter.print(frasi.get(io));
	    	   printWriter.close();
	    	i++;   
	       }
		
		System.out.println("DONE");
		return nomeCartella_output;       
	}	
	
	public static String minus_one(String nomeCartella_input,String nomeCartella_output) throws IOException{
	       
		ArrayList<String> frasi=new ArrayList<String>(); 
			String s;
			

			int i= 1;
			//String path_input="periodi_preprocessed_lowercase";
			File dir = new File(nomeCartella_input);
			File[] directoryListing = dir.listFiles();
			System.out.println("Numero file: "+directoryListing.length);

			if (directoryListing != null) {
				for (File child : directoryListing) {
					
					//PrintWriter out = new PrintWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
					
				 			
					String path = nomeCartella_input+"/periodo_"+i+".txt";
					Scanner sca= new Scanner(new File(path));//
					while(sca.hasNextLine()) //
					{
						s=sca.nextLine();
						s=s.replace("-1 ","minus_one ");
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
		    	   FileWriter fileWriter = new FileWriter(nomeCartella_output+"/periodo"+"_"+i+".txt");
			       PrintWriter printWriter = new PrintWriter(fileWriter);
		    	   //System.out.println(io+","+frasi.get(io));
		    	  
		    	   printWriter.print(frasi.get(io));
		    	   printWriter.close();
		    	i++;   
		       }
		       
			
				System.out.println("DONE");
				return nomeCartella_output;	
	}
	
	public static String deleteDash(String nomeCartella_input,String nomeCartella_output) throws IOException{
	       
		ArrayList<String> frasi=new ArrayList<String>(); 
			String s;
			

			int i= 1;
			//String path_input="periodi_preprocessed_lowercase";
			File dir = new File(nomeCartella_input);
			File[] directoryListing = dir.listFiles();
			System.out.println("Numero file: "+directoryListing.length);

			if (directoryListing != null) {
				for (File child : directoryListing) {
					
					//PrintWriter out = new PrintWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
					
				 			
					String path = nomeCartella_input+"/periodo_"+i+".txt";
					Scanner sca= new Scanner(new File(path));//
					while(sca.hasNextLine()) //
					{
						s=sca.nextLine();
						s=s.replace("-","");
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
		    	   FileWriter fileWriter = new FileWriter(nomeCartella_output+"/periodo"+"_"+i+".txt");
			       PrintWriter printWriter = new PrintWriter(fileWriter);
		    	   //System.out.println(io+","+frasi.get(io));
		    	  
		    	   printWriter.print(frasi.get(io));
		    	   printWriter.close();
		    	i++;   
		       }
		       
			
				System.out.println("DONE");
				return nomeCartella_output;	
	}		
	
	public static String deleteParentesiGraffe(String nomeCartella_input,String nomeCartella_output) throws IOException{
	       
		ArrayList<String> frasi=new ArrayList<String>(); 
			String s;
			String s2;
			

			int i= 1;
			//String path_input="periodi_preprocessed_lowercase";
			File dir = new File(nomeCartella_input);
			File[] directoryListing = dir.listFiles();
			System.out.println("Numero file: "+directoryListing.length);

			if (directoryListing != null) {
				for (File child : directoryListing) {
					
					//PrintWriter out = new PrintWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
					
				 			
					String path = nomeCartella_input+"/periodo_"+i+".txt";
					Scanner sca= new Scanner(new File(path));//
					while(sca.hasNextLine()) //
					{
						s=sca.nextLine();
						s=s.replace("{","");
						s2=s;
						s2=s2.replace("}","");
						System.out.println(i+","+s2);
						frasi.add(s2);
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
		    	   FileWriter fileWriter = new FileWriter(nomeCartella_output+"/periodo"+"_"+i+".txt");
			       PrintWriter printWriter = new PrintWriter(fileWriter);
		    	   //System.out.println(io+","+frasi.get(io));
		    	  
		    	   printWriter.print(frasi.get(io));
		    	   printWriter.close();
		    	i++;   
		       }
		       
			
				System.out.println("DONE");
				return nomeCartella_output;	
	}			
	
	public static String deleteParentesiQuadre(String nomeCartella_input,String nomeCartella_output) throws IOException{
	       
		ArrayList<String> frasi=new ArrayList<String>(); 
			String s;
			String s2;
			

			int i= 1;
			//String path_input="periodi_preprocessed_lowercase";
			File dir = new File(nomeCartella_input);
			File[] directoryListing = dir.listFiles();
			System.out.println("Numero file: "+directoryListing.length);

			if (directoryListing != null) {
				for (File child : directoryListing) {
					
					//PrintWriter out = new PrintWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
					
				 			
					String path = nomeCartella_input+"/periodo_"+i+".txt";
					Scanner sca= new Scanner(new File(path));//
					while(sca.hasNextLine()) //
					{
						s=sca.nextLine();
						s=s.replace("[","");
						s2=s;
						s2=s2.replace("]","");
						System.out.println(i+","+s2);
						frasi.add(s2);
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
		    	   FileWriter fileWriter = new FileWriter(nomeCartella_output+"/periodo"+"_"+i+".txt");
			       PrintWriter printWriter = new PrintWriter(fileWriter);
		    	   //System.out.println(io+","+frasi.get(io));
		    	  
		    	   printWriter.print(frasi.get(io));
		    	   printWriter.close();
		    	i++;   
		       }
		       
			
				System.out.println("DONE");
				return nomeCartella_output;	
	}	
	
	public static String deleteParentesiTonde(String nomeCartella_input,String nomeCartella_output) throws IOException{
	       
		ArrayList<String> frasi=new ArrayList<String>(); 
			String s;
			String s2;
			

			int i= 1;
			//String path_input="periodi_preprocessed_lowercase";
			File dir = new File(nomeCartella_input);
			File[] directoryListing = dir.listFiles();
			System.out.println("Numero file: "+directoryListing.length);

			if (directoryListing != null) {
				for (File child : directoryListing) {
					
					//PrintWriter out = new PrintWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
					
				 			
					String path = nomeCartella_input+"/periodo_"+i+".txt";
					Scanner sca= new Scanner(new File(path));//
					while(sca.hasNextLine()) //
					{
						s=sca.nextLine();
						s=s.replace("(","");
						s2=s;
						s2=s2.replace(")","");
						System.out.println(i+","+s2);
						frasi.add(s2);
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
		    	   FileWriter fileWriter = new FileWriter(nomeCartella_output+"/periodo"+"_"+i+".txt");
			       PrintWriter printWriter = new PrintWriter(fileWriter);
		    	   //System.out.println(io+","+frasi.get(io));
		    	  
		    	   printWriter.print(frasi.get(io));
		    	   printWriter.close();
		    	i++;   
		       }
		       
			
				System.out.println("DONE");
				return nomeCartella_output;	
	}		
		
}
