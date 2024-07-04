import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	private int begin, end;
	private LinkedList<Integer> listBegin=new LinkedList<Integer>();
	private LinkedList<Integer> listEnd=new LinkedList<Integer>(); 
	public Solution() {
		begin=0;
		end=0;
	}

	public int getBegin() {
		return begin;
	}


	public void setBegin(int begin) {
		this.begin = begin;
		listBegin.add(begin);
	}


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
		listEnd.add(end);
	}
	
	public boolean estLibre(int heureDebut, int heureFin) {
		for(int i=0; i<listBegin.size(); i++) {
			if((heureDebut>=listBegin.get(i) && heureDebut<listEnd.get(i)) || (heureFin>listBegin.get(i) && heureFin<=listEnd.get(i)) || (heureDebut<=listBegin.get(i) && heureFin>=listEnd.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line;
		int numLine=0;
		int nbExs;
		int posEx=-1;
		int sizeEx=0;
		LinkedList<String> linesEx=new LinkedList<String>();
		LinkedList<String> exercices=new LinkedList<String>();
		while(sc.hasNextLine()) {
			line=sc.nextLine();
			if(numLine==0) {
				nbExs=Integer.parseInt(line);
			} else if(posEx==-1) {
				sizeEx=Integer.parseInt(line);
				posEx=0;
			} else {
				linesEx.add(line);
				posEx++;
				if(posEx==sizeEx) {
					posEx=-1;
					String strExTotal="";
					for(String lineMat : linesEx) {
						strExTotal+=lineMat+"\n";
					}
					linesEx=new LinkedList<String>();
					exercices.add(strExTotal);
				}
			}
			numLine++;
		}
		sc.close();
		for(int i=0; i<exercices.size(); i++) {
			Solution Cameron=new Solution();
			Solution Jamie=new Solution();
			String retourExo="";
			String exercice=exercices.get(i);
			String[] activites=exercice.split("\n");
			for(String activite: activites) {
				String[] horaires=activite.split(" ");
				int heureDebut=Integer.parseInt(horaires[0]);
				int heureFin=Integer.parseInt(horaires[1]);
				if(Jamie.estLibre(heureDebut, heureFin)) {
					Jamie.setBegin(heureDebut);
					Jamie.setEnd(heureFin);
					retourExo+="J";
				} else if(Cameron.estLibre(heureDebut, heureFin)) {
					Cameron.setBegin(heureDebut);
					Cameron.setEnd(heureFin);
					retourExo+="C";
				} else {
					retourExo="IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #"+(i+1)+": "+retourExo);
		}
	}
}
