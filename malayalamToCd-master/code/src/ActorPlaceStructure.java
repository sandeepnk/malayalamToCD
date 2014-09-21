
public class ActorPlaceStructure extends IObjectStructure{

	int mental_state;
	int physical_state;
	int health;
	int anger;
	int fear;
	String specific = new String();
	
	
	public ActorPlaceStructure()
	{
		mental_state = 999;
		physical_state=999;
		health=999;
		anger=999;
		fear=999;
	}
	public String get_state(int state_value, String state_type)
	{
		if(state_type.equals("mental_state"))
		{
			switch(state_value)
			{
				case 10: return "ecstatic";
				case 5 : return "happy";
				case 2 : return "pleased";
				case 0 : return "ok";
				case -2 : return "sad";
				case -3 : return "upset";
				case -5 : return "depressed";
				case -9 : return "catatonic";
				default : return "invalid";
			}
		}
		if(state_type.equals("physical_state"))
		{
			switch(state_value)
			{
				case 10: return "ok";
				case -3 : return "hurt";
				case -5 : return "injured";
				case -9 : return "harmed";
				case -10 : return "dead";
			}
		}
		if(state_type.equals("anger"))
		{
			switch(state_value)
			{
				case 0: return "calm";
				case -2 : return "upset";
				case -3 : return "irked";
				case -5 : return "angry";
				case -8 : return "enraged";
				case -9 : return "furious";
			}
		}
		if(state_type.equals("health"))
		{
			switch(state_value)
			{
				case 10 : return "perfect";
				case 7 : return "tip top";
				case 0 : return "all right";
				case -7 : return "sick";
				case -9 : return "gravely ill";
				case -10 : return "dead";
			}
		}
		return "invalid";
	}
}
