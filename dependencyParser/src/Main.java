import dependencyParser.frasi.Stampa_Dependencies;
import preprocessing.DeleteURL;
import preprocessing.RemoveCharacter;
import preprocessing.SentencesLowercase; 

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
		

		 if (args != null && args.length > 0) {
	            if (args[0].equals("-nopreprocessing"))
	            	
	                System.out.print("Hello");
	            else 
	               if (args[0].equals("-preprocessing"))	               
	            {	  
	            	   //System.out.print("Goodbye");
	            	  String path_input = "periodi"; //path_input indica il path dove si trovano i files cotenenti le frasi da dare in input al metodo
	            	  String path_output = "periodi_preprocessed";   //path_input indica il path dove inserire i file contenenti le frasi senza URL
		              DeleteURL.preprocessing_deleteURL(path_input,path_output);
		              //il metodo preprocessing_removeCharacter prende in input i file creati dal metodo preprocessing_deleteURL chiamato prima  
                      // come risultato riscrive i file che erano stati creati dal metodo preprocessing_deleteURL memorizzando le frasi in cui è stato sostituito -1 con minus_one
		              RemoveCharacter.preprocessing_removeCharacter(path_output,path_output); 
		             //il metodopreprocessing_sentencesLowercase prende in input i file creati dal metodo preprocessing_removeCharacter chiamato prima  
                      // come risultato riscrive i file che erano stati creati dal preprocessing_removeCharacter memorizzando le frasi in minuscolo
		              SentencesLowercase.preprocessing_sentencesLowercase(path_output,path_output);
	              

	        } else{
	            System.out.print("No Arguments passed");
	        }
	 
		
		
	}
 }
}