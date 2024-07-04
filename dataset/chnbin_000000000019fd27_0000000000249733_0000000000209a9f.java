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
			String str = sc.next();
			String res = "";
			
			LinkedList<String> stack = new LinkedList<>();
			
			for (char c: str.toCharArray()) {
				if (c == '0') {
					if (stack.size() == 0) {
						res += c;
					} else {
						res += ("("+ stack.pop() +")" + c);
					}
				} else {
					if (stack.size() == 0) {
						stack.push("" + c);
					} else {
						stack.push(stack.pop() + c);
					}
				}
			}
			
			if (stack.size() != 0) {
				res += ("(" + stack.pop() + ")");
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
