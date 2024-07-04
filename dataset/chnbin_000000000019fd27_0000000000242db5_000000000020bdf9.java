import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			String res = "";
			
			List<TimeSlot> timeSlot = new ArrayList<>();
			LinkedList<TimeSlot> Cameron = new LinkedList<>();
			LinkedList<TimeSlot> Jamie = new LinkedList<>();
			
			for (int j = 0; j < N; j++) {
				int startTime = sc.nextInt();
				int endTime = sc.nextInt();
				TimeSlot slot = new TimeSlot(startTime, endTime);
				timeSlot.add(slot);
			}
			
			Collections.sort(timeSlot, (a, b) -> (a.startTime - b.startTime));
			
			for (int k = 0; k < timeSlot.size(); k++) {
				TimeSlot t = timeSlot.get(k);
				
				if (Cameron.size() == 0) {
					Cameron.push(t);
					res += "C";
					continue;
				} else {
					if (Cameron.peek().endTime <= t.startTime) {
						Cameron.push(t);
						res += "C";
						continue;
					}
				}
				
				if (Jamie.size() == 0) {
					Jamie.push(t);
					res += "J";
					continue;
				} else {
					if (Jamie.peek().endTime <= t.startTime) {
						Jamie.push(t);
						res += "J";
						continue;
					} else {
						res = "IMPOSSIBLE";
						break;
					}
				}
			}
			
			System.out.println("Case #" + i + ": " + res);
		}
		sc.close();
	}
	
	public static class TimeSlot {
		public int startTime;
		public int endTime;
		
		public TimeSlot(int sTime, int eTime) {
			startTime = sTime;
			endTime = eTime;
		}
	}
}
