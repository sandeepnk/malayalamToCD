public class unicodeString
{
	public static String convert(String str)
	{
		StringBuffer ostr = new StringBuffer();
		for(int i=0; i<str.length(); i++) 
		{
			char ch = str.charAt(i);
			if ((ch >= 0x0020) && (ch <= 0x007e))	// Does the char need to be converted to unicode? 
			{
				ostr.append(ch);					// No.
			} else 									// Yes.
			{
	        	ostr.append("\\u") ;				// standard unicode format.
				String hex = Integer.toHexString(str.charAt(i) & 0xFFFF);	// Get hex value of the char. 
				for(int j=0; j<4-hex.length(); j++)	// Prepend zeros because unicode requires 4 digits
					ostr.append("0");
				ostr.append(hex.toLowerCase());		// standard unicode format.
				//ostr.append(hex.toLowerCase(Locale.ENGLISH));
			}
		}
	return (new String(ostr));		//Return the stringbuffer cast as a string.
	}
}
