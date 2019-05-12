package targetExtraction.frasi;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

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
 * Implementa R1 - The phone has a good "screen"
 * 
 * console ridirezionata nel file r1a.csv
 * 
 * @author Antonio
 *
 */

public class R1 {

	public static String r1a_lc(String nome_filegrammatical_dep,String nome_filedependencies,String nome_fileoutput) throws IOException{ 

		/*String sa;
		sa="ciao";
		sa=sa+"\n";
		sa=sa+"a tutti";
		System.out.println(sa);*/
		try {    
			Scanner s= new Scanner(new File("negativeWord/negativeWord.txt"));//
			List<String> negativeWord = new ArrayList<>();//
			while(s.hasNextLine()) //
			{
				negativeWord.add(s.nextLine());//
			}//
			String[] lista_gramm = null;
			String[] lista_dep = null;

			//nome_filegrammatical_dep="grammatical_dep_preprocessed.txt";
			BufferedReader br = new BufferedReader(new FileReader("grammatical_dep/"+nome_filegrammatical_dep)); //sentence_grammatical		
			//nome_filedependencies="dependencies_preprocessed.txt";
			BufferedReader br_2 = new BufferedReader(new FileReader("dependencies/"+nome_filedependencies)); // 

			String line = br.readLine();
			String line_2 = br_2.readLine();
			//nome_fileoutput="r1a_lc.csv";
			File fout = new File("risultati_regole/"+nome_fileoutput); //
	     	FileOutputStream fos = new FileOutputStream(fout);//
		    PrintStream ps = new PrintStream(fos); //
			String r = null;//

			int i = 1;

			while (line != null) {

				lista_gramm = line.split(";");

				for(String token: lista_gramm) {

					String[] ruoli = token.split("-"); // separazione di token in due parti es token=on-IN allora ruoli[0]=on e ruoli[1]=IN
					
					//System.out.println(token);

					String ruolo = ruoli[1]; //iserimento della grammatical_dep associata alla parola (ad es vale JJ) 
					
					//System.out.println(ruoli[1]);

					if((ruolo.equals("JJ"))||(ruolo.equals("JJS"))||(ruolo.equals("JJR"))) {
						if(negativeWord.contains(ruoli[0])) {  //se la parola a cui è associato come grammatical_dep JJ O JJS O JJR è una parola negativa

							/*
							System.out.println(ruoli[0]);
							break;
							 */

							lista_dep = line_2.split(";");   
							
							//System.out.println(line_2);

							for(String token_dep: lista_dep) {

								String[] tipo_dep = token_dep.split("\\(");   // dependencies è soddiviso in due parti cioe ad es se si considera un token_dep che è nsubj(look-4, i-3) 
								                                             // allora tipo_dep[0]= nsubj mentre tipo_dep[1]= look-4, i-3) 
								  
								//System.out.println(tipo_dep[1]); 

								if(tipo_dep[0].equals("amod")) {  

									String[] ck = tipo_dep[1].split(", "); //patch-6 + simple-5)    // ad es tipo_dep[1]= rule-5, stupid-4), con ck divido le due parti cioè ck[0]=rule-5 e ck[1]=stupid-4)
									
									//System.out.println(token_dep);
									//System.out.println(ck[0]);
									//System.out.println(ck[1]);
									
									
									//System.out.println(tipo_dep[1]);
									//System.out.println(tipo_dep[0]);

									String[] ckk = ck[1].split("-");  // in ckk si separono le due parti presenti in ck[1], ad es. ck[1]= stupid-4)
									                                  // allora ckk[0]= stupid  e  ckk[1]= 4)
									//System.out.println(ck[1]);
									//System.out.println(ckk[0]);
									//System.out.println(ckk[1]);
									//System.out.println(ruoli[0]);

									if (ckk[0].equals(ruoli[0])) {  //se la parola a cui è associato come grammatical_dep JJ O JJS O JJR è uguale alla parola che si trova in amod al secondo posto

										String[] dep = token_dep.split("-");  //token_dep contiene ad es amod(rule-5, stupid-4), viene separato in due parti in dep cioè amod(rule-5  - stupid-4  
										
										//System.out.println(token_dep);  
										//System.out.println(dep[0]);

										String[] last = dep[0].split("\\(");
                                       String target = last[1];  //contiene il soggetto di amod
										//System.out.println(last[1]);

										for(String token_2: lista_gramm) {

											String[] ruoli_2 = token_2.split("-"); 	//ruoli_2 contiene le grammatical_dep delle frasi selezionate es horrible-JJ
											//System.out.println(token_2);
											
											String ruolo_2 = ruoli_2[0]; // contiene la prima parte della grammatical_dep es who (la parte prima il -)
											String ruolo_3 = ruoli_2[1]; //cotiene la grammatical_dep della parola ad es WP (la parte dopo il -)
											
										
											//System.out.println(ruoli_2[0]); 
											//System.out.println(ruoli_2[1]); 

											if(ruolo_2.equals(target))  //se il soggetto di amod è uguale alla parola presente prima di - nella grammatical_dep

												if((ruolo_3.equals("NN"))||(ruolo_3.equals("NNS"))) {    // se alla parola uguale al soggetto di amod è associato NN o NNS

													//System.out.println(i+","+target);
													r=i+","+target;//
													System.out.println(r);//
							                        ps.println(r); //
													     
												} else 
												{
													//System.out.println(i+","+"invalid target");
													r=i+","+"invalid target";//
													System.out.println(r);//
													ps.println(r);//
												}												
										}
									}
								}
							}
						}
					}
				}
				i++;
				line = br.readLine(); // try to read another line
				line_2 = br_2.readLine();

			}

			br.close();	
			br_2.close();   
        } catch (IOException e) {    
            e.printStackTrace();  
        }  
	 return nome_fileoutput;	
	}
	
}