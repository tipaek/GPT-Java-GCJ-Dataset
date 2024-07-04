import java.util.*;
import java.math.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			testCase(scan, i + 1);
		}
	}

	public static void testCase(Scanner scan, int t) {
		String digits = scan.next();
		int toBeClosed = 0;
		for (int i = 0; i < digits.length(); i++) {
			int next = Integer.parseInt(""+digits.charAt(i));
	//		System.out.println("              DEBUG         :" + next);
			String pref = "";
			if(next>toBeClosed) {
				
				for(int j=0; j<next-toBeClosed; j++) {
					pref = pref + '(';
				}
				digits = digits.substring(0,i) + pref + digits.substring(i);
				i+= Math.abs(next-toBeClosed);
				toBeClosed = next;
			} else if(next<toBeClosed) {
				
				for(int j=0; j<toBeClosed-next; j++) {
					pref = pref + ')';
				}
				digits = digits.substring(0,i) + pref + digits.substring(i);
				i+= Math.abs(next-toBeClosed);
				toBeClosed = next;
				
			}
		}
		String endingSuffix = "";
		for(int j=0; j<toBeClosed; j++) {
			endingSuffix = endingSuffix + ')';
		}
		digits = digits + endingSuffix;
		System.out.println("Case #" + t + ": " + digits);
	}
}
