package targetExtraction.frasi;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
 * @author Antonio e Giuliana
 *
 */

public class R2 {

		public static String r2(String nome_filegrammatical_dep,String nome_filedependencies,String nome_fileoutput,String nome_fileInputRisultatiunificati, String nomeFileOutputRisultatiunificati) throws Exception { 

			File dir = new File("periodi");
			 File[] directoryListing = dir.listFiles();
			 boolean virgola=true;
			
			//String nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx"; //
				File file = new File("risultatiRegoleUnificati/"+nome_fileInputRisultatiunificati); //
		     	FileInputStream fis = new FileInputStream(file);//
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
			    XSSFSheet sheet = workbook.getSheet("Risultati Regole");
			    XSSFRow row = sheet.getRow(0);
			    //String nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
		        String percorsoFileOutput="risultatiRegoleUnificati/"+nomeFileOutputRisultatiunificati;
		        int col_Rule2=-1;
			
		        for(int g=0; g < row.getLastCellNum(); g++)
		        {
		            if(row.getCell(g).getStringCellValue().trim().equals("R2"))
		            	col_Rule2 = g;
		      
		        }
			
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
		    String valoreDaInserire = null;//

			int i = 1;

			while (line != null) {

				 if(i<=directoryListing.length)
                     RisultatiRegoleUnificati.eliminaValoreCella(workbook,sheet,percorsoFileOutput,i,col_Rule2);
				
				
				lista_gramm = line.split(";");

				for(String token: lista_gramm) {

					String[] ruoli = token.split("-");

					String ruolo = ruoli[1];

					if((ruolo.equals("JJ"))||(ruolo.equals("JJS"))||(ruolo.equals("JJR"))) {

						if(negativeWord.contains(ruoli[0])) { //se si sta considerando un aggettivo negativo

							lista_dep = line_2.split(";");

							for(String token_dep: lista_dep) {

								String[] tipo_dep = token_dep.split("\\(");

								if (tipo_dep[0].equals("amod")) {  

									String[] ck = tipo_dep[1].split(", "); //patch-6 + simple-5)

									String[] ckk = ck[1].split("-");
									
									/*System.out.println(token_dep); 
									System.out.println(tipo_dep[1]); 
									System.out.println(ck[0]); 
									System.out.println(ck[1]); 
									System.out.println(ckk[0]); */

									if (ckk[0].equals(ruoli[0])) {  //ckk[0] contiene la seconda parola presente nella dipendenza amod
                                                                   // se la seconda parola presente nella dipendenza amod è un aggettivo negativo
										
										String[] dep = token_dep.split("-");

										String[] last = dep[0].split("\\(");

										String target = last[1];   //prende la prima parola che si trova nella dipendenza amod
										
										/*System.out.println(token_dep);   
										System.out.println(last[1]);*/

										for(String token_2: lista_gramm) {
											String[] ruoli_2 = token_2.split("-");

											String ruolo_2 = ruoli_2[0];
											String ruolo_3 = ruoli_2[1];

											if(ruolo_2.equals(target)) 	
											{
												if((ruolo_3.equals("NN"))||(ruolo_3.equals("NNS"))) {  //se la prima parola presente nella dipendenza amod è un nome 

													for(String token_dep_2: lista_dep) {

														String[] tipo_dep_2 = token_dep_2.split("\\(");

														if(tipo_dep_2[0].equals("nsubj")) { // ipod

															String[] dep_2 = token_dep_2.split("-");
															//System.out.println(dep_2[0]);   
															//System.out.println(dep_2[1]);

															String[] last_2 = dep_2[0].split("\\(");

															String target_2 = last_2[1]; //prende la prima parola che si trova nella dipendenza nsubj
															
															/*System.out.println( token_dep_2);
															System.out.println( last_2[1]);*/

															for(String token_3: lista_gramm) {

																String[] ruoli_3 = token_3.split("-");

																String ruolo_a = ruoli_3[0];
																String ruolo_b = ruoli_3[1];

																if(ruolo_a.equals(target_2))
																{
																	if((ruolo_b.equals("NN"))||(ruolo_b.equals("NNS"))) { //se la prima parola che si trova nella dipendenza nsubj è un nome

																		String[] finale = token_dep_2.split(", ");

																		//String subj_targ = finale[1].substring(0, finale[1].length()-3);
																		
																		String[] subj_targ = finale[1].split("-");
																		
																		/*System.out.println(token_dep_2);
																		System.out.println(finale[1]);*/

																		//System.out.println(i+","+subj_targ);
																		if(target.equals(target_2))  //aggiunta da me, condizione che verifica se la prima parola presente nella dipendenza amod sia uguale alla prima parola presente nella dipendenza nsubj
																		{
																			valoreDaInserire=i+","+subj_targ[0];//
																			System.out.println(valoreDaInserire);//
																			ps.println(valoreDaInserire); //
																			valoreDaInserire=subj_targ[0];// si considera come target la serconda parola presente nelladipendenza nsubj
														                    RisultatiRegoleUnificati.scritturaValore(workbook,sheet,percorsoFileOutput,valoreDaInserire,i,col_Rule2,virgola);
																		}
	
																	} else 																	
																	{
																		System.out.println(i+","+"invalid_target");	
												                        ps.println(i+","+"invalid_target"); //
												                        valoreDaInserire="invalid_target";//
																		RisultatiRegoleUnificati.scritturaValore(workbook,sheet,percorsoFileOutput,valoreDaInserire,i,col_Rule2,virgola);
																	}	
																}
											
															}
														}
													}
												} else 
												{
													System.out.println(i+","+"invalid_target");	
							                        ps.println(i+","+"invalid_target"); //
							                        valoreDaInserire="invalid_target";//
													RisultatiRegoleUnificati.scritturaValore(workbook,sheet,percorsoFileOutput,valoreDaInserire,i,col_Rule2,virgola);
												}
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


