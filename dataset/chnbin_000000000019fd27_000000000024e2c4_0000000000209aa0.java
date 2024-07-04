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
			String res = "POSSIBLE";
			int n = sc.nextInt();
			int K = sc.nextInt();
			Set<Integer> set = new HashSet<>();
			
			if (n % 2 != 0) {
				for (int j = 1; j <=n; j++) {
					set.add(j * n);
				}
				
				set.add(((1 + n) * n) / 2);
				
				if (!set.contains(K)) {
					res = "IMPOSSIBLE";
				}
			} else {
				for (int k = 1; k <= n; k++) {
					set.add(k * n);
				}
				
				if (!set.contains(K)) {
					res = "IMPOSSIBLE";
				}
			}
			
			
			System.out.println("Case #" + i + ": " + res);
		}
		sc.close();
	}
	
	public static class TimeSlot {
		public int startTime;
		public int endTime;
		public int index;
		
		public TimeSlot(int sTime, int eTime, int idx) {
			startTime = sTime;
			endTime = eTime;
			index = idx;
		}
	}
}
