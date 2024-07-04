import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner cin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = cin.nextInt();
		for (int c = 0 ; c < T ; c ++)
		{
			int N = cin.nextInt();
			String resultat = "";
			ArrayList<ArrayList> liste_J = new ArrayList<ArrayList>();
			ArrayList<ArrayList> liste_C = new ArrayList<ArrayList>();
			for (int num_act = 0 ; num_act < N ; num_act ++)
			{

				int debut_act = cin.nextInt();
				int fin_act = cin.nextInt();
				
				boolean ok = true;
				int i = 0;
				while (ok && i < liste_J.size())
				{
					
					ArrayList<Integer> act = liste_J.get(i);
					if ((debut_act < act.get(1)) && (act.get(0) < debut_act))
					{
						ok = false;
						break;
					}
					else if (fin_act < act.get(1) && act.get(0) < fin_act)
					{
						ok = false;
						break;
					}
					else 
					{
						i++;
					}
				}
				if (ok) 
				{
					ArrayList ajout = new ArrayList();
					ajout.add(debut_act);
					ajout.add(fin_act);
					liste_J.add(ajout);
					resultat+="J";
				}
				else
				{
					ok = true;
					i = 0;
					while (ok && i < liste_C.size())
					{
						ArrayList<Integer> act = liste_C.get(i);
						if ((debut_act < act.get(1)) && (act.get(0) < debut_act))
						{
							ok = false;
							break;
						}
						else if (fin_act < act.get(1) && act.get(0) < fin_act)
						{
							ok = false;
							break;
						}
						else 
						{
							i++;
						}
					}
					if (ok) 
					{
						ArrayList ajout = new ArrayList();
						ajout.add(debut_act);
						ajout.add(fin_act);
						liste_C.add(ajout);
						resultat+="C";
					}
					else
					{
						resultat = "IMPOSSIBLE";
						break;
					}
					
				}
				}
			
			
		
	System.out.println("Case #"+(c+1)+": "+resultat);
	}
	
}
}
