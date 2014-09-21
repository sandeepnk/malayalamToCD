
public class Action extends ObjectStructure {
	String name = new String();
	String m_name = new String();
	String token = new String();
	String cd_form = new String();
	String part_of_speech = new String();
	ObjectStructure using_instrument = new ObjectStructure();
	String conceptual_tense = new String(); //eq past, present, future
	Adverb_structure[] adverb = new Adverb_structure[10];
	
}
