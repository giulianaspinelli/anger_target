package preprocessing;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SentencesLowercase {
public static void preprocessing_sentencesLowercase(String path) throws Exception {

	
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
	}	

}


