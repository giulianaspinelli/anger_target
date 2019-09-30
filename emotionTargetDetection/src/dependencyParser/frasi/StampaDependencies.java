package dependencyParser.frasi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;

/**
 * Stampa le dependencies per ogni commento in sentence
 * 
 * 
 * 
 * @author Antonio e Giuliana
 *
 */

public class StampaDependencies {

	/*public static String demoDP(LexicalizedParser lp, String filename, int i,String s) throws Exception {

		TreebankLanguagePack tlp = new PennTreebankLanguagePack();
		
		GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
		
		for (List<HasWord> sentence : new DocumentPreprocessor(filename)) {
			
			Tree parse = lp.apply(sentence);

			GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
			Collection tdl = gs.typedDependenciesCCprocessed();
					
			String separator ="";
			s = null;
			for(Object token: tdl) {
				
				//System.out.print(separator+token);
				//
				//separator = ";";
				if (s==null) //
				{
					s=token.toString()+ ";";//
				}
				else
				{
					s=s+token.toString()+ ";";//
				}	
			}			
		}
	return s;	
	}


	public static void main(String args[]) throws Exception {

		LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");

		int i= 1;

		File dir = new File("periodi_preprocessed");
		File[] directoryListing = dir.listFiles();
		System.out.println("Numero file: "+directoryListing.length);

		File fout = new File("C:/Users/giuli/Desktop/dependencies_lowercase.txt");
     	FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		 		
		String s = null;
		
		if (directoryListing != null) {
			for (File child : directoryListing) {

				String path = "periodi_preprocessed/periodo_"+i+".txt";

				s=demoDP(lp, path, i,s);
				//System.out.println(i+","+s);	
				//System.out.println();	
				if(i<=directoryListing.length)
				{
					bw.write(s);
					bw.newLine();
					System.out.print(i+","+s);
					System.out.println();					
				}
				i++;
			}



			//demoDP(lp,"C:/Users/Antonio/Desktop/sentence.txt");
		}
		bw.close();
		System.out.println("DONE");
	}*/
	
	public static String dependencies_Preprocessed(String nomeCartella_input,String nomeFile_output) throws Exception {
		
		LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");

		int i= 1;
        //path_input="periodi_preprocessed";
		File dir = new File(nomeCartella_input);
		File[] directoryListing = dir.listFiles();
		System.out.println("Numero file: "+directoryListing.length);
		//path_output="dependencies_preprocessed.txt";
		File fout = new File("dependencies/"+nomeFile_output);
     	FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		 		
		String s = null;
		boolean incremento=true;
		String r = null;
			
		if (directoryListing != null) {
			for (File child : directoryListing) {
				
				

				String path = nomeCartella_input+"/periodo_"+i+".txt";
								
				TreebankLanguagePack tlp = new PennTreebankLanguagePack();
				
				GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
				
				for (List<HasWord> sentence : new DocumentPreprocessor(path)) {
		
					
					Tree parse = lp.apply(sentence);

					GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
					Collection tdl = gs.typedDependenciesCCprocessed();
							
					String separator ="";

					s = null;
					for(Object token: tdl) {
						
						//System.out.print(separator+token);
						//
						//separator = ";";
						if (s==null) //
						{
							s=token.toString()+ ";";//
							//System.out.print(separator+token);
						}
						else
						{
							s=s+token.toString()+ ";";//
							//System.out.print(separator+token);
						}	
					}
					
					if(i<=directoryListing.length)				
					{ 
						
						bw.write(s);
						if(incremento==true)  
						{	
							 System.out.print(i+","+s);	 
							 s=r;
						}
						else	
						{
							//s=s+r;
							//System.out.println();
							System.out.print(s);
							
						}
						
						
					}
				  
				  incremento=false;	
				}
				
				//System.out.println(num);
				//if(i==44 || i==45 || i==54 ||i==90 ||i==95 ||i==105 ||i==113 ||i==135 ||i==138 ||i==171 ||i==174 ||i==203 ||i==226 ||i==229 ||i==234 ||i==241 ||i==251 ||i==256 ||i==258 ||i==261 ||i==266 ||i==272 ||i==279 ||i==286 ||i==294 ||i==299 ||i==300 ||i==304||i==310||i==312||i==315||i==327||i==331||i==334||i==346||i==369||i==372||i==390||i==391||i==404||i==405||i==409||i==415||i==421||i==426||i==428||i==434||i==443||i==444||i==451||i==462||i==464||i==465||i==466||i==469||i==478||i==480||i==482||i==498||i==502||i==505||i==510||i==525||i==549||i==571||i==572||i==574||i==576||i==579||i==580||i==582||i==588||i==593||i==600||i==601||i==604||i==605||i==610||i==621||i==626||i==631||i==638||i==656||i==657||i==658||i==703||i==708||i==709||i==713||i==718)	//frasi con -			
				//if(i==196 ||i==214||i==334||i==372||i==454||i==494||i==505||i==511||i==570||i==665||i==668||i==713) //frasi con [ ]
				//if(i==68|| i==131 ||i==205||i==242 ||i==419||i==420||i==421 ||i==443 ||i==505 ||i==511 ||i==556||i==602||i==626||i==638||i==700||i==713)
				/*if(i<=directoryListing.length)				
				{
					bw.write(s);
					bw.newLine();
					System.out.print(i+","+s);
					System.out.println();					
				}
					*/
				
				bw.newLine();
				System.out.println();
				i++;
				incremento=true;
			}
			
				
			
		}
		bw.close();
		System.out.println("DONE");	
		return nomeFile_output;
	}
		
}