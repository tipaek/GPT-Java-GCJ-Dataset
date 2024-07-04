import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	private static boolean addFreeTime(int start, int end, ArrayList<Integer> freeTimes) {
		
		for (int i = 0; i < freeTimes.size(); i += 2) {
			int fStart = freeTimes.get(i);
			int fEnd = freeTimes.get(i + 1);
			
			if (fStart == fEnd) {
				return false;
			}
			
			if (fStart <= start && fEnd >= end) {
				freeTimes.add(i + 1, start);
				freeTimes.add(i + 2, end);
				
				return true;
			}
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scanner.nextInt();
		
		for (int i1 = 1; i1 <= t; ++i1) {
			ArrayList<Integer> c = new ArrayList<>();
			ArrayList<Integer> j = new ArrayList<>();
			c.add(0);
			c.add(1440);
			j.add(0);
			j.add(1440);
			int n = scanner.nextInt();
			StringBuilder stringBuilder = new StringBuilder();
			
			for (int i = 0; i < n; ++i) {
				int start = scanner.nextInt();
				int end = scanner.nextInt();
				
				boolean found = addFreeTime(start, end, c);
				
				if (found) {
					stringBuilder.append("C");
				} else {
					found = addFreeTime(start, end, j);
					if (found) {
						stringBuilder.append("J");
					} else {
						stringBuilder.delete(0, stringBuilder.length());
						stringBuilder.append("IMPOSSIBLE");
						break;
					}
				}
				
			}
			
			System.out.println("Case #" + i1 + ": " + stringBuilder.toString());
		}
	}
}