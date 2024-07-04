import java.util.*;
public class Solution{
	static int testCases = 0;
	static Scanner s;
	public static void main(String[] args){
		s = new Scanner(System.in);
		testCases = s.nextInt();
		s.nextLine();
		String output = "";
		for(int i=0;i<testCases;i++){
			output = output + runTestCase(i+1);
		}

		System.out.println(output);
	}

	public static String runTestCase(int c){
		String[] tokens;
		int size = s.nextInt();
		s.nextLine();
		Activity[] activities = new Activity[size];
		for(int i=0;i<size;i++){			
			tokens = s.nextLine().split(" ");
			Activity a = new Activity(
				Integer.parseInt(tokens[0]), 
				Integer.parseInt(tokens[1]),
				i
			);
			activities[i] = a;
		}
				
		//sort the activities...
		Activity temp;
		for (int i = 1; i < activities.length; i++) {
		    for (int j = i; j > 0; j--) {
		     if (activities[j].leftBound < activities[j - 1].leftBound) {
		      temp = activities[j];
		      activities[j] = activities[j - 1];
		      activities[j - 1] = temp;
		     }
		    }
		}

		int intersects = 0;
		String nextAssign = "C";
		boolean impossible = false;
		for(int i = 0;i<activities.length;i++){
			if(activities[i].assignedTo.equals("")){
				activities[i].assignedTo = "C";
				nextAssign = "J";
			}else{
				nextAssign = activities[i].assignedTo.equals("C") ? "J" : "C";
			}
			int j = i+1;
			while(j< activities.length && activities[j].leftBound < activities[i].rightBound ){
				//these activities interset activity i
				if(!activities[j].assignedTo.equals("")
					&& activities[j].assignedTo.equals(activities[i].assignedTo) ){
					// it was already assigned..
					// and it was assigned to the same... so return impossible
					impossible = true;
				}
				activities[j].assignedTo = nextAssign;
				j++;
			}
			nextAssign = nextAssign.equals("C") ? "J" : "C";
		}

		if(impossible){
			return "Case #" +c+": IMPOSSIBLE\n";
		}

		// resort back to original...
		for (int i = 1; i < activities.length; i++) {
		    for (int j = i; j > 0; j--) {
		     if (activities[j].order < activities[j - 1].order) {
		      temp = activities[j];
		      activities[j] = activities[j - 1];
		      activities[j - 1] = temp;
		     }
		    }
		}

		String output = "";
		for(int i=0;i<activities.length;i++){
			output = output+activities[i].assignedTo;
		}
		return "Case #"+c+": "+ output +"\n";
	}	
}

class Activity{
	String assignedTo;
	int leftBound, rightBound, order;
	public Activity(int l, int r, int o){
		leftBound= l;
		rightBound = r;
		order = o;
		assignedTo = "";
	}
	public String toString(){
		return "Activity assigned to : " + assignedTo+", " +leftBound + " -- " + rightBound;
	}

}