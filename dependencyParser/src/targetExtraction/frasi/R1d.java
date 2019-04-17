package targetExtraction.frasi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Implementa R1.4 - Predicati nominali con copula 
 * 
 * console ridirezionata nel file r1d.csv
 * 
 * @author Antonio
 *
 */

public class R1d {
	public static void main(String[] args) throws Exception {

		Scanner s= new Scanner(new File("negativeWord/negativeWord.txt"));//
		List<String> negativeWord = new ArrayList<>();//
		while(s.hasNextLine()) //
		{
			negativeWord.add(s.nextLine());//
		}//
		String[] lista_gramm = null;
		String[] lista_dep = null;

		BufferedReader br = new BufferedReader(new FileReader("grammatical_dep_lowercase/grammatical_dep_lowercase.txt")); //sentence_grammatical		
		BufferedReader br_2 = new BufferedReader(new FileReader("dependencies_lowercase/dependencies_lowercase.txt"));

		String line = br.readLine();
		String line_2 = br_2.readLine();
		
		File fout = new File("risultati_regole/r1d_lc.csv"); //
     	FileOutputStream fos = new FileOutputStream(fout);//
	    PrintStream ps = new PrintStream(fos); //
		String r = null;//

		int i = 1;

		while (line != null) {

			lista_gramm = line.split(";");

			for(String token: lista_gramm) {

				String[] ruoli = token.split("-");

				String ruolo = ruoli[1];

				if((ruolo.equals("JJ"))||(ruolo.equals("JJS"))||(ruolo.equals("JJR"))||(ruolo.equals("NN"))||(ruolo.equals("NNS"))) {

					if(negativeWord.contains(ruoli[0])) {

						lista_dep = line_2.split(";");

						boolean found_cop = false;

						for(String token_dep: lista_dep) {	// my reasoning is bad

							String[] tipo_dep = token_dep.split("\\("); // cop + bad-9, is-8)

							if(tipo_dep[0].equals("cop")) { // 

								found_cop = true;

								String[] ck = tipo_dep[1].split(", "); //bad-9 + is-8)

								String[] ckk = ck[0].split("-"); // bad + 9

								if (ckk[0].equals(ruoli[0])) {

									for(String token_depp: lista_dep) {

										String[] dep = token_depp.split("\\(");  // nsubj + bad-9, reasoning)

										if(dep[0].equals("nsubj")) {

											String[] last = dep[1].split(",");

											if(last[0].substring(0, last[0].length()-2).equals(ruoli[0])) {


												String target = last[1].substring(0, last[1].length()-2);

												//System.out.println(i+","+target+","+"cop #1");
												r=i+","+target+","+"cop #1";//
												System.out.println(r);//
						                        ps.println(r); //
											}

										}										
									}							
								}
							}
						}

						if(found_cop==false) {

							for(String token_dep: lista_dep) {	//I'm an idiot

								String[] tipo_dep = token_dep.split("\\("); // dobj + Im-1, idiot-3)

								if(tipo_dep[0].equals("dobj")) { // 

									String[] ck = tipo_dep[1].split(", "); // Im-1 + idiot-3)

									String[] ckk = ck[1].split("-"); // idiot + 3

									if (ckk[0].equals(ruoli[0])) {

										String target = ck[0].substring(0, ck[0].length()-2);

										//System.out.println(i+","+target+","+"cop #2");
										r=i+","+target+","+"cop #2";//
										System.out.println(r);//
				                        ps.println(r); //
									}
								}
							}
						}

						if(found_cop==false) {

							for(String token_dep: lista_dep) {	//I'm an idiot

								String[] tipo_dep = token_dep.split("\\("); // dobj + Im-1, idiot-3)

								if(tipo_dep[0].equals("nsubj")) { // 

									String[] ck = tipo_dep[1].split(", "); // Im-1 + idiot-3)

									String[] ckk = ck[0].split("-"); // idiot + 3

									if (ckk[0].equals(ruoli[0])) {

										String target = ck[1].substring(0, ck[1].length()-3);

										//System.out.println(i+","+target+","+"cop #3");
										r=i+","+target+","+"cop #3";//
										System.out.println(r);//
				                        ps.println(r); //
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
	}

}
