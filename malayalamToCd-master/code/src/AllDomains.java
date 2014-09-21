import java.io.*;

public class AllDomains
{
	public static boolean isCDFormMalayalam = false;

	public ActorPlaceStructure[] politicians = new ActorPlaceStructure[200]; //86
	public ActorPlaceStructure[]places = new ActorPlaceStructure[600]; //543
	public ActorPlaceStructure[] pronouns = new ActorPlaceStructure[100]; //55
	public IObjectStructure[] objects = new IObjectStructure[150]; //104
	public Adverb_structure[] adverb = new Adverb_structure[100] ; //33
	public Adjective_structure[] adjective = new Adjective_structure[100]; //30
	
	public int nPoliticians=0;
	public int nPlaces=0;
	public int nPronouns=0;
	public int nObjects=0;
	public int nAdverb=0;
	public int nAdjective=0;
	
	public boolean load() {
		loadPoliticians();
		loadPlaces();
		loadPronouns();
		loadObjects(); 
		loadAdverbs();
		loadAdjectives();
		return true;
	}



	/***********************POLITICIANS*****************************/
	private void loadPoliticians()
	{
		try 
		{
			File inFile = new File("POLITICIANS_NAMES");
			try
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(
						new FileInputStream(inFile), "UTF8"));
				String strLine;
				int i=0;
				//	
				//	
				try 
				{
					while ((strLine = br.readLine()) != null)   
					{
						String[] parts = strLine.split("-");
						if(parts.length !=2) {
							System.err.println("Error in Parsing politicians"+strLine);
							return;
						}
						String e_part = parts[0];
						String m_part=parts[1];
						politicians[i] = new ActorPlaceStructure();
						politicians[i].token = e_part;
						//		
						if(isCDFormMalayalam) {
							politicians[i].name = m_part;
							politicians[i].cd_form = "(PERSON(NAME "+m_part.trim()+"))";// (ISA(ADJECTIVE))*)";
						} else {
							politicians[i].name = e_part;
							politicians[i].cd_form = "(PERSON(NAME "+e_part.trim()+"))";
						}
						//		
						politicians[i].part_of_speech="NOUN-PHRASE";
						//		
						politicians[i].type = "person";
						//		
						politicians[i].specific ="YES";
						politicians[i].m_name = m_part.trim();
						i++;
					}
					br.close();
					nPoliticians=i;
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			catch (UnsupportedEncodingException e) 
			{

			} 
		} 
		catch (FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
	}
	/***********************PLACES*****************************/
	private void loadPlaces()
	{
		try 
		{
			File inFile = new File("PLACES_NAMES");
			try
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(
						new FileInputStream(inFile), "UTF8"));
				String strLine;
				int i=0;
				try
				{
					while ((strLine = br.readLine()) != null)   
					{
						String[] parts = strLine.split("-");
						if(parts.length !=2) {
							System.err.println("Error in Parsing place");
							return;
						}
						String e_part = parts[0];
						String m_part=parts[1];
						places[i] = new ActorPlaceStructure();
						places[i].token = e_part;
						if(isCDFormMalayalam) {
							places[i].cd_form = "(PLACE(NAME "+m_part.trim()+"))";
							places[i].name = m_part;
						} else {
							places[i].cd_form = "(PLACE(NAME "+e_part.trim()+"))";
							places[i].name = e_part;
						}
						places[i].part_of_speech="NOUN-PHRASE";
						places[i].type = "object";
						places[i].m_name = m_part.trim();
						i++;
					}
					br.close();
					nPlaces=i;
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			catch (UnsupportedEncodingException e) 
			{

			} 
		} 
		catch (FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
	}
	/***********************PRONOUN*****************************/
	private void loadPronouns()
	{
		try 
		{
			File inFile = new File("PRONOUN_NAMES");
			FileInputStream fstream = new FileInputStream(inFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//	
			//	
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split("-");
					if(parts.length !=2) {
						System.err.println("Error in Parsing pronoun"+strLine);
						return;
					}
					String e_part = parts[0];
					String m_part=parts[1];
					pronouns[i] = new ActorPlaceStructure();
					
					pronouns[i].token = e_part;
					pronouns[i].m_name = m_part.trim();
					strLine = br.readLine();
					if(isCDFormMalayalam) {
						pronouns[i].cd_form = m_part.trim();
						pronouns[i].name = m_part;
					} else {
						pronouns[i].cd_form = e_part.trim();
						pronouns[i].name = e_part;
					}
					int k=0;
					int flag1=0;
					int flag2=0;
					for(k=0;k<strLine.length()-6;k++)
					{
						if(strLine.charAt(k)=='O' && strLine.charAt(k+1)=='B' &&
								strLine.charAt(k+2)=='J' && strLine.charAt(k+3)=='E' && 
								strLine.charAt(k+4)=='C' && strLine.charAt(k+5)=='T')
							flag1=1;
						if(strLine.charAt(k)=='P' && strLine.charAt(k+1)=='E' &&
								strLine.charAt(k+2)=='R' && strLine.charAt(k+3)=='S' &&
								strLine.charAt(k+4)=='O' && strLine.charAt(k+5)=='N')
							flag2=1;
					}
					pronouns[i].part_of_speech="NOUN-PHRASE";
					if(flag1==1 && flag2==0)
						pronouns[i].type = "object";
					if(flag1==1 && flag2==1)
						pronouns[i].type = "both";
					if(flag1==0 && flag2==1)
						pronouns[i].type = "person";
					strLine = br.readLine();
					pronouns[i].specific = strLine;
					i++;
				}
				br.close();
				nPronouns=i;
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
	/***********************OBJECT*****************************/
	private void loadObjects()
	{
		try {
			File inFile = new File("OBJECT_NAMES");
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
						System.err.println("Error in Parsing object"+strLine);
						return;
					}
					String e_part = parts[0];
					String m_part=parts[1];
					objects[i] = new IObjectStructure();	
					if(e_part.charAt(e_part.length()-1) =='*')
					{
						e_part = e_part.substring(0, e_part.length()-1);
						objects[i].token = e_part;
						if(isCDFormMalayalam) {
							objects[i].cd_form = "(OBJECT(NAME "+m_part.trim()+"))";//;(ISA(ADJECTIVE))*)";
							objects[i].name = m_part;
						} else {
							objects[i].name = e_part;
							objects[i].cd_form = "(OBJECT(NAME "+e_part.trim()+"))";//;(ISA(ADJECTIVE))*)";
						}
						objects[i].part_of_speech="ABSTRACT-NOUN-PHRASE";

						objects[i].type = "object";
						objects[i].m_name=m_part.trim();

					}
					else
					{
						objects[i].token = e_part;
						if(isCDFormMalayalam){
							objects[i].cd_form = "(OBJECT(NAME "+m_part.trim()+"))";
							objects[i].name = m_part;
						} else {
							objects[i].cd_form = "(OBJECT(NAME "+e_part.trim()+"))";
							objects[i].name = e_part;
						}
						objects[i].part_of_speech="NOUN-PHRASE";
						objects[i].type = "object";
						objects[i].m_name=m_part.trim();
					}
					i++;
				}
				br.close();
				nObjects=i;
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
	/***********************ADVERB*****************************/
	private void loadAdverbs()
	{
		try 
		{
			File inFile = new File("ADVERB_NAMES");
			FileInputStream fstream = new FileInputStream(inFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			//	
			//	
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split("-");
					if(parts.length !=2) {
						System.err.println("Error in Parsing adverb");
						return;
					}
					String e_part = parts[0];
					String m_part=parts[1];
					adverb[i] = new Adverb_structure();

					//		
					adverb[i].token = e_part;
					//		

					if(isCDFormMalayalam) {
						adverb[i].cd_form = "(ADVERB "+m_part.trim()+")";
						adverb[i].name = m_part;
					}else {
						adverb[i].name = e_part;
						adverb[i].cd_form = "(ADVERB "+e_part.trim()+")";
					}//		
					adverb[i].part_of_speech="ADVERB-PHRASE";
					//		
					adverb[i].type = "adverb";
					adverb[i].m_name = m_part.trim();
					//		
					i++;
				}
				br.close();
				nAdverb=i;
			} catch (IOException e) 
			{
				e.printStackTrace();
			}

		} 
		catch (FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
	}
	/***********************ADJECTIVE*****************************/
	private void loadAdjectives()
	{
		try 
		{
			File inFile = new File("ADJECTIVE_NAMES");
			FileInputStream fstream = new FileInputStream(inFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//	
			//	
			int i=0;
			try 
			{
				while ((strLine = br.readLine()) != null)   
				{
					String[] parts = strLine.split("-");
					if(parts.length !=2) {
						System.err.println("Error in Parsing adjectives");
						return;
					}
					String e_part = parts[0];
					String m_part=parts[1];
					adjective[i] = new Adjective_structure();
					adjective[i].token = e_part;
					//		

					if(isCDFormMalayalam) {
						adjective[i].cd_form = "(ADJECTIVE "+m_part.trim()+")";
						adjective[i].name = m_part;
					}else {
						adjective[i].cd_form = "(ADJECTIVE "+e_part.trim()+")";
						adjective[i].name = e_part;
					}//		
					adjective[i].part_of_speech="ADJECTIVE-PHRASE";
					///		
					adjective[i].type = "adjective";
					adjective[i].m_name = m_part.trim();
					//		
					i++;
				}
				br.close();
				nAdjective=i;
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}

		} catch (FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
	}
}
