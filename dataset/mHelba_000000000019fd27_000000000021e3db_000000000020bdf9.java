import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int nbtest = in.nextInt();
		
		for(int i = 0; i < nbtest; i++){
			int nbTask;
			String res = "";
			boolean planningOK = true;
			Planning CPlanning = new Planning();
			Planning JPlanning = new Planning();
			
			nbTask = in.nextInt();
			for(int j = 0; j < nbTask; j++){
				int start;
				int end;
				Activite activity;
				
				start = in.nextInt();
				end = in.nextInt();
				activity = new Activite(start, end);
				if(planningOK && CPlanning.addActivityPossible(activity)){
					CPlanning.addActivity(activity);
					res += "C";
				} else if(planningOK && JPlanning.addActivityPossible(activity)){
					JPlanning.addActivity(activity);
					res += "J";
				} else {
					planningOK = false;
					res = "IMPOSSIBLE";
				}
			}
			
			if(i != 0){
				System.out.println("");
			}
			System.out.print("Case #" + (i + 1) + ": " + res);
		}
	}
}

class Planning {
	private ArrayList<Activite> liste = new ArrayList<Activite>();
	
	public Planning(){}
	
	public boolean addActivityPossible(Activite activity){
		for(int i = 0; i < this.liste.size(); i++){
			Activite act;
			
			act = this.liste.get(i);
			if(!((act.getStart() < activity.getStart() && act.getEnd() <= activity.getStart())
					|| act.getStart() >= activity.getEnd())){
				return false;
			}
		}
			
		return true;
	}
	
	public void addActivity(Activite activity){
		this.liste.add(activity);
	}

	public ArrayList<Activite> getListe() {
		return liste;
	}

	public void setListe(ArrayList<Activite> liste) {
		this.liste = liste;
	}
}

class Activite {
	private int start;
	private int end;
	
	public Activite(int start, int end){
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}