package dependencyParser.frasi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;

/**
 * Stampa i POS per ogni commento in sentence
 * 
 * 
 * 
 * @author Antonio e Giuliana
 *
 */


public class StampaGrammaticalDep {

	private final static String PCG_MODEL = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";        

	private final TokenizerFactory<CoreLabel> tokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(), "invertible=true");

	private static final LexicalizedParser parser = LexicalizedParser.loadModel(PCG_MODEL);

	public Tree parse(String str) {                
		List<CoreLabel> tokens = tokenize(str);
		Tree tree = parser.apply(tokens);
		return tree;
	}

	private List<CoreLabel> tokenize(String str) {
		Tokenizer<CoreLabel> tokenizer =
				tokenizerFactory.getTokenizer(
						new StringReader(str));    
		
		return tokenizer.tokenize();
	}

	
	public static String grammatical_Dep_Preprocessed(String nomeCartella_input,String nomeFile_output) throws Exception { 
					
		   int i= 1;
		   //nomeCartella_input="periodi_preprocessed";
		   File dir = new File(nomeCartella_input);
		   File[] directoryListing = dir.listFiles();
		   System.out.println("Numero file: "+directoryListing.length);
		   //nomeFile_output="grammatical_dep_preprocessed.txt"
		 	File fout = new File("grammatical_dep/"+nomeFile_output);//
	     	FileOutputStream fos = new FileOutputStream(fout);//
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));//
			String s = null;//
			
			if (directoryListing != null) {
				for (File child : directoryListing) {		
						String path = nomeCartella_input+"/periodo_"+i+".txt";
						 BufferedReader br = new BufferedReader(new FileReader(path));
						 String line = br.readLine();				
							br.close();

							Tree tree = parser.parse(line);  

							List<Tree> leaves = tree.getLeaves();
							// Print words and Pos Tags
							s=null;//
							for (Tree leaf : leaves) { 
								Tree parent = leaf.parent(tree);
								//System.out.print(leaf.label().value() + "-" + parent.label().value() + ";");
								
								if (s==null) //
								{
									s=leaf.label().value() + "-" + parent.label().value() + ";";//
								}
								else
								{
									s=s+leaf.label().value() + "-" + parent.label().value() + ";";//
								}				
							}
							//System.out.print(i);
							//System.out.println();
							//frase 419 è IL PROBLEMA per R1a
							//frase 420 è IL PROBLEMA per R1a
							//frase 713 è IL PROBLEMA per R1a
							
							//frase 242 è IL PROBLEMA per R1b
							//frase 419 è IL PROBLEMA per R1b
							//frase 421 è IL PROBLEMA per R1b
							//frase 713 è IL PROBLEMA per R1b
							
							//frase 68 è IL PROBLEMA per R1e
							//frase 131 è IL PROBLEMA per R1e
							//frase 205 è IL PROBLEMA per R1e
							//frase 419 è IL PROBLEMA per R1e
							//frase 443 è IL PROBLEMA per R1e
							//frase 511 è IL PROBLEMA per R1e
							//frase 713 è IL PROBLEMA per R1e
							
							//400 non da errore 
							//415 non da errore
							//417 non da errore
							//418 non da errore
							//714 non da errore
							//715 non da errore
							//da i>=421 && i<=712 non da errore 
							//da i>=715 && i<=723 non da errore
							//da i>=710 && i<=715 da errore
							//da i>=500 && i<=723 da errore
                            //419 da errore
							//420 da errore
							//440 da errore
						
							//frase dopo 520 ci mette molto tempo
							//frase dopo 509 ci mette molto tempo
						    //frase dopo 528 ci mette molto tempo
							//frase dopo 712 ci mette molto tempo
							
							//frasi i>=1 && i<=418 non da errore per R1b_lc
							//FRASE 420 non da errore 
							//frasi i>=422 && i<=712 non da errore per R1b_lc 
							//FRASE 713 da errore
							//frasi i>=714 && i<=723 non da errore per R1b_lc 
							//frasi da 200 a 300 da errore per R1b_lc
							
							//frasi da 401 a 450 da errore per R1b_lc
							
							//frasi i>=1 && i<=723 non da errore per R1c_lc
							
							//tutte frasi non danno errore con R1d_lc
							
							//frasi i>=1 && i<=67 non da errore per R1e_lc
							//frase 68 da errore 
							//frasi i>=69 && i<=130 non da errore per R1e_lc 
							//frase 131 da errore
							//frasi i>=132 && i<=204 non da errore per R1e_lc 
							//frase 205 da errore
							//frasi i>=206 && i<=418 non da errore per R1e_lc 
							//frase 419 da errore 
							//frasi i>=420 && i<=442 non da errore per R1e_lc 
							//frase 443 da errore
							//frasi i>=444 && i<=510 non da errore per R1e_lc 
							//frase 511 da errore
							//frasi i>=512 && i<=712 non da errore per R1e_lc 
							//frase 713 da errore
							//frasi i>=714 && i<=723 non da errore per R1e_lc --
							
							 
							//if(i==44 || i==45 || i==54 ||i==90 ||i==95 ||i==105 ||i==113 ||i==135 ||i==138 ||i==171 ||i==174 ||i==203 ||i==226 ||i==229 ||i==234 ||i==241 ||i==251 ||i==256 ||i==258 ||i==261 ||i==266 ||i==272 ||i==279 ||i==286 ||i==294 ||i==299 ||i==300 ||i==304||i==310||i==312||i==315||i==327||i==331||i==334||i==346||i==369||i==372||i==390||i==391||i==404||i==405||i==409||i==415||i==421||i==426||i==428||i==434||i==443||i==444||i==451||i==462||i==464||i==465||i==466||i==469||i==478||i==480||i==482||i==498||i==502||i==505||i==510||i==525||i==549||i==571||i==572||i==574||i==576||i==579||i==580||i==582||i==588||i==593||i==600||i==601||i==604||i==605||i==610||i==621||i==626||i==631||i==638||i==656||i==657||i==658||i==703||i==708||i==709||i==713||i==718)	//frasi con -							
							//if(i==196 ||i==214||i==334||i==372||i==454||i==494||i==505||i==511||i==570||i==665||i==668||i==713) // frasi con [ ]
							//if(i==68|| i==131 ||i==205||i==242 ||i==419||i==420||i==421 ||i==443 ||i==505 ||i==511 ||i==556||i==602||i==626||i==638||i==700||i==713)
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
			
			
			
			/*if (directoryListing != null) {
			 for (File child : directoryListing) {
				 
				 if(i>=1 && i<4)	
				 {
					 String path = "periodi_preprocessed_lowercase/periodo_"+1+".txt";
					 BufferedReader br = new BufferedReader(new FileReader(path));
					 String line = br.readLine();				
						br.close();

						Tree tree = parser.parse(line);  

						List<Tree> leaves = tree.getLeaves();
						// Print words and Pos Tags
						s=null;//
						for (Tree leaf : leaves) { 
							Tree parent = leaf.parent(tree);
							//System.out.print(leaf.label().value() + "-" + parent.label().value() + ";");
							
							if (s==null) //
							{
								s=leaf.label().value() + "-" + parent.label().value() + ";";//
							}
							else
							{
								s=s+leaf.label().value() + "-" + parent.label().value() + ";";//
							}				
						}
						//System.out.println();
						if(i<=directoryListing.length)//
						{
							System.out.print(i+","+s);//
							System.out.println();//
							bw.write(s);//
							bw.newLine();//
						}				
						
				 }
				 i++;	
			 }
		 
			
			}			
			System.out.println("DONE");				
			}	*/		
	 
	

			bw.close();
			System.out.println("DONE");	
			return nomeFile_output;
 }
	
}
