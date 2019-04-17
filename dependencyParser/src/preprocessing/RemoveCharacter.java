package preprocessing;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Permette di sostituire -1 con minus_one nelle frasi. Il metoddo della classe prende in input: 
 * -il path dove si trovano i files contenti le frasi da dare in input(path_input),
 * -il path dove si trovano i failes dove verranno inserite le frasi dove si è sostituito -1 con minus_one(path_output)
 * 
 * @author Giuliana Spinelli 
 * 
 *
 */

public class RemoveCharacter {

	//static final String FILEPATH = "C:/Users/giuli/Desktop/input.txt";
	
	
	//public static void RemoveCharacter
	
	
	
	public static void preprocessing_removeCharacter(String path_input,String path_output) throws IOException{
       
		ArrayList<String> frasi=new ArrayList<String>(); 
			String s;
			

			int i= 1;
			//String path_input="periodi_preprocessed_lowercase";
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
		    	   FileWriter fileWriter = new FileWriter(path_output+"/periodo"+"_"+i+".txt");
			       PrintWriter printWriter = new PrintWriter(fileWriter);
		    	   //System.out.println(io+","+frasi.get(io));
		    	  
		    	   printWriter.print(frasi.get(io));
		    	   printWriter.close();
		    	i++;   
		       }
		       
			
				System.out.println("DONE");
		
		
		
		
		
		/*ArrayList<String> str=new ArrayList<String>();
	    str.add("aaa");
	    str.add("dddd");
	  
	    //Result = [0, 11, 12, 1, 2, 3]
	    System.out.println(str);
	    System.out.println(str.get(1));*/
		
		
		/*try {
			 
	            System.out.println(new String(readFromFile(FILEPATH, 150, 23)));
	 
	            writeToFile(FILEPATH, "JavaCodeGeeks Rocks!",0);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }*/
		
		/*ArrayList<String> frasi=new ArrayList<String>();
	 
    	String s;

		int i= 1;

		File dir = new File("periodi_preprocessed_lowercase");
		File[] directoryListing = dir.listFiles();
		System.out.println("Numero file: "+directoryListing.length);

		if (directoryListing != null) {
			for (File child : directoryListing) {
				
				//PrintWriter out = new PrintWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
				FileWriter fileWriter = new FileWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			 			
				String path = "periodi_preprocessed_lowercase/periodo_"+i+".txt";
				Scanner sca= new Scanner(new File(path));//
				while(sca.hasNextLine()) //
				{
					s=sca.nextLine();
					s=s.replace("-1 ","minus_one ");
					System.out.println(i+","+s);
					frasi.add("aaa");
					//printWriter.print(s);
					//printWriter.close();
					//out.print(s);
					//out.close();
						
				}//
				//out.close();
				 i++;
			}

				
			}
			System.out.println("DONE");*/
    	
    	
    	
    	/*String helloWorld = "i think its really stupid that visitparents visits the current component  so -1 on just updating the javadocs.";
    	String hellWrld = helloWorld.replace("-1","minus_one");
    	System.out.println(hellWrld);*/
    	
    }
	
	 /*public static byte[] readFromFile(String filePath, int position, int size)
	            throws IOException {
	 
	        RandomAccessFile file = new RandomAccessFile(filePath, "r");
	        file.seek(position);
	        byte[] bytes = new byte[size];
	        file.read(bytes);
	        file.close();
	        return bytes;
	 
	    }
	 
	    public static void writeToFile(String filePath, String data, int position)
	            throws IOException {
	 
	        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
	        file.seek(position);
	        file.write(data.getBytes());
	        file.close();
	 
	    }*/
	
	

}