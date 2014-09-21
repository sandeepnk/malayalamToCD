import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Test{
	   public static void main(String [] args) {
		   String input =null;
		   String unicode_str =null;
		   String str_unicode =null;
//try {
//	  	System.out.println("Enter statement : ");
//	    InputStreamReader streamReader = new InputStreamReader(System.in);
//	    BufferedReader bufferedReader = new BufferedReader(streamReader);
//	    input  = bufferedReader.readLine();
//	} catch (IOException e) {
//	    e.printStackTrace();
//	}
			/***********************PLACES*****************************/
				try 
				{
					File inFile = new File("PLACES_NAMES");
				     try
				    {
					BufferedReader br = new BufferedReader(new InputStreamReader(
		                      new FileInputStream(inFile), "UTF8"));
					String strLine;
					System.out.println("--------------------------------------------------------------------");
					System.out.println("Places");
					try
					{
						while ((strLine = br.readLine()) != null)   
						{
							String[] parts = strLine.split("-");
							if(parts.length !=2) {
								System.err.println("Error in Parsing");
								return;
							}
							String m_part=parts[1];
							if(m_part.length() == 4){
								  System.out.println("size kitti");
							}
								  unicode_str=unicodeString.convert(m_part);
								  System.out.println("unicode:"+unicode_str);
								  str_unicode = stringUnicode.convert(unicode_str);
								  System.out.println("unicode to string:"+str_unicode);
						}
						br.close();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
				catch (UnsupportedEncodingException e) 
			    {
					System.out.println(e.getMessage());
			    } 
				} 
				catch (FileNotFoundException fe)
				{
				    fe.printStackTrace();
				}
System.out.println("Entered: " +input);
}
}