import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static String sout;
	
	
	private static int getDigit(String s, int i) {
		return 	Character.getNumericValue(s.charAt(i));
	}
	
	private static int[] find(String s) {
		
		int max = -1;
		int imax = -1;
		for(int i = 0; i < s.length(); i++) {
			int number = getDigit(s, i);
			
			if(max < number) {
				max = number;
				imax = i;
			}
		}
		
		if(max == 0) {
			return null;
		}
		
		int j = imax + 1;
		
		while(j < s.length()) {
			int number = getDigit(s, j);
			if(number != -1 && number < max) {
				break;
			}
			j++;
		}
		return new int[] {imax, j, max};
	}
	
	
	
	
	private static String testCase(Scanner in) {
		sout = in.next();
		
		String s = sout;
		
		do {
			int[] p = find(s);
			
			if(p == null) {
				
				String output = "";
				for(int i = 0, j =0; i < s.length(); i++) {
					if(getDigit(s, i) == 0) {
						output += getDigit(sout, j);
						j++;
					}else {
						output += s.charAt(i);
					}
				}
				return output;
			}else {
				int ll = p[1]-p[0];
				String s1 = "";
				for(int i = 0; i < ll; i++) {
					int d = getDigit(s, p[0]+i);
					if(d == -1) {
						s1+= s.charAt( p[0]+i);
					}else {
						s1+=String.valueOf(d-1);
					}
				}

				s = s.substring(0, p[0]) + "(" + s1 + ")" + s.substring(p[1]);
			}
			
		}while(true);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; i++) {
			System.out.println("Case #"+ i + ": "+  testCase(in));
		}
		
//		System.out.println(testCase(in));
		
//		String s = "((0(0)0))";
//		int[] p = find(s);
//		
//		int ll = p[1]-p[0];
//		String s1 = "";
//		for(int i = 1; i < ll; i++) {
//			int d = getDigit(s, p[0]+i);
//			if(d == -1) {
//				s1+= s.charAt(p[0]+i);
//			}else {
//				s1+=String.valueOf(d-1);
//			}
//		}
//		
//		System.out.println(s.substring(0, p[0]) + "(" + s1 + ")" + s.substring(p[1]));
//		
//		
	}
}
