import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberInstances;
		try {
			numberInstances = Integer.parseInt(br.readLine());
		    for (int i = 1; i <= numberInstances; ++i) {
		    	boolean failed = false;
		    	String[] arguments = br.readLine().split(" ");
		    	int numberActivities = Integer.parseInt(arguments[0]);
		        Activity[] allActs = new Activity[numberActivities];
		        char[] responsible = new char[numberActivities];
		    	for (int j = 0; j< numberActivities; j++) {
		    		String[] activity = br.readLine().split(" ");
		    		int start = Integer.parseInt(activity[0]);
		    		int end = Integer.parseInt(activity[1]);
		    		allActs[j] = new Activity(start, end, j);
		    	}
		    	java.util.Arrays.sort(allActs);
		    	//System.out.println(java.util.Arrays.toString(allActs));
		    	int jamieBusy = 0;
		    	int cameronBusy = 0;
		    	for (Activity act:allActs) {
		    		if (act.start >= jamieBusy) {
		    			jamieBusy = act.end;
		    			responsible[act.index] = 'J';
		    			continue;
		    		}
		    		if (act.start >= cameronBusy) {
		    			cameronBusy = act.end;
		    			responsible[act.index] = 'C';
		    		}
		    		else {
		    			failed = true;
		    			break;
		    		}
		    		
		    	}
		    	//java.util.Arrays.toString(responsible);
		    	if (failed) System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
		    	else System.out.println("Case #" + i + ": " + new String(responsible));
		    }
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	static class Activity implements Comparable<Activity>{
		int start;
		int end;
		int index;
		public Activity (int start, int end, int index) {
			this.start=start;
			this.end=end;
			this.index = index;
		}
		@Override
		public int compareTo(Activity o) {
			if (this.start != ((Activity) o).start) return Integer.signum(this.start - ((Activity) o).start);
			return Integer.signum(this.end - ((Activity) o).end);
		}
		
		public String toString() {
			return "(" + index + "," + start +"," + end + ")";
		}
	}
		
	
}
