import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	public class Time {
		private int st;
		private int et;
		private int index;
		private char initial;

	}

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();

		for (int qItr = 0; qItr < t; qItr++) {

			int n = scanner.nextInt();

			List<Time> activities = new ArrayList<Time>();

			String s = "";
			for(int j=0;j<n;j++) {
				s += " ";
			}
			
			Time time = null;
			for (int i = 0; i < n; i++) {
				time = new Solution().new Time();
				int st = scanner.nextInt();
				int et = scanner.nextInt();
				
				time.et = et;
				time.st = st;
				time.index = i;

				activities.add(time);
			}

			activities.sort(new Comparator<Time>() {

				@Override
				public int compare(Time o1, Time o2) {
					return o1.st-o2.st;
				}
				
			});
			
			List<Time> onGoingActivities = new ArrayList<Time>();
			List<Time> onGoingActivities1 = new ArrayList<Time>();
			boolean fail = false;
			
			for(int i=0;i<activities.size();i++) {
				Time tm = activities.get(i);
				
				if(!onGoingActivities.isEmpty()) {
					
					for(Time t1: onGoingActivities) {
						if(t1.et > tm.st)
							onGoingActivities1.add(t1);
					}
				}
				
				onGoingActivities.clear();
				onGoingActivities.addAll(onGoingActivities1);
				onGoingActivities1.clear();
				
				if(onGoingActivities.size() >= 2){
					fail = true;
					break;
				}else if(onGoingActivities.size() == 0) {
					tm.initial = 'J';
				}else {
					if(onGoingActivities.get(0).initial == 'J')
						tm.initial='C';
					else
						tm.initial = 'J';
				}
				
				onGoingActivities.add(tm);
				s = s.substring(0, tm.index) 
			              + tm.initial 
			              + s.substring(tm.index + 1); 
			}
			
			if(fail)
				System.out.println("Case #" + (qItr + 1) + ": IMPOSSIBLE");
			else
				System.out.println("Case #" + (qItr + 1) + ": " + s);
		}

		scanner.close();
	}

}
