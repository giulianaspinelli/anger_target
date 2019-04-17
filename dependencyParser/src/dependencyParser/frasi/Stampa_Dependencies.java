package dependencyParser.frasi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
 * @author Antonio
 *
 */

public class Stampa_Dependencies {

	public static void main(String args[]) throws Exception {

		LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");

		int i= 1;

		File dir = new File("periodi");
		File[] directoryListing = dir.listFiles();
		System.out.println("Numero file: "+directoryListing.length);
		BufferedWriter writer = new BufferedWriter(new FileWriter("dependencies/dependencies.csv")); //

		if (directoryListing != null) {
			for (File child : directoryListing) {

				//String path = "periodi_preprocessed/periodo_"+i+".txt"; COMMENTATO DA ME 
				String path = "periodi/periodo_"+i+".txt";

				TreebankLanguagePack tlp = new PennTreebankLanguagePack();
				
				GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
				String s = null;
				
				for (List<HasWord> sentence : new DocumentPreprocessor(path)) {
					
					Tree parse = lp.apply(sentence);

					GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
					Collection tdl = gs.typedDependenciesCCprocessed();
					
							
					String separator ="";

					for(Object token: tdl) {
						
						//System.out.print(separator+token);
						separator = ";";
						if(s==null)
							s=token+separator;
						else 
							s=s+token+separator;
						
						separator = ";";
					}
					
					//System.out.println();			
				}
				if(i<=directoryListing.length)
				{
									
					System.out.print(i+","+s);//
					System.out.println();//
					writer.write(s);//
					writer.newLine();//				     
					
				}
				i++;
			}

			writer.close();	

			//demoDP(lp,"C:/Users/Antonio/Desktop/sentence.txt");
		}
		System.out.println("DONE");
	}
}