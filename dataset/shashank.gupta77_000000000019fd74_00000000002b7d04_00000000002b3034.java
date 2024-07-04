/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int tc=1;tc<=t;++tc) {
			int n = scan.nextInt();
			String[] arr = new String[n];
			for(int i=0;i<n;++i) {
				arr[i] = scan.next();
			}
		    String ans = String.format("Case #%d: %s", tc, solve(arr));
		    System.out.println(ans);
		}
	}
	
	static String solve(String[] arr) {
		String commonStart = "";
		String commonEnd = "";
		for(String str : arr) {
			String[] split = str.split("\\*");
			String start = split[0];
			String end = str.substring(str.lastIndexOf("*") + 1, str.length());
			
			if(!isEmpty(start)) {
				if(isEmpty(commonStart)) {
					commonStart = start;
				} else {
					if(exists(start, commonStart)) {
						commonStart = start.length() < commonStart.length() ? start : commonStart;
					} else {
						return "*";
					}
				}
			}
			
			if(!isEmpty(end)) {
				if(isEmpty(commonEnd)) {
					commonEnd = end;
				} else {
					if(exists(end, commonEnd)) {
						commonEnd = end.length() < commonEnd.length() ? commonEnd : end;
					} else {
						return "*";
					}
				}
			}
		}
		return commonEnd;
	}
	
	static boolean isEmpty(String s) {
		return s == null || "".equals(s);
	}
	
	static boolean exists(String a, String b) {
		return a.indexOf(b) != -1 || b.indexOf(a) != -1;
	}
}