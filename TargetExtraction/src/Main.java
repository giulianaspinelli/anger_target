
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
	            else if (args[0].equals("-preprocessing"))
	                System.out.print("Goodbye");

	        } else{
	            System.out.print("No Arguments passed");
	        }
	 
		
		
	}
	
	
	
	
	
	

}
