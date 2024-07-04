 
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t ; ++i) {
      int size = in.nextInt();
      Tuple[] activities = new Tuple[size];
      for(int j = 0; j<size; j++) {
    	  int a = in.nextInt();
    	  int b = in.nextInt();
    	  Tuple temp  = new Tuple(a,b);
    	  activities[j]=temp;
      }
      Scheduler sh = new Scheduler(size,activities);
      System.out.println("Case #" + i + ": " + sh.organize());
    }
  }
}

class Tuple {
	int[] content = new int[2];
	public Tuple(int a, int b) {
		content[0]=a;
		content[1]=b;
	}
	public int getStart() {
		return content[0];
	}
	public int getEnd() {
		return content[1];
	}
}

class Scheduler {
	char[] output;
	Tuple[] activities;
	ArrayList<Tuple> Jamie = new ArrayList<Tuple>();
	ArrayList<Tuple> Cam = new ArrayList<Tuple>();
	
	public Scheduler(int size, Tuple[] activities) {
		output = new char[size];
		this.activities = activities;
	}
	public String organize() {
		//#1 find and assign earliest activity to Cameron
		int early = this.findEarliest();
		Cam.add(activities[early]);
		output[early]='C';
		activities[early]=new Tuple(-1,-1);
		//#2 for each activity
		for(int a=0; a<activities.length;a++) {
			if(activities[a].getStart()==-1) {
				//do nothing as this has already been assigned
			}else {
				//#2a check if can be assigned to J
				if(isFree(activities[a],Cam)) {
					Cam.add(activities[a]);
					output[a]='C';
					activities[a]= new Tuple(-1,-1);
				}else if(isFree(activities[a], Jamie)){
					Jamie.add(activities[a]);
					output[a]='J';
					activities[a]= new Tuple(-1,-1);
				}else {
					return "IMPOSSIBLE";
				}
				//#2b check if can be assigned to C
				//#2c impossible
			}
			
		}
		String solution = "";
		for(int x=0;x<output.length;x++){
		    solution += output[x];
		}
		return solution;
	}
	public boolean isFree(Tuple act, List<Tuple> actor) {
		for(Tuple plan : actor) {
			if(act.getStart()<plan.getEnd()) {
				if(act.getEnd()>plan.getStart()){
					return false;
				}
			}
		}
		return true;
	}
	public int findEarliest() {
		Tuple earliest = new Tuple(100000,0);
		int earliest_index = 0;
		for(int a = 0; a<activities.length; a++) {
			if(activities[a].getStart()<=earliest.getStart()) {
				earliest = activities[a];
				earliest_index = a;
			}
		}
		return earliest_index;
	}
	public void printActivities() {
		for(Tuple t: activities) {
			System.out.println("starts at: " + t.getStart() + " ends at: " + t.getEnd());
		}
	}
}