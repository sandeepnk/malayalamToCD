import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
   public static void main(String [] args) {
	 String input = null;
     AllDomains domain = new AllDomains();
     domain.load();
     AllVerbs verbs = new AllVerbs();
     verbs.load();
     
     Parser parser = new Parser(domain, verbs);
     String [] sentences;
      try {
    	  	System.out.println("Enter sentence to convert(with a space before'.' ): ");
    	    InputStreamReader streamReader = new InputStreamReader(System.in);
    	    BufferedReader bufferedReader = new BufferedReader(streamReader);
    	    input  = bufferedReader.readLine();
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}
      sentences=input.split("\\.");
      for(int i=0;i<sentences.length;i++){
    	 System.out.println("Input: " +sentences[i]);
    	 String cdForm=parser.parse(sentences[i]+" .");
    	 System.out.println("\nCD-FORM : "+cdForm+"\n");
      }
  }
} 