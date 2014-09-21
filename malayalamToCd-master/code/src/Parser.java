import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

@SuppressWarnings("unused")
public class Parser {
	AllDomains domain;
	AllVerbs verbs;

	HashMap<String, String> mapObjects = new HashMap<String, String>();
	private String global_ret;
	private String Using;
	Parser(AllDomains output_1a_domain, AllVerbs output_1a_verbs){
		domain = output_1a_domain;
		verbs = output_1a_verbs;
	}
	public String parse(String new_string){
		create_maps();
		//        Iterator iterator = mapObjects.keySet().iterator();  
		//        
		//        while (iterator.hasNext()) {  
		//           String key = iterator.next().toString();  
		//           String value = mapObjects.get(key).toString();  
		//           
		//             
		//        }  
		String temp = new String();
		temp = new_string;
		String karthavu = "", karmam = "";
		String[] parts = temp.split("\\s+");
		for(int i = 0; i < parts.length ; i++){
			//
			if(mapObjects.containsKey(parts[i])){
				String type = mapObjects.get(parts[i]);
				if(type.equals("politicians")){
					//
					karthavu = parts[i];
				}
				else if(type.equals("objects")){
					karmam = parts[i];
					//
				}
				else if(type.equals("pronouns") && !parts[i].equals("ഏത്") && !parts[i].equals("ആരുടെ") &&
						!parts[i].equals("ആരേ") && !parts[i].equals("ആര്") ){
					
					if(parts[i].equals("അത്") || parts[i].equals("ഇത്")){
						parts[i] = karmam;
						//
					}
					else{
						parts[i] = karthavu;
						//
					}
				}
			}
		}
		new_string = "";
		for(int i = 0; i < parts.length ; i++){
			new_string = new_string + parts[i] + " ";
		}
		//
		parse_sentence(new_string);
		return global_ret;
	}

	public void create_maps(){
		int i;
		for(i = 0; i < 116; i++){
			try{
				mapObjects.put(domain.politicians[i].m_name, "politicians");
			}
			catch(NullPointerException e){
				break;
			}
		}

		for(i = 0; i < 600; i++){
			try{
				//mapObjects.put(domain.places[i].name, "places");
				mapObjects.put(domain.places[i].m_name, "places");
			}
			catch(NullPointerException e){
				break;
			}
		}

		for(i = 0; i < 100; i++){
			try{
				//mapObjects.put(domain.pronouns[i].name, "pronouns");
				mapObjects.put(domain.pronouns[i].m_name, "pronouns");
			}
			catch(NullPointerException e){
				break;
			}
		}

		for(i = 0; i < 150; i++){
			try{
				//mapObjects.put(domain.adjective[i].name, "adjective");
				mapObjects.put(domain.adjective[i].m_name, "adjective");
			}
			catch(NullPointerException e){
				break;
			}
		}

		for(i = 0; i < 100; i++){
			try{
				//mapObjects.put(domain.adverb[i].name, "adverb");
				mapObjects.put(domain.adverb[i].m_name, "adverb");
			}
			catch(NullPointerException e){
				break;
			}
		}
		for(i = 0; i < 150; i++){
			try{
				//mapObjects.put(domain.objects[i].name, "objects");
				mapObjects.put(domain.objects[i].m_name, "objects");
			}
			catch(NullPointerException e){
				break;
			}
		}
		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.mtrans_verbs[i].m_name, "mtrans_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}
		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.speak_verbs[i].m_name, "speak_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}
		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.mbuild_verbs[i].m_name, "mbuild_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}
		for(i = 0; i < 100; i++){
			try{
				//mapObjects.put(verbs.ptrans_verbs[i].name, "ptrans_verbs");
				mapObjects.put(verbs.ptrans_verbs[i].m_name, "ptrans_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}
		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.atrans_verbs[i].m_name, "atrans_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}
		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.propel_verbs[i].m_name, "propel_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}
		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.expel_verbs[i].m_name,"expel_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}
		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.grasp_verbs[i].m_name, "grasp_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}
		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.ingest_verbs[i].m_name, "ingest_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}

		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.attend_verbs[i].m_name, "attend_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}

		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.state_verbs[i].m_name, "state_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}
	}
	
	String parse_sentence(String sentence){
		String new_str = "";
		String[] parts = sentence.split("\\s+");
		int i,j,x,length=parts.length;
		for(i = 0; i < parts.length; i++){
			String part;
			part = parts[i].toLowerCase();
			if(mapObjects.containsKey(part) && mapObjects.get(part).equals("mbuild_verbs")){
				process_mbuild(sentence, parts);
				return "";
			}
		}
		if((x = search("അതുകൊണ്ട്", parts))  != 0){
			String sub1 = "", sub2 = "";
			for(j = 0; j < x; j++){
				sub1 = sub1+ " " +parts[j];
			}
			for(j = x+1; j < length; j++){
				sub2 = sub2 + " " + parts[j];
			}
			parse_sentence(sub1);
			String s1 = global_ret;
			parse_sentence(sub2);
			String s2 = global_ret;
			global_ret = "(LEADSTO \n  " + s1 + " \n  " + s2 + "\n  (CONC_TENSE PAST)\n  (USING NULL))";
			return global_ret;
		}
		else if(((x = search("by", parts))  != 0) || ((x = search("because", parts))  != 0)){
			String sub1 = "", sub2 = "";
			for(j = 0; j < x; j++){
				sub1 = sub1+ " " +parts[j];
			}
			for(j = x+1; j < length; j++){
				sub2 = sub2 + " " + parts[j];
			}
			parse_sentence(sub2);
			String s1 = global_ret;
			parse_sentence(sub1);
			String s2 = global_ret;
			global_ret = "(LEADSTO \n  " + s1 + " \n  " + s2 + "\n  (CONC_TENSE PAST)\n  (USING NULL))\n";
			return global_ret;
		}
		else if(((x = search("prevented", parts))  != 0) || ((x = search("prevents", parts))  != 0) || 
				((x = search("prevent", parts))  != 0) || ((x = search("preventing", parts))  != 0)){
			String sub1 = "", sub2 = "";
			for(j = 0; j < x; j++){
				sub1 = sub1+ " " +parts[j];
			}
			for(j = x+1; j < length; j++){
				sub2 = sub2 + " " + parts[j];
			}
			parse_sentence(sub1);
			String s1 = global_ret;
			parse_sentence(sub2);
			String s2 = global_ret;
			global_ret = "(LEADSTO \n  " + s1 + " \n  " + s2 + "\n  (CONC_TENSE NOT)\n  (USING NULL))\n";
			return global_ret;
		}
		else if((x = search("that", parts)) != 0){
			
			String sub1 = "", sub2 = "";
			for(j = 0; j < x; j++){
				sub1 = sub1+ " " +parts[j];
			}
			for(j = x+1; j < length; j++){
				sub2 = sub2 + " " + parts[j];
			}
			parse_sentence(sub1);
			String s1 = new String(global_ret);
			parse_sentence(sub2);
			String s2 = new String(global_ret);
			int index = s1.indexOf("(OBJECT NULL)");
			String s11 = s1.substring(0, index+8);
			String s12 = s1.substring(index+12, s1.length());
			global_ret = s11+" "+s2+s12;
			//System.out.println("final : "+global_ret);
			return global_ret;
		}
		else{
		String using = "NULL";
		String adj = "", adj_n = "", adj_o = "", noun = "";
		String[] part = sentence.split("\\s+");
		for(i = 0; i < part.length ; i++){
			if(part[i].equals("കൊണ്ട്")||part[i].equals("ഉപയോഗിച്ച്")){
				new_str = new String("");
				for(j = 0 ; j < i ; j ++){
					if(mapObjects.containsKey(part[j]) 
							&& mapObjects.get(part[j]).equals("objects")&&part[j+1].equals("കൊണ്ട്")||part[j+1].equals("ഉപയോഗിച്ച്")){
						using = part[j];
						adj_o = adj;
						break;
					}
					else if(part[j].endsWith("യുടെ")){
						String remain1 = part[j].replace("യുടെ", "");
						if(mapObjects.containsKey(remain1) 
								&& (mapObjects.get(remain1).equals("politicians") 
										||mapObjects.get(remain1).equals("places"))){
							adj_n = adj;
							adj = "";
							noun = remain1;
						}}
					else if(part[j].endsWith("വിന്റെ")){
						String remain = part[j].replace("വിന്റെ", "");
						if(mapObjects.containsKey(remain) 
								&& (mapObjects.get(remain).equals("politicians") 
										||mapObjects.get(remain).equals("places"))){
							adj_n = adj;
							adj = "";
							noun = remain;
						}
					}
					else if(mapObjects.containsKey(part[j]) 
							&& mapObjects.get(part[j]).equals("adjective")){
						adj = adj + "(ISA" + getCDForm(part[j],"a")+")";
					}
					else {
						new_str += part[j]+ " ";
					}
				}
			}/*End of കൊണ്ട് */
			else
				new_str += part[i]+ " ";
		}
		if(using.equals("NULL")){
			Using = "(USING NULL)";
		}
		else{
			Using = "(USING (OBJECT (NAME "+getBaseForm(using)+")";
			if(!noun.equals("")){
				Using += "(POSSBY (PERSON (NAME "+ getBaseForm(noun)+")(POSSBY NULL) ";
				if(!adj_n.equals("")){
					Using += getBaseForm(adj_n);
				}
				Using += "))";
				Using += getBaseForm(adj_o)+"))";
			}
			else{
				Using += "(POSSBY NULL)"+ getBaseForm(adj_o)+"))";
			}
		}
}
		sentence = new_str;
		return process_simple(new_str);
	}

	int search(String x, String[] p){
		int i;
		for(i = 0; i < p.length; i++){
			if(p[i].equals(x))
				return i;
		}
		return 0;
	}

	String process_simple(String sentence){
		String[] parts = sentence.split("\\s+");
		int i,flag = 0, whose = 0;
		String map = "";
		String whoseobject = "";
		boolean whosenoun = false;	
		LinkedHashMap<String, ArrayList<String>> objectAdj = new LinkedHashMap<String, ArrayList<String>>();
		ArrayList<String> adds = new ArrayList<String>();
		ArrayList<String> adds2 = new ArrayList<String>();
		ArrayList<String> verb_adverb = new ArrayList<String>();
		String karthavu = "";
		String verb_sent = "";
		String remain ="";
		int offlag=0;
		// parse to determine adjectives and adverbs
		for(i = 0; i < parts.length; i++){
			if(parts[i].equals("")){
				continue;
			}
			if(parts[i].endsWith("വിന്റെ")||parts[i].endsWith("യുടെ")) {
				remain = parts[i].replace("യുടെ", "");
				parts[i] = parts[i].replace("യുടെ", "");
				map = mapObjects.get(remain);
				if(!mapObjects.get(parts[i]).equals("politicians") && karthavu != ""){
					offlag = 1;
				}
			}
			else{
				map = mapObjects.get(parts[i]);
			}
			if(map == null || map.equals(".")){
				continue;
			}
			if(whosenoun && map.equals("adjective")){
				objectAdj.get(whoseobject).add(parts[i]);
				whosenoun = false;
				whose = 0;
				continue;
			}//of replaced,other cases TODO
			if(offlag == 1) {
				flag = 1;	
				continue;
			}
			else if(parts[i].equals("ആരുടെ")){
				whose = 1;
			}
			else if(map.equals("adjective")){
				if(flag == 0 && whose != 1){
					adds.add(parts[i]);
				}
				else if(flag == 1 || whose == 1){
					adds2.add(parts[i]);
				}
			}
			else if(map.equals("adverb")){
				verb_adverb.add(parts[i]);
			}
			else if(map.equals("politicians")||map.equals("places")||
					(map.equals("pronouns") && !parts[i].equals("ഏത്") && !parts[i].equals("ആരുടെ") &&
							!parts[i].equals("ആരേ") && !parts[i].equals("ആര്")||map.equals("objects"))){
				if(whose == 1){
					whoseobject = parts[i];
					whosenoun = true;
					if(!objectAdj.containsKey(parts[i])){
						ArrayList<String> toput = new ArrayList<String>();
						toput.addAll(adds2);
						objectAdj.put(parts[i], toput);
						adds2.clear();
					}
				}
				else if(flag == 1){
					flag = 0;
					if(!objectAdj.containsKey(parts[i])){
						ArrayList<String> toput = new ArrayList<String>();
						toput.addAll(adds2);
						objectAdj.put(parts[i], toput);
						adds2.clear();
					}
				}
				else{

					karthavu = parts[i];
					//
					if(!objectAdj.containsKey(parts[i])){
						ArrayList<String> toput = new ArrayList<String>();
						toput.addAll(adds);
						objectAdj.put(parts[i], toput);
						adds.clear();
					}
				}
			}
			else if(map.substring(map.lastIndexOf('_') + 1).equals("verbs")){
				verb_sent = parts[i];
				ArrayList<String> toput = new ArrayList<String>();
				toput.addAll(adds);
				objectAdj.get(karthavu).addAll(toput);
				adds.clear();
			}
		}
		objectAdj.get(karthavu).addAll(adds);
		if(!verb_sent.equals("")){
			ArrayList<String> toput = new ArrayList<String>();
			toput.addAll(verb_adverb);
			objectAdj.put(verb_sent,toput);
		}
		//
		//2nd Parse to determine possessed by
		ArrayList<Character> Type_char_list = new ArrayList<Character>();
		ArrayList<Integer> index_list = new ArrayList<Integer>();
		LinkedHashMap<String, ArrayList<String>> poss_by = new LinkedHashMap<String, ArrayList<String>>();
		String remain1 ="";
		for(i = 0 ; i < parts.length ; i++){
			if(parts[i].equals("")){
				continue;
			}
			map = mapObjects.get(parts[i]);
			//of changed.
			if(parts[i].endsWith("യുടെ")||parts[i].endsWith("വിന്റെ")){
				remain1 = parts[i].replace("യുടെ", "");
				if(mapObjects.get(remain1).equals("politicians")&& 
						!mapObjects.get(remain1).equals("objects")){
					Type_char_list.add('n');
					index_list.add(i);
				}
			}
			else if(map == null || map.equals(".")){
				//'s changed
				if(parts[i].endsWith("വിന്റെ"))
					continue;
				Type_char_list.add('*');
				index_list.add(i);
				continue;
			}
			else if(map.equals("objects")||map.equals("politicians")|| map.equals("pronouns") 
					||map.equals("places")){
				if(parts[i].equals("ആരുടെ")){
					continue;
				}
				Type_char_list.add('n');
				index_list.add(i);
			}
			else if(map.substring(map.lastIndexOf('_') + 1).equals("verbs")){
				Type_char_list.add('v');
				index_list.add(i);
			}
			else if(!map.equals("adverb") && !map.equals("adjective")){
				Type_char_list.add('*');
				index_list.add(i);
			}
			/*else {
				Type_char_list.add('o');
				index_list.add(i);
			}*/
		}
		//		
		//		

		for(int k = 0; k < Type_char_list.size(); k++){
			if(Type_char_list.get(k) == 'n'){
				if((k+2) < Type_char_list.size() && 
						Type_char_list.get(k+2) == 'n' 
						&& Type_char_list.get(k+1) != 'n'){
					ArrayList<String> poss = new ArrayList<String>();
					poss.add(parts[index_list.get(k+2)]); //subject object verb.
					poss_by.put(parts[index_list.get(k)], poss); 
					k = k+1;
				}
				else if((k+2) < Type_char_list.size() && Type_char_list.get(k+2) == 'n'&& Type_char_list.get(k+1) == 'n'){
					if(Type_char_list.get(k+2) == '*'){
						ArrayList<String> poss = new ArrayList<String>();
						poss.add(parts[index_list.get(k)]); //n n n
						poss_by.put(parts[index_list.get(k+1)], poss); 
						k = k+2;
					}
					else{ArrayList<String> poss = new ArrayList<String>();
					poss.add(parts[index_list.get(k+1)]); //n n n
					poss_by.put(parts[index_list.get(k)], poss); 
					k = k+1;
					}
				}
				//TODO
				/*else if((k+5) < Type_char_list.size() && Type_char_list.get(k+1) == '*' && 
						Type_char_list.get(k+2) == 'n' && Type_char_list.get(k+3) == 'n' && Type_char_list.get(k+5) == 'v'){
					ArrayList<String> poss = new ArrayList<String>();
					poss.add(parts[index_list.get(k+3)]);
					poss.add(parts[index_list.get(k)]);
					poss_by.put(parts[index_list.get(k+2)], poss);
					//k = k+3;
					break;
				}*/
				//TODO
				else if((k+2) < Type_char_list.size() && Type_char_list.get(1) == 'o'
						&& Type_char_list.get(2) == 'n'){
					ArrayList<String> poss = new ArrayList<String>();
					poss.add(parts[index_list.get(k+2)]);
					poss_by.put(parts[index_list.get(k)], poss);
					k = k + 2;
				}
				else{
					ArrayList<String> poss;
					/*if(poss_by.containsKey(parts[index_list.get(k)])) {
						poss = new ArrayList<String>(poss_by.get(parts[index_list.get(k)]));
						poss.add("");
					} else*/
					poss = new ArrayList<String>();
					poss_by.put(parts[index_list.get(k)], poss);
				}
			}
		}
		//
		String ret = "";
		//	
		if(verb_sent.equals("")){
			ret  = process_noverb(poss_by, objectAdj, sentence);
		}
		else{
			switch(mapObjects.get(verb_sent)){
			case "mtrans_verbs":
				ret = process_mtrans(poss_by, objectAdj, sentence, verb_sent);
				break;
			case "speak_verbs":
				ret = process_speak(poss_by, objectAdj, sentence, verb_sent);
				break;
			case "ptrans_verbs":
				ret = process_ptrans(poss_by, objectAdj, sentence, verb_sent);
				break;
			case "atrans_verbs":
				ret = process_atrans(poss_by, objectAdj, sentence, verb_sent);
				break;
			case "propel_verbs":
				ret = process_propel(poss_by, objectAdj, sentence,verb_sent);
				break;
			case "mbuild_verbs":
				ret = process_mtrans(poss_by, objectAdj, sentence,verb_sent);
				break;
			case "expel_verbs":
				ret = process_expel(poss_by, objectAdj, sentence, verb_sent);
				break;
			case "grasp_verbs":
				ret = process_grasp(poss_by, objectAdj, sentence, verb_sent);
				break;
			case "ingest_verbs":
				ret = process_ingest(poss_by, objectAdj, sentence, verb_sent);
				break;
			case "attend_verbs":
				ret = process_attend(poss_by, objectAdj, sentence, verb_sent);
				break;
				case "state_verbs":
					ret = process_state(poss_by, objectAdj, sentence, verb_sent);
					break;
			default:
				ret = process_noverb(poss_by, objectAdj, sentence);
				break;
			}
		}
		return ret;
	}
	/**
	 * Get CD Form.
	 * @param s String word
	 * @param p String 
	 * 		n : noun
	 * 		o : object
	 * 		no: noun or object
	 * 		a : {@link Adjective_structure}
	 * 		av: {@link Adverb_structure}
	 * @return CDFORM
	 */
	String getCDForm(String s, String p){
		if(p.equals("n")){
			//politicians,place,pronoun
			for(int i = 0 ;  i < domain.nPoliticians; i++){
				if(domain.politicians[i].m_name.equals(s))
					return domain.politicians[i].cd_form;
			}
			for(int i = 0 ;  i < domain.nPlaces ; i++){
				if(domain.places[i].m_name.equals(s))
					return domain.places[i].cd_form;
			}
			for(int i = 0 ;  i < domain.nPronouns; i++){
				try{
					if(domain.pronouns[i].m_name.equals(s))
						return domain.pronouns[i].cd_form;
				}
				catch(IndexOutOfBoundsException e){
					break;
				}
			}
		}
		else if(p.equals("o")){
			//object
			for(int i = 0 ;  i < domain.nObjects ; i++){
				if(domain.objects[i].m_name.equals(s))
					return domain.objects[i].cd_form;
			}
		}
		else if(p.equals("no")){
			//politician,place,pronoun,object
			for(int i = 0 ;  i < domain.nPoliticians; i++){
				String check =""; 
				//
				if(s.endsWith("യുടെ")){
					check = s.replace("യുടെ", "");}
				if(domain.politicians[i].m_name.equals(check)){
					return domain.politicians[i].cd_form;	
				}
				else if(domain.politicians[i].m_name.equals(s)){
					return domain.politicians[i].cd_form;}
				else{continue;}
			}
			for(int i = 0 ;  i < domain.nPlaces ; i++){
				if(domain.places[i].m_name.equals(s))
					return domain.places[i].cd_form;
			}
			for(int i = 0 ;  i < domain.nPronouns; i++){
				try{
					if(domain.pronouns[i].m_name.equals(s))
						return domain.pronouns[i].cd_form;
				}
				catch(IndexOutOfBoundsException e){
					break;
				}
			}
			for(int i = 0 ;  i < domain.nObjects; i++){
				if(domain.objects[i].m_name.equals(s))
					return domain.objects[i].cd_form;
			}
		}
		else if(p.equals("a")){
			//adjective
			for(int i = 0 ;  i < domain.nAdjective ; i++){
				if(domain.adjective[i].m_name.equals(s))
					return domain.adjective[i].cd_form;
			}
		}
		else if(p.equals("av")){
			//adjective
			for(int i = 0 ;  i < domain.nAdverb; i++){
				if(domain.adverb[i].m_name.equals(s))
					return domain.adjective[i].cd_form;
			}
		}
		return s;
	}
	
	
	/**
	 * Get Base Form for CD output.
	 * @param s String word
	 * @return Base form for CDFORM
	 */
	String getBaseForm(String s){
			for(int i = 0 ;  i <domain.nPoliticians; i++){
				if(domain.politicians[i].m_name.equals(s))
					return domain.politicians[i].name;
			}
			for(int i = 0 ;  i < domain.nPlaces ; i++){
				if(domain.places[i].m_name.equals(s))
					return domain.places[i].name;
			}
			for(int i = 0 ;  i < domain.nPronouns ; i++){
					if(domain.pronouns[i].m_name.equals(s))
						return domain.pronouns[i].name;
			}
			for(int i = 0 ;  i < domain.nObjects ; i++){
				if(domain.objects[i].m_name.equals(s))
					return domain.objects[i].name;
			}
			for(int i = 0 ;  i < domain.nAdjective ; i++){
				if(domain.adjective[i].m_name.equals(s))
					return domain.adjective[i].name;
			}
			for(int i = 0 ;  i < domain.nAdverb ; i++){
				if(domain.adverb[i].m_name.equals(s))
					return domain.adjective[i].name;
			}
		return s;
	}

	String process_noverb(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence){
		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String pos = "", src = "", dest = "";
		String temp = "", actor = "", actor_cd = "";


		Iterator<String> it = possessMap.keySet().iterator();
		if(it.hasNext()) {
			p1 = (String) it.next();
			p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ " ) ";
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String tempCDform = "";
					if(addMap.containsKey(t2)){
						tempCDform = getCDForm(t2,"no");
						tempCDform = tempCDform.substring(0,tempCDform.lastIndexOf(')'));
						tempCDform = tempCDform + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							tempCDform = tempCDform + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						tempCDform += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+tempCDform
								+" ) ";
					}
					else{
						p1_cd = p1_cd + " "+ tempCDform + " ";
					}
				}
				else if(possessMap.get(p1).size() == 2){
					String t2 = possessMap.get(p1).get(0);
					String tempCDForm = "";
					String t1 = possessMap.get(p1).get(1);
					String tempCDForm1 = "";
					if(addMap.containsKey(t1)){
						tempCDForm1 = getCDForm(t1,"no");
						tempCDForm1 = tempCDForm1.substring(0,tempCDForm1.lastIndexOf(')'));
						tempCDForm1 = tempCDForm1 + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							tempCDForm1 = tempCDForm1 + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						tempCDForm1 += ")";
					}
					if(addMap.containsKey(t2)){
						tempCDForm = getCDForm(addMap.get(t2).get(0),"no");
						tempCDForm = tempCDForm.substring(0,tempCDForm.lastIndexOf(')'));
						tempCDForm = tempCDForm + "( POSSBY " + tempCDForm1 + " )";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							tempCDForm = tempCDForm + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						tempCDForm += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+tempCDForm + " ) ";
					}
					else{
						p1_cd = p1_cd + "(POSSBY "+tempCDForm
								+" "+tempCDForm1 + " ) ";
					}
				}
				else if(possessMap.get(p1).size() == 0){
					p1_cd = p1_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(p1)){
				for(int i = 0 ; i < addMap.get(p1).size(); i++){
					p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";


		}

		ret  = p1_cd;		

		//	
		global_ret = ret;
		return ret;

	}	

	String process_ptrans(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String pos = "", src = "", dest = "", src_cd = "", dest_cd = "";
		String temp = "", actor = "", actor_cd = "";
		Ptrans ptrans_verb = new Ptrans();
		for(int i = 0; i < verbs.ptrans_verbs.length; i++){
			if(verbs.ptrans_verbs[i].m_name.equals(verb_sent)){
				ptrans_verb = verbs.ptrans_verbs[i];
				break;
			}
		}
		String[] parts = sentence.split("\\s+");
		Iterator<String> it = possessMap.keySet().iterator();
		int fromflag = 0, toflag = 0;
		for(int i = 0; i < parts.length; i++){
			if(parts[i].equals("നിന്നും")||parts[i].equals("നിന്ന്")) 
				fromflag = 1;
			else if(parts[i].endsWith("യിലേക്ക്")|| parts[i].equals("വരെ")) {
				toflag = 1;
			}
			else if(possessMap.containsKey(parts[i]) &&
					mapObjects.get(parts[i]).equals("politicians") && fromflag == 0 && toflag == 1){
				src = parts[i];
			}
			else if(possessMap.containsKey(parts[i])){
				if(mapObjects.get(parts[i]).equals("objects")){
					obj = parts[i];
				}
				//				else{
				//					obj = p1;
				//				}
			}
			if( fromflag == 1 && possessMap.containsKey(parts[i-1]) &&
					mapObjects.get(parts[i-1]).equals("places")){
				fromflag = 0;
				src = parts[i-1];
			}
			if(toflag == 1){
				if(parts[i].endsWith("യിലേക്ക്")){
					String remain = parts[i].replace("യിലേക്ക്","");
					//
					if(mapObjects.get(remain).equals("places")){
						toflag = 0;
						dest = remain;}
				}
				else{
					
					if(parts[i].equals("വരെ") && mapObjects.get(parts[i-1]).equals("places")){
						
						toflag = 0;
						dest = parts[i-1];}
				}
			}
		}
		///////////////////
		if(it.hasNext()) {
			p1 = (String) it.next();
			String map = mapObjects.get(p1);
			//	
			if(!map.equals("pronouns")&& map.equals("politicians"))
				p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ " ) ";
			else 	//should take care of every pronouns
				p1_cd = "(PERSON ";
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					if(addMap.containsKey(t2)){
						t = getCDForm(t2,"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t
								+" ) ";
					}
					else{
						p1_cd = p1_cd + " "+ t + " ";
					}
				}
				else if(possessMap.get(p1).size() == 2){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					String t1 = possessMap.get(p1).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "( POSSBY " + t1_cd + " )";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
					}
					else{
						p1_cd = p1_cd + "(POSSBY "+t
								+" "+t1_cd + " ) ";
					}
				}
				else if(possessMap.get(p1).size() == 0){
					p1_cd = p1_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(p1)){
				for(int i = 0 ; i < addMap.get(p1).size(); i++){
					p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";
			//	
		}
		///////////////////done actor/////////////
		if(src != ""){
			if(mapObjects.get(src).equals("politicians")){
				src_cd = " (PERSON (NAME "+getBaseForm(src)+" ) ";
			}
			else{
				src_cd = " (PLACE (NAME "+getBaseForm(src)+" ) ";}
			if(possessMap.containsKey(src)){
				if(possessMap.get(src).size() == 1 ){
					String t2 = possessMap.get(src).get(0);
					if(t2.equals(p1)){
						src_cd = src_cd + " (POSSBY " + p1_cd + ")";
					}
					else{
						String t = "";
						if(addMap.containsKey(t2)){
							t = getCDForm(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t+" (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(src).get(0)).equals("pronouns")){
							src_cd = src_cd + "(POSSBY "+t
									+" ) ";
						}
						else{
							src_cd = src_cd + " "+ t + " ";
						}
					}
				}
				else if(possessMap.get(src).size() == 2){
					String t2 = possessMap.get(src).get(0);
					String tmpCD = "";
					String t1 = possessMap.get(src).get(1);
					String tmpCD1 = "";
					if(addMap.containsKey(t1)){
						tmpCD1 = getCDForm(t1,"no");
						tmpCD1 = tmpCD1.substring(0,tmpCD1.lastIndexOf(')'));
						tmpCD1 = tmpCD1 + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							tmpCD1 = tmpCD1 + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						tmpCD1 += ")";
					}
					if(addMap.containsKey(t2)){
						tmpCD = getCDForm(addMap.get(t2).get(0),"no");
						tmpCD = tmpCD.substring(0,tmpCD.lastIndexOf(')'));
						tmpCD = tmpCD + "(POSSBY " + tmpCD1 + ")";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							tmpCD = tmpCD + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						tmpCD += ")";
					}
					if(!mapObjects.get(possessMap.get(src).get(1)).equals("pronouns")){
						src_cd = src_cd + "(POSSBY "+tmpCD + " ) ";
					}
				}
				else if(possessMap.get(src).size() == 0){
					src_cd = src_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(src)){
				for(int i = 0 ; i < addMap.get(src).size(); i++){
					src_cd = src_cd + "(ISA "+getCDForm(addMap.get(src).get(i),"a")+" ) ";
				}
			}
			src_cd += " )";
		}
		//////////////done source/////////////////
		if(dest != ""){
			dest_cd = " (PLACE (NAME "+getBaseForm(dest)+" ) ";
			if(possessMap.containsKey(dest)){
				if(possessMap.get(dest).size() == 1 ){
					String t2 = possessMap.get(dest).get(0);
					if(t2.equals(p1)){
						dest_cd = dest_cd + " (POSSBY " + p1_cd + ")";
					}
					else{
						String tempCD = "";
						if(addMap.containsKey(t2)){
							tempCD = getCDForm(t2,"n");
							tempCD = tempCD.substring(0,tempCD.lastIndexOf(')'));
							tempCD = tempCD+" (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								tempCD = tempCD + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							tempCD += ")";
						}
						if(!mapObjects.get(possessMap.get(dest).get(0)).equals("pronouns")){
							dest_cd = dest_cd + "(POSSBY "+tempCD
									+" ) ";
						}
						else{
							dest_cd = dest_cd + " "+ tempCD + " ";
						}
					}
				}
				else if(possessMap.get(dest).size() == 2){
					String t2 = possessMap.get(dest).get(0);
					String tmpCD = "";
					String t1 = possessMap.get(dest).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						tmpCD = getCDForm(addMap.get(t2).get(0),"no");
						tmpCD = tmpCD.substring(0,tmpCD.lastIndexOf(')'));
						tmpCD = tmpCD + "(POSSBY " + t1_cd + ")";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							tmpCD = tmpCD + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						tmpCD += ")";
					}
					if(!mapObjects.get(possessMap.get(dest).get(1)).equals("pronouns")){
						dest_cd = dest_cd + "(POSSBY "+tmpCD + " ) ";
					}
				}
				else if(possessMap.get(dest).size() == 0){
					dest_cd = dest_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(dest)){
				for(int i = 0 ; i < addMap.get(dest).size(); i++){
					dest_cd = dest_cd + "(ISA "+getCDForm(addMap.get(dest).get(i),"a")+" ) ";
				}
			}
			dest_cd += " )";
		}
		/////////////done dest////////////////////
		if(obj.equals("")){
			obj_cd = "(OBJECT " + p1_cd + " )";
		}
		else{
			obj_cd = " (OBJECT (OBJECT (NAME "+getBaseForm(obj)+" ) ";
			if(possessMap.containsKey(obj)){
				if(possessMap.get(obj).size() == 1 ){
					String t2 = possessMap.get(obj).get(0);
					if(t2.equals(p1)){
						obj_cd = obj_cd + " (POSSBY " + p1_cd + ")";
					}
					else{
						String t = "";
						if(addMap.containsKey(t2)){
							t = getCDForm(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t+" (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
							obj_cd = obj_cd + "(POSSBY "+t
									+" ) ";
						}
						else{
							obj_cd = obj_cd + " "+ t + " ";
						}
					}
				}
				else if(possessMap.get(obj).size() == 2){
					String t2 = possessMap.get(obj).get(0);
					String t = "";
					String t1 = possessMap.get(obj).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "(POSSBY " + t1_cd + ")";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
						obj_cd = obj_cd + "(POSSBY "+t + " ) ";
					}
				}
				else if(possessMap.get(obj).size() == 0){
					obj_cd = obj_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(obj)){
				for(int i = 0 ; i < addMap.get(obj).size(); i++){
					obj_cd = obj_cd + "(ISA "+getCDForm(addMap.get(obj).get(i),"a")+" ) ";
				}
			}
			obj_cd += " ))";
		}
		ret = ret + "(PTRANS ";
		if(src == ""){
			ret += " \n\t(FROM NULL) ";
		}
		else{
			ret = ret + "\n\t(FROM " + src_cd + ")";
		}
		if(dest == ""){
			ret = ret + "\n\t(TO NULL)";
		}
		else{
			ret = ret + "\n\t(TO " + dest_cd + ")";
		}
		ret = ret + "\n\t"+obj_cd ;
		ret = ret + "\n\t(ACTOR " + p1_cd + ")";
		String A = "";
		if(addMap.containsKey(verb_sent)){
			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
				A = A + " (ISA (ADVERB " + getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
			}
		}
		ret = ret + "\n\t(CONC_TENSE PAST)\n\t"+Using+"\n\t";
		ret = ret + A +")\n";
		global_ret = ret;
		//	
		return "";
	}
	String process_ingest(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){

		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String temp = "",actor = "", actor_cd = "";
		Ingest  ingest_verb = new Ingest();

		for(int i = 0; i < verbs.ingest_verbs.length; i++){
			//
			if(verbs.ingest_verbs[i].m_name.equals(verb_sent)){
				ingest_verb = verbs.ingest_verbs[i];
				break;
			}
		}

		Iterator<String> it = possessMap.keySet().iterator();
		if(it.hasNext()) {
			p1 = (String) it.next();
			if(mapObjects.get(p1).equals("politicians"))
				p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ " ) ";
			//
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String tmpCD = "";
					if(addMap.containsKey(t2)){
						tmpCD = getCDForm(t2,"no");
						tmpCD = tmpCD.substring(0,tmpCD.lastIndexOf(')'));
						tmpCD = tmpCD + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							tmpCD = tmpCD + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						tmpCD += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+tmpCD
								+" ) ";
					}
					else{
						p1_cd = p1_cd + " "+ tmpCD + " ";
					}
				}
				else if(possessMap.get(p1).size() == 2){
					String t2 = possessMap.get(p1).get(0);
					String tempCD = "";
					String t1 = possessMap.get(p1).get(1);
					String temp1CD = "";
					if(addMap.containsKey(t1)){
						temp1CD = getCDForm(t1,"no");
						temp1CD = temp1CD.substring(0,temp1CD.lastIndexOf(')'));
						temp1CD = temp1CD + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							temp1CD = temp1CD + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						temp1CD += ")";
					}
					if(addMap.containsKey(t2)){
						tempCD = getCDForm(addMap.get(t2).get(0),"no");
						tempCD = tempCD.substring(0,tempCD.lastIndexOf(')'));
						tempCD = tempCD + "( POSSBY " + temp1CD + " )";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							tempCD = tempCD + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						tempCD += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+tempCD + " ) ";
					}
					else{
						p1_cd = p1_cd + "(POSSBY "+tempCD
								+" "+temp1CD + " ) ";
					}
				}
				else if(possessMap.get(p1).size() == 0){
					p1_cd = p1_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(p1)){
				for(int i = 0 ; i < addMap.get(p1).size(); i++){
					p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";


		}

		while(it.hasNext()){
			temp = (String)it.next();
			String map = mapObjects.get(temp);
			if(map.equals("objects")){
				obj = temp;
				obj_cd = "(OBJECT (OBJECT (NAME "+getBaseForm(obj)+" ) ";
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(possessMap.containsKey(obj)){

					if(possessMap.get(obj).size() == 1 ){
						String t2 = possessMap.get(obj).get(0);
						if(t2.equals(p1)){
							obj_cd = obj_cd + "(POSSBY "+p1_cd + ")";
						}
						else if(t2.equals(p2)){
							obj_cd = obj_cd + "(POSSBY "+p2_cd+")";
						}
						else{
							String tmpCD = "";
							if(addMap.containsKey(t2)){
								tmpCD = getCDForm(t2,"no");
								tmpCD = tmpCD.substring(0,tmpCD.lastIndexOf(')'));
								tmpCD += " (POSSBY NULL)";
								for(int k = 0; k < addMap.get(t2).size(); k++){
									tmpCD = tmpCD + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
								}
								tmpCD += ")";
							}
							if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
								obj_cd = obj_cd + "(POSSBY "+tmpCD
										+" ) ";
							}
							else{
								obj_cd = obj_cd + " "+ tmpCD + " ";
							}
						}
					}
					else if(possessMap.get(obj).size() == 2){
						String t2 = possessMap.get(obj).get(0);
						String tmpCD = "";
						String t1 = possessMap.get(obj).get(1);
						String tmp1CD = "";
						if(addMap.containsKey(t1)){
							tmp1CD = getCDForm(t1,"no");
							tmp1CD = tmp1CD.substring(0,tmp1CD.lastIndexOf(')'));
							tmp1CD += " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								tmp1CD = tmp1CD + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							tmp1CD += ")";
						}
						if(addMap.containsKey(t2)){
							tmpCD = getCDForm(addMap.get(t2).get(0),"no");
							tmpCD = tmpCD.substring(0,tmpCD.lastIndexOf(')'));
							tmpCD += " (POSSBY " + tmp1CD + " )";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								tmpCD = tmpCD + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							tmpCD += ")";
						}
						if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
							obj_cd = obj_cd + "(POSSBY "+tmpCD + " ) ";
						}
						else{
							obj_cd = obj_cd + "(POSSBY "+tmpCD
									+" "+tmp1CD + " ) ";
						}
					}
					else if(possessMap.get(obj).size() == 0){
						obj_cd = obj_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(obj)){
					for(int i = 0 ; i < addMap.get(obj).size(); i++){
						obj_cd = obj_cd + "(ISA "+getCDForm(addMap.get(obj).get(i),"a")+" ) ";
					}
				}
				obj_cd += " ))";
			}
		}

		String A = "";
		if(addMap.containsKey(verb_sent)){
			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
				A = A + " (ISA (ADVERB " + getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
			}
		}
		if(!obj_cd.equals(""))
			ret  = ret + "(INGEST \n\t(ACTOR "+ p1_cd + ")\n\t"+obj_cd +" \n\t(CONC_TENSE PAST)\n\t"+Using+"\n\t"+A+")\n";
		else
			ret  = ret + "(INGEST \n\t(ACTOR "+ p1_cd + ") \n\t(OBJECT NULL) \n\t(CONC_TENSE PAST)\n\t"+Using+"\n\t"+A+")\n";
		//	
		global_ret = ret;
		return ret;

	}
	String process_attend(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){

		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String temp = "",actor = "", actor_cd = "";
		Attend  attendVerb = new Attend();

		for(int i = 0; i < verbs.attend_verbs.length; i++){
			if(verbs.attend_verbs[i].m_name.equals(verb_sent)){
				attendVerb = verbs.attend_verbs[i];
				break;
			}
		}

		Iterator<String> it = possessMap.keySet().iterator();
		if(it.hasNext()) {
			p1 = (String) it.next();
			p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ " ) ";
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					if(addMap.containsKey(t2)){
						t = getCDForm(t2,"n");
						if(t != "")
							t = t.substring(0,t.lastIndexOf(')'));
						t = t + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t
								+" ) ";
					}
					else{
						p1_cd = p1_cd + " "+ t + " ";
					}
				}
				else if(possessMap.get(p1).size() == 2){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					String t1 = possessMap.get(p1).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "( POSSBY " + t1_cd + " )";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
					}
					else{
						p1_cd = p1_cd + "(POSSBY "+t
								+" "+t1_cd + " ) ";
					}
				}
				else if(possessMap.get(p1).size() == 0){
					p1_cd = p1_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(p1)){
				for(int i = 0 ; i < addMap.get(p1).size(); i++){
					p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";


		}

		while(it.hasNext()){
			temp = (String)it.next();
			String map = mapObjects.get(temp);
			if(map.equals("politicians") || map.equals("places")){
				p2 = temp;
				p2_cd = "(PERSON (NAME "+getBaseForm(p2)+ " ) ";				
				if(possessMap.containsKey(p2)){
					if(possessMap.get(p2).size() == 1 ){
						String t2 = possessMap.get(p2).get(0);
						String t = "";
						if(addMap.containsKey(t2)){
							t = getCDForm(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p2).get(0)).equals("pronouns")){
							p2_cd = p2_cd + "(POSSBY "+t
									+" ) ";
						}
						else{
							p2_cd = p2_cd + " "+ t + " ";
						}
					}
					else if(possessMap.get(p2).size() == 2){
						String t2 = possessMap.get(p2).get(0);
						String t = "";
						String t1 = possessMap.get(p2).get(1);
						String t1_cd = "";
						if(addMap.containsKey(t1)){
							t1_cd = getCDForm(t1,"no");
							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							t1_cd += " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							t1_cd += ")";
						}
						if(addMap.containsKey(t2)){
							t = getCDForm(addMap.get(t2).get(0),"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += " (POSSBY " + t1_cd + ")";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p2).get(1)).equals("pronouns")){
							p2_cd = p2_cd + "(POSSBY "+t + " ) ";
						}
						else{
							p2_cd = p2_cd + "(POSSBY "+t
									+" "+t1_cd + " ) ";
						}
					}
					else if(possessMap.get(p2).size() == 0){
						p2_cd = p2_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(p2)){
					for(int i = 0 ; i < addMap.get(p2).size(); i++){
						p2_cd = p2_cd + "(ISA "+getCDForm(addMap.get(p2).get(i),"a")+" ) ";	
					}
				}
				p2_cd += " )";
				//	
			}
			else if(map.equals("objects")){
				obj = temp;
				obj_cd = "(OBJECT (OBJECT (NAME "+getBaseForm(obj)+" ) ";
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(possessMap.containsKey(obj)){

					if(possessMap.get(obj).size() == 1 ){
						String t2 = possessMap.get(obj).get(0);
						if(t2.equals(p1)){
							obj_cd = obj_cd + "(POSSBY "+p1_cd+")";
						}
						else if(t2.equals(p2)){
							obj_cd = obj_cd + "(POSSBY "+p2_cd+")";
						}
						else{
							String t = "";
							if(addMap.containsKey(t2)){
								t = getCDForm(t2,"no");
								t = t.substring(0,t.lastIndexOf(')'));
								t += " (POSSBY NULL)";
								for(int k = 0; k < addMap.get(t2).size(); k++){
									t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
								}
								t += ")";
							}
							if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
								obj_cd = obj_cd + "(POSSBY "+t
										+" ) ";
							}
							else{
								obj_cd = obj_cd + " "+ t + " ";
							}
						}
					}
					else if(possessMap.get(obj).size() == 2){
						String t2 = possessMap.get(obj).get(0);
						String t = "";
						String t1 = possessMap.get(obj).get(1);
						String t1_cd = "";
						if(addMap.containsKey(t1)){
							t1_cd = getCDForm(t1,"no");
							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							t1_cd += " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							t1_cd += ")";
						}
						if(addMap.containsKey(t2)){
							t = getCDForm(addMap.get(t2).get(0),"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += " (POSSBY " + t1_cd + " )";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
							obj_cd = obj_cd + "(POSSBY "+t + " ) ";
						}
						else{
							obj_cd = obj_cd + "(POSSBY "+t
									+" "+t1_cd + " ) ";
						}
					}
					else if(possessMap.get(obj).size() == 0){
						obj_cd = obj_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(obj)){
					for(int i = 0 ; i < addMap.get(obj).size(); i++){
						obj_cd = obj_cd + "(ISA "+getCDForm(addMap.get(obj).get(i),"a")+" ) ";
					}
				}
				obj_cd += " ))";
			}
		}

		String A = "";
		if(addMap.containsKey(verb_sent)){
			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
				A = A + " (ISA (ADVERB " + 
			getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
			}
		}

		String organ = "";
		if(verb_sent.equals("കേട്ടു") || verb_sent.equals("ശ്രദ്ധിക്കുന്നു") || verb_sent.equals("കേള്‍ക്കുന്നു") ||verb_sent.equals("ശ്രദ്ധിച്ചിരുന്നു") || verb_sent.equals("ശ്രദ്ധിച്ചു")|| verb_sent.equals("കേട്ടിരുന്നു"))
			organ = "EAR";
		else 
			organ = "EYE";

		if(!obj_cd.equals(""))
			ret = ret + "(ATTEND \n\t(ACTOR "+p1_cd+") \n\t(ORGAN "+organ+")\n\t" +obj_cd+" \n\t(CONC_TENSE PAST)\n\t"+Using+"\n\t"+A+")\n";
		else if(!p2.equals(""))
			ret = ret + "(ATTEND \n\t(ACTOR "+p1_cd+") \n\t(ORGAN "+organ+") \n\t(OBJECT "+p2_cd+")\n\t(CONC_TENSE PAST)\n\t"+Using+"\n\t"+A+")\n";
		else
			ret = ret + "(ATTEND \n\t(ACTOR "+p1_cd+") \n\t(ORGAN "+organ+") \n\t(OBJECT NULL) \n\t(CONC_TENSE PAST)\n\t"+Using+"\n\t"+A+")\n";

		//	
		global_ret = ret;
		return ret;
	}
	String process_mbuild(String sent, String[] parts){
		int i,j;
		int fromflag = 0, that1flag = 0, that2flag = 0;
		String adj = "", adv = "";
		String sent1 = "", sent2 = "", sent1_cd = "", sent2_cd = "", sent_cd = "";
		int noun_flag = 0;
		String dummy = "";
		for(i = 0; i < parts.length; i++){
			if(parts[i].equals("നിന്നും")||parts[i].equals("നിന്ന്")){
				if(fromflag == 1 && that2flag == 0){
					sent1 = sent1 + parts[i-1] + " ";
				}
				else if(fromflag == 1 && that2flag == 1){
					sent2 = sent2 + parts[i] + " ";
				}
				else
					fromflag = 1;
			}
			else if(fromflag == 0 && noun_flag == 0){
				if(mapObjects.containsKey(parts[i]) && mapObjects.get(parts[i]) == "politicians"){
					noun_flag = 1;
				}
				else{
					adj = parts[i];
				}
				if(!mapObjects.get(parts[i]).equals("mbuild_verbs"))
					dummy = dummy + parts[i] + " ";
			}
			else if(fromflag == 0 && noun_flag == 1 && that1flag == 0){
				if(!mapObjects.get(parts[i]).equals("mbuild_verbs"))
					dummy = dummy + parts[i] + " ";
				if(mapObjects.get(parts[i]).equals("adverb")){
					adv = parts[i];
				}
			}
			else if(parts[i].equals("അത്") && that1flag == 0 && fromflag == 1){
				that1flag = 1;
			}
			else if(parts[i].equals("that") && that1flag == 1 && fromflag == 1){
				that2flag = 1;
			}
			else if(that2flag == 0){
				sent1 = sent1 + parts[i] + " ";
			}
			else if(that2flag == 1){
				sent2 = sent2 + parts[i] + " ";
			}
		}
		
		
		parse_sentence(sent1);
		sent1_cd = global_ret;
		
		parse_sentence(sent2);
		sent2_cd = global_ret;
		String act = "";
		if(!adj.equals(""))
			act = "(ACTOR (PERSON (NAME "+getBaseForm(dummy) + ")" + "(POSSBY NULL)" + "(ISA " + adj + "))";
		else
			act = "(ACTOR (PERSON (NAME "+getBaseForm(dummy) + ")" + "(POSSBY NULL))";
		if(!adv.equals("")){
			sent_cd = "(MBUILD " + getBaseForm(act) + "\n\t(INITIAL " + sent1_cd + ")(FINAL " + sent2_cd + ")" +
					Using + "(ADVERB " + getBaseForm(adv) + ")(CONC_TENSE " + "PAST)))";
		}
		else
			sent_cd = "(MBUILD " + getBaseForm(act) + "\n\t(INITIAL " + sent1_cd + ")(FINAL " + sent2_cd + ")" +
					Using + "(CONC_TENSE " + "PAST)))";
		global_ret = sent_cd;
		return "";}
	String process_propel (LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String temp = "",actor = "", actor_cd = "";
		Propel propelVerb = new Propel();

		for(int i = 0; i < verbs.propel_verbs.length; i++){
			if(verbs.propel_verbs[i].m_name.equals(verb_sent)){
				propelVerb = verbs.propel_verbs[i];
				break;
			}
		}
		String[] parts = sentence.split("\\s+");
		Iterator<String> it = possessMap.keySet().iterator();
		for(int i = 1; i < parts.length; i++){
			if(parts[i].equals("നേരെ")){
				p2 = parts[i-1];
				if (mapObjects.containsKey(p2) &&mapObjects.get(p2).equals("politicians") )
					p2_cd = "(PERSON (NAME "+getBaseForm(p2)+ " ) ";
				else
					p2_cd = "(OBJECT (NAME "+getBaseForm(p2)+ " ) ";
			}
		}
		if(it.hasNext()) {
			p1 = (String) it.next();
			p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ " ) ";
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					if(addMap.containsKey(t2)){
						t = getCDForm(t2,"o");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t
								+" ) ";
					}
					else{
						p1_cd = p1_cd + " "+ t + " ";
					}
				}
				else if(possessMap.get(p1).size() == 2){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					String t1 = possessMap.get(p1).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "( POSSBY " + t1_cd + " )";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
					}
					else{
						p1_cd = p1_cd + "(POSSBY "+t
								+" "+t1_cd + " ) ";
					}
				}
				else if(possessMap.get(p1).size() == 0){
					p1_cd = p1_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(p1)){
				for(int i = 0 ; i < addMap.get(p1).size(); i++){
					p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";
		}
		String Prev = "";
		String th = "";
		while(it.hasNext()){
			Prev=th;
			th= (String) it.next();
			if(mapObjects.containsKey(th) &&mapObjects.get(th).equals("objects")){
				obj = th;
				obj_cd = "(OBJECT (OBJECT (NAME "+getBaseForm(obj)+" ) ";
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(possessMap.containsKey(obj)){
					if(possessMap.get(obj).size() == 1 ){
						String t2 = possessMap.get(obj).get(0);
						if(t2.equals(p1)){
							obj_cd = obj_cd + "(POSSBY "+p1_cd+")";
						}
						else if(t2.equals(p2)){
							obj_cd = obj_cd + "(POSSBY "+p2_cd+")";
						}
						else{
							String t = "";
							if(addMap.containsKey(t2)){
								t = getCDForm(t2,"o");
								t = t.substring(0,t.lastIndexOf(')'));
								t += " (POSSBY NULL)";
								for(int k = 0; k < addMap.get(t2).size(); k++){
									t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
								}
								t += ")";
							}
							if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
								obj_cd = obj_cd + "(POSSBY "+t
										+" ) ";
							}
							else{
								obj_cd = obj_cd + " "+ t + " ";
							}
						}
					}
					else if(possessMap.get(obj).size() == 2){
						String t2 = possessMap.get(obj).get(0);
						String t = "";
						String t1 = possessMap.get(obj).get(1);
						String t1_cd = "";
						if(addMap.containsKey(t1)){
							t1_cd = getCDForm(t1,"no");
							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							t1_cd += " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							t1_cd += ")";
						}
						if(addMap.containsKey(t2)){
							t = getCDForm(addMap.get(t2).get(0),"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += " (POSSBY " + t1_cd + " )";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
							obj_cd = obj_cd + "(POSSBY "+t + " ) ";
						}
						else{
							obj_cd = obj_cd + "(POSSBY "+t
									+" "+t1_cd + " ) ";
						}
					}
					else if(possessMap.get(obj).size() == 0){
						obj_cd = obj_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(obj)){
					for(int i = 0 ; i < addMap.get(obj).size(); i++){
						obj_cd = obj_cd + "(ISA "+getCDForm(addMap.get(obj).get(i),"a")+" ) ";
					}
				}
				obj_cd += " ))";
			}
			
			if((mapObjects.containsKey(th) 
					&& (mapObjects.get(th).equals("politicians") 
							|| mapObjects.get(th).equals("places")))){
					p2 = th;
					p2_cd = "(PERSON (NAME "+getBaseForm(p2)+ " ) ";
				
				if(possessMap.containsKey(p2)){
					if(possessMap.get(p2).size() == 1 ){
						String t2 = possessMap.get(p2).get(0);
						String t = "";
						
						if(addMap.containsKey(t2)){
							t = getCDForm(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p2).get(0)).equals("pronouns")){
							p2_cd = p2_cd + "(POSSBY "+t
									+" ) ";
						}
						else{
							p2_cd = p2_cd + " "+ t + " ";
						}
					}
					else if(possessMap.get(p2).size() == 2){
						String t2 = possessMap.get(p2).get(0);
						String t = "";
						String t1 = possessMap.get(p2).get(1);
						String t1_cd = "";
						if(addMap.containsKey(t1)){
							t1_cd = getCDForm(t1,"no");
							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							t1_cd += " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							t1_cd += ")";
						}
						if(addMap.containsKey(t2)){
							t = getCDForm(addMap.get(t2).get(0),"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += " (POSSBY " + t1_cd + ")";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p2).get(1)).equals("pronouns")){
							p2_cd = p2_cd + "(POSSBY "+t + " ) ";
						}
						else{
							p2_cd = p2_cd + "(POSSBY "+t
									+" "+t1_cd + " ) ";
						}
					}
					else if(possessMap.get(p2).size() == 0){
						p2_cd = p2_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(p2)){
					for(int i = 0 ; i < addMap.get(p2).size(); i++){
						p2_cd = p2_cd + "(ISA "+getCDForm(addMap.get(p2).get(i),"a")+" ) ";	
					}
				}
				p2_cd += " )";
			}
		}
		ret = "(PROPEL \n\t(FROM " + p1_cd + ") \n\t(TO " + p2_cd + ") \n\t" + obj_cd + " \n\t(PHYSCONT (" + p2_cd + " " + obj_cd + 
				"))";
		String A = "";
		if(addMap.containsKey(verb_sent)){
			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
				A = A + " (ISA (ADVERB " + getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
			}
		}
		ret = ret + "\n\t(CONC_TENSE PAST)\n\t" +Using+"\n\t"+ A + ")\n";
		String thu = "";
		thu = get_state_propel(propelVerb, p2_cd);
		//	if(verb_sent.equals("fight")){
		// what to do here ???	
		//	}
		if(!thu.equals("")){
			ret ="(LEADSTO \n  " + ret + "\n  " + thu + " \n\t(CONC_TENSE PAST) \n\t"+Using +"\n\t"+ A + ")"
					+ "\n  (CONC_TENSE PAST) \n  (USING NULL))\n";
		}
		global_ret = ret;
		//	
		return "";
	}
	String get_state_propel(Propel verb_struct, String src){
		//	System.out.println("printing this " + verb_struct.source.mental_state + "  " + 
		//				verb_struct.dest.mental_state);
		if(verb_struct.dest.mental_state != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE MENTAL_STATE (INITIAL " + 
			(verb_struct.dest.mental_state+10) + ") (FINAL 21) )";
		if(verb_struct.dest.physical_state != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE PHYSICAL_STATE (INITIAL " + 
			(verb_struct.dest.physical_state+10) + ") (FINAL 21) )";
		if(verb_struct.dest.health != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE HEALTH (INITIAL " + 
			(verb_struct.dest.health+10) + ") (FINAL 21) )";
		if(verb_struct.dest.fear != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE FEAR (INITIAL " + 
			(verb_struct.dest.fear+10) + ") (FINAL 21) )";
		if(verb_struct.dest.anger != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE ANGER (INITIAL " + 
			(verb_struct.dest.anger+10) + ") (FINAL 21) )";
		return "";
	}
	String process_expel(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String temp = "",actor = "", actor_cd = "";
		Expel expelVerb = new Expel();

		for(int i = 0; i < verbs.expel_verbs.length; i++){
			if(verbs.expel_verbs[i].m_name.equals(verb_sent)){
				expelVerb = verbs.expel_verbs[i];
				break;
			}
		}

		Iterator<String> it = possessMap.keySet().iterator();
		if(it.hasNext()) {
			p1 = (String) it.next();
			p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ " ) ";
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					if(addMap.containsKey(t2)){
						t = getCDForm(t2,"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t
								+" ) ";
					}
					else{
						p1_cd = p1_cd + " "+ t + " ";
					}
				}
				else if(possessMap.get(p1).size() == 2){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					String t1 = possessMap.get(p1).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "( POSSBY " + t1_cd + " )";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
					}
					else{
						p1_cd = p1_cd + "(POSSBY "+t
								+" "+t1_cd + " ) ";
					}
				}
				else if(possessMap.get(p1).size() == 0){
					p1_cd = p1_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(p1)){
				for(int i = 0 ; i < addMap.get(p1).size(); i++){
					p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";
		}
		if(domain.isCDFormMalayalam == false){
		if(verb_sent.equals("കരഞ്ഞു"))
			obj_cd = "(OBJECT (NAME WATER) (FROM EYES))";
		else if(verb_sent.equals("ചുമക്കുക"))
			obj_cd = "(OBJECT (NAME COUGH) (FROM MOUTH))";
		else if(verb_sent.equals("ചോരവാര്‍ന്നുപോയി"))
			obj_cd = "(OBJECT (NAME BLOOD) (FROM BODY))";
		else if(verb_sent.equals("വിയര്‍ക്കുക"))
			obj_cd = "(OBJECT (NAME SWEAT) (FROM SKIN))";
		else
			obj_cd = "NULL";
		}
		else
		{
			if(verb_sent.equals("കരഞ്ഞു"))
				obj_cd = "(OBJECT (NAME കണ്ണ് ) (FROM വെളളം  ))";
			else if(verb_sent.equals("ചുമക്കുക"))
				obj_cd = "(OBJECT (NAME ) (FROM  ))";
			else if(verb_sent.equals("ചോരവാര്‍ന്നുപോയി"))
				obj_cd = "(OBJECT (NAME രക്തം ) (FROM ശരീരം ))";
			else if(verb_sent.equals("വിയര്‍ക്കുക"))
				obj_cd = "(OBJECT (NAME ) (FROM ))";
			else
				obj_cd = "NULL";	
		}
		String A = "";
		if(addMap.containsKey(verb_sent)){
			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
				A = A + " (ISA (ADVERB " + getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
			}
		}		
		ret = ret +"(EXPEL \n\t(FROM "+p1_cd+") \n\t";
		ret = ret +obj_cd;
		ret =ret + "\n\t(CONC_TENSE PAST) \n\t"+Using+"\n\t"+A+")";
		String thu = "";
		if(verb_sent.equals("ചോരവാര്‍ന്നുപോയി")){
			thu = "(CHANGE (OBJECT " + p1_cd + ") (STATE PHYSICAL_STATE (INITIAL " + 
					(expelVerb.actor.physical_state+10) + ") (FINAL 21) )" +
					" (CONC_TENSE PAST) "+Using + A + ")";
		}
		if(!thu.equals(""))
			ret = "(LEADSTO \n  " + ret + "\n  " + thu + "\n  (CONC_TENSE PAST) \n  (USING NULL))\n";
		global_ret = ret;
		//	
		return "";
	}
	String process_grasp(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String temp = "",actor = "", actor_cd = "";
		Grasp  graspVerb = new Grasp();

		for(int i = 0; i < verbs.grasp_verbs.length; i++){
			if(verbs.grasp_verbs[i].m_name.equals(verb_sent)){
				graspVerb = verbs.grasp_verbs[i];
				break;
			}
		}

		Iterator<String> it = possessMap.keySet().iterator();
		if(it.hasNext()) {
			p1 = (String) it.next();
			p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ " ) ";
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					if(addMap.containsKey(t2)){
						t = getCDForm(t2,"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t
								+" ) ";
					}
					else{
						p1_cd = p1_cd + " "+ t + " ";
					}
				}
				else if(possessMap.get(p1).size() == 2){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					String t1 = possessMap.get(p1).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "( POSSBY " + t1_cd + " )";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
					}
					else{
						p1_cd = p1_cd + "(POSSBY "+t
								+" "+t1_cd + " ) ";
					}
				}
				else if(possessMap.get(p1).size() == 0){
					p1_cd = p1_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(p1)){
				for(int i = 0 ; i < addMap.get(p1).size(); i++){
					p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";


		}

		while(it.hasNext()){
			temp = (String)it.next();
			String map = mapObjects.get(temp);
			if(map.equals("politicians") || map.equals("places")){
				p2 = temp;
				p2_cd = "(PERSON (NAME "+getBaseForm(p2)+ " ) ";				
				if(possessMap.containsKey(p2)){
					if(possessMap.get(p2).size() == 1 ){
						String t2 = possessMap.get(p2).get(0);
						String t = "";
						if(addMap.containsKey(t2)){
							t = getCDForm(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p2).get(0)).equals("pronouns")){
							p2_cd = p2_cd + "(POSSBY "+t
									+" ) ";
						}
						else{
							p2_cd = p2_cd + " "+ t + " ";
						}
					}
					else if(possessMap.get(p2).size() == 2){
						String t2 = possessMap.get(p2).get(0);
						String t = "";
						String t1 = possessMap.get(p2).get(1);
						String t1_cd = "";
						if(addMap.containsKey(t1)){
							t1_cd = getCDForm(t1,"no");
							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							t1_cd += " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							t1_cd += ")";
						}
						if(addMap.containsKey(t2)){
							t = getCDForm(addMap.get(t2).get(0),"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += " (POSSBY " + t1_cd + ")";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p2).get(1)).equals("pronouns")){
							p2_cd = p2_cd + "(POSSBY "+t + " ) ";
						}
						else{
							p2_cd = p2_cd + "(POSSBY "+t
									+" "+t1_cd + " ) ";
						}
					}
					else if(possessMap.get(p2).size() == 0){
						p2_cd = p2_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(p2)){
					for(int i = 0 ; i < addMap.get(p2).size(); i++){
						p2_cd = p2_cd + "(ISA "+getCDForm(addMap.get(p2).get(i),"a")+" ) ";	
					}
				}
				p2_cd += " )";
				//	
			}
			else if(map.equals("objects")){
				obj = temp;
				obj_cd = "(OBJECT (OBJECT (NAME "+getBaseForm(obj)+" ) ";
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(possessMap.containsKey(obj)){

					if(possessMap.get(obj).size() == 1 ){
						String t2 = possessMap.get(obj).get(0);
						if(t2.equals(p1)){
							obj_cd = obj_cd + "(POSSBY "+p1_cd+")";
						}
						else if(t2.equals(p2)){
							obj_cd = obj_cd + "(POSSBY "+p2_cd+")";
						}
						else{
							String t = "";
							if(addMap.containsKey(t2)){
								t = getCDForm(t2,"no");
								t = t.substring(0,t.lastIndexOf(')'));
								t += " (POSSBY NULL)";
								for(int k = 0; k < addMap.get(t2).size(); k++){
									t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
								}
								t += ")";
							}
							if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
								obj_cd = obj_cd + "(POSSBY "+t
										+" ) ";
							}
							else{
								obj_cd = obj_cd + " "+ t + " ";
							}
						}
					}
					else if(possessMap.get(obj).size() == 2){
						String t2 = possessMap.get(obj).get(0);
						String t = "";
						String t1 = possessMap.get(obj).get(1);
						String t1_cd = "";
						if(addMap.containsKey(t1)){
							t1_cd = getCDForm(t1,"no");
							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							t1_cd += " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							t1_cd += ")";
						}
						if(addMap.containsKey(t2)){
							t = getCDForm(addMap.get(t2).get(0),"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += " (POSSBY " + t1_cd + " )";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
							obj_cd = obj_cd + "(POSSBY "+t + " ) ";
						}
						else{
							obj_cd = obj_cd + "(POSSBY "+t
									+" "+t1_cd + " ) ";
						}
					}
					else if(possessMap.get(obj).size() == 0){
						obj_cd = obj_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(obj)){
					for(int i = 0 ; i < addMap.get(obj).size(); i++){
						obj_cd = obj_cd + "(ISA "+getCDForm(addMap.get(obj).get(i),"a")+" ) ";
					}
				}
				obj_cd += " ))";
			}
		}

		String A = "";
		if(addMap.containsKey(verb_sent)){
			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
				A = A + " (ISA (ADVERB " + getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
			}
		}
		if(!obj_cd.equals(""))
			ret = ret + "(GRASP \n\t(ACTOR "+p1_cd+") \n\t"+obj_cd+" \n\t(CONC_TENSE PAST)\n\t"+Using+"\n\t"+A+")\n";
		else if(!p2.equals(""))
			ret = ret + "(GRASP \n\t(ACTOR "+p1_cd+") \n\t(OBJECT "+p2_cd+") \n\t(CONC_TENSE PAST)"+Using+"\n\t"+A+")\n";
		else
			ret = ret + "(GRASP \n\t(ACTOR "+p1_cd+") \n\t(OBJECT NULL) \n\t(CONC_TENSE PAST)\n\t"+Using+"\n\t"+A+")\n";

		//	
		global_ret = ret;
		return ret;

	}
	String process_state(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		state state_verb = new state();
		for(int i = 0; i < verbs.state_verbs.length; i++){
			if(verbs.state_verbs[i].m_name.equals(verb_sent)){
				state_verb = verbs.state_verbs[i];
				break;
			}
		}
		Iterator<String> it = possessMap.keySet().iterator();
		if(it.hasNext()) {
			p1 = (String) it.next();
			String map = mapObjects.get(p1);
			//	
			if(!map.equals("pronouns"))
				p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ " ) ";
			else 	//should take care of every pronouns
				p1_cd = "(PERSON ";
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					if(addMap.containsKey(t2)){
						t = getCDForm(t2,"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t
								+" ) ";
					}
					else{
						p1_cd = p1_cd + " "+ t + " ";
					}
				}
				else if(possessMap.get(p1).size() == 2){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					String t1 = possessMap.get(p1).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "( POSSBY " + t1_cd + " )";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
					}
					else{
						p1_cd = p1_cd + "(POSSBY "+t
								+" "+t1_cd + " ) ";
					}
				}
				else if(possessMap.get(p1).size() == 0){
					p1_cd = p1_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(p1)){
				for(int i = 0 ; i < addMap.get(p1).size(); i++){
					p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";
		}
		if(state_verb.actor.mental_state != 999)
			ret = "(CHANGE (OBJECT " + p1_cd + ") (STATE MENTAL_STATE (INITIAL " + 
					(state_verb.actor.mental_state+10) + ") (FINAL 21) )";
		if(state_verb.actor.physical_state != 999)
			ret = "(CHANGE (OBJECT " + p1_cd + ") (STATE PHYSICAL_STATE (INITIAL " + 
					(state_verb.actor.physical_state+10) + ") (FINAL 21) )";
		if(state_verb.actor.anger != 999)
			ret = "(CHANGE (OBJECT " + p1_cd + ") (STATE ANGER (INITIAL " + 
					(state_verb.actor.anger+10) + ") (FINAL 21) )";
		if(state_verb.actor.health != 999)
			ret = "(CHANGE (OBJECT " + p1_cd + ") (STATE HEALTH (INITIAL " + 
					(state_verb.actor.health+10) + ") (FINAL 21) )";
		if(state_verb.actor.fear != 999)
			ret = "(CHANGE (OBJECT " + p1_cd + ") (STATE FEAR (INITIAL " + 
					(state_verb.actor.fear+10) + ") (FINAL 21) )";
		ret = " (CONC_TENSE PAST) "+Using;
		String A = "";
		if(addMap.containsKey(verb_sent)){
			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
				A = A + " (ISA (ADVERB " + getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
			}
		}
		ret = ret + A + ")";
		global_ret = ret;
		return ret;
	}
	String process_atrans(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String pos = "", src = "", dest = "", src_cd = "", dest_cd = "";
		String temp = "", actor = "", actor_cd = "";
		ATrans atrans_verb = new ATrans();
		for(int i = 0; i < verbs.atrans_verbs.length; i++){
			if(verbs.atrans_verbs[i].m_name.equals(verb_sent)){
				atrans_verb = verbs.atrans_verbs[i];
				break;
			}
		}
		String[] parts = sentence.split("\\s+");
		Iterator<String> it = possessMap.keySet().iterator();
		ArrayList<String> temp_array = new ArrayList<>();
		int fromflag = 0, toflag = 0;
		for(int i = 0; i < parts.length; i++){
			if(parts[i].equals("from")) fromflag = 1;
			else if(parts[i].equals("to")) {
				toflag = 1;
			}
			else if(possessMap.containsKey(parts[i]) && !mapObjects.get(parts[i]).equals("objects") 
					&& !temp_array.contains(parts[i]) && fromflag == 1){
				fromflag = 0;
				src = parts[i];
			}
			else if(possessMap.containsKey(parts[i]) && !mapObjects.get(parts[i]).equals("objects") 
					&& !temp_array.contains(parts[i]) && toflag == 1){
				toflag = 0;
				dest = parts[i];
			}
			else if(possessMap.containsKey(parts[i]) && mapObjects.get(parts[i]).equals("objects")){
				obj = parts[i];
			}
			if(!temp_array.contains(parts[i])) temp_array.add(parts[i]);
		}
		if(src == "")
			src = p1;
		else if(dest == "")
			dest = p1;
		if(it.hasNext()) {
			p1 = (String) it.next();
			String map = mapObjects.get(p1);
			//	
			if(!map.equals("pronouns"))
				p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ " ) ";
			else 	//should take care of every pronouns
				p1_cd = "(PERSON ";
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					if(addMap.containsKey(t2)){
						t = getCDForm(t2,"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t
								+" ) ";
					}
					else{
						p1_cd = p1_cd + " "+ t + " ";
					}
				}
				else if(possessMap.get(p1).size() == 2){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					String t1 = possessMap.get(p1).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "( POSSBY " + t1_cd + " )";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
					}
					else{
						p1_cd = p1_cd + "(POSSBY "+t
								+" "+t1_cd + " ) ";
					}
				}
				else if(possessMap.get(p1).size() == 0){
					p1_cd = p1_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(p1)){
				for(int i = 0 ; i < addMap.get(p1).size(); i++){
					p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";
			//	
		}
		///////////////////done actor/////////////
		if(src == "")
			src_cd = p1_cd;
		else if(src != ""){
			src_cd = " (PLACE (NAME "+getBaseForm(src)+" ) ";
			if(possessMap.containsKey(src)){
				if(possessMap.get(src).size() == 1 ){
					String t2 = possessMap.get(src).get(0);
					if(t2.equals(p1)){
						src_cd = src_cd + " (POSSBY " + p1_cd + ")";
					}
					else{
						String t = "";
						if(addMap.containsKey(t2)){
							t = getCDForm(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t+" (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(src).get(0)).equals("pronouns")){
							src_cd = src_cd + "(POSSBY "+t
									+" ) ";
						}
						else{
							src_cd = src_cd + " "+ t + " ";
						}
					}
				}
				else if(possessMap.get(src).size() == 2){
					String t2 = possessMap.get(src).get(0);
					String t = "";
					String t1 = possessMap.get(src).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "(POSSBY " + t1_cd + ")";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(src).get(1)).equals("pronouns")){
						src_cd = src_cd + "(POSSBY "+t + " ) ";
					}
				}
				else if(possessMap.get(src).size() == 0){
					src_cd = src_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(src)){
				for(int i = 0 ; i < addMap.get(src).size(); i++){
					src_cd = src_cd + "(ISA "+getCDForm(addMap.get(src).get(i),"a")+" ) ";
				}
			}
			src_cd += " )";
		}
		//////////////done source/////////////////
		if(dest == "")
			dest_cd = p1_cd;
		else if(dest != ""){
			dest_cd = " (PLACE (NAME "+getBaseForm(dest)+" ) ";
			if(possessMap.containsKey(dest)){
				if(possessMap.get(dest).size() == 1 ){
					String t2 = possessMap.get(dest).get(0);
					if(t2.equals(p1)){
						dest_cd = dest_cd + " (POSSBY " + p1_cd + ")";
					}
					else{
						String t = "";
						if(addMap.containsKey(t2)){
							t = getCDForm(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t+" (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(dest).get(0)).equals("pronouns")){
							dest_cd = dest_cd + "(POSSBY "+t
									+" ) ";
						}
						else{
							dest_cd = dest_cd + " "+ t + " ";
						}
					}
				}
				else if(possessMap.get(dest).size() == 2){
					String t2 = possessMap.get(dest).get(0);
					String t = "";
					String t1 = possessMap.get(dest).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "(POSSBY " + t1_cd + ")";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(dest).get(1)).equals("pronouns")){
						dest_cd = dest_cd + "(POSSBY "+t + " ) ";
					}
				}
				else if(possessMap.get(dest).size() == 0){
					dest_cd = dest_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(dest)){
				for(int i = 0 ; i < addMap.get(dest).size(); i++){
					dest_cd = dest_cd + "(ISA "+getCDForm(addMap.get(dest).get(i),"a")+" ) ";
				}
			}
			dest_cd += " )";
		}
		/////////////done dest////////////////////
		if(obj.equals("")){
			obj_cd = p1_cd;
		}
		else{
			obj_cd = " (OBJECT (OBJECT (NAME "+getBaseForm(obj)+" ) ";
			if(possessMap.containsKey(obj)){
				if(possessMap.get(obj).size() == 1 ){
					String t2 = possessMap.get(obj).get(0);
					if(t2.equals(p1)){
						obj_cd = obj_cd + " (POSSBY " + p1_cd + ")";
					}
					else{
						String t = "";
						if(addMap.containsKey(t2)){
							t = getCDForm(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t+" (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
							obj_cd = obj_cd + "(POSSBY "+t
									+" ) ";
						}
						else{
							obj_cd = obj_cd + " "+ t + " ";
						}
					}
				}
				else if(possessMap.get(obj).size() == 2){
					String t2 = possessMap.get(obj).get(0);
					String t = "";
					String t1 = possessMap.get(obj).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "(POSSBY " + t1_cd + ")";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
						obj_cd = obj_cd + "(POSSBY "+t + " ) ";
					}
				}
				else if(possessMap.get(obj).size() == 0){
					obj_cd = obj_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(obj)){
				for(int i = 0 ; i < addMap.get(obj).size(); i++){
					obj_cd = obj_cd + "(ISA "+getCDForm(addMap.get(obj).get(i),"a")+" ) ";
				}
			}
			obj_cd += " ))";
		}
		ret = ret + "(ATRANS ";
		ret = ret + "\n\t(FROM " + src_cd + ")";
		ret = ret + "\n\t(TO " + dest_cd + ")";
		ret = ret + obj_cd ;
		ret = ret + "\n\t(ACTOR " + p1_cd + ")";
		String A = "";
		if(addMap.containsKey(verb_sent)){
			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
				A = A + " (ISA (ADVERB " + getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
			}
		}

		ret = ret + "\n\t(CONC_TENSE PAST)\n\t"+Using;
		ret = ret + A+ ")\n";
		String thu = get_state_atrans(atrans_verb, p1_cd);
		if(!thu.equals("")){
			ret = "(LEADSTO \n  " + ret + "\n  " + thu + " \n\t(CONC_TENSE PAST) \n\t"+Using +"\n\t"+ A + ")"
					+ "\n  (CONC_TENSE PAST) \n  (USING NULL))\n";}
		global_ret = ret;
		//
		return "";
	}
	String process_mtrans(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
		//LinkedHashMap<String, Obj_Struct> cd_map = new LinkedHashMap<>();
		//cd_map = put_in_CDmap(sentence);		
		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String pos = "", src = "", dest = "";
		String temp = "", actor = "", actor_cd = "";
		MTrans mtrans_verb = new MTrans();

		for(int i = 0; i < verbs.mtrans_verbs.length; i++){
			if(verbs.mtrans_verbs[i].m_name.equals(verb_sent)){
				mtrans_verb = verbs.mtrans_verbs[i];
				break;
			}
		}		
		if(mtrans_verb.source.name.equals("LTM") || mtrans_verb.source.name.equals("EYE")||
				mtrans_verb.source.name.equals("CP")){
			src = "(OBJECT (NAME "+getBaseForm(mtrans_verb.source.name) + ")";
			dest = "(OBJECT (NAME "+ getBaseForm(mtrans_verb.dest.name) +")";
			Iterator<String> it = possessMap.keySet().iterator();
			if(it.hasNext()) {
				p1 = (String) it.next();
				String map = mapObjects.get(p1);
				if(!map.equals("pronouns"))
					p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ " ) ";
				else 	
					p1_cd = "(PERSON ";
				if(possessMap.containsKey(p1)){
					if(possessMap.get(p1).size() == 1 ){
						String t2 = possessMap.get(p1).get(0);
						String t = "";
						if(addMap.containsKey(t2)){
							t = getCDForm(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t + "(POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}

							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
							p1_cd = p1_cd + "(POSSBY "+t
									+" ) ";
						}
						else{
							p1_cd = p1_cd + " "+ t + " ";
						}
					}
					else if(possessMap.get(p1).size() == 2){
						String t2 = possessMap.get(p1).get(0);
						String t = "";
						String t1 = possessMap.get(p1).get(1);
						String t1_cd = "";
						if(addMap.containsKey(t1)){
							t1_cd = getCDForm(t1,"no");
							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							t1_cd = t1_cd + "(POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							t1_cd += ")";
						}
						if(addMap.containsKey(t2)){
							t = getCDForm(addMap.get(t2).get(0),"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t + "(POSSBY " + t1_cd + ")";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
							p1_cd = p1_cd + "(POSSBY "+t + ") ";
						}
					}
					else if(possessMap.get(p1).size() == 0){
						p1_cd = p1_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(p1)){
					for(int i = 0 ; i < addMap.get(p1).size(); i++){
						p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+" ) ";	
					}
				}
				p1_cd += " )";
				//
			}
			while(it.hasNext()){
				temp = (String)it.next();
				String map = mapObjects.get(temp);
				//	if(map.equals("objects")){
				obj = temp;
				obj_cd = "(OBJECT (OBJECT (NAME "+getBaseForm(obj)+" ) ";
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(possessMap.containsKey(obj)){

					if(possessMap.get(obj).size() == 1 ){
						String t2 = possessMap.get(obj).get(0);
						if(t2.equals(p1)){
							obj_cd = obj_cd + "(POSSBY "+ p1_cd + ")";
						}
						else{
							String t = "";
							if(addMap.containsKey(t2)){
								t = getCDForm(t2,"no");
								t = t.substring(0,t.lastIndexOf(')'));
								t = t+" (POSSBY NULL)";
								for(int k = 0; k < addMap.get(t2).size(); k++){
									t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
								}
								t += ")";
							}
							if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
								obj_cd = obj_cd + "(POSSBY "+t
										+" ) ";
							}
							else{
								obj_cd = obj_cd + " "+ t + " ";
							}
						}
					}
					else if(possessMap.get(obj).size() == 2){
						String t2 = possessMap.get(obj).get(0);
						String t = "";
						String t1 = possessMap.get(obj).get(1);
						String t1_cd = "";
						if(addMap.containsKey(t1)){
							t1_cd = getCDForm(t1,"no");
							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							t1_cd = t1_cd + " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							t1_cd += ")";
						}
						if(addMap.containsKey(t2)){
							t = getCDForm(addMap.get(t2).get(0),"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t + "(POSSBY " + t1_cd + ")";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
							obj_cd = obj_cd + "(POSSBY "+t + " ) ";
						}
					}
					else if(possessMap.get(obj).size() == 0){
						obj_cd = obj_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(obj)){
					for(int i = 0 ; i < addMap.get(obj).size(); i++){
						obj_cd = obj_cd + "(ISA "+getCDForm(addMap.get(obj).get(i),"a")+" ) ";
					}
				}
				obj_cd += " ))";
			}
			ret = "(MTRANS \n\t(FROM "+src +"(POSSBY "+p1_cd+"))) \n\t(TO "+dest+" (POSSBY "+p1_cd+" )))" ;
			if(!obj.equals("")){
				ret = ret + " "+obj_cd + " ";
			}
			else{
				ret = ret + "\n\t(OBJECT NULL)";
			}
			ret += "\n\t(ACTOR " + p1_cd + ")";
			ret = ret + "\n\t(CONC_TENSE PAST)\n\t"+Using;
			String A = "";
			if(addMap.containsKey(verb_sent)){
				for(int i = 0; i < addMap.get(verb_sent).size(); i++){
					A = A + " (ISA (ADVERB " + getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
				}
			}
			ret = ret + A;
			ret = ret + ")";
			String thu = get_state(mtrans_verb, p1_cd, "");
			if(!thu.equals("")){
				ret ="(LEADSTO \n  " + ret + "\n  " + thu + " \n\t(CONC_TENSE PAST) \n\t"+Using +"\n\t"+ A + ")"
						+ "\n  (CONC_TENSE PAST) \n  (USING NULL))\n";
			}			
		}
		////*************************************************else part *******************/////////////////////////
		else{
			Iterator<String> it = possessMap.keySet().iterator();
			if(it.hasNext()) {
				p1 = (String) it.next();
				String map = mapObjects.get(p1);
				if(!map.equals("pronouns"))
					p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ " ) ";
				else 	//should take care of every pronouns
					p1_cd = "(PERSON ";
				if(possessMap.containsKey(p1)){
					if(possessMap.get(p1).size() == 1 ){
						String t2 = possessMap.get(p1).get(0);
						String t = "";
						if(addMap.containsKey(t2)){
							t = getCDForm(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t + " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
							p1_cd = p1_cd + "(POSSBY "+t
									+" ) ";
						}
						else{
							p1_cd = p1_cd + " "+ t + " ";
						}
					}
					else if(possessMap.get(p1).size() == 2){
						String t2 = possessMap.get(p1).get(0);
						String t = "";
						String t1 = possessMap.get(p1).get(1);
						String t1_cd = "";
						if(addMap.containsKey(t1)){
							t1_cd = getCDForm(t1,"no");
							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							t1_cd = t1_cd + " (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							t1_cd += ")";
						}
						if(addMap.containsKey(t2)){
							t = getCDForm(addMap.get(t2).get(0),"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t + "( POSSBY " + t1_cd + " )";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
							p1_cd = p1_cd + "(POSSBY "+t + " ) ";
						}
						else{
							p1_cd = p1_cd + "(POSSBY "+t
									+" "+t1_cd + " ) ";
						}
					}
					else if(possessMap.get(p1).size() == 0){
						p1_cd = p1_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(p1)){
					for(int i = 0 ; i < addMap.get(p1).size(); i++){
						p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+" ) ";	
					}
				}
				p1_cd += " )";
				//	
			}
			while(it.hasNext()){
				temp = (String)it.next();
				String map = mapObjects.get(temp);
				if(map.equals("politicians") || map.equals("places") || map.equals("pronouns")){
					p2 = temp;
					if(!map.equals("pronouns"))
						p2_cd = "(PERSON (NAME "+getBaseForm(p2)+ " ) ";
					else 	//should take care of every pronouns
						p2_cd = "(PERSON ";
					if(possessMap.containsKey(p2)){

						if(possessMap.get(p2).size() == 1 ){
							String t2 = possessMap.get(p2).get(0);
							String t = "";
							if(addMap.containsKey(t2)){
								t = getCDForm(t2,"no");
								t = t.substring(0,t.lastIndexOf(')'));
								t += " (POSSBY NULL)";
								for(int k = 0; k < addMap.get(t2).size(); k++){
									t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
								}
								t += ")";
							}
							if(!mapObjects.get(possessMap.get(p2).get(0)).equals("pronouns")){
								p2_cd = p2_cd + "(POSSBY "+t
										+" ) ";
							}
							else{
								p2_cd = p2_cd + " "+ t + " ";
							}
						}
						else if(possessMap.get(p2).size() == 2){
							String t2 = possessMap.get(p2).get(0);
							String t = "";
							String t1 = possessMap.get(p2).get(1);
							String t1_cd = "";
							if(addMap.containsKey(t1)){
								t1_cd = getCDForm(t1,"no");
								t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
								t1_cd += " (POSSBY NULL)";
								for(int k = 0; k < addMap.get(t1).size(); k++){
									t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
								}
								t1_cd += ")";
							}
							if(addMap.containsKey(t2)){
								t = getCDForm(addMap.get(t2).get(0),"no");
								t = t.substring(0,t.lastIndexOf(')'));
								t += " (POSSBY " + t1_cd + ")";
								for(int k = 0; k < addMap.get(t2).size(); k++){
									t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
								}
								t += ")";
							}
							if(!mapObjects.get(possessMap.get(p2).get(1)).equals("pronouns")){
								p2_cd = p2_cd + "(POSSBY "+t + " ) ";
							}
							else{
								p2_cd = p2_cd + "(POSSBY "+t
										+" "+t1_cd + " ) ";
							}
						}
						else if(possessMap.get(p2).size() == 0){
							p2_cd = p2_cd + "(POSSBY NULL)";
						}
					}
					if(addMap.containsKey(p2)){
						for(int i = 0 ; i < addMap.get(p2).size(); i++){
							p2_cd = p2_cd + "(ISA "+getCDForm(addMap.get(p2).get(i),"a")+" ) ";	
						}
					}
					p2_cd += " )";
					//	
				}
				else if(map.equals("objects")){
					obj = temp;
					obj_cd = "(OBJECT (OBJECT (NAME "+getBaseForm(obj)+" ) ";
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					if(possessMap.containsKey(obj)){

						if(possessMap.get(obj).size() == 1 ){
							String t2 = possessMap.get(obj).get(0);
							if(t2.equals(p1)){
								obj_cd = obj_cd + "(POSSBY "+p1_cd + ")";
							}
							else if(t2.equals(p2)){
								obj_cd = obj_cd + "(POSSBY "+ p2_cd+")";
							}
							else{
								String t = "";
								if(addMap.containsKey(t2)){
									t = getCDForm(t2,"no");
									t = t.substring(0,t.lastIndexOf(')'));
									t += " (POSSBY NULL)";
									for(int k = 0; k < addMap.get(t2).size(); k++){
										t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
									}
									t += ")";
								}
								if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
									obj_cd = obj_cd + "(POSSBY "+t
											+" ) ";
								}
								else{
									obj_cd = obj_cd + " "+ t + " ";
								}
							}
						}
						else if(possessMap.get(obj).size() == 2){
							String t2 = possessMap.get(obj).get(0);
							String t = "";
							String t1 = possessMap.get(obj).get(1);
							String t1_cd = "";
							if(addMap.containsKey(t1)){
								t1_cd = getCDForm(t1,"no");
								t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
								t1_cd += " (POSSBY NULL)";
								for(int k = 0; k < addMap.get(t1).size(); k++){
									t1_cd = t1_cd + " ( ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
								}
								t1_cd += ")";
							}
							if(addMap.containsKey(t2)){
								t = getCDForm(addMap.get(t2).get(0),"no");
								t = t.substring(0,t.lastIndexOf(')'));
								t += " (POSSBY " + t1_cd + " )";
								for(int k = 0; k < addMap.get(t2).size(); k++){
									t = t + " ( ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
								}
								t += ")";
							}
							if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
								obj_cd = obj_cd + "(POSSBY "+t + " ) ";
							}
							else{
								obj_cd = obj_cd + "(POSSBY "+t
										+" "+t1_cd + " ) ";
							}
						}
						else if(possessMap.get(obj).size() == 0){
							obj_cd = obj_cd + "(POSSBY NULL)";
						}
					}
					if(addMap.containsKey(obj)){
						for(int i = 0 ; i < addMap.get(obj).size(); i++){
							obj_cd = obj_cd + "(ISA "+getCDForm(addMap.get(obj).get(i),"a")+" ) ";
						}
					}
					obj_cd += " ))";
				}
			}
			if(verb_sent.equals("receive") || verb_sent.equals("take")){
				ret = "(MTRANS " ;
				if(!p2.equals(""))
					ret = ret + "\n\t(FROM "+p2_cd+")";
				if(!p1.equals(""))
					ret = ret + "\n\t(TO "+p1_cd+" )";
				if(!obj.equals(""))
					ret = ret + " "+obj_cd ;
				else{
					ret = ret + "\n\t(OBJECT NULL)";
				}
				if(p2 != "")
					ret = ret + "\n\t(ACTOR " + p2_cd + ")";
				ret = ret + "\n\t(CONC_TENSE PAST) \n\t"+Using;
				String A = "";
				if(addMap.containsKey(verb_sent)){
					for(int i = 0; i < addMap.get(verb_sent).size(); i++){
						A = A + " (ISA (ADVERB " + getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
					}
				}
				ret = ret + A;
				ret = ret + ")";
				String thu = get_state(mtrans_verb, p2_cd, p1_cd);
				if(!thu.equals("")){
					ret = "(LEADSTO \n  " + ret + "\n  " + thu + " \n\t(CONC_TENSE PAST) \n\t"+Using +"\n\t"+ A + ")"
							+ "\n  (CONC_TENSE PAST) \n  (USING NULL))\n";
				}
			}
			else{
				ret = "(MTRANS " ;
				if(!p1.equals(""))
					ret = ret + "\n\t(FROM "+p1_cd+")";
				if(!p2.equals(""))
					ret = ret + "\n\t(TO "+p2_cd+")";
				if(!obj.equals(""))
					ret = ret + " "+obj_cd;
				else{
					ret = ret + "\n\t(OBJECT NULL)";
				}
				if(p1 != "")
					ret = ret + "\n\t(ACTOR " + p1_cd + ")";
				ret = ret + "\n\t(CONC_TENSE PAST) \n\t"+Using;
				String A = "";
				if(addMap.containsKey(verb_sent)){
					for(int i = 0; i < addMap.get(verb_sent).size(); i++){
						A = A + " (ISA (ADVERB " + getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
					}
				}
				ret = ret + A;
				ret = ret + ")";
				String thu = get_state(mtrans_verb, p1_cd, p2_cd);
				if(!thu.equals("")){
					ret ="(LEADSTO \n  " + ret + "\n  " + thu + " \n\t(CONC_TENSE PAST) \n\t"+Using +"\n\t"+ A + ")"
							+ "\n  (CONC_TENSE PAST) \n  (USING NULL))\n";
				}
			}
		}
		//	
		global_ret = ret;
		return ret;
	}
	String get_state(MTrans verb_struct, String src, String dest){
		//	System.out.println("printing this " + verb_struct.source.mental_state + "  " + 
		//				verb_struct.dest.mental_state);
		if(verb_struct.actor.mental_state != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE MENTAL_STATE (INITIAL " + 
			(verb_struct.actor.mental_state+10) + ") (FINAL 21) )";
		if(verb_struct.actor.physical_state != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE PHYSICAL_STATE (INITIAL " + 
			(verb_struct.actor.physical_state+10) + ") (FINAL 21) )";
		if(verb_struct.actor.health != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE HEALTH (INITIAL " + 
			(verb_struct.actor.health+10) + ") (FINAL 21) )";
		if(verb_struct.actor.fear != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE FEAR (INITIAL " + 
			(verb_struct.actor.fear+10) + ") (FINAL 21) )";
		if(verb_struct.actor.anger != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE ANGER (INITIAL " + 
			(verb_struct.actor.anger+10) + ") (FINAL 21) )";
		if(verb_struct.dest.mental_state != 999)
			return "(CHANGE (OBJECT " + dest + ") (STATE MENTAL_STATE (INITIAL " + 
			(verb_struct.actor.mental_state+10) + ") (FINAL 21) )";
		if(verb_struct.dest.physical_state != 999)
			return "(CHANGE (OBJECT " + dest + ") (STATE PHYSICAL_STATE (INITIAL " + 
			(verb_struct.actor.physical_state+10) + ") (FINAL 21) )";
		if(verb_struct.dest.health != 999)
			return "(CHANGE (OBJECT " + dest + ") (STATE HEALTH (INITIAL " + 
			(verb_struct.actor.health+10) + ") (FINAL 21) )";
		if(verb_struct.dest.fear != 999)
			return "(CHANGE (OBJECT " + dest + ") (STATE FEAR (INITIAL " + 
			(verb_struct.actor.fear+10) + ") (FINAL 21) )";
		if(verb_struct.dest.anger != 999)
			return "(CHANGE (OBJECT " + dest + ") (STATE ANGER (INITIAL " + 
			(verb_struct.actor.anger+10) + ") (FINAL 21) )";
		return "";
	}
	String process_speak(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String temp = "",actor = "", actor_cd = "";
		speak  speakVerb = new speak();

		for(int i = 0; i < verbs.speak_verbs.length; i++){
			if(verbs.speak_verbs[i].m_name.equals(verb_sent)){
				speakVerb = verbs.speak_verbs[i];
				break;
			}
		}

		Iterator<String> it = possessMap.keySet().iterator();
		if(it.hasNext()) {
			p1 = (String) it.next();
			p1_cd = "(PERSON (NAME "+getBaseForm(p1)+ ")";
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					if(addMap.containsKey(t2)){
						t = getCDForm(t2,"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "(POSSBY NULL)";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + "(ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t
								+")";
					}
					else{
						p1_cd = p1_cd + " "+ t + " ";
					}
				}
				else if(possessMap.get(p1).size() == 2){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					String t1 = possessMap.get(p1).get(1);
					String t1_cd = "";
					if(addMap.containsKey(t1)){
						t1_cd = getCDForm(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + "(POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " (ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = getCDForm(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "(POSSBY " + t1_cd + ")";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + "(ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
						}
						t += ")";
					}
					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
						p1_cd = p1_cd + "(POSSBY "+t + ")";
					}
					else{
						p1_cd = p1_cd + "(POSSBY "+t
								+" "+t1_cd + ")";
					}
				}
				else if(possessMap.get(p1).size() == 0){
					p1_cd = p1_cd + "(POSSBY NULL)";
				}
			}
			if(addMap.containsKey(p1)){
				for(int i = 0 ; i < addMap.get(p1).size(); i++){
					p1_cd = p1_cd + "(ISA "+getCDForm(addMap.get(p1).get(i),"a")+")";	
				}
			}
			p1_cd += ")";


		}

		while(it.hasNext()){
			temp = (String)it.next();
			String map = mapObjects.get(temp);
			if(map.equals("politicians") || map.equals("places")){
				p2 = temp;
				p2_cd = "(PERSON (NAME "+getBaseForm(p2)+ ")";				
				if(possessMap.containsKey(p2)){
					if(possessMap.get(p2).size() == 1 ){
						String t2 = possessMap.get(p2).get(0);
						String t = "";
						if(addMap.containsKey(t2)){
							t = getCDForm(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += "(POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + "(ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p2).get(0)).equals("pronouns")){
							p2_cd = p2_cd + "(POSSBY "+t
									+")";
						}
						else{
							p2_cd = p2_cd + " "+ t + " ";
						}
					}
					else if(possessMap.get(p2).size() == 2){
						String t2 = possessMap.get(p2).get(0);
						String t = "";
						String t1 = possessMap.get(p2).get(1);
						String t1_cd = "";
						if(addMap.containsKey(t1)){
							t1_cd = getCDForm(t1,"no");
							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							t1_cd += "(POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								t1_cd = t1_cd + "(ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							t1_cd += ")";
						}
						if(addMap.containsKey(t2)){
							t = getCDForm(addMap.get(t2).get(0),"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += " (POSSBY " + t1_cd + ")";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + "(ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(p2).get(1)).equals("pronouns")){
							p2_cd = p2_cd + "(POSSBY "+t + ")";
						}
						else{
							p2_cd = p2_cd + "(POSSBY "+t
									+" "+t1_cd + ")";
						}
					}
					else if(possessMap.get(p2).size() == 0){
						p2_cd = p2_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(p2)){
					for(int i = 0 ; i < addMap.get(p2).size(); i++){
						p2_cd = p2_cd + "(ISA "+getCDForm(addMap.get(p2).get(i),"a")+")";	
					}
				}
				p2_cd += " )";
				//	
			}
			else if(map.equals("objects")){
				obj = temp;
				obj_cd = "(OBJECT (OBJECT (NAME "+getBaseForm(obj)+")";
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(possessMap.containsKey(obj)){

					if(possessMap.get(obj).size() == 1 ){
						String t2 = possessMap.get(obj).get(0);
						if(t2.equals(p1)){
							obj_cd = obj_cd + "(POSSBY "+p1_cd+")";
						}
						else if(t2.equals(p2)){
							obj_cd = obj_cd + "(POSSBY "+p2_cd+")";
						}
						else{
							String t = "";
							if(addMap.containsKey(t2)){
								t = getCDForm(t2,"no");
								t = t.substring(0,t.lastIndexOf(')'));
								t += "(POSSBY NULL)";
								for(int k = 0; k < addMap.get(t2).size(); k++){
									t = t + "(ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
								}
								t += ")";
							}
							if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
								obj_cd = obj_cd + "(POSSBY "+t
										+")";
							}
							else{
								obj_cd = obj_cd + " "+ t + " ";
							}
						}
					}
					else if(possessMap.get(obj).size() == 2){
						String t2 = possessMap.get(obj).get(0);
						String t = "";
						String t1 = possessMap.get(obj).get(1);
						String t1_cd = "";
						if(addMap.containsKey(t1)){
							t1_cd = getCDForm(t1,"no");
							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							t1_cd += "(POSSBY NULL)";
							for(int k = 0; k < addMap.get(t1).size(); k++){
								t1_cd = t1_cd + "(ISA " + getCDForm(addMap.get(t1).get(k),"a") + ")";
							}
							t1_cd += ")";
						}
						if(addMap.containsKey(t2)){
							t = getCDForm(addMap.get(t2).get(0),"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t += " (POSSBY " + t1_cd + ")";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + "(ISA " + getCDForm(addMap.get(t2).get(k),"a") + ")";
							}
							t += ")";
						}
						if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
							obj_cd = obj_cd + "(POSSBY "+t + ")";
						}
						else{
							obj_cd = obj_cd + "(POSSBY "+t
									+" "+t1_cd + ")";
						}
					}
					else if(possessMap.get(obj).size() == 0){
						obj_cd = obj_cd + "(POSSBY NULL)";
					}
				}
				if(addMap.containsKey(obj)){
					for(int i = 0 ; i < addMap.get(obj).size(); i++){
						obj_cd = obj_cd + "(ISA "+getCDForm(addMap.get(obj).get(i),"a")+")";
					}
				}
				obj_cd += "))";
			}
		}

		String A = "";
		if(addMap.containsKey(verb_sent)){
			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
				A = A + " (ISA (ADVERB " + getBaseForm(addMap.get(verb_sent).get(i)) + " ))"; 
			}
		}

		if(!obj_cd.equals("")){
			if(!p2.equals("")){
				ret = ret + "(SPEAK \n\t(FROM "+p1_cd+") \n\t(TO "+p2_cd+") \n\t"+obj_cd+" \n\t(CONC_TENSE PAST)\n\t"+Using+"\n\t"+A+")\n";
				//ret = ret + "(SPEAK \n\t(FROM "+p1_cd+") \n\t(TO "+p2_cd+") \n\t"+obj_cd+" \n\t(CONC_TENSE "+TENSE+")\n\t"
				//					+Using+"\n\t"+A+")\n";
			}
			else{
				ret = ret + "(SPEAK \n\t(FROM "+p1_cd+") \n\t(TO NULL) \n\t"+obj_cd+" \n\t(CONC_TENSE PAST)\n\t"
						+Using+"\n\t"+A+")\n";
				//ret = ret + "(SPEAK \n\t(FROM "+p1_cd+") \n\t(TO NULL) \n\t"+obj_cd+" \n\t(CONC_TENSE "+TENSE+")\n\t"
				//		+Using+"\n\t"+A+")\n";
			}
		}
		else{
			if(!p2.equals("")){
				ret = ret + "(SPEAK \n\t(FROM "+p1_cd+") \n\t(TO "
						+ p2_cd +") \n\t(OBJECT NULL) \n\t(CONC_TENSE PAST)\n\t"+Using+"\n\t"+A+")\n";
				//ret = ret + "(SPEAK \n\t(FROM "+p1_cd+") \n\t(TO "
				//		+ p2_cd +") \n\t(OBJECT NULL) \n\t(CONC_TENSE "+TENSE+")\n\t"+Using+"\n\t"+A+")\n";
			}
			else{
				ret = ret + "(SPEAK \n\t(FROM "+p1_cd+") \n\t(TO NULL) \n\t(OBJECT NULL) \n\t(CONC_TENSE PAST)\n\t"
						+Using+"\n\t"+A+")\n";
				//ret = ret + "(SPEAK \n\t(FROM "+p1_cd+") \n\t(TO NULL) \n\t(OBJECT NULL) \n\t(CONC_TENSE "+TENSE+")\n\t"
				//		+Using+"\n\t"+A+")\n";
			}
		}


		//	
		global_ret = ret;
		return ret;

	}
	String get_state_atrans(ATrans verb_struct, String src){
		//	System.out.println("printing this " + verb_struct.source.mental_state + "  " + 
		//				verb_struct.dest.mental_state);
		if(verb_struct.actor.mental_state != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE MENTAL_STATE (INITIAL " + 
			(verb_struct.actor.mental_state+10) + ") (FINAL 21) )";
		if(verb_struct.actor.physical_state != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE PHYSICAL_STATE (INITIAL " + 
			(verb_struct.actor.physical_state+10) + ") (FINAL 21) )";
		if(verb_struct.actor.health != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE HEALTH (INITIAL " + 
			(verb_struct.actor.health+10) + ") (FINAL 21) )";
		if(verb_struct.actor.fear != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE FEAR (INITIAL " + 
			(verb_struct.actor.fear+10) + ") (FINAL 21) )";
		if(verb_struct.actor.anger != 999)
			return "(CHANGE (OBJECT " + src + ") (STATE ANGER (INITIAL " + 
			(verb_struct.actor.anger+10) + ") (FINAL 21) )";
		return "";
	}
}	