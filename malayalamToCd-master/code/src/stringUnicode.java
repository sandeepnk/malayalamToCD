import org.apache.commons.lang.StringEscapeUtils;

public class stringUnicode{
	
public static String convert(String unicode)
{
	String converted = unicode;
	return(StringEscapeUtils.unescapeJava(converted));
}
}