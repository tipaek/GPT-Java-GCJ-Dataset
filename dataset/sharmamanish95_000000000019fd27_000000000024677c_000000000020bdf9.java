import java.util.*;

class Solution {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i<=t; i++) {
            int n = sc.nextInt();
            Activity[] activities = new Activity[n];
            for(int j = 0; j<n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                activities[j] = new Activity(start, end);
            }
            String ans = solve(activities, n);
            System.out.println("Case #"+ i +": " + ans);
        }
    }
    
    static String solve(Activity[] activities, int n) {
        if(n==1)
            return "C";
		int cEnd = 0, jEnd = 0;
		StringBuilder sb = new StringBuilder();
		Arrays.sort(activities, (a,b) -> a.startTime-b.startTime);
		
		for(Activity curr: activities) {
			if(curr.startTime>=cEnd) {
				sb.append('C');
				cEnd = curr.endTime;
			}else if(curr.startTime>=jEnd) {
				sb.append('J');
				jEnd = curr.endTime;
			} else {
				return "IMPOSSIBLE";
			}
		}
		return sb.toString();
	}
    
}

class Activity {
	int startTime;
	int endTime;
	
	public Activity(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Activity [startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
