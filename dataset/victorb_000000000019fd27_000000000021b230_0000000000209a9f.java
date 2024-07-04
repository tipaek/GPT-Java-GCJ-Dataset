import java.util.*;

public class Solution {
	

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);	
		for(int tNum = sc.nextInt(), tCurr = 1; tCurr <= tNum; tCurr++ ) {			
			String s = sc.next();
			
			int cnt = 0;
			StringBuilder result = new StringBuilder();
			for(char c : s.toCharArray()) {
				int d = c - '0';
				int diff = d - cnt;
				if (diff != 0) {
					char[] arr = new char[Math.abs(diff)];
					Arrays.fill(arr, diff > 0 ? '(' : ')');
					result.append(arr);
					cnt += diff;
				}					
				result.append(c);
				
			}
			

			int diff = 0 - cnt;
			if (diff != 0) {
				char[] arr = new char[Math.abs(diff)];
				Arrays.fill(arr, diff > 0 ? '(' : ')');
				result.append(arr);
				cnt += diff;
			}					

			
			
			System.out.println(String.format("Case #%d: %s", tCurr, result));					
			
			
		}
		System.out.flush();
		
	}
	
}
