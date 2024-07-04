import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int nbtest = in.nextInt();
		
		for(int i = 0; i < nbtest; i++){
			int nbTask;
			boolean planningOK = true;
			Planning centralPlanning = new Planning();
			Planning CPlanning = new Planning();
			Planning JPlanning = new Planning();
			
			nbTask = in.nextInt();
			for(int j = 0; j < nbTask; j++){
				int start;
				int end;
				Activite activity;
				
				start = in.nextInt();
				end = in.nextInt();
				activity = new Activite(start, end, j);
				centralPlanning.addActivity(activity);
			}
			
			centralPlanning.sortPlanning();
			
			for(int j = 0; j < nbTask && planningOK; j++){
				Activite activity;
				
				activity = centralPlanning.getListe().get(j);
				if(planningOK && CPlanning.addActivityPossible(activity)){
					CPlanning.addActivity(activity);
				} else if(planningOK && JPlanning.addActivityPossible(activity)){
					JPlanning.addActivity(activity);
				} else {
					planningOK = false;
				}
			}
			
			System.out.print("Case #" + (i + 1) + ": ");
			if(planningOK){
				for(int j = 0; j < nbTask; j++){
					if(CPlanning.activityExist(j)){
						System.out.print("C");
					} else {
						System.out.print("J");
					}
				}
			} else {
				System.out.print("IMPOSSIBLE");
			}
			System.out.println("");
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
			if(!(act.getEnd() <= activity.getStart() || act.getStart() >= activity.getEnd())){
				return false;
			}
		}
			
		return true;
	}
	
	public boolean activityExist(int id){
		for(int i = 0; i < this.liste.size(); i++){
			if(id == this.liste.get(i).getId()){
				return true;
			}
		}
		
		return false;
	}
	
	public void sortPlanning(){
		Collections.sort(this.liste);
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

class Activite implements Comparable<Activite>{
	private int id;
	private int start;
	private int end;
	
	public Activite(int start, int end, int id){
		this.start = start;
		this.end = end;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public int compareTo(Activite act) {
		return this.start < act.getStart() ? -1 : this.start > act.getStart() ? 1 : 0;
	}
}