import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int z = scanner.nextInt(); 
		boolean possible = false; 
		
		for(int k = 0; k < z; k++) {
			int inputs = scanner.nextInt();
			ArrayList<Time> ctime = new ArrayList<>();
			ArrayList<Time> jtime = new ArrayList<>();
			String result = "";	
			
			for(int i = 0; i < inputs; i++) {
				Time t = new Time(scanner.nextInt(), scanner.nextInt()); 
				if(i == 0) {
					result += "J";
					jtime.add(t);
				}
				else {
					possible = true; 
					for(int m = 0; m < jtime.size(); m++) {
						if(timeIssue(t, jtime.get(m))) {
							possible = false;
							break; 
						}
					}
					
					if(possible) {
						jtime.add(t);
						result += "J";
						continue;
					}
					possible = true;
					for(int m = 0; m < ctime.size(); m++) {
						if(timeIssue(t, ctime.get(m))) {
							possible = false; 
							break;
						}
					}
					
					if(possible) {
						ctime.add(t);
						result += "C";
					}
					else {
						result = "IMPOSSIBLE";
						break;
					}
				}
			}
			System.out.println("Case #" + (k + 1) + ":" + result);
		}
		System.exit(0);
	}
	
	public static boolean timeIssue(Time a, Time b) {
		if((	a.start < b.end && a.end >= b.end) 
				|| (a.start <= b.start && a.end > b.start) 
				|| (a.start >= b.start && a.end <= b.end))
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
