
public class IObjectStructure extends ObjectStructure {
	//used for place and objects
	String token = new String();
	String name = new String();
	String m_name = new String();
	String cd_form = new String();
	String part_of_speech = new String();
	String type = new String();
	Adjective_structure[] adjective = new Adjective_structure[10];
	ObjectStructure poss_by = new ObjectStructure();
	
	int size;
	int physical_state;
	int quality;
	public String get_state(int state_value, String state_type)
	{
		
		if(state_type.equals("physical_state"))
		{
			switch(state_value)
			{
				case 10: return "ok";
				case -3 : return "hurt";
				case -5 : return "broken";
				case -9 : return "harmed";
				case -10 : return "dead";
			}
		}
		if(state_type.equals("size"))
		{
			switch(state_value)
			{
				case 10: return "massive";
				case 9 : return "huge";
				case 8 : return "normal";
				case 7 : return "small";
				case 6 : return "tiny";
			}
		}
		if(state_type.equals("quality"))
		{
			switch(state_value)
			{
				case 10: return "superb";
				case 9 : return "good";
				case 8 : return "average";
				case 7 : return "bad";
				case 6 : return "poor";
			}
		}
		return "invalid";
	}
}
