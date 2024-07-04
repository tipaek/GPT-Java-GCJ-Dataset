

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0;i<t;i++) {
			int n = sc.nextInt();
			String [] p = new String[n];
			sc.nextLine();
			for (int j = 0;j<n;j++)
			{
				p[j]=sc.nextLine();
			}
			
			boolean endingsMatch = true;
			boolean startsMatch = true;
			String start = "";
			for (int j = 0;j<n;j++) {
				String str = p[j];
				if (str.charAt(0)=='*') continue;
				String beg = str.substring(0, str.indexOf('*'));
				String big = start;
				String small = beg;
				if (start.length()<beg.length()) {
					big = beg;
					small = start;
				}
				if (big.contains(small)) {
					start = big;
					p[j]=str.substring(str.indexOf('*'));
				} else {
					startsMatch = false;
					break;
				}
			}
			
			String end = "";
			for (int j = 0;j<n;j++) {
				String str = p[j];
				if (str.charAt(str.length()-1)=='*') continue;
				String beg = "";
				if (str.length()>str.lastIndexOf('*')+1) beg = str.substring(str.lastIndexOf('*')+1);
				String big = end;
				String small = beg;
				if (end.length()<beg.length()) {
					big = beg;
					small = end;
				}
				if (big.contains(small)) {
					end = big;
					if (str.length()>str.lastIndexOf('*')+1)
						p[j] = str.substring(0,str.lastIndexOf('*')+1);
				} else {
					endingsMatch = false;
					break;
				}
			}
			
			if (startsMatch==false || endingsMatch==false) 
			{
				System.out.println("Case #"+(i+1)+": *");
				continue;
			}
			System.out.println("Case #"+(i+1)+": "+start+end);
		}
	}
}