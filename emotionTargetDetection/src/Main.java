import java.util.Scanner;

import dependencyParser.frasi.StampaDependencies;
import dependencyParser.frasi.StampaGrammaticalDep;
import edu.stanford.nlp.util.StringUtils;
import preprocessing.Preprocessing;
import targetExtraction.frasi.PrintResultsRule;
import targetExtraction.frasi.R1;
import targetExtraction.frasi.R2;
import targetExtraction.frasi.R3;
import targetExtraction.frasi.R4;
import targetExtraction.frasi.R5;
import targetExtraction.frasi.RisultatiRegoleUnificati;
//import targetExtraction.frasi.R6; 

public class Main {
	
	
	public static void main(String[] args) throws Exception { 
				
		//caso in cui non ci sia il preprocessig:
		// chiamo il metodo della classe Stampa_dependencies
		//chiamo il metodo della classe Grammaticla_Dep
		//chiamo le varie regole per identificare il target della frase 
		
		//caso in cui ci sia il preprocessig:
		//chiamo il metodo della classe SentencesLowercase(restituisce le psarole in minuscolo)
		// chiamo il metodo della classe Stampa_dependencies_lowercase
		//chiamo il metodo della classe Grammaticla_Dep_lowercase
		//chiamo le varie regole per identificare il target della frase
		
		String nomeCartella_input=""; //nome della cartella dove si trovano le frasi da dare in input per avere le dipendenze grammaticali e le dipendenze di Stanford
		String nomeCartella_output="";
		String nomeFile_output=""; //nome dei files che contiene le dipendenze di Stanford delle frasi 
		String nome_filegrammatical_dep=""; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
        String nome_filedependencies=""; //identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
        String nome_fileoutput=""; //nome del filwe dove memorizzare i risultati della regola usata per identificare il target delle frasi
        String nome_fileinput=""; //nome del file in input alla classe per visualizzare i risultati ottenuti dall'elaborazione delle regole(i risultato sarebbero i target delle frasi)
        int i=0;
        int risposta = 0;
        Scanner in = new Scanner(System.in);
        
        String nome_fileInputRisultatiunificati;
        String nomeFileOutputRisultatiunificati;
        
       /* Scanner scanner = new Scanner(System. in);
        String inputString;
        System.out.print("Enter a string : ");    	      
	    inputString = scanner. nextLine();*/
        
        System.out.println("+-------------------------------------------------+");
    	System.out.println("|  Sistema per identificare i target nelle frasi  |");
    	System.out.println("+-------------------------------------------------+");
        while(risposta!=-1)		
        {            	
            System.out.println();
            System.out.println("********************** Menu **********************");
            System.out.println("1 Eliminazione degli URL nelle frasi");
            System.out.println("2 Sostituzione dei -1 con minus_one nelle frasi");
            System.out.println("3 Trasformazione in minuscolo delle frasi");
            System.out.println("4 Eliminzione del - nelle frasi");
            System.out.println("5 Eliminzione {} nelle frasi");
            System.out.println("6 Eliminzione [] nelle frasi");
            System.out.println("7 Eliminzione () nelle frasi");
            System.out.println("8 Estrazione dei POS identificati con Stanford Parser delle frasi (Tagging)");
            System.out.println("9 Estrazione delle diemndenze identificate con Stanford Parser delle frasi (Universal dependencies)");
            System.out.println("10 Riconoscimento del target delle frasi usando la regola R1");
            System.out.println("11 Riconoscimento del target delle frasi usando la regola R2");
            System.out.println("12 Riconoscimento del target delle frasi usando la regola R3");
            System.out.println("13 Riconoscimento del target delle frasi usando la regola R4");
            System.out.println("14 Riconoscimento del target delle frasi usando la regola R5"); 
            System.out.println("15 Unificazione dei risultati otteniti dalle varie regole"); 
            System.out.println("-1 Uscire dal sistema"); 
            System.out.println(""); 
           
            System.out.printf("Digita il numero corrispondente alla voce del menu riferita all'operanzione da effettuare:  ");
            risposta = in.nextInt();
            if(risposta== 1)
            {
         	   i++;
         	   if(i==1)    	  
         	   {
         		 System.out.println();
                 System.out.println("***************** Eliminazione degli URL dalle frasi *****************");
           	     System.out.println();
           	     nomeCartella_input = "periodi"; // nome della cartella dove si trovano i files cotenenti le frasi da dare in input al metodo
           	     nomeCartella_output = "periodi_preprocessed";   //nome della cartella dove inserire i file contenenti le frasi senza URL
           	     nomeCartella_input =Preprocessing.deleteURL(nomeCartella_input,nomeCartella_output);  
         	      
         	   }
         	   else
         	   { 
         		  System.out.println();
         		  System.out.println("***************** Eliminazione degli URL dalle frasi *****************");
            	  System.out.println(); 
            	  nomeCartella_input=Preprocessing.deleteURL(nomeCartella_input,nomeCartella_output); 
         	   }
            }
            if(risposta== 2)
            {
         	   i++;
         	   if(i==1)    	  
         	   {
         		  System.out.println();
         		  System.out.println("************* Sostituzione dei -1 con minus_one nelle frasi ***************");	        
	              System.out.println();
	              nomeCartella_input = "periodi"; // nome della cartella dove si trovano i files cotenenti le frasi da dare in input al metodo
	           	  nomeCartella_output = "periodi_preprocessed";   //nome della cartella dove inserire i file contenenti le frasi in cui si � sostituito -1 con minus_one 
	              nomeCartella_input=Preprocessing.minus_one(nomeCartella_input,nomeCartella_output);   
         	      
         	   }
         	  else
        	   { 
         		  System.out.println();
         		  System.out.println("************* Sostituzione dei -1 con minus_one nelle frasi ***************");	        
           	      System.out.println(); 
           	      nomeCartella_input=Preprocessing.minus_one(nomeCartella_input,nomeCartella_output); 
           	   
        	   }
         	 }
            if(risposta== 3)
            {
         	   i++;
         	   if(i==1)    	  
         	   {
         		  System.out.println();
	              System.out.println("*************** Trasformazione in minuscolo delle frasi *****************");	        
	              System.out.println();
	              nomeCartella_input = "periodi"; // nome della cartella dove si trovano i files cotenenti le frasi da dare in input al metodo
	           	  nomeCartella_output = "periodi_preprocessed";   //nome della cartella dove inserire i file contenenti le frasi in minuscolo 
	              nomeCartella_input=Preprocessing.sentencesLowercase(nomeCartella_input,nomeCartella_output);           	      
         	   }
         	  else
       	      { 
         		  System.out.println();
         		  System.out.println("*************** Trasformazione in minuscolo delle frasi *****************");
          	      System.out.println(); 
          	      //il metodo preprocessing_sentencesLowercase prende in input i file creati dal metodo preprocessing_removeCharacter chiamato prima  
                  // come risultato riscrive i file che erano stati creati dal preprocessing_removeCharacter memorizzando le frasi in minuscolo
          	      nomeCartella_input=Preprocessing.sentencesLowercase(nomeCartella_input,nomeCartella_output);    
          	   
       	      }
         	 }
            
            if(risposta== 4)
            {
         	   i++;
         	   if(i==1)    	  
         	   {
         		  System.out.println();
	              System.out.println("*************** Eliminazione di - nelle frasi *****************");	        
	              System.out.println();
	              nomeCartella_input = "periodi"; // nome della cartella dove si trovano i files cotenenti le frasi da dare in input al metodo
	           	  nomeCartella_output = "periodi_preprocessed";   //nome della cartella dove inserire i file contenenti le frasi in minuscolo 
	              nomeCartella_input=Preprocessing.deleteDash(nomeCartella_input,nomeCartella_output);           	      
         	   }
         	  else
       	      { 
         		  System.out.println();
         		  System.out.println("*************** Eliminazione di - nelle frasi *****************");
          	      System.out.println(); 
          	      //il metodo preprocessing_sentencesLowercase prende in input i file creati dal metodo preprocessing_removeCharacter chiamato prima  
                  // come risultato riscrive i file che erano stati creati dal preprocessing_removeCharacter memorizzando le frasi in minuscolo
          	      nomeCartella_input=Preprocessing.deleteDash(nomeCartella_input,nomeCartella_output);    
          	   
       	      }
         	 }
            
            if(risposta== 5)
            {
         	   i++;
         	   if(i==1)    	  
         	   {
         		  System.out.println();
	              System.out.println("*************** Eliminazione di {} nelle frasi *****************");	        
	              System.out.println();
	              nomeCartella_input = "periodi"; // nome della cartella dove si trovano i files cotenenti le frasi da dare in input al metodo
	           	  nomeCartella_output = "periodi_preprocessed";   //nome della cartella dove inserire i file contenenti le frasi in minuscolo 
	              nomeCartella_input=Preprocessing.deleteParentesiGraffe(nomeCartella_input,nomeCartella_output);           	      
         	   }
         	  else
       	      { 
         		  System.out.println();
         		  System.out.println("*************** Eliminazione di {} nelle frasi *****************");
          	      System.out.println(); 
          	      //il metodo preprocessing_sentencesLowercase prende in input i file creati dal metodo preprocessing_removeCharacter chiamato prima  
                  // come risultato riscrive i file che erano stati creati dal preprocessing_removeCharacter memorizzando le frasi in minuscolo
          	      nomeCartella_input=Preprocessing.deleteParentesiGraffe(nomeCartella_input,nomeCartella_output);    
          	   
       	      }
         	 }
            
            if(risposta== 6)
            {
         	   i++;
         	   if(i==1)    	  
         	   {
         		  System.out.println();
	              System.out.println("*************** Eliminazione di [] nelle frasi *****************");	        
	              System.out.println();
	              nomeCartella_input = "periodi"; // nome della cartella dove si trovano i files cotenenti le frasi da dare in input al metodo
	           	  nomeCartella_output = "periodi_preprocessed";   //nome della cartella dove inserire i file contenenti le frasi in minuscolo 
	              nomeCartella_input=Preprocessing.deleteParentesiQuadre(nomeCartella_input,nomeCartella_output);           	      
         	   }
         	  else
       	      { 
         		  System.out.println();
         		  System.out.println("*************** Eliminazione di [] nelle frasi *****************");
          	      System.out.println(); 
          	      //il metodo preprocessing_sentencesLowercase prende in input i file creati dal metodo preprocessing_removeCharacter chiamato prima  
                  // come risultato riscrive i file che erano stati creati dal preprocessing_removeCharacter memorizzando le frasi in minuscolo
          	      nomeCartella_input=Preprocessing.deleteParentesiQuadre(nomeCartella_input,nomeCartella_output);    
          	   
       	      }
         	 }
            
            if(risposta== 7)
            {
         	   i++;
         	   if(i==1)    	  
         	   {
         		  System.out.println();
	              System.out.println("*************** Eliminazione di () nelle frasi *****************");	        
	              System.out.println();
	              nomeCartella_input = "periodi"; // nome della cartella dove si trovano i files cotenenti le frasi da dare in input al metodo
	           	  nomeCartella_output = "periodi_preprocessed";   //nome della cartella dove inserire i file contenenti le frasi in minuscolo 
	              nomeCartella_input=Preprocessing.deleteParentesiTonde(nomeCartella_input,nomeCartella_output);           	      
         	   }
         	  else
       	      { 
         		  System.out.println();
         		  System.out.println("*************** Eliminazione di () nelle frasi *****************");
          	      System.out.println(); 
          	      //il metodo preprocessing_sentencesLowercase prende in input i file creati dal metodo preprocessing_removeCharacter chiamato prima  
                  // come risultato riscrive i file che erano stati creati dal preprocessing_removeCharacter memorizzando le frasi in minuscolo
          	      nomeCartella_input=Preprocessing.deleteParentesiTonde(nomeCartella_input,nomeCartella_output);    
          	   
       	      }
         	 }
            
            if(risposta== 8)
            {
         	   
         	   if(i==0)    	  
         	   {
         		  
         		  System.out.println();
         		  System.out.println("******* Visualizzazione delle dipendenze grammaticali (Tagging) delle frasi identificate con Stanford Parser *********");
          	      System.out.println();
		          //il metodo grammatical_Dep_Preprocessed prende in input i files contenenti le frasi in cui � stato fatto il preproccessing e da come risultato un file in cui sono presenti le dipendenze grammaticalu delle frasi
		          nomeCartella_input="periodi";
		          nomeFile_output="grammatical_dep.txt";
		          nome_filegrammatical_dep=StampaGrammaticalDep.grammatical_Dep_Preprocessed(nomeCartella_input,nomeFile_output);
         	   }
         	  else
       	      { 
         		 System.out.println();
	             System.out.println("******* Visualizzazione delle dipendenze grammaticali (Tagging) identificate con Stanford Parser delle frasi con preprocessing *********");
	             System.out.println();
	             //il metodo grammatical_Dep_Preprocessed prende in input i files contenenti le frasi in cui � stato fatto il preproccessing e da come risultato un file in cui sono presenti le dipendenze grammaticalu delle frasi
	             nomeFile_output="grammatical_dep_preprocessed.txt";
	             nome_filegrammatical_dep=StampaGrammaticalDep.grammatical_Dep_Preprocessed(nomeCartella_input,nomeFile_output);
          	   
       	      }
         	 }
            
            if(risposta== 9)
            {
         	   
         	   if(i==0)    	  
         	   {
         		  
         		  System.out.println();
	              System.out.println("******* Visualizzazione delle dipendenze(Universal dependencies) delle frasi identificate con Stanford Parser *******");
		          System.out.println();
		          //il metodo dependencies_Preprocessed prende in input i files contenenti le frasi  e da come risultato un file in cui sono presenti le dipendenze delle frasi
		          nomeCartella_input="periodi";
		          nomeFile_output="dependencies.txt";
		          nome_filedependencies=StampaDependencies.dependencies_Preprocessed(nomeCartella_input,nomeFile_output); 
         	   }
         	  else
       	      { 
         		 System.out.println();
	              System.out.println("******* Visualizzazione delle dipendenze(Universal dependencies) identificate con Stanford Parser delle frasi con preprocessing *******");
	              System.out.println();
	             //il metodo dependencies_Preprocessed prende in input i files contenenti le frasi in cui � stato fatto il preproccessing e da come risultato un file in cui sono presenti le dipendenze delle frasi
	             nomeFile_output="dependencies_preprocessed.txt";
	             nome_filedependencies=StampaDependencies.dependencies_Preprocessed(nomeCartella_input,nomeFile_output);         	   
       	      }
         	 }
            
            if(risposta== 10)
            {
         	   
         	   if(i==0)    	  
         	   {
         		   System.out.println();
		           System.out.println("******* Riconoscimento del target delle frasi usando la regola R1 *******");
		           System.out.println();
		           nome_filegrammatical_dep="grammatical_dep.txt";
		           nome_filedependencies="dependencies.txt";
		           nome_fileoutput="r1.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		           nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
		           nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
		           nome_fileinput=R1.r1(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput,nome_fileInputRisultatiunificati,nomeFileOutputRisultatiunificati);
		             
		           System.out.println();
		           System.out.println("******* Visulaizzazione dei targets delle frasi estrapolati usando la regola R1 *******");
		           System.out.println();
		           //nome_fileinput="r1.csv";
		           PrintResultsRule.printResultsRule(nome_fileinput);
         	   }
         	  else
       	      { 
         		 System.out.println();
	             System.out.println("******* Riconoscimento del target delle frasi con preprocessing usando la regola R1 *******");
	             System.out.println();
	             nome_filegrammatical_dep="grammatical_dep_preprocessed.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
	             nome_filedependencies="dependencies_preprocessed.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
	             nome_fileoutput="r1_pre.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
	             nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
		         nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
	             
	             nome_fileinput=R1.r1(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput,nome_fileInputRisultatiunificati,nomeFileOutputRisultatiunificati);
	             
	             System.out.println();
		         System.out.println("******* Visulaizzazione dei targets delle frasi estrapolati usando la regola R1 *******");
		         System.out.println();
		        // nome_fileinput="r1_pre.csv";
		         PrintResultsRule.printResultsRule(nome_fileinput);
       	      }
         	 }
            
            if(risposta== 11)
            {
         	   
         	   if(i==0)    	  
         	   {
         		  System.out.println();
		          System.out.println("******* Riconoscimento del target delle frasi usando la regola R2 *******");
		          System.out.println();
		          nome_filegrammatical_dep="grammatical_dep.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
		          nome_filedependencies="dependencies.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
		          nome_fileoutput="r2.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		          nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
			      nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
		          nome_fileinput=R2.r2(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput,nome_fileInputRisultatiunificati,nomeFileOutputRisultatiunificati);
	          
		          System.out.println();
		          System.out.println("******* Visulaizzazione dei targets delle frasi estrapolati usando la regola R2 *******");
		          System.out.println();
		          nome_fileinput="r2.csv";
		          PrintResultsRule.printResultsRule(nome_fileinput); 
         	   }
         	  else
       	      { 
         		 System.out.println();
	             System.out.println("******* Riconoscimento del target delle frasi con preprocessing usando la regola R2 *******");
	             System.out.println();
	             nome_filegrammatical_dep="grammatical_dep_preprocessed.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
	             nome_filedependencies="dependencies_preprocessed.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
	             nome_fileoutput="r2_pre.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
	             nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
		         nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
	             nome_fileinput=R2.r2(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput,nome_fileInputRisultatiunificati,nomeFileOutputRisultatiunificati);
            
	             System.out.println();
		         System.out.println("******* Visulaizzazione dei targets delle frasi estrapolati usando la regola R2 *******");
		         System.out.println();
		         nome_fileinput="r2_pre.csv";
		         PrintResultsRule.printResultsRule(nome_fileinput);
       	      }
         	 }
            
            if(risposta== 12)
            {
         	   
         	   if(i==0)    	  
         	   {
         		  System.out.println();
	          	  System.out.println("******* Riconoscimento del target delle frasi usando la regola R3 *******");
		          System.out.println();
		          nome_filegrammatical_dep="grammatical_dep.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
		          nome_filedependencies="dependencies.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
		          nome_fileoutput="r3.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		          nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
			         nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
		          nome_fileinput=R3.r3(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput,nome_fileInputRisultatiunificati, nomeFileOutputRisultatiunificati);
		             
		          System.out.println();
		          System.out.println("******* Visulaizzazione dei targets delle frasi estrapolati usando la regola R3 *******");
		          System.out.println();
		          nome_fileinput="r3.csv";
		          PrintResultsRule.printResultsRule(nome_fileinput);
         	   }
         	  else
       	      { 
         		 System.out.println();
            	 System.out.println("******* Riconoscimento del target delle frasi con preprocessing usando la regola R3 *******");
	             System.out.println();
	             nome_filegrammatical_dep="grammatical_dep_preprocessed.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
	             nome_filedependencies="dependencies_preprocessed.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
	             nome_fileoutput="r3_pre.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
	             nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
		         nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
	             nome_fileinput=R3.r3(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput,nome_fileInputRisultatiunificati, nomeFileOutputRisultatiunificati);
	             
	             System.out.println();
		         System.out.println("******* Visulaizzazione dei targets delle frasi estrapolati usando la regola R3 *******");
		         System.out.println();
		         nome_fileinput="r3_pre.csv";
		         PrintResultsRule.printResultsRule(nome_fileinput); 
       	      }
         	 }
            
            if(risposta== 13)
            {
         	   
         	   if(i==0)    	  
         	   {
         		    System.out.println();
		            System.out.println("******* Riconoscimento del target delle frasi usando la regola R4 *******");
		            System.out.println();
		            nome_filegrammatical_dep="grammatical_dep.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
		            nome_filedependencies="dependencies.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
		            nome_fileoutput="r4.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		            nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
			        nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
		            nome_fileinput=R4.r4(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput,nome_fileInputRisultatiunificati,nomeFileOutputRisultatiunificati);
	          	   
	          	    System.out.println();
		            System.out.println("******* Visulaizzazione dei targets delle frasi estrapolati usando la regola R4 *******");
		            System.out.println();
		            nome_fileinput="r4.csv";
		            PrintResultsRule.printResultsRule(nome_fileinput);
         	   }
         	  else
       	      { 
         		 System.out.println();
	             System.out.println("******* Riconoscimento del target delle frasi con preprocessing usando la regola R4 *******");
	             System.out.println();
	             nome_filegrammatical_dep="grammatical_dep_preprocessed.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
	             nome_filedependencies="dependencies_preprocessed.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
	             nome_fileoutput="r4_pre.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
	             nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
		         nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
	             nome_fileinput=R4.r4(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput,nome_fileInputRisultatiunificati,nomeFileOutputRisultatiunificati);
            	   
	             System.out.println();
		         System.out.println("******* Visulaizzazione dei targets delle frasi estrapolati usando la regola R4 *******");
		         System.out.println();
		         nome_fileinput="r4_pre.csv";
		         PrintResultsRule.printResultsRule(nome_fileinput);
       	      }
         	 }
            
            if(risposta== 14)
            {	   
         	   if(i==0)    	  
         	   {
         		  System.out.println();
			      System.out.println("******* Riconoscimento del target delle frasi usando la regola R5 *******");
			      System.out.println();
			      nome_filegrammatical_dep="grammatical_dep.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
			      nome_filedependencies="dependencies.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
			      nome_fileoutput="r5.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
			      nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
			      nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
			      nome_fileinput= R5.r5(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput,nome_fileInputRisultatiunificati,nomeFileOutputRisultatiunificati);
	           
	              System.out.println();
		          System.out.println("******* Visulaizzazione dei targets delle frasi estrapolati usando la regola R5 *******");
		          System.out.println();
		          nome_fileinput="r5.csv";
		          PrintResultsRule.printResultsRule(nome_fileinput);   
         	   }
         	  else
       	      { 
         		     System.out.println();
			         System.out.println("******* Riconoscimento del target delle frasi con preprocessing usando la regola R5 *******");
			         System.out.println();
			         nome_filegrammatical_dep="grammatical_dep_preprocessed.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
			         nome_filedependencies="dependencies_preprocessed.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
			         nome_fileoutput="r5_pre.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
			         nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
			         nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
			         nome_fileinput=R5.r5(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput,nome_fileInputRisultatiunificati,nomeFileOutputRisultatiunificati); 
	            	            
			         System.out.println();
			         System.out.println("******* Visulaizzazione dei targets delle frasi estrapolati usando la regola R5 *******");
			         System.out.println();
			         nome_fileinput="r5_pre.csv";
			         PrintResultsRule.printResultsRule(nome_fileinput); 
       	      }
         	 }

            if(risposta== 15)
            {	   
         	   if(i==0)    	  
         	   {
         		  System.out.println();
			      System.out.println("******* Unificazione dei risultati avuti dalle varie regole *******");
			      System.out.println();
			      nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
			      nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole.xlsx";
			      //RisultatiRegoleUnificati.targetUnificati(nome_fileInputRisultatiunificati,nomeFileOutputRisultatiunificati);   
         	   }
         	  else
       	      { 
         		     System.out.println();
         		     System.out.println("******* Unificazione dei risultati avuti dalle varie regole *******");
			         System.out.println();
			         nome_fileInputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
			         nomeFileOutputRisultatiunificati="TargetRiconosciutiDaRegole_preprocessed.xlsx";
			         RisultatiRegoleUnificati.targetUnificati(nome_fileInputRisultatiunificati,nomeFileOutputRisultatiunificati);   
       	      }
         	 }
            
            
            
            if(risposta== -1)       	
            {
            	System.out.print("Esecuzione terminata del sistema."); 
            	
            }
           }
       
        
        
        
        
        /* if (args != null && args.length > 0) {
	            if (args[0].equals("-nopreprocessing"))
	                
	            {	            	 
	            	 System.out.println();
		             System.out.println("***Visualizzazione delle dipendenze grammaticali identificate da Stanford delle frasi***");
		             System.out.println();
		             //il metodo grammatical_Dep_Preprocessed prende in input i files contenenti le frasi in cui � stato fatto il preproccessing e da come risultato un file in cui sono presenti le dipendenze grammaticalu delle frasi
		             nomeCartella_input="periodi";
		             nomeFile_output="grammatical_dep.txt";
		             nome_filegrammatical_dep=Stampa_Grammatical_Dep_Preprocessed.grammatical_Dep_Preprocessed(nomeCartella_input,nomeFile_output);
	            		            	
	            	System.out.println();
	            	System.out.println("***Visualizzazione delle dipendenze identificate da Stanford delle frasi***");
		            System.out.println();
		             //il metodo dependencies_Preprocessed prende in input i files contenenti le frasi e da come risultato un file in cui sono presenti le dipendenze delle frasi
		            nomeCartella_input="periodi";
		            nomeFile_output="dependencies.txt";
		            nome_filedependencies=Stampa_Dependencies_Preprocessed.dependencies_Preprocessed(nomeCartella_input,nomeFile_output); 
		             
		            System.out.println();
		            System.out.println("***Riconoscimento del target delle frasi usando la regola R1a_lc***");
		            System.out.println();
		           // nome_filegrammatical_dep="grammatical_dep.txt";
		           // nome_filedependencies="dependencies.txt";
		            nome_fileoutput="r1a.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		            nome_fileinput=R1a_lc.r1a_lc(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput);
		             
		            System.out.println();
		            System.out.println("***Visulaizzazione dei targets delle frasi estrapolati usando la regola R1a_lc***");
		            System.out.println();
		            //nome_fileinput="r1a.csv";
		            PrintResults1a.printResults1a(nome_fileinput);
		            		            
		            System.out.println();
		            System.out.println("***Riconoscimento del target delle frasi usando la regola R1b_lc***");
		            System.out.println();
		            nome_filegrammatical_dep="grammatical_dep.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
		            nome_filedependencies="dependencies.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
		            nome_fileoutput="r1b.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		            nome_fileinput=R1b_lc.r1b_lc(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput);
	          
		            System.out.println();
		            System.out.println("***Visulaizzazione dei targets delle frasi estrapolati usando la regola R1b_lc***");
		            System.out.println();
		            //nome_fileinput="r1b.csv";
		            PrintResults1a.printResults1a(nome_fileinput);
		            
		            System.out.println();
	          	    System.out.println("***Riconoscimento del target delle frasi usando la regola R1c_lc***");
		            System.out.println();
		            //nome_filegrammatical_dep="grammatical_dep.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
		            //nome_filedependencies="dependencies.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
		            nome_fileoutput="r1c.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		            nome_fileinput=R1c_lc.r1c_lc(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput);
		             
		            System.out.println();
		            System.out.println("***Visulaizzazione dei targets delle frasi estrapolati usando la regola R1c_lc***");
		            System.out.println();
		            //nome_fileinput="r1c.csv";
		            PrintResults1a.printResults1a(nome_fileinput);
		            
		            System.out.println();
		            System.out.println("***Riconoscimento del target delle frasi usando la regola R1d_lc***");
		            System.out.println();
		            //nome_filegrammatical_dep="grammatical_dep.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
		            //nome_filedependencies="dependencies.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
		            nome_fileoutput="r1d.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		            nome_fileinput=R1d_lc.r1d_lc(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput);
	          	   
	          	    System.out.println();
		            System.out.println("***Visulaizzazione dei targets delle frasi estrapolati usando la regola R1d_lc***");
		            System.out.println();
		            //nome_fileinput="r1d.csv";
		            PrintResults1a.printResults1a(nome_fileinput);
	          	    	          	    
	          	    System.out.println();
			        System.out.println("***Riconoscimento del target delle frasi usando la regola R1e_lc***");
			        System.out.println();
			        //nome_filegrammatical_dep="grammatical_dep.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
			        //nome_filedependencies="dependencies.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
			        nome_fileoutput="r1e.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
			        nome_fileinput= R1e_lc.r1e_lc(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput);
	           
	            
		            System.out.println();
		            System.out.println("***Visulaizzazione dei targets delle frasi estrapolati usando la regola R1e_lc***");
		            System.out.println();
		            //nome_fileinput="r1e.csv";
		            PrintResults1a.printResults1a(nome_fileinput);
	            
	            
	            }	*/            
	            /*else 
	               if (args[0].equals("-preprocessing"))	               
	            {	  
	            	   System.out.println("***Eliminazione degli URL dalle frasi***");
	            	   System.out.println();
	            	   nomeCartella_input = "periodi"; // nome della cartella dove si trovano i files cotenenti le frasi da dare in input al metodo
	            	   nomeCartella_output = "periodi_preprocessed";   //nome della cartella dove inserire i file contenenti le frasi senza URL
	            	   nomeCartella_input =DeleteURL.preprocessing_deleteURL(nomeCartella_input,nomeCartella_output);
		              
		              System.out.println();
		              System.out.println("***Sostituzione dei -1 con minus_one nelle frasi***");
		              System.out.println();
		              //il metodo preprocessing_removeCharacter prende in input i file creati dal metodo preprocessing_deleteURL chiamato prima  
                      // come risultato riscrive i file che erano stati creati dal metodo preprocessing_deleteURL memorizzando le frasi in cui � stato sostituito -1 con minus_one
		              nomeCartella_input=RemoveCharacter.preprocessing_removeCharacter(nomeCartella_input,nomeCartella_output); 
		            
		              System.out.println();
		              System.out.println("***Trasformazione in minuscolo delle frasi***");
		              System.out.println();
		              //il metodo preprocessing_sentencesLowercase prende in input i file creati dal metodo preprocessing_removeCharacter chiamato prima  
                      // come risultato riscrive i file che erano stati creati dal preprocessing_removeCharacter memorizzando le frasi in minuscolo
		              nomeCartella_input=SentencesLowercase.preprocessing_sentencesLowercase(nomeCartella_input,nomeCartella_output);
		              
		              System.out.println();
		             System.out.println("***Visualizzazione delle dipendenze grammaticali identificate da Stanford delle frasi con preprocessing***");
		             System.out.println();
		             //il metodo grammatical_Dep_Preprocessed prende in input i files contenenti le frasi in cui � stato fatto il preproccessing e da come risultato un file in cui sono presenti le dipendenze grammaticalu delle frasi
		             nomeFile_output="grammatical_dep_preprocessed.txt";
		             nome_filegrammatical_dep=Stampa_Grammatical_Dep_Preprocessed.grammatical_Dep_Preprocessed(nomeCartella_input,nomeFile_output);
		              		              
		              System.out.println();
		              System.out.println("***Visualizzazione delle dipendenze identificate da Stanford delle frasi con preprocessing***");
		              System.out.println();
		             //il metodo dependencies_Preprocessed prende in input i files contenenti le frasi in cui � stato fatto il preproccessing e da come risultato un file in cui sono presenti le dipendenze delle frasi
		             nomeFile_output="dependencies_preprocessed.txt";
		             nome_filedependencies=Stampa_Dependencies_Preprocessed.dependencies_Preprocessed(nomeCartella_input,nomeFile_output); 

		             System.out.println();
		             System.out.println("***Riconoscimento del target delle frasi con preprocessing usando la regola R1a_lc***");
		             System.out.println();
		             nome_filegrammatical_dep="grammatical_dep_preprocessed.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
		             nome_filedependencies="dependencies_preprocessed.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
		             nome_fileoutput="r1a_lc.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		             nome_fileinput=R1a_lc.r1a_lc(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput);
		             
		             System.out.println();
			         System.out.println("***Visulaizzazione dei targets delle frasi estrapolati usando la regola R1a_lc***");
			         System.out.println();
			         nome_fileinput="r1a_lc.csv";
			         PrintResults1a.printResults1a(nome_fileinput);
		                      
		             System.out.println();
		             System.out.println("***Riconoscimento del target delle frasi con preprocessing usando la regola R1b_lc***");
		             System.out.println();
		             nome_filegrammatical_dep="grammatical_dep_preprocessed.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
		             nome_filedependencies="dependencies_preprocessed.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
		             nome_fileoutput="r1b_lc.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		             nome_fileinput=R1b_lc.r1b_lc(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput);
	            
		             System.out.println();
			         System.out.println("***Visulaizzazione dei targets delle frasi estrapolati usando la regola R1b_lc***");
			         System.out.println();
			         nome_fileinput="r1b_lc.csv";
			         PrintResults1a.printResults1a(nome_fileinput);
		                     
		             System.out.println();
	            	 System.out.println("***Riconoscimento del target delle frasi con preprocessing usando la regola R1c_lc***");
		             System.out.println();
		             nome_filegrammatical_dep="grammatical_dep_preprocessed.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
		             nome_filedependencies="dependencies_preprocessed.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
		             nome_fileoutput="r1c_lc.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		             nome_fileinput=R1c_lc.r1c_lc(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput);
		             
		             System.out.println();
			         System.out.println("***Visulaizzazione dei targets delle frasi estrapolati usando la regola R1c_lc***");
			         System.out.println();
			         nome_fileinput="r1c_lc.csv";
			         PrintResults1a.printResults1a(nome_fileinput);
		              
		             System.out.println();
		             System.out.println("***Riconoscimento del target delle frasi con preprocessing usando la regola R1d_lc***");
		             System.out.println();
		             nome_filegrammatical_dep="grammatical_dep_preprocessed.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
		             nome_filedependencies="dependencies_preprocessed.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
		             nome_fileoutput="r1d_lc.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
		             nome_fileinput=R1d_lc.r1d_lc(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput);
	            	   
		             System.out.println();
			         System.out.println("***Visulaizzazione dei targets delle frasi estrapolati usando la regola R1d_lc***");
			         System.out.println();
			         nome_fileinput="r1d_lc.csv";
			         PrintResults1a.printResults1a(nome_fileinput);
		             
		             System.out.println();
			         System.out.println("***Riconoscimento del target delle frasi con preprocessing usando la regola R1e_lc***");
			         System.out.println();
			         nome_filegrammatical_dep="grammatical_dep_preprocessed.txt"; //identifica il nome del file in cui sono stati memorizzati le dipendenze grammaticali di Stanford delle frasi
			         nome_filedependencies="dependencies_preprocessed.txt";//identifica il nome del file in cui sono stati memorizzati le dipendenze di Stanford delle frasi
			         nome_fileoutput="r1e_lc.csv"; //identifica il nome del file dove si andranno a memerizzare i risultati ottenuti dalla regola R1a_lc(si memorizzano i target identificati nelle regole)
			         nome_fileinput=R1e_lc.r1e_lc(nome_filegrammatical_dep, nome_filedependencies, nome_fileoutput); 
	            	            
			         System.out.println();
			         System.out.println("***Visulaizzazione dei targets delle frasi estrapolati usando la regola R1e_lc***");
			         System.out.println();
			         nome_fileinput="r1d_lc.csv";
			         PrintResults1a.printResults1a(nome_fileinput);
	            
	            } else{
	            System.out.print("No Arguments passed");
	        }
	 
		
		
	}*/
 }
}