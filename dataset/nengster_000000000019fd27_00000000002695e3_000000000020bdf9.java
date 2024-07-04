import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Activity{
	int id;
	int start;
	int end;
	char who;
	public Activity(int id, int start, int end) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
	}
	boolean isOverlap(Activity oAct) {
		if (this.start>=oAct.start && this.start<oAct.end) {
			return true;			
		}
		else if (this.end>oAct.start && this.end<=oAct.end) {
			return true;
		}
		return false;
	}
}

class ActivityById implements Comparator<Activity>{

	@Override
	public int compare(Activity o1, Activity o2) {
		return o1.id-o2.id;
	}	
}

class ActivityByTime implements Comparator<Activity>{

	@Override
	public int compare(Activity o1, Activity o2) {
		return o1.start != o2.start ? o1.start - o2.start : o1.end - o2.end;
	}	
}

public class Solution {

	ArrayList<Activity> activities = new ArrayList<Activity>();
	StringBuilder schedule = new StringBuilder("");
	
	public Solution(Scanner in) { 
        int nAct = Integer.parseInt(in.nextLine());
		for (int i = 0; i < nAct; i++) {
			String[] line = in.nextLine().split(" ");
			activities.add(new Activity(i, Integer.parseInt(line[0]),Integer.parseInt(line[1])));
		}
	}
	
	public String doGreedy() {
		activities.sort(new ActivityByTime());
		Activity prevCact = new Activity(0,0,0);
		Activity prevJact = new Activity(0,0,0);

		for(int i=0; i<activities.size(); i++) {
			Activity newAct = activities.get(i);
			if(!newAct.isOverlap(prevCact)) {
				prevCact = newAct;
				activities.get(i).who='C';
			}
			else if(!newAct.isOverlap(prevJact)){
				prevJact = newAct;
				activities.get(i).who='J';				
			}
			else {
				return "IMPOSSIBLE";
			}
			//System.out.println("Assign " + activities.get(i).start + " -> " + activities.get(i).end + " to " + activities.get(i).who);
		}
		activities.sort(new ActivityById());
		for(Activity act:activities) {
			schedule.append(act.who);
		}
		return schedule.toString();
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int TS = Integer.parseInt(in.nextLine());
        ArrayList<String> schedule = new ArrayList<String>();
        for (int ts = 0; ts < TS; ts++ ) {
        	Solution solution = new Solution(in);
        	schedule.add(solution.doGreedy());
        }
        in.close();
        for (int ts = 0; ts < TS; ts++ ) {
        	System.out.println("Case #" + (ts+1) + ": " + schedule.get(ts));
        }
	}

}