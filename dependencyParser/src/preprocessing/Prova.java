package preprocessing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Prova {
	
	public static void main(String[] args) throws IOException{
		String s1;
		String s2;
		String s3;
		String s4;
		String s5;
		String s6;
		String s7;
		
		int i= 1;

		File dir = new File("periodi_preprocessed_lowercase");
		File[] directoryListing = dir.listFiles();
		System.out.println("Numero file: "+directoryListing.length);

		if (directoryListing != null) {
			for (File child : directoryListing) {
				
				//PrintWriter out = new PrintWriter("periodi_preprocessed_lowercase2/periodo"+"_"+i+".txt");
				FileWriter fileWriter = new FileWriter("periodi_preprocessed_lowercase3/periodo"+"_"+i+".txt");
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			 			
				String path = "periodi_preprocessed_lowercase2/periodo_"+i+".txt";
				Scanner sca= new Scanner(new File(path));//
				while(sca.hasNextLine()) //
				{
					s1=sca.nextLine();
					s1=s1.replace("-","");
					s2=s1;
					System.out.println(i+","+s1);
					//printWriter.print(s);
					
					s2=s2.replace("[","");
					s3=s2;
					System.out.println(i+","+s2);
					//printWriter.print(s2);
					
					s3=s3.replace("]","");
					s4=s3;
					System.out.println(i+","+s3);
					//printWriter.print(s3);
					
					s4=s4.replace("{","");
					s5=s4;
					System.out.println(i+","+s4);
					//printWriter.print(s4);
					
					s5=s5.replace("}","");
					s6=s5;
					System.out.println(i+","+s5);
					//printWriter.print(s5);
					
					s6=s6.replace("(","");
					s7=s6;
					System.out.println(i+","+s6);
					//printWriter.print(s6);
					
					s7=s7.replace(")","");
					System.out.println(i+","+s7);
					printWriter.print(s7);
					printWriter.close();
					//out.print(s);
					//out.close();
						
				}//
				
				
				
				//out.close();
				 i++;
			}

				
			}
			System.out.println("DONE");	
	}
	
	
}
