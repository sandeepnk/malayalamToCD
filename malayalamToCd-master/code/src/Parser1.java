import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

@SuppressWarnings("unused")
public class Parser1 {
	AllDomains domain;
	AllVerbs verbs;
	
	HashMap<String, String> mapObjects = new HashMap<String, String>();
	private String global_ret;
	private String Using;
	Parser1(AllDomains output_1a_domain, AllVerbs output_1a_verbs){
		domain = output_1a_domain;
		verbs = output_1a_verbs;
	}
	public void parse(String new_string){
        create_maps();
        String temp = new String();
       // String m_new_sting = new String();
       // m_new_string = convert_to_english(new_string);
        temp = new_string;
        String lastnoun = "", lastobj = "";
        String[] parts = temp.split("\\s+");
        for(int i = 0; i < parts.length ; i++){
        	System.out.println(parts[i]);
            if(mapObjects.containsKey(parts[i])){
                String type = mapObjects.get(parts[i]);
                if(type.equals("politicians")){
                	System.out.println("Entered if"+parts[i]);
                    lastnoun = parts[i];
                }
                else if(type.equals("objects")){
                    lastobj = parts[i];
                    System.out.println("Entered if"+parts[i]);
                }
                else if(type.equals("pronouns") && !parts[i].equals("who") && !parts[i].equals("whose") &&
                        !parts[i].equals("whom") && !parts[i].equals("which") ){
                	System.out.println("Entered if"+parts[i]);
                    if(parts[i].equals("it") || parts[i].equals("this")){
                        parts[i] = lastobj;
                        System.out.println("Entered if"+parts[i]);
                    }
                    else{
                        parts[i] = lastnoun;
                        System.out.println("entered else");
                    }
                }
            }
        }
        new_string = "";
        for(int i = 0; i < parts.length ; i++){
            new_string = new_string + parts[i] + " ";
        }
        System.out.println(new_string);
        parse_sentence(new_string);
        System.out.println("\nCD-FORM : "+global_ret+"\n");
    }
	
	public void create_maps(){
		int i;
		for(i = 0; i < 116; i++){
			try{
				mapObjects.put(domain.politicians[i].name, "politicians");
				mapObjects.put(domain.politicians[i].m_name, "politicians");
			}
			catch(NullPointerException e){
				break;
			}
		}

		for(i = 0; i < 600; i++){
			try{
				mapObjects.put(domain.places[i].name, "places");
				mapObjects.put(domain.places[i].m_name, "places");
			}
			catch(NullPointerException e){
				break;
			}
		}

		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(domain.pronouns[i].name, "pronouns");
				mapObjects.put(domain.pronouns[i].m_name, "pronouns");
			}
			catch(NullPointerException e){
				break;
			}
		}

		for(i = 0; i < 150; i++){
			try{
				mapObjects.put(domain.adjective[i].name, "adjective");
				mapObjects.put(domain.adjective[i].m_name, "adjective");
			}
			catch(NullPointerException e){
				break;
			}
		}
		
		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(domain.adverb[i].name, "adverb");
				mapObjects.put(domain.adverb[i].m_name, "adverb");
			}
			catch(NullPointerException e){
				break;
			}
		}
		for(i = 0; i < 150; i++){
			try{
				mapObjects.put(domain.objects[i].name, "objects");
				mapObjects.put(domain.objects[i].m_name, "objects");
			}
			catch(NullPointerException e){
				break;
			}
		}
//		for(i = 0; i < 100; i++){
//			try{
//				mapObjects.put(verbs.mtrans_verbs[i].name, "mtrans_verbs");
//			}
//			catch(NullPointerException e){
//				break;
//			}
//		}
//		for(i = 0; i < 100; i++){
//			try{
//				mapObjects.put(verbs.speak_verbs[i].name, "speak_verbs");
//			}
//			catch(NullPointerException e){
//				break;
//			}
//		}
//		for(i = 0; i < 100; i++){
//			try{
//				mapObjects.put(verbs.mbuild_verbs[i].name, "mbuild_verbs");
//			}
//			catch(NullPointerException e){
//				break;
//			}
//		}
		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.ptrans_verbs[i].name, "ptrans_verbs");
				mapObjects.put(verbs.ptrans_verbs[i].m_name, "ptrans_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}
//		for(i = 0; i < 100; i++){
//			try{
//				mapObjects.put(verbs.atrans_verbs[i].name, "atrans_verbs");
//			}
//			catch(NullPointerException e){
//				break;
//			}
//		}
//		for(i = 0; i < 100; i++){
//			try{
//				mapObjects.put(verbs.propel_verbs[i].name, "propel_verbs");
//			}
//			catch(NullPointerException e){
//				break;
//			}
//		}
//		for(i = 0; i < 100; i++){
//			try{
//				mapObjects.put(verbs.expel_verbs[i].name, "expel_verbs");
//			}
//			catch(NullPointerException e){
//				break;
//			}
//		}
//		for(i = 0; i < 100; i++){
//			try{
//				mapObjects.put(verbs.grasp_verbs[i].name, "grasp_verbs");
//			}
//			catch(NullPointerException e){
//				break;
//			}
//		}
		for(i = 0; i < 100; i++){
			try{
				mapObjects.put(verbs.ingest_verbs[i].name, "ingest_verbs");
				mapObjects.put(verbs.ingest_verbs[i].m_name, "ingest_verbs");
			}
			catch(NullPointerException e){
				break;
			}
		}
	}
//		for(i = 0; i < 100; i++){
//			try{
//				mapObjects.put(verbs.attend_verbs[i].name, "attend_verbs");
//			}
//			catch(NullPointerException e){
//				break;
//			}
//		}
//		for(i = 0; i < 100; i++){
//			try{
//				mapObjects.put(verbs.state_verbs[i].name, "state_verbs");
//			}
//			catch(NullPointerException e){
//				break;
//			}
//		}
//	}
//	
	String parse_sentence(String sentence){
		String[] parts = sentence.split("\\s+");
		int i,j, length = parts.length, x;
		if(parts[0].toLowerCase().equals("if")){
			String sub1 = "", sub2 = "";
			for(i = length-1; i >= 0; i--){
				if(parts[i].toLowerCase().equals("then")){
					for(j = 1; j < i; j++){
						sub1 = sub1 + " " + parts[j];
					}
					for(j = i+1; j < length; j++){
						sub2 = sub2 + " " + parts[j];
					}
					parse_sentence(sub1);
					String s1 = global_ret;
					parse_sentence(sub2);
					String s2 = global_ret;
					global_ret = "(LEADS TO " + s1 + " " + s2 + " )";
					return global_ret;
				}
			}
		}
		else if((x = search("but", parts)) != 0){
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
			global_ret = "(AND " + s1 + " " + s2 + " )";
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
			String new_str = "";
			int flag = 0;
			String adj = "", adj_n = "", adj_o = "", noun = "";
			//System.out.println("Sentence coming : " + sentence);
			String[] part = sentence.split("\\s+");
			for(i = 0; i < part.length ; i++){
				if(part[i].equals("with") || part[i].equals("using")){
					flag = 1;
					for(j = i+1 ; j < part.length ; j ++){
						if(mapObjects.containsKey(part[j]) && mapObjects.get(part[j]).equals("objects")){
							using = part[j];
							adj_o = adj;
							i = j;
							break;
						}
						else if(mapObjects.containsKey(part[j]) && (mapObjects.get(part[j]).equals("politicians") ||mapObjects.get(part[j]).equals("places"))){
							adj_n = adj;
							adj = "";
							noun = part[j];
						}
						else if(mapObjects.containsKey(part[j]) && mapObjects.get(part[j]).equals("adjective")){
							adj = adj + "(ISA (ADJECTIVE "+ part[j]+"))";
						}
					}
				}
				else
					new_str += part[i]+ " ";
			}
			if(using.equals("NULL")){
				Using = "(USING NULL)";
			}
			else{
				Using = "(USING (OBJECT (NAME "+using+")";
				if(!noun.equals("")){
					Using += "(POSSBY (PERSON (NAME "+ noun+")(POSSBY NULL) ";
					if(!adj_n.equals("")){
						Using += adj_n;
					}
					Using += "))";
					Using += adj_o+"))";
				}
				else{
					Using += "(POSSBY NULL)"+ adj_o+"))";
				}
			}
			
			//System.out.println("new string : "+new_str + " using : "+ Using);
			sentence = new_str;
			return process_simple(new_str);
		}
		return "";
	}
	
	int search(String x, String[] p){
		int i;
		for(i = 0; i < p.length; i++){
			if(p[i].toLowerCase().equals(x))
				return i;
		}
		return 0;
	}
	
	String process_simple(String sentence){
		String[] parts = sentence.split("\\s+");
		int i,r = 0, flag = 0, whose = 0;
		String map = "";
		String whoseobject = "";
		boolean whosenoun = false;	
		LinkedHashMap<String, ArrayList<String>> objectAdj = new LinkedHashMap<String, ArrayList<String>>();
		ArrayList<String> adds = new ArrayList<String>();
		ArrayList<String> adds2 = new ArrayList<String>();
		ArrayList<String> verb_adverb = new ArrayList<String>();
		String lastnoun = "";
		String verb_sent = "";
		// parse to determine adjectives and adverbs
		for(i = 0; i < parts.length; i++){
			if(parts[i].equals("")){
				continue;
			}
			map = mapObjects.get(parts[i]);
			if(map == null || map.equals(".")){
				continue;
			}
			if(whosenoun && map.equals("adjective")){
				objectAdj.get(whoseobject).add(parts[i]);
				whosenoun = false;
				whose = 0;
				continue;
			}
			if(parts[i].equals("of")) {
				flag = 1;
				
				continue;
			}
			else if(parts[i].equals("whose")){
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
					(map.equals("pronouns") && !parts[i].equals("who") && !parts[i].equals("whose") &&
							!parts[i].equals("whom") && !parts[i].equals("which"))||map.equals("objects")){
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
					lastnoun = parts[i];
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
				//if(!toput.isEmpty()){
				objectAdj.get(lastnoun).addAll(toput);
				adds.clear();
			}
		}
		objectAdj.get(lastnoun).addAll(adds);
		if(!verb_sent.equals("")){
			ArrayList<String> toput = new ArrayList<String>();
			toput.addAll(verb_adverb);
			objectAdj.put(verb_sent,toput);
		}
		//System.out.println("\n Adjectives/Adverbs : " + objectAdj + "\n");
		//2nd Parse to determine possessed by
		ArrayList<Character> char_list = new ArrayList<Character>();
		ArrayList<Integer> index_list = new ArrayList<Integer>();
		LinkedHashMap<String, ArrayList<String>> poss_by = new LinkedHashMap<String, ArrayList<String>>();
		for(i = 0 ; i < parts.length ; i++){
			if(parts[i].equals("")){
				continue;
			}
			map = mapObjects.get(parts[i]);
			if(parts[i].equals("of")){
				char_list.add('o');
				index_list.add(i);
			}
			else if(map == null || map.equals(".")){
				if(parts[i].equals("'s"))
					continue;
				char_list.add('*');
				index_list.add(i);
				continue;
			}
			else if(map.equals("objects")||map.equals("politicians")|| map.equals("pronouns") 
					 ||map.equals("places")){
				if(parts[i].equals("whose")){
					continue;
				}
				char_list.add('n');
				index_list.add(i);
			}
			else if(map.substring(map.lastIndexOf('_') + 1).equals("verbs")){
				char_list.add('v');
				index_list.add(i);
			}
			else if(!map.equals("adverb") && !map.equals("adjective")){
				char_list.add('*');
				index_list.add(i);
			}
		}
	//	System.out.println(char_list);
	//	System.out.println(index_list);
		
		for(int k = 0; k < char_list.size(); k++){
			if(char_list.get(k) == 'n'){
				if((k+1) < char_list.size() && char_list.get(k+1) == 'n'){
					ArrayList<String> poss = new ArrayList<String>();
					poss.add(parts[index_list.get(k)]);
					poss_by.put(parts[index_list.get(k+1)], poss);
					k = k+1;
				}
				else if((k+3) < char_list.size() && char_list.get(k+1) == 'o' && 
						char_list.get(k+2) == 'n' && char_list.get(k+3) == 'n'){
					ArrayList<String> poss = new ArrayList<String>();
					poss.add(parts[index_list.get(k+3)]);
					poss.add(parts[index_list.get(k+2)]);
					poss_by.put(parts[index_list.get(k)], poss);
					k = k+3;
				}
				else if((k+2) < char_list.size() && char_list.get(1) == 'o' && char_list.get(2) == 'n'){
					ArrayList<String> poss = new ArrayList<String>();
					poss.add(parts[index_list.get(k+2)]);
					poss_by.put(parts[index_list.get(k)], poss);
					k = k + 2;
				}
				else{
					ArrayList<String> poss = new ArrayList<String>();
					poss_by.put(parts[index_list.get(k)], poss);
				}
			}
		}
	//	System.out.println(poss_by);
		String ret = "";
	//	System.out.println("Verb coming :"+verb_sent + ": "+mapObjects.get(verb_sent) );
		if(verb_sent.equals("")){
			ret  = process_noverb(poss_by, objectAdj, sentence);
		}
		else{
			switch(mapObjects.get(verb_sent)){
//				case "mtrans_verbs":
//					ret = process_mtrans(poss_by, objectAdj, sentence, verb_sent);
//					break;
//				case "speak_verbs":
//					ret = process_speak(poss_by, objectAdj, sentence, verb_sent);
//					break;
				case "ptrans_verbs":
					ret = process_ptrans(poss_by, objectAdj, sentence, verb_sent);
					break;
//				case "atrans_verbs":
//					ret = process_atrans(poss_by, objectAdj, sentence, verb_sent);
//					break;
//				case "propel_verbs":
//					ret = process_propel(poss_by, objectAdj, sentence,verb_sent);
//					break;
//				case "mbuild_verbs":
//					ret = process_mbuild(poss_by, objectAdj, sentence);
//					break;
//				case "expel_verbs":
//					ret = process_expel(poss_by, objectAdj, sentence, verb_sent);
//					break;
//				case "grasp_verbs":
//					ret = process_grasp(poss_by, objectAdj, sentence, verb_sent);
//					break;
				case "ingest_verbs":
					ret = process_ingest(poss_by, objectAdj, sentence, verb_sent);
					break;
//				case "attend_verbs":
//					ret = process_attend(poss_by, objectAdj, sentence, verb_sent);
//					break;
//				case "state_verbs":
//					ret = process_state(poss_by, objectAdj, sentence, verb_sent);
//					break;
				default:
					ret = process_noverb(poss_by, objectAdj, sentence);
					break;
			}
		}
		return "";
	}
	
	String get_cdform(String s, String p){
		if(p.equals("n")){
			for(int i = 0 ;  i < 118 ; i++){
				if(domain.politicians[i].name.equals(s))
					return domain.politicians[i].cd_form;
			}
			for(int i = 0 ;  i < 543 ; i++){
				if(domain.places[i].name.equals(s))
					return domain.places[i].cd_form;
			}
			for(int i = 0 ;  i < domain.pronouns.length ; i++){
				try{
				if(domain.pronouns[i].name.equals(s))
					return domain.pronouns[i].cd_form;
				}
				catch(IndexOutOfBoundsException e){
					break;
				}
			}
		}
		else if(p.equals("o")){
			for(int i = 0 ;  i < 82 ; i++){
				if(domain.objects[i].name.equals(s))
					return domain.objects[i].cd_form;
			}
		}
		else if(p.equals("no")){
			for(int i = 0 ;  i < 118 ; i++){
				if(domain.politicians[i].name.equals(s)){
					return domain.politicians[i].cd_form;	
				}
			}
			for(int i = 0 ;  i < 543 ; i++){
				if(domain.places[i].name.equals(s))
					return domain.places[i].cd_form;
			}
			for(int i = 0 ;  i < domain.pronouns.length ; i++){
				try{
				if(domain.pronouns[i].name.equals(s))
					return domain.pronouns[i].cd_form;
				}
				catch(IndexOutOfBoundsException e){
					break;
				}
			}
			for(int i = 0 ;  i < 82 ; i++){
				if(domain.objects[i].name.equals(s))
					return domain.objects[i].cd_form;
			}
		}
		else if(p.equals("a")){
			for(int i = 0 ;  i < domain.adjective.length ; i++){
				if(domain.adjective[i].name.equals(s))
					return domain.adjective[i].cd_form;
			}
		}
		return "";
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
			p1_cd = "(PERSON (NAME "+p1+ " ) ";
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					 if(addMap.containsKey(t2)){
						 t = get_cdform(t2,"no");
						 t = t.substring(0,t.lastIndexOf(')'));
						 t = t + " (POSSBY NULL)";
						 for(int k = 0; k < addMap.get(t2).size(); k++){
							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
						 t1_cd = get_cdform(t1,"no");
						 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						 t1_cd = t1_cd + " (POSSBY NULL)";
						 for(int k = 0; k < addMap.get(t1).size(); k++){
							 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
						 }
						 t1_cd += ")";
					 }
					 if(addMap.containsKey(t2)){
						 t = get_cdform(addMap.get(t2).get(0),"no");
						 t = t.substring(0,t.lastIndexOf(')'));
						 t = t + "( POSSBY " + t1_cd + " )";
						 for(int k = 0; k < addMap.get(t2).size(); k++){
							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
					p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";
			
			
		}
		
		ret  = p1_cd;		
		
	//	System.out.println("speak example : " + ret );
		global_ret = ret;
		return ret;

	}
//	String process_mtrans(LinkedHashMap<String, ArrayList<String>> possessMap, 
//			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
//		//LinkedHashMap<String, Obj_Struct> cd_map = new LinkedHashMap<>();
//		//cd_map = put_in_CDmap(sentence);		
//		String ret = "";
//		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
//		String pos = "", src = "", dest = "";
//		String temp = "", actor = "", actor_cd = "";
//		mtrans mtrans_verb = new mtrans();
//
//		for(int i = 0; i < verbs.mtrans_verbs.length; i++){
//			if(verbs.mtrans_verbs[i].name.equals(verb_sent)){
//				mtrans_verb = verbs.mtrans_verbs[i];
//				break;
//			}
//		}		
//		if(mtrans_verb.source.name.equals("LTM") || mtrans_verb.source.name.equals("EYE")||
//				mtrans_verb.source.name.equals("CP")){
//			src = "(OBJECT (NAME "+mtrans_verb.source.name + ")";
//			dest = "(OBJECT (NAME "+ mtrans_verb.dest.name +")";
//			Iterator it = possessMap.keySet().iterator();
//			if(it.hasNext()) {
//				p1 = (String) it.next();
//				String map = mapObjects.get(p1);
//				if(!map.equals("pronouns"))
//					p1_cd = "(PERSON (NAME "+p1+ " ) ";
//				else 	
//					p1_cd = "(PERSON ";
//				if(possessMap.containsKey(p1)){
//					if(possessMap.get(p1).size() == 1 ){
//						String t2 = possessMap.get(p1).get(0);
//						String t = "";
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(t2,"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t = t + "(POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 
//							 t += ")";
//						 }
//						 if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
//							 p1_cd = p1_cd + "(POSSBY "+t
//									 +" ) ";
//						 }
//						 else{
//							 p1_cd = p1_cd + " "+ t + " ";
//						 }
//					}
//					else if(possessMap.get(p1).size() == 2){
//						String t2 = possessMap.get(p1).get(0);
//						String t = "";
//						String t1 = possessMap.get(p1).get(1);
//						String t1_cd = "";
//						 if(addMap.containsKey(t1)){
//							 t1_cd = get_cdform(t1,"no");
//							 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//							 t1_cd = t1_cd + "(POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t1).size(); k++){
//								 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//							 }
//							 t1_cd += ")";
//						 }
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(addMap.get(t2).get(0),"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t = t + "(POSSBY " + t1_cd + ")";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
//							p1_cd = p1_cd + "(POSSBY "+t + ") ";
//						}
//					}
//					else if(possessMap.get(p1).size() == 0){
//						p1_cd = p1_cd + "(POSSBY NULL)";
//					}
//				}
//				if(addMap.containsKey(p1)){
//					for(int i = 0 ; i < addMap.get(p1).size(); i++){
//						p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
//					}
//				}
//				p1_cd += " )";
//				//System.out.println("CD form : "+p1_cd);
//			}
//			while(it.hasNext()){
//				temp = (String)it.next();
//				String map = mapObjects.get(temp);
//			//	if(map.equals("objects")){
//					obj = temp;
//					obj_cd = "(OBJECT (OBJECT (NAME "+obj+" ) ";
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//					if(possessMap.containsKey(obj)){
//						
//						if(possessMap.get(obj).size() == 1 ){
//							String t2 = possessMap.get(obj).get(0);
//							if(t2.equals(p1)){
//								obj_cd = obj_cd + "(POSSBY "+ p1_cd + ")";
//							}
//							else{
//								String t = "";
//								if(addMap.containsKey(t2)){
//									 t = get_cdform(t2,"no");
//									 t = t.substring(0,t.lastIndexOf(')'));
//									 t = t+" (POSSBY NULL)";
//									 for(int k = 0; k < addMap.get(t2).size(); k++){
//										 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//									 }
//									 t += ")";
//								 }
//								 if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
//									 obj_cd = obj_cd + "(POSSBY "+t
//											 +" ) ";
//								 }
//								 else{
//									 obj_cd = obj_cd + " "+ t + " ";
//								 }
//							}
//						}
//						else if(possessMap.get(obj).size() == 2){
//							String t2 = possessMap.get(obj).get(0);
//							String t = "";
//							String t1 = possessMap.get(obj).get(1);
//							String t1_cd = "";
//							 if(addMap.containsKey(t1)){
//								 t1_cd = get_cdform(t1,"no");
//								 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//								 t1_cd = t1_cd + " (POSSBY NULL)";
//								 for(int k = 0; k < addMap.get(t1).size(); k++){
//									 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//								 }
//								 t1_cd += ")";
//							 }
//							 if(addMap.containsKey(t2)){
//								 t = get_cdform(addMap.get(t2).get(0),"no");
//								 t = t.substring(0,t.lastIndexOf(')'));
//								 t = t + "(POSSBY " + t1_cd + ")";
//								 for(int k = 0; k < addMap.get(t2).size(); k++){
//									 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//								 }
//								 t += ")";
//							 }
//							if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
//								obj_cd = obj_cd + "(POSSBY "+t + " ) ";
//							}
//						}
//						else if(possessMap.get(obj).size() == 0){
//							obj_cd = obj_cd + "(POSSBY NULL)";
//						}
//					}
//					if(addMap.containsKey(obj)){
//						for(int i = 0 ; i < addMap.get(obj).size(); i++){
//							obj_cd = obj_cd + "(ISA "+get_cdform(addMap.get(obj).get(i),"a")+" ) ";
//						}
//					}
//					obj_cd += " ))";
//			}
//			ret = "(MTRANS (FROM "+src +" (POSSBY "+p1_cd+" ))) (TO "+dest+" (POSSBY "+p1_cd+" ))) " ;
//			if(!obj.equals("")){
//				ret = ret + " "+obj_cd + " ";
//			}
//			else{
//				ret = ret + "(OBJECT NULL)";
//			}
//			ret += "(ACTOR " + p1_cd + " )";
//			ret = ret + " (CONC_TENSE PAST) "+Using;
//			String A = "";
//			if(addMap.containsKey(verb_sent)){
//				for(int i = 0; i < addMap.get(verb_sent).size(); i++){
//					A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
//				}
//			}
//			ret = ret + A;
//			ret = ret + ")";
//			String thu = get_state(mtrans_verb, p1_cd, "");
//			if(!thu.equals("")){
//				ret ="( LEADSTO " + ret + "\n" + thu + " (CONC_TENSE PAST) "+Using + A + "))";
//			}			
//		}
//////*************************************************else part *******************/////////////////////////
//		else{
//			Iterator it = possessMap.keySet().iterator();
//			if(it.hasNext()) {
//				p1 = (String) it.next();
//				String map = mapObjects.get(p1);
//				if(!map.equals("pronouns"))
//					p1_cd = "(PERSON (NAME "+p1+ " ) ";
//				else 	//should take care of every pronouns
//					p1_cd = "(PERSON ";
//				if(possessMap.containsKey(p1)){
//					if(possessMap.get(p1).size() == 1 ){
//						String t2 = possessMap.get(p1).get(0);
//						String t = "";
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(t2,"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t = t + " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						 if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
//							 p1_cd = p1_cd + "(POSSBY "+t
//									 +" ) ";
//						 }
//						 else{
//							 p1_cd = p1_cd + " "+ t + " ";
//						 }
//					}
//					else if(possessMap.get(p1).size() == 2){
//						String t2 = possessMap.get(p1).get(0);
//						String t = "";
//						String t1 = possessMap.get(p1).get(1);
//						String t1_cd = "";
//						 if(addMap.containsKey(t1)){
//							 t1_cd = get_cdform(t1,"no");
//							 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//							 t1_cd = t1_cd + " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t1).size(); k++){
//								 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//							 }
//							 t1_cd += ")";
//						 }
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(addMap.get(t2).get(0),"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t = t + "( POSSBY " + t1_cd + " )";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
//							p1_cd = p1_cd + "(POSSBY "+t + " ) ";
//						}
//						else{
//							p1_cd = p1_cd + "(POSSBY "+t
//									+" "+t1_cd + " ) ";
//						}
//					}
//					else if(possessMap.get(p1).size() == 0){
//						p1_cd = p1_cd + "(POSSBY NULL)";
//					}
//				}
//				if(addMap.containsKey(p1)){
//					for(int i = 0 ; i < addMap.get(p1).size(); i++){
//						p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
//					}
//				}
//				p1_cd += " )";
//			//	System.out.println("CD form : "+p1_cd);
//			}
//			while(it.hasNext()){
//				temp = (String)it.next();
//				String map = mapObjects.get(temp);
//				if(map.equals("politicians") || map.equals("places") || map.equals("pronouns")){
//					p2 = temp;
//					if(!map.equals("pronouns"))
//						p2_cd = "(PERSON (NAME "+p2+ " ) ";
//					else 	//should take care of every pronouns
//						p2_cd = "(PERSON ";
//					if(possessMap.containsKey(p2)){
//						
//						if(possessMap.get(p2).size() == 1 ){
//							String t2 = possessMap.get(p2).get(0);
//							String t = "";
//							 if(addMap.containsKey(t2)){
//								 t = get_cdform(t2,"no");
//								 t = t.substring(0,t.lastIndexOf(')'));
//								 t += " (POSSBY NULL)";
//								 for(int k = 0; k < addMap.get(t2).size(); k++){
//									 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//								 }
//								 t += ")";
//							 }
//							 if(!mapObjects.get(possessMap.get(p2).get(0)).equals("pronouns")){
//								 p2_cd = p2_cd + "(POSSBY "+t
//										 +" ) ";
//							 }
//							 else{
//								 p2_cd = p2_cd + " "+ t + " ";
//							 }
//						}
//						else if(possessMap.get(p2).size() == 2){
//							String t2 = possessMap.get(p2).get(0);
//							String t = "";
//							String t1 = possessMap.get(p2).get(1);
//							String t1_cd = "";
//							 if(addMap.containsKey(t1)){
//								 t1_cd = get_cdform(t1,"no");
//								 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//								 t1_cd += " (POSSBY NULL)";
//								 for(int k = 0; k < addMap.get(t1).size(); k++){
//									 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//								 }
//								 t1_cd += ")";
//							 }
//							 if(addMap.containsKey(t2)){
//								 t = get_cdform(addMap.get(t2).get(0),"no");
//								 t = t.substring(0,t.lastIndexOf(')'));
//								 t += " (POSSBY " + t1_cd + ")";
//								 for(int k = 0; k < addMap.get(t2).size(); k++){
//									 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//								 }
//								 t += ")";
//							 }
//							if(!mapObjects.get(possessMap.get(p2).get(1)).equals("pronouns")){
//								p2_cd = p2_cd + "(POSSBY "+t + " ) ";
//							}
//							else{
//								p2_cd = p2_cd + "(POSSBY "+t
//										+" "+t1_cd + " ) ";
//							}
//						}
//						else if(possessMap.get(p2).size() == 0){
//							p2_cd = p2_cd + "(POSSBY NULL)";
//						}
//					}
//					if(addMap.containsKey(p2)){
//						for(int i = 0 ; i < addMap.get(p2).size(); i++){
//							p2_cd = p2_cd + "(ISA "+get_cdform(addMap.get(p2).get(i),"a")+" ) ";	
//						}
//					}
//					p2_cd += " )";
//				//	System.out.println("CD2 form : "+p2_cd);
//				}
//				else if(map.equals("objects")){
//					obj = temp;
//					obj_cd = "(OBJECT (OBJECT (NAME "+obj+" ) ";
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//					if(possessMap.containsKey(obj)){
//						
//						if(possessMap.get(obj).size() == 1 ){
//							String t2 = possessMap.get(obj).get(0);
//							if(t2.equals(p1)){
//								obj_cd = obj_cd + "(POSSBY "+p1_cd + ")";
//							}
//							else if(t2.equals(p2)){
//								obj_cd = obj_cd + "(POSSBY "+ p2_cd+")";
//							}
//							else{
//								String t = "";
//								if(addMap.containsKey(t2)){
//									 t = get_cdform(t2,"no");
//									 t = t.substring(0,t.lastIndexOf(')'));
//									 t += " (POSSBY NULL)";
//									 for(int k = 0; k < addMap.get(t2).size(); k++){
//										 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//									 }
//									 t += ")";
//								 }
//								 if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
//									 obj_cd = obj_cd + "(POSSBY "+t
//											 +" ) ";
//								 }
//								 else{
//									 obj_cd = obj_cd + " "+ t + " ";
//								 }
//							}
//						}
//						else if(possessMap.get(obj).size() == 2){
//							String t2 = possessMap.get(obj).get(0);
//							String t = "";
//							String t1 = possessMap.get(obj).get(1);
//							String t1_cd = "";
//							 if(addMap.containsKey(t1)){
//								 t1_cd = get_cdform(t1,"no");
//								 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//								 t1_cd += " (POSSBY NULL)";
//								 for(int k = 0; k < addMap.get(t1).size(); k++){
//									 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//								 }
//								 t1_cd += ")";
//							 }
//							 if(addMap.containsKey(t2)){
//								 t = get_cdform(addMap.get(t2).get(0),"no");
//								 t = t.substring(0,t.lastIndexOf(')'));
//								 t += " (POSSBY " + t1_cd + " )";
//								 for(int k = 0; k < addMap.get(t2).size(); k++){
//									 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//								 }
//								 t += ")";
//							 }
//							if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
//								obj_cd = obj_cd + "(POSSBY "+t + " ) ";
//							}
//							else{
//								obj_cd = obj_cd + "(POSSBY "+t
//										+" "+t1_cd + " ) ";
//							}
//						}
//						else if(possessMap.get(obj).size() == 0){
//							obj_cd = obj_cd + "(POSSBY NULL)";
//						}
//					}
//					if(addMap.containsKey(obj)){
//						for(int i = 0 ; i < addMap.get(obj).size(); i++){
//							obj_cd = obj_cd + "(ISA "+get_cdform(addMap.get(obj).get(i),"a")+" ) ";
//						}
//					}
//					obj_cd += " ))";
//				}
//			}
//			if(verb_sent.equals("receive") || verb_sent.equals("take")){
//				ret = "(MTRANS " ;
//				if(!p2.equals(""))
//					ret = ret + "(FROM "+p2_cd+" ) ";
//				if(!p1.equals(""))
//					ret = ret + "(TO "+p1_cd+" ) ";
//				if(!obj.equals(""))
//					ret = ret + " "+obj_cd ;
//				else{
//					ret = ret + "(OBJECT NULL)";
//				}
//				if(p2 != "")
//					ret = ret + "( ACTOR " + p2_cd + ")";
//				ret = ret + " (CONC_TENSE PAST) "+Using;
//				String A = "";
//				if(addMap.containsKey(verb_sent)){
//					for(int i = 0; i < addMap.get(verb_sent).size(); i++){
//						A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
//					}
//				}
//				ret = ret + A;
//				ret = ret + ")";
//				String thu = get_state(mtrans_verb, p2_cd, p1_cd);
//				if(!thu.equals("")){
//					ret ="( LEADSTO " + ret + "\n" + thu + " (CONC_TENSE PAST) "+Using + A + " ))";
//				}
//			}
//			else{
//				ret = "(MTRANS " ;
//				if(!p1.equals(""))
//					ret = ret + "(FROM "+p1_cd+" ) ";
//				if(!p2.equals(""))
//					ret = ret + "(TO "+p2_cd+" ) ";
//				if(!obj.equals(""))
//					ret = ret + " "+obj_cd;
//				else{
//					ret = ret + "(OBJECT NULL)";
//				}
//				if(p1 != "")
//					ret = ret + "( ACTOR " + p1_cd + ")";
//				ret = ret + " (CONC_TENSE PAST) "+Using;
//				String A = "";
//				if(addMap.containsKey(verb_sent)){
//					for(int i = 0; i < addMap.get(verb_sent).size(); i++){
//						A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
//					}
//				}
//				ret = ret + A;
//				ret = ret + ")";
//				String thu = get_state(mtrans_verb, p1_cd, p2_cd);
//				if(!thu.equals("")){
//					ret ="( LEADSTO " + ret + "\n" + thu + " (CONC_TENSE PAST) "+Using + A + " ))";
//				}
//			}
//		}
//	//	System.out.println("mtrans example : "+ret);
//		global_ret = ret;
//		return ret;
//	}
//	
//	String get_state(mtrans verb_struct, String src, String dest){
//	//	System.out.println("printing this " + verb_struct.source.mental_state + "  " + 
//	//				verb_struct.dest.mental_state);
//		if(verb_struct.actor.mental_state != 999)
//			return "(CHANGE (OBJECT " + src + ") (STATE MENTAL_STATE (INITIAL " + 
//		(verb_struct.actor.mental_state+10) + ") (FINAL 21) )";
//		if(verb_struct.actor.physical_state != 999)
//			return "(CHANGE (OBJECT " + src + ") (STATE PHYSICAL_STATE (INITIAL " + 
//			(verb_struct.actor.physical_state+10) + ") (FINAL 21) )";
//		if(verb_struct.actor.health != 999)
//			return "(CHANGE (OBJECT " + src + ") (STATE HEALTH (INITIAL " + 
//			(verb_struct.actor.health+10) + ") (FINAL 21) )";
//		if(verb_struct.actor.fear != 999)
//			return "(CHANGE (OBJECT " + src + ") (STATE FEAR (INITIAL " + 
//			(verb_struct.actor.fear+10) + ") (FINAL 21) )";
//		if(verb_struct.actor.anger != 999)
//			return "(CHANGE (OBJECT " + src + ") (STATE ANGER (INITIAL " + 
//			(verb_struct.actor.anger+10) + ") (FINAL 21) )";
//		if(verb_struct.dest.mental_state != 999)
//			return "(CHANGE (OBJECT " + dest + ") (STATE MENTAL_STATE (INITIAL " + 
//			(verb_struct.actor.mental_state+10) + ") (FINAL 21) )";
//		if(verb_struct.dest.physical_state != 999)
//			return "(CHANGE (OBJECT " + dest + ") (STATE PHYSICAL_STATE (INITIAL " + 
//			(verb_struct.actor.physical_state+10) + ") (FINAL 21) )";
//		if(verb_struct.dest.health != 999)
//			return "(CHANGE (OBJECT " + dest + ") (STATE HEALTH (INITIAL " + 
//			(verb_struct.actor.health+10) + ") (FINAL 21) )";
//		if(verb_struct.dest.fear != 999)
//			return "(CHANGE (OBJECT " + dest + ") (STATE FEAR (INITIAL " + 
//			(verb_struct.actor.fear+10) + ") (FINAL 21) )";
//		if(verb_struct.dest.anger != 999)
//			return "(CHANGE (OBJECT " + dest + ") (STATE ANGER (INITIAL " + 
//			(verb_struct.actor.anger+10) + ") (FINAL 21) )";
//		return "";
//	}
//	
//	String process_speak(LinkedHashMap<String, ArrayList<String>> possessMap, 
//			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
//		String ret = "";
//		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
//		String temp = "",actor = "", actor_cd = "";
//		speak  speakVerb = new speak();
//
//		for(int i = 0; i < verbs.speak_verbs.length; i++){
//			if(verbs.speak_verbs[i].name.equals(verb_sent)){
//				speakVerb = verbs.speak_verbs[i];
//				break;
//			}
//		}
//		
//		Iterator it = possessMap.keySet().iterator();
//		if(it.hasNext()) {
//			p1 = (String) it.next();
//			p1_cd = "(PERSON (NAME "+p1+ " ) ";
//			if(possessMap.containsKey(p1)){
//				if(possessMap.get(p1).size() == 1 ){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(t2,"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					 if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
//						 p1_cd = p1_cd + "(POSSBY "+t
//								 +" ) ";
//					 }
//					 else{
//						 p1_cd = p1_cd + " "+ t + " ";
//					 }
//				}
//				else if(possessMap.get(p1).size() == 2){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					String t1 = possessMap.get(p1).get(1);
//					String t1_cd = "";
//					 if(addMap.containsKey(t1)){
//						 t1_cd = get_cdform(t1,"no");
//						 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//						 t1_cd = t1_cd + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t1).size(); k++){
//							 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//						 }
//						 t1_cd += ")";
//					 }
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(addMap.get(t2).get(0),"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + "( POSSBY " + t1_cd + " )";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
//						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
//					}
//					else{
//						p1_cd = p1_cd + "(POSSBY "+t
//								+" "+t1_cd + " ) ";
//					}
//				}
//				else if(possessMap.get(p1).size() == 0){
//					p1_cd = p1_cd + "(POSSBY NULL)";
//				}
//			}
//			if(addMap.containsKey(p1)){
//				for(int i = 0 ; i < addMap.get(p1).size(); i++){
//					p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
//				}
//			}
//			p1_cd += " )";
//			
//			
//		}
//		
//		while(it.hasNext()){
//			temp = (String)it.next();
//			String map = mapObjects.get(temp);
//			if(map.equals("politicians") || map.equals("places")){
//				p2 = temp;
//				p2_cd = "(PERSON (NAME "+p2+ " ) ";				
//				if(possessMap.containsKey(p2)){
//					if(possessMap.get(p2).size() == 1 ){
//						String t2 = possessMap.get(p2).get(0);
//						String t = "";
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(t2,"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t += " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						 if(!mapObjects.get(possessMap.get(p2).get(0)).equals("pronouns")){
//							 p2_cd = p2_cd + "(POSSBY "+t
//									 +" ) ";
//						 }
//						 else{
//							 p2_cd = p2_cd + " "+ t + " ";
//						 }
//					}
//					else if(possessMap.get(p2).size() == 2){
//						String t2 = possessMap.get(p2).get(0);
//						String t = "";
//						String t1 = possessMap.get(p2).get(1);
//						String t1_cd = "";
//						 if(addMap.containsKey(t1)){
//							 t1_cd = get_cdform(t1,"no");
//							 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//							 t1_cd += " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t1).size(); k++){
//								 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//							 }
//							 t1_cd += ")";
//						 }
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(addMap.get(t2).get(0),"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t += " (POSSBY " + t1_cd + ")";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						if(!mapObjects.get(possessMap.get(p2).get(1)).equals("pronouns")){
//							p2_cd = p2_cd + "(POSSBY "+t + " ) ";
//						}
//						else{
//							p2_cd = p2_cd + "(POSSBY "+t
//									+" "+t1_cd + " ) ";
//						}
//					}
//					else if(possessMap.get(p2).size() == 0){
//						p2_cd = p2_cd + "(POSSBY NULL)";
//					}
//				}
//				if(addMap.containsKey(p2)){
//					for(int i = 0 ; i < addMap.get(p2).size(); i++){
//						p2_cd = p2_cd + "(ISA "+get_cdform(addMap.get(p2).get(i),"a")+" ) ";	
//					}
//				}
//				p2_cd += " )";
//			//	System.out.println("CD2 form : "+p2_cd);
//			}
//			else if(map.equals("objects")){
//				obj = temp;
//				obj_cd = "(OBJECT (OBJECT (NAME "+obj+" ) ";
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//				if(possessMap.containsKey(obj)){
//					
//					if(possessMap.get(obj).size() == 1 ){
//						String t2 = possessMap.get(obj).get(0);
//						if(t2.equals(p1)){
//							obj_cd = obj_cd + "(POSSBY "+p1_cd+")";
//						}
//						else if(t2.equals(p2)){
//							obj_cd = obj_cd + "(POSSBY "+p2_cd+")";
//						}
//						else{
//							String t = "";
//							if(addMap.containsKey(t2)){
//								 t = get_cdform(t2,"no");
//								 t = t.substring(0,t.lastIndexOf(')'));
//								 t += " (POSSBY NULL)";
//								 for(int k = 0; k < addMap.get(t2).size(); k++){
//									 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//								 }
//								 t += ")";
//							 }
//							 if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
//								 obj_cd = obj_cd + "(POSSBY "+t
//										 +" ) ";
//							 }
//							 else{
//								 obj_cd = obj_cd + " "+ t + " ";
//							 }
//						}
//					}
//					else if(possessMap.get(obj).size() == 2){
//						String t2 = possessMap.get(obj).get(0);
//						String t = "";
//						String t1 = possessMap.get(obj).get(1);
//						String t1_cd = "";
//						 if(addMap.containsKey(t1)){
//							 t1_cd = get_cdform(t1,"no");
//							 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//							 t1_cd += " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t1).size(); k++){
//								 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//							 }
//							 t1_cd += ")";
//						 }
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(addMap.get(t2).get(0),"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t += " (POSSBY " + t1_cd + " )";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
//							obj_cd = obj_cd + "(POSSBY "+t + " ) ";
//						}
//						else{
//							obj_cd = obj_cd + "(POSSBY "+t
//									+" "+t1_cd + " ) ";
//						}
//					}
//					else if(possessMap.get(obj).size() == 0){
//						obj_cd = obj_cd + "(POSSBY NULL)";
//					}
//				}
//				if(addMap.containsKey(obj)){
//					for(int i = 0 ; i < addMap.get(obj).size(); i++){
//						obj_cd = obj_cd + "(ISA "+get_cdform(addMap.get(obj).get(i),"a")+" ) ";
//					}
//				}
//				obj_cd += " ))";
//			}
//		}
//
//		String A = "";
//		if(addMap.containsKey(verb_sent)){
//			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
//				A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
//			}
//		}
//		
//		if(!obj_cd.equals("")){
//			if(!p2.equals(""))
//				ret = ret + "(SPEAK (FROM "+p1_cd+") (TO "+p2_cd+") "+obj_cd+" (CONC_TENSE PAST)"+Using+A+")";
//			else
//				ret = ret + "(SPEAK (FROM "+p1_cd+") (TO NULL) "+obj_cd+" (CONC_TENSE PAST)"+Using+A+")";
//		}
//		else{
//			if(!p2.equals(""))
//				ret = ret + "(SPEAK (FROM "+p1_cd+") (TO "+ p2_cd +") (OBJECT NULL) (CONC_TENSE PAST)"+Using+A+")";
//			else
//				ret = ret + "(SPEAK (FROM "+p1_cd+") (TO NULL) (OBJECT NULL) (CONC_TENSE PAST)"+Using+A+")";
//		}
//			
//		
//	//	System.out.println("speak example : " + ret );
//		global_ret = ret;
//		return ret;
//
//	}
//	
//	
//	String process_atrans(LinkedHashMap<String, ArrayList<String>> possessMap, 
//			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
//		String ret = "";
//		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
//		String pos = "", src = "", dest = "", src_cd = "", dest_cd = "";
//		String temp = "", actor = "", actor_cd = "";
//		atrans atrans_verb = new atrans();
//		for(int i = 0; i < verbs.atrans_verbs.length; i++){
//			if(verbs.atrans_verbs[i].name.equals(verb_sent)){
//				atrans_verb = verbs.atrans_verbs[i];
//				break;
//			}
//		}
//		String[] parts = sentence.split("\\s+");
//		Iterator it = possessMap.keySet().iterator();
//		ArrayList<String> temp_array = new ArrayList<>();
//		int fromflag = 0, toflag = 0;
//		for(int i = 0; i < parts.length; i++){
//			if(parts[i].equals("from")) fromflag = 1;
//			else if(parts[i].equals("to")) {
//				toflag = 1;
//			}
//			else if(possessMap.containsKey(parts[i]) && !mapObjects.get(parts[i]).equals("objects") 
//					&& !temp_array.contains(parts[i]) && fromflag == 1){
//				fromflag = 0;
//				src = parts[i];
//			}
//			else if(possessMap.containsKey(parts[i]) && !mapObjects.get(parts[i]).equals("objects") 
//					&& !temp_array.contains(parts[i]) && toflag == 1){
//				toflag = 0;
//				dest = parts[i];
//			}
//			else if(possessMap.containsKey(parts[i]) && mapObjects.get(parts[i]).equals("objects")){
//					obj = parts[i];
//			}
//			if(!temp_array.contains(parts[i])) temp_array.add(parts[i]);
//		}
//		if(src == "")
//			src = p1;
//		else if(dest == "")
//			dest = p1;
//		if(it.hasNext()) {
//			p1 = (String) it.next();
//			String map = mapObjects.get(p1);
//		//	System.out.println("First object : "+ p1);
//			if(!map.equals("pronouns"))
//				p1_cd = "(PERSON (NAME "+p1+ " ) ";
//			else 	//should take care of every pronouns
//				p1_cd = "(PERSON ";
//			if(possessMap.containsKey(p1)){
//				if(possessMap.get(p1).size() == 1 ){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(t2,"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					 if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
//						 p1_cd = p1_cd + "(POSSBY "+t
//								 +" ) ";
//					 }
//					 else{
//						 p1_cd = p1_cd + " "+ t + " ";
//					 }
//				}
//				else if(possessMap.get(p1).size() == 2){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					String t1 = possessMap.get(p1).get(1);
//					String t1_cd = "";
//					 if(addMap.containsKey(t1)){
//						 t1_cd = get_cdform(t1,"no");
//						 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//						 t1_cd = t1_cd + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t1).size(); k++){
//							 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//						 }
//						 t1_cd += ")";
//					 }
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(addMap.get(t2).get(0),"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + "( POSSBY " + t1_cd + " )";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
//						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
//					}
//					else{
//						p1_cd = p1_cd + "(POSSBY "+t
//								+" "+t1_cd + " ) ";
//					}
//				}
//				else if(possessMap.get(p1).size() == 0){
//					p1_cd = p1_cd + "(POSSBY NULL)";
//				}
//			}
//			if(addMap.containsKey(p1)){
//				for(int i = 0 ; i < addMap.get(p1).size(); i++){
//					p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
//				}
//			}
//			p1_cd += " )";
//		//	System.out.println("CD form : "+p1_cd);
//		}
//		///////////////////done actor/////////////
//		if(src == "")
//			src_cd = p1_cd;
//		else if(src != ""){
//			src_cd = " (PLACE (NAME "+src+" ) ";
//			if(possessMap.containsKey(src)){
//				if(possessMap.get(src).size() == 1 ){
//					String t2 = possessMap.get(src).get(0);
//					if(t2.equals(p1)){
//						src_cd = src_cd + " (POSSBY " + p1_cd + ")";
//					}
//					else{
//						String t = "";
//						if(addMap.containsKey(t2)){
//							t = get_cdform(t2,"no");
//							t = t.substring(0,t.lastIndexOf(')'));
//							t = t+" (POSSBY NULL)";
//							for(int k = 0; k < addMap.get(t2).size(); k++){
//								t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							}
//							t += ")";
//						}
//						if(!mapObjects.get(possessMap.get(src).get(0)).equals("pronouns")){
//							src_cd = src_cd + "(POSSBY "+t
//									+" ) ";
//						}
//						else{
//							src_cd = src_cd + " "+ t + " ";
//						}
//					}
//				}
//				else if(possessMap.get(src).size() == 2){
//					String t2 = possessMap.get(src).get(0);
//					String t = "";
//					String t1 = possessMap.get(src).get(1);
//					String t1_cd = "";
//					if(addMap.containsKey(t1)){
//						t1_cd = get_cdform(t1,"no");
//						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//						t1_cd = t1_cd + " (POSSBY NULL)";
//						for(int k = 0; k < addMap.get(t1).size(); k++){
//							t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//						}
//						t1_cd += ")";
//					}
//					if(addMap.containsKey(t2)){
//						t = get_cdform(addMap.get(t2).get(0),"no");
//						t = t.substring(0,t.lastIndexOf(')'));
//						t = t + "(POSSBY " + t1_cd + ")";
//						for(int k = 0; k < addMap.get(t2).size(); k++){
//							t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						}
//						t += ")";
//					}
//					if(!mapObjects.get(possessMap.get(src).get(1)).equals("pronouns")){
//						src_cd = src_cd + "(POSSBY "+t + " ) ";
//					}
//				}
//				else if(possessMap.get(src).size() == 0){
//					src_cd = src_cd + "(POSSBY NULL)";
//				}
//			}
//			if(addMap.containsKey(src)){
//				for(int i = 0 ; i < addMap.get(src).size(); i++){
//					src_cd = src_cd + "(ISA "+get_cdform(addMap.get(src).get(i),"a")+" ) ";
//				}
//			}
//			src_cd += " )";
//		}
//		//////////////done source/////////////////
//		if(dest == "")
//			dest_cd = p1_cd;
//		else if(dest != ""){
//			dest_cd = " (PLACE (NAME "+dest+" ) ";
//			if(possessMap.containsKey(dest)){
//				if(possessMap.get(dest).size() == 1 ){
//					String t2 = possessMap.get(dest).get(0);
//					if(t2.equals(p1)){
//						dest_cd = dest_cd + " (POSSBY " + p1_cd + ")";
//					}
//					else{
//						String t = "";
//						if(addMap.containsKey(t2)){
//							t = get_cdform(t2,"no");
//							t = t.substring(0,t.lastIndexOf(')'));
//							t = t+" (POSSBY NULL)";
//							for(int k = 0; k < addMap.get(t2).size(); k++){
//								t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							}
//							t += ")";
//						}
//						if(!mapObjects.get(possessMap.get(dest).get(0)).equals("pronouns")){
//							dest_cd = dest_cd + "(POSSBY "+t
//									+" ) ";
//						}
//						else{
//							dest_cd = dest_cd + " "+ t + " ";
//						}
//					}
//				}
//				else if(possessMap.get(dest).size() == 2){
//					String t2 = possessMap.get(dest).get(0);
//					String t = "";
//					String t1 = possessMap.get(dest).get(1);
//					String t1_cd = "";
//					if(addMap.containsKey(t1)){
//						t1_cd = get_cdform(t1,"no");
//						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//						t1_cd = t1_cd + " (POSSBY NULL)";
//						for(int k = 0; k < addMap.get(t1).size(); k++){
//							t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//						}
//						t1_cd += ")";
//					}
//					if(addMap.containsKey(t2)){
//						t = get_cdform(addMap.get(t2).get(0),"no");
//						t = t.substring(0,t.lastIndexOf(')'));
//						t = t + "(POSSBY " + t1_cd + ")";
//						for(int k = 0; k < addMap.get(t2).size(); k++){
//							t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						}
//						t += ")";
//					}
//					if(!mapObjects.get(possessMap.get(dest).get(1)).equals("pronouns")){
//						dest_cd = dest_cd + "(POSSBY "+t + " ) ";
//					}
//				}
//				else if(possessMap.get(dest).size() == 0){
//					dest_cd = dest_cd + "(POSSBY NULL)";
//				}
//			}
//			if(addMap.containsKey(dest)){
//				for(int i = 0 ; i < addMap.get(dest).size(); i++){
//					dest_cd = dest_cd + "(ISA "+get_cdform(addMap.get(dest).get(i),"a")+" ) ";
//				}
//			}
//			dest_cd += " )";
//		}
//		/////////////done dest////////////////////
//		if(obj.equals("")){
//			obj_cd = p1_cd;
//		}
//		else{
//			obj_cd = " (OBJECT (OBJECT (NAME "+obj+" ) ";
//			if(possessMap.containsKey(obj)){
//				if(possessMap.get(obj).size() == 1 ){
//					String t2 = possessMap.get(obj).get(0);
//					if(t2.equals(p1)){
//						obj_cd = obj_cd + " (POSSBY " + p1_cd + ")";
//					}
//					else{
//						String t = "";
//						if(addMap.containsKey(t2)){
//							t = get_cdform(t2,"no");
//							t = t.substring(0,t.lastIndexOf(')'));
//							t = t+" (POSSBY NULL)";
//							for(int k = 0; k < addMap.get(t2).size(); k++){
//								t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							}
//							t += ")";
//						}
//						if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
//							obj_cd = obj_cd + "(POSSBY "+t
//									+" ) ";
//						}
//						else{
//							obj_cd = obj_cd + " "+ t + " ";
//						}
//					}
//				}
//				else if(possessMap.get(obj).size() == 2){
//					String t2 = possessMap.get(obj).get(0);
//					String t = "";
//					String t1 = possessMap.get(obj).get(1);
//					String t1_cd = "";
//					if(addMap.containsKey(t1)){
//						t1_cd = get_cdform(t1,"no");
//						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//						t1_cd = t1_cd + " (POSSBY NULL)";
//						for(int k = 0; k < addMap.get(t1).size(); k++){
//							t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//						}
//						t1_cd += ")";
//					}
//					if(addMap.containsKey(t2)){
//						t = get_cdform(addMap.get(t2).get(0),"no");
//						t = t.substring(0,t.lastIndexOf(')'));
//						t = t + "(POSSBY " + t1_cd + ")";
//						for(int k = 0; k < addMap.get(t2).size(); k++){
//							t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						}
//						t += ")";
//					}
//					if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
//						obj_cd = obj_cd + "(POSSBY "+t + " ) ";
//					}
//				}
//				else if(possessMap.get(obj).size() == 0){
//					obj_cd = obj_cd + "(POSSBY NULL)";
//				}
//			}
//			if(addMap.containsKey(obj)){
//				for(int i = 0 ; i < addMap.get(obj).size(); i++){
//					obj_cd = obj_cd + "(ISA "+get_cdform(addMap.get(obj).get(i),"a")+" ) ";
//				}
//			}
//			obj_cd += " ))";
//		}
//		ret = ret + "(ATRANS ";
//		ret = ret + "(FROM " + src_cd + ")";
//		ret = ret + "(TO " + dest_cd + ")";
//		ret = ret + obj_cd ;
//		ret = ret + " (ACTOR " + p1_cd + ")";
//		String A = "";
//		if(addMap.containsKey(verb_sent)){
//			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
//				A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
//			}
//		}
//		
//		ret = ret + "(CONC_TENSE PAST)"+Using;
//		ret = ret + A+ ")";
//		global_ret = ret;
//		System.out.println("ptrans cd form : " + ret );
//		return "";
//	}
//	
	
	String process_ptrans(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String pos = "", src = "", dest = "", src_cd = "", dest_cd = "";
		String temp = "", actor = "", actor_cd = "";
		Ptrans ptrans_verb = new Ptrans();
		for(int i = 0; i < verbs.ptrans_verbs.length; i++){
			if(verbs.ptrans_verbs[i].name.equals(verb_sent)){
				ptrans_verb = verbs.ptrans_verbs[i];
				break;
			}
		}
		String[] parts = sentence.split("\\s+");
		Iterator<String> it = possessMap.keySet().iterator();
		int fromflag = 0, toflag = 0;
		for(int i = 0; i < parts.length; i++){
			if(parts[i].equals("from")) fromflag = 1;
			else if(parts[i].equals("to")) {
				toflag = 1;
			}
			else if(possessMap.containsKey(parts[i]) && mapObjects.get(parts[i]).equals("places") && fromflag == 1){
				fromflag = 0;
				src = parts[i];
			}
			else if(possessMap.containsKey(parts[i]) && mapObjects.get(parts[i]).equals("places") && toflag == 1){
				toflag = 0;
				dest = parts[i];
			}
			else if(possessMap.containsKey(parts[i])){
				if(mapObjects.get(parts[i]).equals("objects")){
					obj = parts[i];
				}
				else{
					obj = p1;
				}
			}
		}
		///////////////////
		if(it.hasNext()) {
			p1 = (String) it.next();
			String map = mapObjects.get(p1);
		//	System.out.println("First object : "+ p1);
			if(!map.equals("pronouns"))
				p1_cd = "(PERSON (NAME "+p1+ " ) ";
			else 	//should take care of every pronouns
				p1_cd = "(PERSON ";
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					 if(addMap.containsKey(t2)){
						 t = get_cdform(t2,"no");
						 t = t.substring(0,t.lastIndexOf(')'));
						 t = t + " (POSSBY NULL)";
						 for(int k = 0; k < addMap.get(t2).size(); k++){
							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
						 t1_cd = get_cdform(t1,"no");
						 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						 t1_cd = t1_cd + " (POSSBY NULL)";
						 for(int k = 0; k < addMap.get(t1).size(); k++){
							 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
						 }
						 t1_cd += ")";
					 }
					 if(addMap.containsKey(t2)){
						 t = get_cdform(addMap.get(t2).get(0),"no");
						 t = t.substring(0,t.lastIndexOf(')'));
						 t = t + "( POSSBY " + t1_cd + " )";
						 for(int k = 0; k < addMap.get(t2).size(); k++){
							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
					p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";
		//	System.out.println("CD form : "+p1_cd);
		}
		///////////////////done actor/////////////
		if(src != ""){
			src_cd = " (PLACE (NAME "+src+" ) ";
			if(possessMap.containsKey(src)){
				if(possessMap.get(src).size() == 1 ){
					String t2 = possessMap.get(src).get(0);
					if(t2.equals(p1)){
						src_cd = src_cd + " (POSSBY " + p1_cd + ")";
					}
					else{
						String t = "";
						if(addMap.containsKey(t2)){
							t = get_cdform(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t+" (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
						t1_cd = get_cdform(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = get_cdform(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "(POSSBY " + t1_cd + ")";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
					src_cd = src_cd + "(ISA "+get_cdform(addMap.get(src).get(i),"a")+" ) ";
				}
			}
			src_cd += " )";
		}
		//////////////done source/////////////////
		if(dest != ""){
			dest_cd = " (PLACE (NAME "+dest+" ) ";
			if(possessMap.containsKey(dest)){
				if(possessMap.get(dest).size() == 1 ){
					String t2 = possessMap.get(dest).get(0);
					if(t2.equals(p1)){
						dest_cd = dest_cd + " (POSSBY " + p1_cd + ")";
					}
					else{
						String t = "";
						if(addMap.containsKey(t2)){
							t = get_cdform(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t+" (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
						t1_cd = get_cdform(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = get_cdform(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "(POSSBY " + t1_cd + ")";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
					dest_cd = dest_cd + "(ISA "+get_cdform(addMap.get(dest).get(i),"a")+" ) ";
				}
			}
			dest_cd += " )";
		}
		/////////////done dest////////////////////
		if(obj.equals("")){
			obj_cd = "(OBJECT " + p1_cd + " )";
		}
		else{
			obj_cd = " (OBJECT (OBJECT (NAME "+obj+" ) ";
			if(possessMap.containsKey(obj)){
				if(possessMap.get(obj).size() == 1 ){
					String t2 = possessMap.get(obj).get(0);
					if(t2.equals(p1)){
						obj_cd = obj_cd + " (POSSBY " + p1_cd + ")";
					}
					else{
						String t = "";
						if(addMap.containsKey(t2)){
							t = get_cdform(t2,"no");
							t = t.substring(0,t.lastIndexOf(')'));
							t = t+" (POSSBY NULL)";
							for(int k = 0; k < addMap.get(t2).size(); k++){
								t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
						t1_cd = get_cdform(t1,"no");
						t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						t1_cd = t1_cd + " (POSSBY NULL)";
						for(int k = 0; k < addMap.get(t1).size(); k++){
							t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
						}
						t1_cd += ")";
					}
					if(addMap.containsKey(t2)){
						t = get_cdform(addMap.get(t2).get(0),"no");
						t = t.substring(0,t.lastIndexOf(')'));
						t = t + "(POSSBY " + t1_cd + ")";
						for(int k = 0; k < addMap.get(t2).size(); k++){
							t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
					obj_cd = obj_cd + "(ISA "+get_cdform(addMap.get(obj).get(i),"a")+" ) ";
				}
			}
			obj_cd += " ))";
		}
		ret = ret + "(PTRANS ";
		if(src == ""){
			ret += " (FROM NULL) ";
		}
		else{
			ret = ret + "(FROM " + src_cd + ")";
		}
		if(dest == ""){
			ret = ret + "(TO NULL)";
		}
		else{
			ret = ret + "(TO " + dest_cd + ")";
		}
		ret = ret + obj_cd ;
		ret = ret + " (ACTOR " + p1_cd + ")";
		String A = "";
		if(addMap.containsKey(verb_sent)){
			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
				A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
			}
		}
		ret = ret + "(CONC_TENSE PAST)"+Using;
		ret = ret + A +")";
		global_ret = ret;
	//	System.out.println("ptrans cd form : " + ret );
		return "";
}
	
//	
//	String process_propel (LinkedHashMap<String, ArrayList<String>> possessMap, 
//			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
//		String ret = "";
//		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
//		String temp = "",actor = "", actor_cd = "";
//		propel propelVerb = new propel();
//
//		for(int i = 0; i < verbs.propel_verbs.length; i++){
//			if(verbs.propel_verbs[i].name.equals(verb_sent)){
//				propelVerb = verbs.propel_verbs[i];
//				break;
//			}
//		}
//		Iterator it = possessMap.keySet().iterator();
//		if(it.hasNext()) {
//			p1 = (String) it.next();
//			p1_cd = "(PERSON (NAME "+p1+ " ) ";
//			if(possessMap.containsKey(p1)){
//				if(possessMap.get(p1).size() == 1 ){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(t2,"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					 if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
//						 p1_cd = p1_cd + "(POSSBY "+t
//								 +" ) ";
//					 }
//					 else{
//						 p1_cd = p1_cd + " "+ t + " ";
//					 }
//				}
//				else if(possessMap.get(p1).size() == 2){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					String t1 = possessMap.get(p1).get(1);
//					String t1_cd = "";
//					 if(addMap.containsKey(t1)){
//						 t1_cd = get_cdform(t1,"no");
//						 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//						 t1_cd = t1_cd + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t1).size(); k++){
//							 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//						 }
//						 t1_cd += ")";
//					 }
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(addMap.get(t2).get(0),"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + "( POSSBY " + t1_cd + " )";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
//						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
//					}
//					else{
//						p1_cd = p1_cd + "(POSSBY "+t
//								+" "+t1_cd + " ) ";
//					}
//				}
//				else if(possessMap.get(p1).size() == 0){
//					p1_cd = p1_cd + "(POSSBY NULL)";
//				}
//			}
//			if(addMap.containsKey(p1)){
//				for(int i = 0 ; i < addMap.get(p1).size(); i++){
//					p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
//				}
//			}
//			p1_cd += " )";
//		}
//		while(it.hasNext()){
//			String th = (String) it.next();
//			if(mapObjects.get(th).equals("objects")){
//				obj = th;
//				obj_cd = "(OBJECT (OBJECT (NAME "+obj+" ) ";
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//				if(possessMap.containsKey(obj)){
//					if(possessMap.get(obj).size() == 1 ){
//						String t2 = possessMap.get(obj).get(0);
//						if(t2.equals(p1)){
//							obj_cd = obj_cd + "(POSSBY "+p1_cd+")";
//						}
//						else if(t2.equals(p2)){
//							obj_cd = obj_cd + "(POSSBY "+p2_cd+")";
//						}
//						else{
//							String t = "";
//							if(addMap.containsKey(t2)){
//								t = get_cdform(t2,"no");
//								t = t.substring(0,t.lastIndexOf(')'));
//								t += " (POSSBY NULL)";
//								for(int k = 0; k < addMap.get(t2).size(); k++){
//									t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//								}
//								t += ")";
//							}
//							if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
//								obj_cd = obj_cd + "(POSSBY "+t
//										+" ) ";
//							}
//							else{
//								obj_cd = obj_cd + " "+ t + " ";
//							}
//						}
//					}
//					else if(possessMap.get(obj).size() == 2){
//						String t2 = possessMap.get(obj).get(0);
//						String t = "";
//						String t1 = possessMap.get(obj).get(1);
//						String t1_cd = "";
//						if(addMap.containsKey(t1)){
//							t1_cd = get_cdform(t1,"no");
//							t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//							t1_cd += " (POSSBY NULL)";
//							for(int k = 0; k < addMap.get(t1).size(); k++){
//								t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//							}
//							t1_cd += ")";
//						}
//						if(addMap.containsKey(t2)){
//							t = get_cdform(addMap.get(t2).get(0),"no");
//							t = t.substring(0,t.lastIndexOf(')'));
//							t += " (POSSBY " + t1_cd + " )";
//							for(int k = 0; k < addMap.get(t2).size(); k++){
//								t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							}
//							t += ")";
//						}
//						if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
//							obj_cd = obj_cd + "(POSSBY "+t + " ) ";
//						}
//						else{
//							obj_cd = obj_cd + "(POSSBY "+t
//									+" "+t1_cd + " ) ";
//						}
//					}
//					else if(possessMap.get(obj).size() == 0){
//						obj_cd = obj_cd + "(POSSBY NULL)";
//					}
//				}
//				if(addMap.containsKey(obj)){
//					for(int i = 0 ; i < addMap.get(obj).size(); i++){
//						obj_cd = obj_cd + "(ISA "+get_cdform(addMap.get(obj).get(i),"a")+" ) ";
//					}
//				}
//				obj_cd += " ))";
//			}
//			if(mapObjects.get(th).equals("politicians") || mapObjects.get(th).equals("places")){
//				p2 = th;
//				p2_cd = "(PERSON (NAME "+p2+ " ) ";				
//				if(possessMap.containsKey(p2)){
//					if(possessMap.get(p2).size() == 1 ){
//						String t2 = possessMap.get(p2).get(0);
//						String t = "";
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(t2,"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t += " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						 if(!mapObjects.get(possessMap.get(p2).get(0)).equals("pronouns")){
//							 p2_cd = p2_cd + "(POSSBY "+t
//									 +" ) ";
//						 }
//						 else{
//							 p2_cd = p2_cd + " "+ t + " ";
//						 }
//					}
//					else if(possessMap.get(p2).size() == 2){
//						String t2 = possessMap.get(p2).get(0);
//						String t = "";
//						String t1 = possessMap.get(p2).get(1);
//						String t1_cd = "";
//						 if(addMap.containsKey(t1)){
//							 t1_cd = get_cdform(t1,"no");
//							 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//							 t1_cd += " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t1).size(); k++){
//								 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//							 }
//							 t1_cd += ")";
//						 }
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(addMap.get(t2).get(0),"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t += " (POSSBY " + t1_cd + ")";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						if(!mapObjects.get(possessMap.get(p2).get(1)).equals("pronouns")){
//							p2_cd = p2_cd + "(POSSBY "+t + " ) ";
//						}
//						else{
//							p2_cd = p2_cd + "(POSSBY "+t
//									+" "+t1_cd + " ) ";
//						}
//					}
//					else if(possessMap.get(p2).size() == 0){
//						p2_cd = p2_cd + "(POSSBY NULL)";
//					}
//				}
//				if(addMap.containsKey(p2)){
//					for(int i = 0 ; i < addMap.get(p2).size(); i++){
//						p2_cd = p2_cd + "(ISA "+get_cdform(addMap.get(p2).get(i),"a")+" ) ";	
//					}
//				}
//				p2_cd += " )";
//			}
//		}
//		ret = "(PROPEL (FROM " + p1_cd + ") (TO " + p2_cd + ") " + obj_cd + " (PHYSCONT (" + p2_cd + " " + obj_cd + 
//								"))";
//		String A = "";
//		if(addMap.containsKey(verb_sent)){
//			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
//				A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
//			}
//		}
//		ret = ret + " (CONC_TENSE PAST) " +Using+ A + ")";
//		String thu = "";
//		thu = get_state_propel(propelVerb, p2_cd);
//	//	if(verb_sent.equals("fight")){
//		// what to do here ???	
//	//	}
//		if(!thu.equals("")){
//			ret ="( LEADSTO " + ret + "\n" + thu + " (CONC_TENSE PAST) "+Using + A + " ))";
//		}
//		global_ret = ret;
//	//	System.out.println("printing propel : " + ret);
//		return "";
//	}
//	
//	String get_state_propel(propel verb_struct, String src){
//	//	System.out.println("printing this " + verb_struct.source.mental_state + "  " + 
//	//				verb_struct.dest.mental_state);
//		if(verb_struct.dest.mental_state != 999)
//			return "(CHANGE (OBJECT " + src + ") (STATE MENTAL_STATE (INITIAL " + 
//		(verb_struct.dest.mental_state+10) + ") (FINAL 21) )";
//		if(verb_struct.dest.physical_state != 999)
//			return "(CHANGE (OBJECT " + src + ") (STATE PHYSICAL_STATE (INITIAL " + 
//			(verb_struct.dest.physical_state+10) + ") (FINAL 21) )";
//		if(verb_struct.dest.health != 999)
//			return "(CHANGE (OBJECT " + src + ") (STATE HEALTH (INITIAL " + 
//			(verb_struct.dest.health+10) + ") (FINAL 21) )";
//		if(verb_struct.dest.fear != 999)
//			return "(CHANGE (OBJECT " + src + ") (STATE FEAR (INITIAL " + 
//			(verb_struct.dest.fear+10) + ") (FINAL 21) )";
//		if(verb_struct.dest.anger != 999)
//			return "(CHANGE (OBJECT " + src + ") (STATE ANGER (INITIAL " + 
//			(verb_struct.dest.anger+10) + ") (FINAL 21) )";
//		return "";
//	}
//	
//	
//	String process_mbuild(LinkedHashMap<String, ArrayList<String>> possessMap, 
//			LinkedHashMap<String, ArrayList<String>> addMap, String sentence){
//		return "";
//		
//	}
//	
//	
//	
//	String process_expel(LinkedHashMap<String, ArrayList<String>> possessMap, 
//			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
//		String ret = "";
//		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
//		String temp = "",actor = "", actor_cd = "";
//		expel expelVerb = new expel();
//
//		for(int i = 0; i < verbs.expel_verbs.length; i++){
//			if(verbs.expel_verbs[i].name.equals(verb_sent)){
//				expelVerb = verbs.expel_verbs[i];
//				break;
//			}
//		}
//		
//		Iterator it = possessMap.keySet().iterator();
//		if(it.hasNext()) {
//			p1 = (String) it.next();
//			p1_cd = "(PERSON (NAME "+p1+ " ) ";
//			if(possessMap.containsKey(p1)){
//				if(possessMap.get(p1).size() == 1 ){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(t2,"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					 if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
//						 p1_cd = p1_cd + "(POSSBY "+t
//								 +" ) ";
//					 }
//					 else{
//						 p1_cd = p1_cd + " "+ t + " ";
//					 }
//				}
//				else if(possessMap.get(p1).size() == 2){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					String t1 = possessMap.get(p1).get(1);
//					String t1_cd = "";
//					 if(addMap.containsKey(t1)){
//						 t1_cd = get_cdform(t1,"no");
//						 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//						 t1_cd = t1_cd + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t1).size(); k++){
//							 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//						 }
//						 t1_cd += ")";
//					 }
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(addMap.get(t2).get(0),"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + "( POSSBY " + t1_cd + " )";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
//						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
//					}
//					else{
//						p1_cd = p1_cd + "(POSSBY "+t
//								+" "+t1_cd + " ) ";
//					}
//				}
//				else if(possessMap.get(p1).size() == 0){
//					p1_cd = p1_cd + "(POSSBY NULL)";
//				}
//			}
//			if(addMap.containsKey(p1)){
//				for(int i = 0 ; i < addMap.get(p1).size(); i++){
//					p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
//				}
//			}
//			p1_cd += " )";
//			
//			
//		}
//		obj = "NULL";
//		if(verb_sent.equals("cry"))
//			obj = "TEARS";
//		else if(verb_sent.equals("cough"))
//			obj = "COUGH";
//		else if(verb_sent.equals("bleed"))
//			obj = "BLOOD";
//		else if(verb_sent.equals("sweat")){
//			obj = "SWEAT";
//		}
//		
//		String A = "";
//		if(addMap.containsKey(verb_sent)){
//			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
//				A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
//			}
//		}		
//		ret = ret +"(EXPEL (FROM "+p1_cd+") (OBJECT "+obj+") (CONC_TENSE PAST) "+Using+A+")";
//		String thu = "";
//		if(verb_sent.equals("bleed")){
//			thu = "(CHANGE (OBJECT " + p1_cd + ") (STATE PHYSICAL_STATE (INITIAL " + 
//					(expelVerb.actor.physical_state+10) + ") (FINAL 21) )" +
//							" (CONC_TENSE PAST) "+Using + A + ")";
//		}
//		if(!thu.equals(""))
//			ret = "( LEADSTO " + ret + "\n" + thu + ")";
//		global_ret = ret;
//	//	System.out.println("printing expel : " + ret);
//		return "";
//	}
//	
//	String process_grasp(LinkedHashMap<String, ArrayList<String>> possessMap, 
//			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
//		String ret = "";
//		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
//		String temp = "",actor = "", actor_cd = "";
//		grasp  graspVerb = new grasp();
//
//		for(int i = 0; i < verbs.grasp_verbs.length; i++){
//			if(verbs.grasp_verbs[i].name.equals(verb_sent)){
//				graspVerb = verbs.grasp_verbs[i];
//				break;
//			}
//		}
//		
//		Iterator it = possessMap.keySet().iterator();
//		if(it.hasNext()) {
//			p1 = (String) it.next();
//			p1_cd = "(PERSON (NAME "+p1+ " ) ";
//			if(possessMap.containsKey(p1)){
//				if(possessMap.get(p1).size() == 1 ){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(t2,"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					 if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
//						 p1_cd = p1_cd + "(POSSBY "+t
//								 +" ) ";
//					 }
//					 else{
//						 p1_cd = p1_cd + " "+ t + " ";
//					 }
//				}
//				else if(possessMap.get(p1).size() == 2){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					String t1 = possessMap.get(p1).get(1);
//					String t1_cd = "";
//					 if(addMap.containsKey(t1)){
//						 t1_cd = get_cdform(t1,"no");
//						 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//						 t1_cd = t1_cd + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t1).size(); k++){
//							 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//						 }
//						 t1_cd += ")";
//					 }
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(addMap.get(t2).get(0),"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + "( POSSBY " + t1_cd + " )";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
//						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
//					}
//					else{
//						p1_cd = p1_cd + "(POSSBY "+t
//								+" "+t1_cd + " ) ";
//					}
//				}
//				else if(possessMap.get(p1).size() == 0){
//					p1_cd = p1_cd + "(POSSBY NULL)";
//				}
//			}
//			if(addMap.containsKey(p1)){
//				for(int i = 0 ; i < addMap.get(p1).size(); i++){
//					p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
//				}
//			}
//			p1_cd += " )";
//			
//			
//		}
//		
//		while(it.hasNext()){
//			temp = (String)it.next();
//			String map = mapObjects.get(temp);
//			if(map.equals("politicians") || map.equals("places")){
//				p2 = temp;
//				p2_cd = "(PERSON (NAME "+p2+ " ) ";				
//				if(possessMap.containsKey(p2)){
//					if(possessMap.get(p2).size() == 1 ){
//						String t2 = possessMap.get(p2).get(0);
//						String t = "";
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(t2,"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t += " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						 if(!mapObjects.get(possessMap.get(p2).get(0)).equals("pronouns")){
//							 p2_cd = p2_cd + "(POSSBY "+t
//									 +" ) ";
//						 }
//						 else{
//							 p2_cd = p2_cd + " "+ t + " ";
//						 }
//					}
//					else if(possessMap.get(p2).size() == 2){
//						String t2 = possessMap.get(p2).get(0);
//						String t = "";
//						String t1 = possessMap.get(p2).get(1);
//						String t1_cd = "";
//						 if(addMap.containsKey(t1)){
//							 t1_cd = get_cdform(t1,"no");
//							 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//							 t1_cd += " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t1).size(); k++){
//								 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//							 }
//							 t1_cd += ")";
//						 }
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(addMap.get(t2).get(0),"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t += " (POSSBY " + t1_cd + ")";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						if(!mapObjects.get(possessMap.get(p2).get(1)).equals("pronouns")){
//							p2_cd = p2_cd + "(POSSBY "+t + " ) ";
//						}
//						else{
//							p2_cd = p2_cd + "(POSSBY "+t
//									+" "+t1_cd + " ) ";
//						}
//					}
//					else if(possessMap.get(p2).size() == 0){
//						p2_cd = p2_cd + "(POSSBY NULL)";
//					}
//				}
//				if(addMap.containsKey(p2)){
//					for(int i = 0 ; i < addMap.get(p2).size(); i++){
//						p2_cd = p2_cd + "(ISA "+get_cdform(addMap.get(p2).get(i),"a")+" ) ";	
//					}
//				}
//				p2_cd += " )";
//			//	System.out.println("CD2 form : "+p2_cd);
//			}
//			else if(map.equals("objects")){
//				obj = temp;
//				obj_cd = "(OBJECT (OBJECT (NAME "+obj+" ) ";
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//				if(possessMap.containsKey(obj)){
//					
//					if(possessMap.get(obj).size() == 1 ){
//						String t2 = possessMap.get(obj).get(0);
//						if(t2.equals(p1)){
//							obj_cd = obj_cd + "(POSSBY "+p1_cd+")";
//						}
//						else if(t2.equals(p2)){
//							obj_cd = obj_cd + "(POSSBY "+p2_cd+")";
//						}
//						else{
//							String t = "";
//							if(addMap.containsKey(t2)){
//								 t = get_cdform(t2,"no");
//								 t = t.substring(0,t.lastIndexOf(')'));
//								 t += " (POSSBY NULL)";
//								 for(int k = 0; k < addMap.get(t2).size(); k++){
//									 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//								 }
//								 t += ")";
//							 }
//							 if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
//								 obj_cd = obj_cd + "(POSSBY "+t
//										 +" ) ";
//							 }
//							 else{
//								 obj_cd = obj_cd + " "+ t + " ";
//							 }
//						}
//					}
//					else if(possessMap.get(obj).size() == 2){
//						String t2 = possessMap.get(obj).get(0);
//						String t = "";
//						String t1 = possessMap.get(obj).get(1);
//						String t1_cd = "";
//						 if(addMap.containsKey(t1)){
//							 t1_cd = get_cdform(t1,"no");
//							 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//							 t1_cd += " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t1).size(); k++){
//								 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//							 }
//							 t1_cd += ")";
//						 }
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(addMap.get(t2).get(0),"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t += " (POSSBY " + t1_cd + " )";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
//							obj_cd = obj_cd + "(POSSBY "+t + " ) ";
//						}
//						else{
//							obj_cd = obj_cd + "(POSSBY "+t
//									+" "+t1_cd + " ) ";
//						}
//					}
//					else if(possessMap.get(obj).size() == 0){
//						obj_cd = obj_cd + "(POSSBY NULL)";
//					}
//				}
//				if(addMap.containsKey(obj)){
//					for(int i = 0 ; i < addMap.get(obj).size(); i++){
//						obj_cd = obj_cd + "(ISA "+get_cdform(addMap.get(obj).get(i),"a")+" ) ";
//					}
//				}
//				obj_cd += " ))";
//			}
//		}
//
//		String A = "";
//		if(addMap.containsKey(verb_sent)){
//			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
//				A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
//			}
//		}
//		if(!obj_cd.equals(""))
//			ret = ret + "(GRASP (ACTOR "+p1_cd+") "+obj_cd+" (CONC_TENSE PAST)"+Using+A+")";
//		else if(!p2.equals(""))
//			ret = ret + "(GRASP (ACTOR "+p1_cd+") (OBJECT "+p2_cd+") (CONC_TENSE PAST)"+Using+A+")";
//		else
//			ret = ret + "(GRASP (ACTOR "+p1_cd+") (OBJECT NULL) (CONC_TENSE PAST)"+Using+A+")";
//		
//	//	System.out.println("grasp example : " + ret );
//		global_ret = ret;
//		return ret;
//		
//	}
	
	String process_ingest(LinkedHashMap<String, ArrayList<String>> possessMap, 
			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
		
		String ret = "";
		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
		String temp = "",actor = "", actor_cd = "";
		Ingest  ingest_verb = new Ingest();

		for(int i = 0; i < verbs.ingest_verbs.length; i++){
			if(verbs.ingest_verbs[i].name.equals(verb_sent)){
				ingest_verb = verbs.ingest_verbs[i];
				break;
			}
		}
		
		Iterator<String> it = possessMap.keySet().iterator();
		if(it.hasNext()) {
			p1 = (String) it.next();
			p1_cd = "(PERSON (NAME "+p1+ " ) ";
			System.out.println("person:"+p1_cd);
			if(possessMap.containsKey(p1)){
				if(possessMap.get(p1).size() == 1 ){
					String t2 = possessMap.get(p1).get(0);
					String t = "";
					 if(addMap.containsKey(t2)){
						 t = get_cdform(t2,"no");
						 t = t.substring(0,t.lastIndexOf(')'));
						 t = t + " (POSSBY NULL)";
						 for(int k = 0; k < addMap.get(t2).size(); k++){
							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
						 t1_cd = get_cdform(t1,"no");
						 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
						 t1_cd = t1_cd + " (POSSBY NULL)";
						 for(int k = 0; k < addMap.get(t1).size(); k++){
							 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
						 }
						 t1_cd += ")";
					 }
					 if(addMap.containsKey(t2)){
						 t = get_cdform(addMap.get(t2).get(0),"no");
						 t = t.substring(0,t.lastIndexOf(')'));
						 t = t + "( POSSBY " + t1_cd + " )";
						 for(int k = 0; k < addMap.get(t2).size(); k++){
							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
					p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
				}
			}
			p1_cd += " )";
			
			
		}
		
		while(it.hasNext()){
			temp = (String)it.next();
			String map = mapObjects.get(temp);
			if(map.equals("objects")){
				obj = temp;
				obj_cd = "(OBJECT (OBJECT (NAME "+obj+" ) ";
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
							String t = "";
							if(addMap.containsKey(t2)){
								 t = get_cdform(t2,"no");
								 t = t.substring(0,t.lastIndexOf(')'));
								 t += " (POSSBY NULL)";
								 for(int k = 0; k < addMap.get(t2).size(); k++){
									 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
							 t1_cd = get_cdform(t1,"no");
							 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
							 t1_cd += " (POSSBY NULL)";
							 for(int k = 0; k < addMap.get(t1).size(); k++){
								 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
							 }
							 t1_cd += ")";
						 }
						 if(addMap.containsKey(t2)){
							 t = get_cdform(addMap.get(t2).get(0),"no");
							 t = t.substring(0,t.lastIndexOf(')'));
							 t += " (POSSBY " + t1_cd + " )";
							 for(int k = 0; k < addMap.get(t2).size(); k++){
								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
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
						obj_cd = obj_cd + "(ISA "+get_cdform(addMap.get(obj).get(i),"a")+" ) ";
					}
				}
				obj_cd += " ))";
			}
		}
		
		String A = "";
		if(addMap.containsKey(verb_sent)){
			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
				A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
			}
		}
		if(!obj_cd.equals(""))
			ret  = ret + "(INGEST (ACTOR "+ p1_cd + ")"+obj_cd +" (CONC_TENSE PAST)"+Using+A+")";
		else
			ret  = ret + "(INGEST (ACTOR "+ p1_cd + ") (OBJECT NULL) (CONC_TENSE PAST)"+Using+A+")";
	//	System.out.println("ingest cd form : " + ret);
		global_ret = ret;
		return ret;
		
	}
	
//	String process_attend(LinkedHashMap<String, ArrayList<String>> possessMap, 
//			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
//		
//		String ret = "";
//		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
//		String temp = "",actor = "", actor_cd = "";
//		attend  attendVerb = new attend();
//
//		for(int i = 0; i < verbs.attend_verbs.length; i++){
//			if(verbs.attend_verbs[i].name.equals(verb_sent)){
//				attendVerb = verbs.attend_verbs[i];
//				break;
//			}
//		}
//		
//		Iterator it = possessMap.keySet().iterator();
//		if(it.hasNext()) {
//			p1 = (String) it.next();
//			p1_cd = "(PERSON (NAME "+p1+ " ) ";
//			if(possessMap.containsKey(p1)){
//				if(possessMap.get(p1).size() == 1 ){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(t2,"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					 if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
//						 p1_cd = p1_cd + "(POSSBY "+t
//								 +" ) ";
//					 }
//					 else{
//						 p1_cd = p1_cd + " "+ t + " ";
//					 }
//				}
//				else if(possessMap.get(p1).size() == 2){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					String t1 = possessMap.get(p1).get(1);
//					String t1_cd = "";
//					 if(addMap.containsKey(t1)){
//						 t1_cd = get_cdform(t1,"no");
//						 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//						 t1_cd = t1_cd + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t1).size(); k++){
//							 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//						 }
//						 t1_cd += ")";
//					 }
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(addMap.get(t2).get(0),"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + "( POSSBY " + t1_cd + " )";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
//						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
//					}
//					else{
//						p1_cd = p1_cd + "(POSSBY "+t
//								+" "+t1_cd + " ) ";
//					}
//				}
//				else if(possessMap.get(p1).size() == 0){
//					p1_cd = p1_cd + "(POSSBY NULL)";
//				}
//			}
//			if(addMap.containsKey(p1)){
//				for(int i = 0 ; i < addMap.get(p1).size(); i++){
//					p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
//				}
//			}
//			p1_cd += " )";
//			
//			
//		}
//		
//		while(it.hasNext()){
//			temp = (String)it.next();
//			String map = mapObjects.get(temp);
//			if(map.equals("politicians") || map.equals("places")){
//				p2 = temp;
//				p2_cd = "(PERSON (NAME "+p2+ " ) ";				
//				if(possessMap.containsKey(p2)){
//					if(possessMap.get(p2).size() == 1 ){
//						String t2 = possessMap.get(p2).get(0);
//						String t = "";
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(t2,"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t += " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						 if(!mapObjects.get(possessMap.get(p2).get(0)).equals("pronouns")){
//							 p2_cd = p2_cd + "(POSSBY "+t
//									 +" ) ";
//						 }
//						 else{
//							 p2_cd = p2_cd + " "+ t + " ";
//						 }
//					}
//					else if(possessMap.get(p2).size() == 2){
//						String t2 = possessMap.get(p2).get(0);
//						String t = "";
//						String t1 = possessMap.get(p2).get(1);
//						String t1_cd = "";
//						 if(addMap.containsKey(t1)){
//							 t1_cd = get_cdform(t1,"no");
//							 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//							 t1_cd += " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t1).size(); k++){
//								 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//							 }
//							 t1_cd += ")";
//						 }
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(addMap.get(t2).get(0),"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t += " (POSSBY " + t1_cd + ")";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						if(!mapObjects.get(possessMap.get(p2).get(1)).equals("pronouns")){
//							p2_cd = p2_cd + "(POSSBY "+t + " ) ";
//						}
//						else{
//							p2_cd = p2_cd + "(POSSBY "+t
//									+" "+t1_cd + " ) ";
//						}
//					}
//					else if(possessMap.get(p2).size() == 0){
//						p2_cd = p2_cd + "(POSSBY NULL)";
//					}
//				}
//				if(addMap.containsKey(p2)){
//					for(int i = 0 ; i < addMap.get(p2).size(); i++){
//						p2_cd = p2_cd + "(ISA "+get_cdform(addMap.get(p2).get(i),"a")+" ) ";	
//					}
//				}
//				p2_cd += " )";
//			//	System.out.println("CD2 form : "+p2_cd);
//			}
//			else if(map.equals("objects")){
//				obj = temp;
//				obj_cd = "(OBJECT (OBJECT (NAME "+obj+" ) ";
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//				if(possessMap.containsKey(obj)){
//					
//					if(possessMap.get(obj).size() == 1 ){
//						String t2 = possessMap.get(obj).get(0);
//						if(t2.equals(p1)){
//							obj_cd = obj_cd + "(POSSBY "+p1_cd+")";
//						}
//						else if(t2.equals(p2)){
//							obj_cd = obj_cd + "(POSSBY "+p2_cd+")";
//						}
//						else{
//							String t = "";
//							if(addMap.containsKey(t2)){
//								 t = get_cdform(t2,"no");
//								 t = t.substring(0,t.lastIndexOf(')'));
//								 t += " (POSSBY NULL)";
//								 for(int k = 0; k < addMap.get(t2).size(); k++){
//									 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//								 }
//								 t += ")";
//							 }
//							 if(!mapObjects.get(possessMap.get(obj).get(0)).equals("pronouns")){
//								 obj_cd = obj_cd + "(POSSBY "+t
//										 +" ) ";
//							 }
//							 else{
//								 obj_cd = obj_cd + " "+ t + " ";
//							 }
//						}
//					}
//					else if(possessMap.get(obj).size() == 2){
//						String t2 = possessMap.get(obj).get(0);
//						String t = "";
//						String t1 = possessMap.get(obj).get(1);
//						String t1_cd = "";
//						 if(addMap.containsKey(t1)){
//							 t1_cd = get_cdform(t1,"no");
//							 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//							 t1_cd += " (POSSBY NULL)";
//							 for(int k = 0; k < addMap.get(t1).size(); k++){
//								 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//							 }
//							 t1_cd += ")";
//						 }
//						 if(addMap.containsKey(t2)){
//							 t = get_cdform(addMap.get(t2).get(0),"no");
//							 t = t.substring(0,t.lastIndexOf(')'));
//							 t += " (POSSBY " + t1_cd + " )";
//							 for(int k = 0; k < addMap.get(t2).size(); k++){
//								 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//							 }
//							 t += ")";
//						 }
//						if(!mapObjects.get(possessMap.get(obj).get(1)).equals("pronouns")){
//							obj_cd = obj_cd + "(POSSBY "+t + " ) ";
//						}
//						else{
//							obj_cd = obj_cd + "(POSSBY "+t
//									+" "+t1_cd + " ) ";
//						}
//					}
//					else if(possessMap.get(obj).size() == 0){
//						obj_cd = obj_cd + "(POSSBY NULL)";
//					}
//				}
//				if(addMap.containsKey(obj)){
//					for(int i = 0 ; i < addMap.get(obj).size(); i++){
//						obj_cd = obj_cd + "(ISA "+get_cdform(addMap.get(obj).get(i),"a")+" ) ";
//					}
//				}
//				obj_cd += " ))";
//			}
//		}
//
//		String A = "";
//		if(addMap.containsKey(verb_sent)){
//			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
//				A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
//			}
//		}
//		
//		String organ = "";
//		if(verb_sent.equals("hear") || verb_sent.equals("listen"))
//			organ = "EAR";
//		else 
//			organ = "EYE";
//		
//		
//		if(!obj_cd.equals(""))
//			ret = ret + "(ATTEND (ACTOR "+p1_cd+") (ORGAN "+organ+") " +obj_cd+" (CONC_TENSE PAST)"+Using+A+")";
//		else if(!p2.equals(""))
//			ret = ret + "(ATTEND (ACTOR "+p1_cd+") (ORGAN "+organ+") (OBJECT "+p2_cd+") (CONC_TENSE PAST)"+Using+A+")";
//		else
//			ret = ret + "(ATTEND (ACTOR "+p1_cd+") (ORGAN "+organ+") (OBJECT NULL) (CONC_TENSE PAST)"+Using+A+")";
//		
//	//	System.out.println("attend example : " + ret );
//		global_ret = ret;
//		return ret;
//
//		
//	}
	
//	String process_state(LinkedHashMap<String, ArrayList<String>> possessMap, 
//			LinkedHashMap<String, ArrayList<String>> addMap, String sentence, String verb_sent){
//		String ret = "";
//		String p1 = "", p2 = "", obj = "", p1_cd = "", p2_cd = "", obj_cd = "";
//		state state_verb = new state();
//		for(int i = 0; i < verbs.state_verbs.length; i++){
//			if(verbs.state_verbs[i].name.equals(verb_sent)){
//				state_verb = verbs.state_verbs[i];
//				break;
//			}
//		}
//		Iterator it = possessMap.keySet().iterator();
//		if(it.hasNext()) {
//			p1 = (String) it.next();
//			String map = mapObjects.get(p1);
//		//	System.out.println("First object : "+ p1);
//			if(!map.equals("pronouns"))
//				p1_cd = "(PERSON (NAME "+p1+ " ) ";
//			else 	//should take care of every pronouns
//				p1_cd = "(PERSON ";
//			if(possessMap.containsKey(p1)){
//				if(possessMap.get(p1).size() == 1 ){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(t2,"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					 if(!mapObjects.get(possessMap.get(p1).get(0)).equals("pronouns")){
//						 p1_cd = p1_cd + "(POSSBY "+t
//								 +" ) ";
//					 }
//					 else{
//						 p1_cd = p1_cd + " "+ t + " ";
//					 }
//				}
//				else if(possessMap.get(p1).size() == 2){
//					String t2 = possessMap.get(p1).get(0);
//					String t = "";
//					String t1 = possessMap.get(p1).get(1);
//					String t1_cd = "";
//					 if(addMap.containsKey(t1)){
//						 t1_cd = get_cdform(t1,"no");
//						 t1_cd = t1_cd.substring(0,t1_cd.lastIndexOf(')'));
//						 t1_cd = t1_cd + " (POSSBY NULL)";
//						 for(int k = 0; k < addMap.get(t1).size(); k++){
//							 t1_cd = t1_cd + " ( ISA " + get_cdform(addMap.get(t1).get(k),"a") + ")";
//						 }
//						 t1_cd += ")";
//					 }
//					 if(addMap.containsKey(t2)){
//						 t = get_cdform(addMap.get(t2).get(0),"no");
//						 t = t.substring(0,t.lastIndexOf(')'));
//						 t = t + "( POSSBY " + t1_cd + " )";
//						 for(int k = 0; k < addMap.get(t2).size(); k++){
//							 t = t + " ( ISA " + get_cdform(addMap.get(t2).get(k),"a") + ")";
//						 }
//						 t += ")";
//					 }
//					if(!mapObjects.get(possessMap.get(p1).get(1)).equals("pronouns")){
//						p1_cd = p1_cd + "(POSSBY "+t + " ) ";
//					}
//					else{
//						p1_cd = p1_cd + "(POSSBY "+t
//								+" "+t1_cd + " ) ";
//					}
//				}
//				else if(possessMap.get(p1).size() == 0){
//					p1_cd = p1_cd + "(POSSBY NULL)";
//				}
//			}
//			if(addMap.containsKey(p1)){
//				for(int i = 0 ; i < addMap.get(p1).size(); i++){
//					p1_cd = p1_cd + "(ISA "+get_cdform(addMap.get(p1).get(i),"a")+" ) ";	
//				}
//			}
//			p1_cd += " )";
//		}
//		if(state_verb.actor.mental_state != 999)
//		ret = "(CHANGE (OBJECT " + p1_cd + ") (STATE MENTAL_STATE (INITIAL " + 
//				(state_verb.actor.mental_state+10) + ") (FINAL 21) )";
//		if(state_verb.actor.physical_state != 999)
//			ret = "(CHANGE (OBJECT " + p1_cd + ") (STATE PHYSICAL_STATE (INITIAL " + 
//					(state_verb.actor.physical_state+10) + ") (FINAL 21) )";
//		if(state_verb.actor.anger != 999)
//			ret = "(CHANGE (OBJECT " + p1_cd + ") (STATE ANGER (INITIAL " + 
//					(state_verb.actor.anger+10) + ") (FINAL 21) )";
//		if(state_verb.actor.health != 999)
//			ret = "(CHANGE (OBJECT " + p1_cd + ") (STATE HEALTH (INITIAL " + 
//					(state_verb.actor.health+10) + ") (FINAL 21) )";
//		if(state_verb.actor.fear != 999)
//			ret = "(CHANGE (OBJECT " + p1_cd + ") (STATE FEAR (INITIAL " + 
//					(state_verb.actor.fear+10) + ") (FINAL 21) )";
//		ret = " (CONC_TENSE PAST) "+Using;
//		String A = "";
//		if(addMap.containsKey(verb_sent)){
//			for(int i = 0; i < addMap.get(verb_sent).size(); i++){
//				A = A + " (ISA (ADVERB " + addMap.get(verb_sent).get(i) + " ))"; 
//			}
//		}
//		ret = ret + A + ")";
//		global_ret = ret;
//		return ret;
//	}
}
	
	
	
	
	
	
	