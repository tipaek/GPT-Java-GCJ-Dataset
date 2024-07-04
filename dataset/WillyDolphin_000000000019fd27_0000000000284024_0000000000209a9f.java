import java.util.*;
public class Solution {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			String raw = sc.next();
			System.out.println("Case #"+i+": "+solve(raw, 0));
		}
	}

	public static String solve(String raw, int outer) {
		if (raw.length() == 0) {
			return "";
		}
		// raw non-empty
		int midx = minIndex(raw);
		int min = raw.charAt(midx) - '0';
		String bef = solve(raw.substring(0,midx), min);
		String aft = solve(raw.substring(midx+1), min);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<min-outer; i++) {
			sb.append('(');
		}
		sb.append(bef);
		sb.append(raw.charAt(midx));
		sb.append(aft);
		for(int i=0; i<min-outer; i++) {
			sb.append(')');
		}
		return sb.toString();
	}
	
	public static int minIndex(String str) {
		int min = 10;
		// str non-empty
		for(char c : str.toCharArray()) {
			if(c-'0' < min) {
				min = c - '0';
			}
		}
		int idx = -1;
		for(char c: str.toCharArray()) {
			idx ++;
			if(c - '0' == min) {
				break;
			}
		}
		return idx;
	}
}


