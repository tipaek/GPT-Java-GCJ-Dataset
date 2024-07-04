

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
//		System.out.println(fun("*XZ","*XYZ"));
		int t = Integer.parseInt(br.readLine());
		int t1 = t;
		
		while (t -- > 0) {
//			System.out.println(String.format("%0" + 3 + "d", 0).replace("0", "("));
			int n = Integer.parseInt(br.readLine());
			String ans = "*";
			
			for (int i = 0;i<n;i++) {
				ans = fun(ans,br.readLine());
//				System.out.println(ans);
			}
			
//			System.out.println("vfd");
			String ans1 = "";
			for (int i = 0;i<ans.length();i++) {
				if (ans.charAt(i) != '*') {
					ans1 = ans1 + ans.substring(i,i+1);
				}
			}
			if (ans1.equals("")) {
				ans1 = "*";
			}
			System.out.println("Case #" + (t1-t) + ": "+ans1);
		}
    }
	public static String fun(String A, String B) {
		String ans = "";
		int i = 0;
		int j = 0;
		String a = "";
		String b = "";
		boolean flagA = false;
		boolean flagB = false;
		while (i < A.length() || j < B.length()) {
			if (i<A.length() && j < B.length()) {
				if (A.charAt(i) == '*' && B.charAt(j) == '*') {
					if(flagA || flagB) {
						if (flagA) {
							ans = ans + b + a + "*";
						}
						else {
							ans = ans + a + b + "*";
						}
						
						i++;
						j++;
						a = "";
						b = "";
					}
					else {
						if (!a.equals("") && !b.equals("")) {
//							System.out.println("1");
							return "";
						}
						else if(!a.equals("")) {
							ans = ans + a + "*";
							a = "";
							i++;
							j++;
						}
						else {
							ans = ans + b + "*";
							b = "";
							i++;
							j++;
						}
					}
					flagA = true;
					flagB = true;
				}
				else if(A.charAt(i) == '*') {
					if(flagA) {
						ans = ans + b + B.substring(j,j+1);
						b = "";
					}
					else {
						flagA = true;
						b = b + B.substring(j,j+1);
						j++;
					}
					
				}
				else if (B.charAt(j) == '*') {
					if(flagB) {
						ans = ans + a + A.substring(i,i+1);
						a = "";
					}
					else {
						flagB = true;
						a = a + A.substring(i,i+1);
						i++;
					}
					
				}
//				else if (A.charAt(i) == B.charAt(j)) {
//					if (a.equals("") && b.equals("")) {
//						ans = ans + A.substring(i,i+1);
//					}
//					else {
//						a = a + A.substring(i,i+1);
//						b = b + B.substring(j,j+1);
//					}
//					i++;
//					j++;
//				}
				else {
					a = a + A.substring(i,i+1);
					b = b + B.substring(j,j+1);
					i++;
					j++;
				}
			}
			else if(i<A.length()) {
				if (A.charAt(i) == '*') {
					if(flagB) {
						ans = ans + a + b;
						a = "";
						b = "";
						i++;
					}
					else {
//						System.out.println("2");
						return "";
					}
				}
				else {
					a = a + A.substring(i,i+1);
					i++;
				}
				
			}
			else if(j<B.length()) {
				if (B.charAt(j) == '*') {
					if(flagA) {
						ans = ans + b + a;
						a = "";
						b = "";
						j++;
					}
					else {
//						System.out.println("3");
						return "";
					}
				}
				else {
					b = b + B.substring(j,j+1);
					j++;
				}
			}
//			System.out.println(a + " " + b);
		}
		if (a.length() < b.length()) {
			if (a.equals(b.substring(b.length()-a.length())) && flagA) {
				ans = ans + b;
			}
		}
		else {
			if (b.equals(a.substring(a.length()-b.length())) && flagB) {
				ans = ans + a;
			}
		}
//		System.out.println("4");
		return ans;
	}
}
