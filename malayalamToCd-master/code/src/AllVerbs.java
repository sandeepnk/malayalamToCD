import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class AllVerbs {
	MTrans[] mtrans_verbs = new MTrans[100];
	speak[] speak_verbs = new speak[100];
	Ptrans[] ptrans_verbs = new Ptrans[100];
	ATrans[] atrans_verbs = new ATrans[100];
	Propel[] propel_verbs = new Propel[100];
	MBuild[] mbuild_verbs = new MBuild[100];
//	do_something1[] do_something_1_verbs = new do_something1[100];
//	do_something2[] do_something_2_verbs = new do_something2[100];
	Expel[] expel_verbs = new Expel[100];
	Grasp[] grasp_verbs = new Grasp[100];
	Ingest[] ingest_verbs = new Ingest[100];
	Attend[] attend_verbs = new Attend[100];
	state[] state_verbs = new state[100];
	int k,ingestcount,attendcount,expelcount,graspcount,statecount;

	public void load(){
	      loadMtrans();
	      loadSpeak();
	      statementhod();
	      loadAtrans();
//	    do_something();
	      loadPtrans();
	      loadPropel();
	      loadMbuild();
	      attendmethod();
	      ingestmethod();
	      expelmethod();
	      graspmethod();
	}
	
	private void loadMtrans()
	{
		try 
		{
			File inFile = new File("MTRANS");
		    FileInputStream fstream = new FileInputStream(inFile);
		    DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split(":");
					if(parts.length !=2) {
						System.err.println("Error in Parsing mtrans");
						return;
					}
					String e_part = parts[0];
					String m_part = parts[1];
					StringTokenizer stt = new StringTokenizer(e_part," ");
					mtrans_verbs[i] = new MTrans();
					int j=0;
					int to_be_changed=0;
					String field_to_be_changed = new String();
			        while (stt.hasMoreTokens()){
			            String token = stt.nextToken();
			            //System.out.println(token);
			           if(j==0)
			           {
			        	   mtrans_verbs[i].name = token;
			        	   mtrans_verbs[i].token = token;
			        	   mtrans_verbs[i].m_name = m_part.trim();
			           }
			           if(j==3)
			           {
			        	   to_be_changed = token.charAt(token.length()-1) - '0';
			        	   //System.out.println(to_be_changed);
			           }
			           if(j==4)
			           {
			        	   field_to_be_changed = token;
			        	  // System.out.println(field_to_be_changed);
			           }
			           if(j==5)
			           {
			        	   if(to_be_changed==1)
			        	   {
			        		  // System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals( "mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   mtrans_verbs[i].actor.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        			   mtrans_verbs[i].actor.physical_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("health"))
			        			   mtrans_verbs[i].actor.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   mtrans_verbs[i].actor.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   mtrans_verbs[i].actor.fear = Integer.parseInt(token);
			        	   }
			        	   if(to_be_changed==2)
			        	   {
			        		   //System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals("mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   mtrans_verbs[i].dest.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        			   mtrans_verbs[i].dest.physical_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("health"))
			        			   mtrans_verbs[i].dest.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   mtrans_verbs[i].dest.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   mtrans_verbs[i].dest.fear = Integer.parseInt(token);
			        	   }
			        	   
			           }
			           j++;
			        }
			        mtrans_verbs[i].part_of_speech = "verb";
			        mtrans_verbs[i].cd_form = "(MTRANS(FROM ?VAR1)(TO ?VAR2)(OBJECT ?VAR3)" +
			        		"(ACTOR ?VAR4)(USING ?VAR5)(ADVERB ?VAR6)*(CONC_TENSE ?VAR7))";
					i++;
				}
				int k;
				for(k=0;k<i;k++)
				{
					//System.out.println(mtrans_verbs[k].name + " Initial State " + mtrans_verbs[k].source.mental_state + "Final State " + mtrans_verbs[k].dest.mental_state);
					//System.out.println(mtrans_verbs[k].name + " "+ mtrans_verbs[k].cd_form);
				}
					br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			for(k=0;k<i;k++)
			{
				if(mtrans_verbs[k].name.equals("remember") || mtrans_verbs[k].name.equals("think") ||mtrans_verbs[k].name.equals("recall"))
				{
					mtrans_verbs[k].source.name = "LTM";
					mtrans_verbs[k].dest.name = "CP";
				}
				if(mtrans_verbs[k].name.equals("read")){
					mtrans_verbs[k].dest.name = "CP";
					mtrans_verbs[k].source.name = "EYE";
				}
				if(mtrans_verbs[k].name.equals("understand"))
				{
					mtrans_verbs[k].dest.name = "LTM";
					mtrans_verbs[k].source.name = "CP";
				}
				if(mtrans_verbs[k].name.equals("hate") || mtrans_verbs[k].name.equals("like") || mtrans_verbs[k].name.equals("dislike")){
					mtrans_verbs[k].source.name = "LTM";
					mtrans_verbs[k].dest.name = "CP";
				}
			}	
		} 
		catch (FileNotFoundException fe)
		{
		    fe.printStackTrace();
		}
			
		
	}
	private void loadSpeak()
	{
		try 
		{
			File inFile = new File("SPEAK");
		    FileInputStream fstream = new FileInputStream(inFile);
		    DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split(":");
					if(parts.length !=2) {
						System.err.println("Error in Parsing speak");
						return;
					}
					String e_part = parts[0];
					String m_part = parts[1];
					StringTokenizer stt = new StringTokenizer(e_part," ");
					speak_verbs[i] = new speak();
					int j=0;
				//System.err.println("in Parsing speak");
					int to_be_changed=0;
					String field_to_be_changed = new String();
			        while (stt.hasMoreTokens()){
			            String token = stt.nextToken();
			            //System.out.println(token);
			           if(j==0)
			           {
			        	   speak_verbs[i].name = token;
			        	   speak_verbs[i].token = token;
			        	   speak_verbs[i].m_name = m_part;
			           }
			           if (j==1 && (token.equals("(INTERROGATIVE)")))
			           {
			        	   speak_verbs[i].interrogative =1;
			           }
			           if(j==3)
			           {
			        	   to_be_changed = token.charAt(token.length()-1) - '0';
			        	   //System.out.println(to_be_changed);
			           }
			           if(j==4)
			           {
			        	   field_to_be_changed = token;
			        	  // System.out.println(field_to_be_changed);
			           }
			           if(j==5)
			           {
			        	   if(to_be_changed==1)
			        	   {
			        		  // System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals( "mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   speak_verbs[i].source.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        			   speak_verbs[i].source.physical_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("health"))
			        			   speak_verbs[i].source.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   speak_verbs[i].source.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   speak_verbs[i].source.fear = Integer.parseInt(token);
			        	   }
			        	   if(to_be_changed==2)
			        	   {
			        		   //System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals("mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   speak_verbs[i].dest.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        			   speak_verbs[i].dest.physical_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("health"))
			        			   speak_verbs[i].dest.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   speak_verbs[i].dest.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   speak_verbs[i].dest.fear = Integer.parseInt(token);
			        	   }
			        	   
			           }
			           j++;
			        }
			        speak_verbs[i].part_of_speech = "verb";
			        speak_verbs[i].cd_form = "(SPEAK(FROM ?VAR1)(TO ?VAR2)(OBJECT ?VAR3)(USING ?VAR4)" +
			        		"(ADVERB ?VAR4)*(CONC_TENSE ?VAR5))";
					i++;
				}
				int k;
				for(k=0;k<i;k++)
					//System.out.println(speak_verbs[k].name + "  " + speak_verbs[k].source.mental_state + " " + speak_verbs[k].dest.mental_state+" "+speak_verbs[k].interrogative);
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException fe)
		{
		    fe.printStackTrace();
		}
		
	}
	private void loadPtrans()
	{
		try 
		{
			File inFile = new File("PTRANS");
		    FileInputStream fstream = new FileInputStream(inFile);
		    DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split("-");
					if(parts.length !=2) {
						System.err.println("Error in Parsing ptrans");
						return;
					}
					String e_part = parts[0];
					String m_part = parts[1];
					StringTokenizer stt = new StringTokenizer(e_part," ");
					ptrans_verbs[i] = new Ptrans();
					int j=0;
					int to_be_changed=0;
					String field_to_be_changed = new String();
			        while (stt.hasMoreTokens()){
			            String token = stt.nextToken();
			            //System.out.println(token);
			           if(j==0)
			           {
			        	   ptrans_verbs[i].name = token;
			        	   ptrans_verbs[i].token = token;
			        	   ptrans_verbs[i].m_name = m_part.trim();
			           }
			           if(j==3)
			           {
			        	   to_be_changed = token.charAt(token.length()-1) - '0';
			        	   //System.out.println(to_be_changed);
			           }
			           if(j==4)
			           {
			        	   field_to_be_changed = token;
			        	  // System.out.println(field_to_be_changed);
			           }
			           if(j==5)
			           {
			        	   if(to_be_changed==1)
			        	   {
			        		  // System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals( "mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   ptrans_verbs[i].source.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        			   ptrans_verbs[i].source.physical_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("health"))
			        			   ptrans_verbs[i].source.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   ptrans_verbs[i].source.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   ptrans_verbs[i].source.fear = Integer.parseInt(token);
			        	   }
			        	   if(to_be_changed==2)
			        	   {
			        		   //System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals("mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   ptrans_verbs[i].dest.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        			   ptrans_verbs[i].dest.physical_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("health"))
			        			   ptrans_verbs[i].dest.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   ptrans_verbs[i].dest.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   ptrans_verbs[i].dest.fear = Integer.parseInt(token);
			        	   }
			        	   
			           }
			           j++;
			        }
			        ptrans_verbs[i].part_of_speech = "verb";
			        ptrans_verbs[i].cd_form = "(PTRANS(FROM ?VAR1)(TO ?VAR2)(OBJECT ?VAR3)" +
			        		"(ACTOR ?VAR4)(USING ?VAR5)(ADVERB ?VAR6)*(CONC_TENSE ?VAR7))";
					i++;
				}
				int k;
				for(k=0;k<i;k++)
				{
					//System.out.println(ptrans_verbs[k].name + "  " + ptrans_verbs[k].source.mental_state + " " + ptrans_verbs[k].dest.mental_state);
					//System.out.println(ptrans_verbs[k].name + ptrans_verbs[k].cd_form);
				}
					br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException fe)
		{
		    fe.printStackTrace();
		}
		
	}
	private void loadAtrans()
	{
		try 
		{
			File inFile = new File("ATRANS");
		    FileInputStream fstream = new FileInputStream(inFile);
		    DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split("-");
					if(parts.length !=2) {
						System.err.println("Error in Parsing atrans");
						return;
					}
					String e_part = parts[0];
					String m_part = parts[1];
					StringTokenizer stt = new StringTokenizer(e_part," ");
					atrans_verbs[i] = new ATrans();
					int j=0;
					int to_be_changed=0;
					String field_to_be_changed = new String();
			        while (stt.hasMoreTokens()){
			            String token = stt.nextToken();
			            //System.out.println(token);
			           if(j==0)
			           {
			        	   atrans_verbs[i].name = token;
			        	   atrans_verbs[i].token = token;
			        	   atrans_verbs[i].m_name = m_part.trim();
			        	   
			           }
			           if(j==3)
			           {
			        	   to_be_changed = token.charAt(token.length()-1) - '0';
			        	   //System.out.println(to_be_changed);
			           }
			           if(j==4)
			           {
			        	   field_to_be_changed = token;
			        	  // System.out.println(field_to_be_changed);
			           }
			           if(j==5)
			           {
			        	   if(to_be_changed==1)
			        	   {
			        		  // System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals( "mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   atrans_verbs[i].source.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        			   atrans_verbs[i].source.physical_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("health"))
			        			   atrans_verbs[i].source.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   atrans_verbs[i].source.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   atrans_verbs[i].source.fear = Integer.parseInt(token);
			        	   }
			        	   if(to_be_changed==2)
			        	   {
			        		   //System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals("mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   atrans_verbs[i].dest.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        			   atrans_verbs[i].dest.physical_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("health"))
			        			   atrans_verbs[i].dest.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   atrans_verbs[i].dest.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   atrans_verbs[i].dest.fear = Integer.parseInt(token);
			        	   }
			        	   
			           }
			           if(j==6)
			        	   atrans_verbs[i].conceptual_tense = token;
			           j++;
			        }
			        atrans_verbs[i].part_of_speech = "verb";
			        atrans_verbs[i].cd_form = "(ATRANS(FROM ?VAR1)(TO ?VAR2)(OBJECT ?VAR3)" +
			        		"(ACTOR ?VAR4)(USING ?VAR5)(ADVERB ?VAR6)*(CONC_TENSE ?VAR7))";
					i++;
				}
				int k;
				for(k=0;k<i;k++)
				{
					//System.out.println(atrans_verbs[k].name + " Initial State  " + 
					//		atrans_verbs[k].source.mental_state + "Final State " + 
					//		atrans_verbs[k].dest.mental_state+" "+atrans_verbs[k].conceptual_tense);
					//System.out.println(atrans_verbs[k].name + atrans_verbs[k].cd_form);
				}
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException fe)
		{
		    fe.printStackTrace();
		}
		
	}
	private void loadPropel()
	{
		try 
		{
			File inFile = new File("PROPEL");
		    FileInputStream fstream = new FileInputStream(inFile);
		    DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split(":");
					if(parts.length !=2) {
						System.err.println("Error in Parsing propel");
						return;
					}
					String e_part = parts[0];
					String m_part=parts[1];
					StringTokenizer stt = new StringTokenizer(e_part," ");
					propel_verbs[i] = new Propel();
					int j=0;
					int to_be_changed=0;
					String field_to_be_changed = new String();
			        while (stt.hasMoreTokens())
			        {
			            String token = stt.nextToken();
			            //System.out.println(token);
			           if(j==0)
			           {
			        	   propel_verbs[i].name = token;
			        	   propel_verbs[i].token = token;
			        	   propel_verbs[i].m_name = m_part.trim();
			           }
			           if(j==3)
			           {
			        	   to_be_changed = token.charAt(token.length()-1) - '0';
			        	   //System.out.println(to_be_changed);
			           }
			           if(j==4)
			           {
			        	   field_to_be_changed = token;
			        	  // System.out.println(field_to_be_changed);
			           }
			           if(j==5)
			           {
			        	   if(to_be_changed==1)
			        	   {
			        		  // System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals( "mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   propel_verbs[i].source.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        			   propel_verbs[i].source.physical_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("health"))
			        			   propel_verbs[i].source.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   propel_verbs[i].source.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   propel_verbs[i].source.fear = Integer.parseInt(token);
			        	   }
			        	   if(to_be_changed==2)
			        	   {
			        		   //System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals("mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   propel_verbs[i].dest.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        		   {
			        			  // System.out.println(Integer.parseInt(token));
			        			   propel_verbs[i].dest.physical_state = Integer.parseInt(token);
			        		   }
			        		   if(field_to_be_changed.equals("health"))
			        			   propel_verbs[i].dest.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   propel_verbs[i].dest.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   propel_verbs[i].dest.fear = Integer.parseInt(token);
			        	   }
			        	   
			           }
			           if(j==8)
			           {
			        	   to_be_changed = token.charAt(token.length()-1) - '0';
			        	   //System.out.println(to_be_changed);
			           }
			           if(j==9)
			           {
			        	   field_to_be_changed = token;
			        	  // System.out.println(field_to_be_changed);
			           }
			           if(j==10)
			           {
			        	   if(to_be_changed==1)
			        	   {
			        		  // System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals( "mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   propel_verbs[i].source.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        		   {
			        		//	   System.out.println(Integer.parseInt(token));
			        			   propel_verbs[i].source.physical_state = Integer.parseInt(token);
			        		   }
			        		   if(field_to_be_changed.equals("health"))
			        			   propel_verbs[i].source.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   propel_verbs[i].source.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   propel_verbs[i].source.fear = Integer.parseInt(token);
			        	   }
			        	   if(to_be_changed==2)
			        	   {
			        		   //System.out.println(field_to_be_changed);
			        		   if(field_to_be_changed.equals("mental_state"))
			        		   {
			        			   //System.out.println("check");
			        			   propel_verbs[i].dest.mental_state = Integer.parseInt(token);
			        			   //System.out.println(Integer.parseInt(token));
			        		   }
			        		   if(field_to_be_changed .equals("physical_state"))
			        			   propel_verbs[i].dest.physical_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("health"))
			        			   propel_verbs[i].dest.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   propel_verbs[i].dest.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear") )
			        			   propel_verbs[i].dest.fear = Integer.parseInt(token);
			        	   }
			        	   
			           }
			           j++;
			        }
			        propel_verbs[i].part_of_speech = "verb";
			        propel_verbs[i].cd_form = "((PROPEL(FROM ?VAR1)(TO ?VAR2)" +
			        		"(OBJECT ?VAR3))(PHYSCONT(?VAR2,?VAR3))(USING ?VAR5)(ADVERB ?VAR6)*(CONC_TENSE ?VAR7))";
					i++;
				}
				int k;
				for(k=0;k<i;k++)
				{
					//System.out.println(propel_verbs[k].name + " Initial State " + propel_verbs[k].source.physical_state + "Final State " + propel_verbs[k].dest.physical_state);
					//System.out.println(propel_verbs[k].name + propel_verbs[k].cd_form);
				}
					br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException fe)
		{
		    fe.printStackTrace();
		}
		
	}
	private void loadMbuild()
	{
		try 
		{
			File inFile = new File("MBUILD");
		    FileInputStream fstream = new FileInputStream(inFile);
		    DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split("-");
					if(parts.length !=2) {
						System.err.println("Error in Parsing mbuild");
						return;
					}
					String e_part = parts[0];
					String m_part=parts[1];
					mbuild_verbs[i] = new MBuild();
					mbuild_verbs[i].name = e_part;
					mbuild_verbs[i].token = e_part;
					mbuild_verbs[i].m_name = m_part.trim();
					mbuild_verbs[i].part_of_speech = "verb";
					mbuild_verbs[i].cd_form = "MBUILD((ACTOR ?VAR1)(INITIAL ?VAR2)(FINAL ?VAR3)" +
							"(USING ?VAR4)(ADVERB ?VAR5)*(CONC_TENSE ?VAR6))";
					i++;
				}
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
			catch (FileNotFoundException fe)
			{
			    fe.printStackTrace();
			}
	}
//	private void do_something()
//	{
//		try 
//		{
//			File inFile = new File("DO_SOMETHING");
//		    FileInputStream fstream = new FileInputStream(inFile);
//		    DataInputStream in = new DataInputStream(fstream);
//			BufferedReader br = new BufferedReader(new InputStreamReader(in));
//			String strLine;
//			int i=0;
//			int k=0;
//			String name = new String();
//			try 
//			{
//				while ((strLine = br.readLine()) != null)   
//				{
//					StringTokenizer stt = new StringTokenizer(strLine," ");
//					int j=0;
//					int to_be_changed=0;
//					int flag=0;
//					String field_to_be_changed = new String();
//			        while (stt.hasMoreTokens())
//			        {
//			            String token = stt.nextToken();
//			            //System.out.println(token);
//			           if(j==0)
//			           {
//			        	   name = token;
//			           }
//			           if(j==1 && token.equals("person"))
//			           {
//			        	   do_something_1_verbs[i] = new do_something1();
//			        	   do_something_1_verbs[i].name = name;
//			        	   do_something_1_verbs[i].token = name;
//			        	   do_something_1_verbs[i].part_of_speech = "verb";
//			        	  // System.out.println(token);
//			        	   flag=1;
//			           }
//			           if(j==1 && token.equals("object"))
//			           {
//			        	   do_something_2_verbs[k] = new do_something2();
//			        	   do_something_2_verbs[k].name = name;
//			        	   do_something_2_verbs[k].token = name;
//			        	   do_something_2_verbs[k].part_of_speech = "verb";
//			        	   flag=2;
//			           }
//			           if(j==2 && token.equals("abstract"))
//			           {
//			        	   if(flag==1)
//			        		   do_something_1_verbs[i].using_instrument.part_of_speech = "ABSTRACT-NOUN-PHRASE";
//			        	   else
//			        		   do_something_2_verbs[k].using_instrument.part_of_speech = "ABSTRACT-NOUN-PHRASE";
//			        		   
//			           }
//			           if(j==5)
//			           {
//			        	   to_be_changed = token.charAt(token.length()-1) - '0';
//			        	   //System.out.println(to_be_changed);
//			           }
//			           if(j==6)
//			           {
//			        	   field_to_be_changed = token;
//			        	  // System.out.println(field_to_be_changed);
//			           }
//			           if(j==7)
//			           {
//			        	   if(flag==1)
//			        	   {
//			        		   do_something_1_verbs[i].name=name;
//			        		   do_something_1_verbs[i].token = name;
//			        		   if(to_be_changed==1) //actor to be changed
//			        		   {
//			        			   if(field_to_be_changed.equals( "mental_state"))
//				        		   {
//				        			   //System.out.println("check");
//				        			   do_something_1_verbs[i].actor.mental_state = Integer.parseInt(token);
//				        			   //System.out.println(Integer.parseInt(token));
//				        		   }
//				        		   if(field_to_be_changed .equals("physical_state"))
//				        		   {
//				        			//   System.out.println(Integer.parseInt(token));
//				        			   do_something_1_verbs[i].actor.physical_state = Integer.parseInt(token);
//				        		   }
//				        		   if(field_to_be_changed.equals("health"))
//				        			   do_something_1_verbs[i].actor.health = Integer.parseInt(token);
//				        		   if(field_to_be_changed.equals("anger"))
//				        			   do_something_1_verbs[i].actor.anger = Integer.parseInt(token);
//				        		   if(field_to_be_changed.equals("fear") )
//				        			   do_something_1_verbs[i].actor.fear = Integer.parseInt(token);
//			        		   }
//			        		   if(to_be_changed==2) //actor to be changed
//			        		   {
//			        			   if(field_to_be_changed.equals( "mental_state"))
//				        		   {
//				        			   //System.out.println("check");
//				        			   do_something_1_verbs[i].object.mental_state = Integer.parseInt(token);
//				        			   //System.out.println(Integer.parseInt(token));
//				        		   }
//				        		   if(field_to_be_changed .equals("physical_state"))
//				        		   {
//				        			 //  System.out.println(Integer.parseInt(token));
//				        			   do_something_1_verbs[i].object.physical_state = Integer.parseInt(token);
//				        		   }
//				        		   if(field_to_be_changed.equals("health"))
//				        			   do_something_1_verbs[i].object.health = Integer.parseInt(token);
//				        		   if(field_to_be_changed.equals("anger"))
//				        			   do_something_1_verbs[i].object.anger = Integer.parseInt(token);
//				        		   if(field_to_be_changed.equals("fear") )
//				        			   do_something_1_verbs[i].object.fear = Integer.parseInt(token);
//				        		   do_something_1_verbs[i].cd_form = "(DO SOMETHING(ACTOR ?VAR1)(OBJECT ?VAR2)" +
//				        		   		"(USING ?VAR3)(ADVERB ?VAR4)*(CONC_TENSE ?VAR5))";
//				        		   if(field_to_be_changed.equals("NOT"))
//				        		   {
//				        			   do_something_1_verbs[i].cd_form = "((DO SOMETHING(ACTOR ?VAR1)(OBJECT ?VAR2)" +
//				        			   		"(USING ?VAR3))(RESULT(?VAR2,?VAR4))(ADVERB ?VAR6)*(CONC_TENSE ?VAR7))";
//				        		   }
//			        		   }
//			        		 i++;
//			        	   }
//			        	   if(flag==2)
//			        	   {
//			        		   do_something_2_verbs[k].name=name;
//			        		   do_something_2_verbs[k].token = name;
//			        		   if(to_be_changed==1) //actor to be changed
//			        		   {
//			        			   if(field_to_be_changed.equals( "mental_state"))
//				        		   {
//				        			   //System.out.println("check");
//				        			   do_something_2_verbs[k].actor.mental_state = Integer.parseInt(token);
//				        			   //System.out.println(Integer.parseInt(token));
//				        		   }
//				        		   if(field_to_be_changed .equals("physical_state"))
//				        		   {
//				        			   //System.out.println(Integer.parseInt(token));
//				        			   do_something_2_verbs[k].actor.physical_state = Integer.parseInt(token);
//				        		   }
//				        		   if(field_to_be_changed.equals("health"))
//				        			   do_something_2_verbs[k].actor.health = Integer.parseInt(token);
//				        		   if(field_to_be_changed.equals("anger"))
//				        			   do_something_2_verbs[k].actor.anger = Integer.parseInt(token);
//				        		   if(field_to_be_changed.equals("fear") )
//				        			   do_something_2_verbs[k].actor.fear = Integer.parseInt(token);
//			        		   }
//			        		   if(to_be_changed==2) //actor to be changed
//			        		   {
//			        			  
//				        		   if(field_to_be_changed .equals("physical_state"))
//				        		   {
//				        			   //System.out.println(Integer.parseInt(token));
//				        			   do_something_2_verbs[k].object.physical_state = Integer.parseInt(token);
//				        		   }
//				        		   if(field_to_be_changed.equals("size"))
//				        			   do_something_2_verbs[k].object.size = Integer.parseInt(token);
//				        		   if(field_to_be_changed.equals("quality"))
//				        			   do_something_2_verbs[k].object.quality = Integer.parseInt(token);
//			        		   }
//			        		   do_something_2_verbs[k].cd_form = "(DO SOMETHING(ACTOR ?VAR1)(OBJECT ?VAR2)" +
//			        		   		"(USING ?VAR3)(ADVERB ?VAR4)*(CONC_TENSE ?VAR5))";
//			        		   k++;
//			        	   }
//			           }
//			           j++;
//			        }
//				}
//				int l;
//				for(l=0;l<i;l++)
//				{
//					//System.out.println(l);
//					//System.out.println(do_something_1_verbs[l].name + "  "+do_something_1_verbs[l].cd_form);
//				}
//					for(l=0;l<k;l++)
//					{
//						//System.out.println(do_something_2_verbs[l].name + do_something_2_verbs[l].cd_form);
//					//	System.out.println(do_something_2_verbs[l].name + "Initial State  "+do_something_2_verbs[l].object.size+"Final State "+do_something_2_verbs[l].object.quality+" "+do_something_2_verbs[l].object.physical_state);
//					}
//					br.close();
//			} 
//			catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
//		} 
//		catch (FileNotFoundException fe)
//		{
//		    fe.printStackTrace();
//		}
//		
//	}
	private void expelmethod()
	{
		try 
		{
			File inFile = new File("EXPEL");
		    FileInputStream fstream = new FileInputStream(inFile);
		    DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split(":");
					if(parts.length !=2) {
						System.err.println("Error in Parsing expel");
						return;
					}
					String e_part = parts[0];
					String m_part=parts[1];
					StringTokenizer stt = new StringTokenizer(e_part," ");
					expel_verbs[i] = new Expel();
					int j=0;
					String field_to_be_changed = new String();
			        while (stt.hasMoreTokens()){
			            String token = stt.nextToken();
			           if(j==0)
			           {
			        	   expel_verbs[i].name = token;
			        	   expel_verbs[i].token = token;
			        	   expel_verbs[i].m_name = m_part.trim();
			        	   expel_verbs[i].cd_form = "(EXPEL(FROM ?VAR1)(OBJECT ?VAR2)(USING ?VAR3)" +
			        	   		"(ADVERB ?VAR4)*(CONC_TENSE ?VAR5)) ";
			           }
			           if(j==4)
			           {
			        	   field_to_be_changed = token;
			           }
			           if(j==5)
			           {
			        	 
			        		   if(field_to_be_changed.equals("mental_state"))
			        			   expel_verbs[i].actor.mental_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("physical_state"))
			        			   expel_verbs[i].actor.physical_state = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("health"))
			        			   expel_verbs[i].actor.health = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("anger"))
			        			   expel_verbs[i].actor.anger = Integer.parseInt(token);
			        		   if(field_to_be_changed.equals("fear"))
			        			   expel_verbs[i].actor.fear = Integer.parseInt(token);
			        	   
			
			        	   
			           }
			           j++;
			        }
					i++;
				}
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			expelcount = i;
		} 
		catch (FileNotFoundException fe)
		{
		    fe.printStackTrace();
		}
		
		for(k=0;k<expelcount;k++)
		{
			//System.out.println(expel_verbs[k].m_name + expel_verbs[k].cd_form);
		}
	}
	private void graspmethod()
	{
		try 
		{
			File inFile = new File("GRASP");
		    FileInputStream fstream = new FileInputStream(inFile);
		    DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					grasp_verbs[i] = new Grasp();
					String[] parts = strLine.split("-");
					if(parts.length !=2) {
						System.err.println("Error in Parsing grasp");
						return;
					}
					String e_part = parts[0];
					String m_part=parts[1];
					grasp_verbs[i].name = e_part;
			        grasp_verbs[i].token = e_part;
			        grasp_verbs[i].m_name = m_part.trim();
			        grasp_verbs[i].cd_form = "(GRASP(ACTOR ?VAR1)(OBJECT ?VAR2)" +
			        	   		"(USING ?VAR3)(ADVERB ?VAR4)*(CONC_TENSE ?VAR5)) ";
			        i++;
				}
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			graspcount = i;
		} 
		catch (FileNotFoundException fe)
		{
		    fe.printStackTrace();
		}
		for(k=0;k<graspcount;k++)
		{
			//System.out.println(grasp_verbs[k].name + grasp_verbs[k].cd_form);
		}
		
	}
	private void ingestmethod()
	{
		try 
		{
			File inFile = new File("INGEST");
		    FileInputStream fstream = new FileInputStream(inFile);
		    DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split("-");
					if(parts.length !=2) {
						System.err.println("Error in Parsing ingest");
						return;
					}
					String e_part = parts[0];
					String m_part=parts[1];
					StringTokenizer stt = new StringTokenizer(e_part," ");
					ingest_verbs[i] = new Ingest();
					int j=0;
			        while (stt.hasMoreTokens()){
			            String token = stt.nextToken();
			           if(j==0)
			           {
			        	   ingest_verbs[i].name = token;
			        	   ingest_verbs[i].token = token;
			        	   ingest_verbs[i].m_name = m_part.trim();
			        	   ingest_verbs[i].cd_form = "(INGEST(ACTOR ?VAR1)(OBJECT ?VAR2)" +
			        	   		"(USING ?VAR3)(ADVERB ?VAR4)*(CONC_TENSE ?VAR5)) ";
			           }
			           j++;
			        }
					i++;
				}
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			ingestcount = i;
		} 
		catch (FileNotFoundException fe)
		{
		    fe.printStackTrace();
		}
		for(k=0;k<ingestcount;k++)
		{
			//System.out.println(ingest_verbs[k].name + ingest_verbs[k].cd_form);
		}
}
	private void attendmethod()
	{
		try 
		{
			File inFile = new File("ATTEND");
		    FileInputStream fstream = new FileInputStream(inFile);
		    DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			try 
			{
				
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split("-");
					if(parts.length !=2) {
						System.err.println("Error in Parsing attend");
						return;
					}
					String e_part = parts[0];
					String m_part=parts[1];
					StringTokenizer stt = new StringTokenizer(e_part," ");
					attend_verbs[i] = new Attend();
					int j=0;
			        while (stt.hasMoreTokens()){
			            String token = stt.nextToken();
			           if(j==0)
			           {
			        	   attend_verbs[i].name = token;
			        	   attend_verbs[i].m_name = m_part.trim();
			        	   attend_verbs[i].token = token;
			        	   attend_verbs[i].cd_form = " ATTEND((ACTOR ?VAR1)(ORGAN ?VAR2)(OBJECT ?VAR3)" +
			        	   		"(USING ?VAR4)(ADVERB ?VAR5)*(CONC_TENSE ?VAR6)) ";
			           }
			           j++;
			        }
					i++;
				}
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			attendcount = i;
		} 
		catch (FileNotFoundException fe)
		{
		    fe.printStackTrace();
		}
		for(k=0;k<attendcount;k++)
		{
			//System.out.println(attend_verbs[k].name + attend_verbs[k].cd_form);
		}
	}
	private void statementhod()
	{
		try 
		{
			File inFile = new File("STATE");
		    FileInputStream fstream = new FileInputStream(inFile);
		    DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split(":");
					if(parts.length !=2) {
						System.err.println("Error in Parsing state");
						return;
					}
					String e_part = parts[0];
					String m_part=parts[1];
					StringTokenizer stt = new StringTokenizer(e_part," ");
					state_verbs[i] = new state();
					int j=0;
			        while (stt.hasMoreTokens()){
			            String token = stt.nextToken();
			           if(j==0)
			           {
			        	   state_verbs[i].name = token;
			        	   state_verbs[i].token = token;
			        	   state_verbs[i].m_name = m_part.trim();
			        	   
			           }
			           if(j==1)
			           {
			        	  // System.out.println("check "+token.substring(0,3));
			        	   if(token.substring(0,3).equals("NOT"))
			        	   {
			        		   state_verbs[i].conceptual_tense="/";
			        		   state_verbs[i].cd_form = "(" +token.substring(3)+ "ACTOR ?VAR1)(OBJECT ?VAR2)(USING ?VAR3)(ADVERB ?VAR4)*(CONC_TENSE ?VAR5)))";
			        	   }
			        	   else 
			        	   {
			        		   state_verbs[i].cd_form = "("+ token + "?VAR1)(OBJECT ?VAR2))(USING ?VAR3)(ADVERB ?VAR4)*(CONC_TENSE ?VAR5)";
			        	   }
			           }
			           j++;
			        }
					i++;
				}
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			statecount = i;
		} 
		catch (FileNotFoundException fe)
		{
		    fe.printStackTrace();
		}
		for(k=0;k<statecount;k++)
		{
			//System.out.println(state_verbs[k].name + state_verbs[k].cd_form);
			
		}
	}
}
