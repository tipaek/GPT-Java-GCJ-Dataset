import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int z = scanner.nextInt(); 
		boolean possible = false; 
		
		for(int k = 0; k < z; k++) {
			int inputs = scanner.nextInt();
			ArrayList<Time> ctime = new ArrayList<>();
			ArrayList<Time> jtime = new ArrayList<>();
			StringBuilder result = new StringBuilder();	
			
			for(int i = 0; i < inputs; i++) {
				int start = scanner.nextInt(); 
				int end = scanner.nextInt();
				Time t = new Time(start, end); 
				if(i == 0) {
					result.append("C");
					ctime.add(t);
				}
				else {
					possible = true; 
					for(int m = 0; m < ctime.size(); m++) {
						if(timeIssue(t, ctime.get(m))) {
							possible = false;
							break; 
						}
					}
					
					if(possible) {
						ctime.add(t);
						result.append("C");
						continue;
					}
					possible = true;
					for(int m = 0; m < jtime.size(); m++) {
						if(timeIssue(t, jtime.get(m))) {
							possible = false; 
							break;
						}
					}
					
					if(possible) {
						jtime.add(t);
						result.append("J");
					}
					else {
						result = new StringBuilder("IMPOSSIBLE");
						break;
					}
				}
			}
			System.out.println("Case #" + (k + 1) + ": " + result.toString());
		}
	}
	
	public static boolean timeIssue(Time a, Time b) {
		if( (a.start < b.end && a.end >= b.end) ||
			(a.start <= b.start && a.end > b.start) ||
			(a.start >= b.start && a.end <= b.end))
			return true;
		return false;
	}

	public static class Time {
		int start; 
		int end; 
		
		public Time(int start, int end) {
			this.start = start;
			this.end = end; 
		}
	}
}
