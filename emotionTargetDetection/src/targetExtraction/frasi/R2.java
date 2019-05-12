package targetExtraction.frasi;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
 * Implementa R2 - "Ipod" is the best mp3 player
 * 
 * console ridirezionata nel file r1b.csv
 * 
 * @author Antonio
 *
 */

public class R2 {

		public static String r1b_lc(String nome_filegrammatical_dep,String nome_filedependencies,String nome_fileoutput) throws Exception { 

			Scanner s= new Scanner(new File("negativeWord/negativeWord.txt"));//
			List<String> negativeWord = new ArrayList<>();//
			while(s.hasNextLine()) //
			{
				negativeWord.add(s.nextLine());//
			}//
			String[] lista_gramm = null;
			String[] lista_dep = null;

			// nome_filegrammatical_dep="grammatical_dep_preprocessed.txt";
			BufferedReader br = new BufferedReader(new FileReader("grammatical_dep/"+nome_filegrammatical_dep)); //sentence_grammatical		
			//nome_filedependencies="dependencies_preprocessed.txt";
			BufferedReader br_2 = new BufferedReader(new FileReader("dependencies/"+nome_filedependencies)); // 

			String line = br.readLine();
			String line_2 = br_2.readLine();
			//nome_fileoutput="r1b_lc.csv";
			File fout = new File("risultati_regole/"+nome_fileoutput); //
	     	FileOutputStream fos = new FileOutputStream(fout);//
		    PrintStream ps = new PrintStream(fos); //
			String r = null;//

			int i = 1;

			while (line != null) {

				lista_gramm = line.split(";");

				for(String token: lista_gramm) {

					String[] ruoli = token.split("-");

					String ruolo = ruoli[1];

					if((ruolo.equals("JJ"))||(ruolo.equals("JJS"))||(ruolo.equals("JJR"))) {

						if(negativeWord.contains(ruoli[0])) {

							lista_dep = line_2.split(";");

							for(String token_dep: lista_dep) {

								String[] tipo_dep = token_dep.split("\\(");

								if (tipo_dep[0].equals("amod")) {

									String[] ck = tipo_dep[1].split(", "); //patch-6 + simple-5)

									String[] ckk = ck[1].split("-");

									if (ckk[0].equals(ruoli[0])) {

										String[] dep = token_dep.split("-");

										String[] last = dep[0].split("\\(");

										String target = last[1];

										for(String token_2: lista_gramm) {
											String[] ruoli_2 = token_2.split("-");

											String ruolo_2 = ruoli_2[0];
											String ruolo_3 = ruoli_2[1];

											if(ruolo_2.equals(target)) 

												if((ruolo_3.equals("NN"))||(ruolo_3.equals("NNS"))) {

													for(String token_dep_2: lista_dep) {

														String[] tipo_dep_2 = token_dep_2.split("\\(");

														if(tipo_dep_2[0].equals("nsubj")) { // ipod

															String[] dep_2 = token_dep_2.split("-");
															//System.out.println(dep_2[0]);   
															//System.out.println(dep_2[1]);

															String[] last_2 = dep_2[0].split("\\(");

															String target_2 = last_2[1]; //prende la prima parola che si trova nell'associazione nsubj
															//System.out.println( last_2[1]);

															for(String token_3: lista_gramm) {

																String[] ruoli_3 = token_3.split("-");

																String ruolo_a = ruoli_3[0];
																String ruolo_b = ruoli_3[1];

																if(ruolo_a.equals(target_2)) 

																	if((ruolo_b.equals("NN"))||(ruolo_b.equals("NNS"))) {

																		String[] finale = token_dep_2.split(", ");

																		String subj_targ = finale[1].substring(0, finale[1].length()-3);

																		//System.out.println(i+","+subj_targ);
																		r=i+","+subj_targ;//
																		System.out.println(r);//
												                        ps.println(r); //

																	} else 																	
																	{
																		System.out.println(i+","+"invalid target");	
												                        ps.println(i+","+"invalid target"); //
																	}										
															}
														}
													}
												} else 
												{
													System.out.println(i+","+"invalid target");	
							                        ps.println(i+","+"invalid target"); //
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
		    return nome_fileoutput;
		}
}