import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < T; i++) {
			String s = sc.nextLine();
			System.out.println("Case #"+(i+1)+": "+solve(s));
		}
	}
	
	public static String solve(String s) {
		String solution = "";
		int nbOpen = 0;
		for(int i = 0; i < s.length(); i++) {
			int val = Integer.valueOf(s.charAt(i))-48;
			int diff = val - nbOpen; 
			if(diff > 0) {
				for(int j = 0; j < diff; j++) {
					solution += "(";
					nbOpen ++;
				}
			} else {
				diff = - diff; 
				for(int j = 0; j < diff; j++) {
					solution += ")";
					nbOpen --;
				}
			}
			solution += Integer.toString(val);		
		}	
		for(int i = 0; i < nbOpen; i++) {
			solution += ')';
		}
		return solution;
	}

}
