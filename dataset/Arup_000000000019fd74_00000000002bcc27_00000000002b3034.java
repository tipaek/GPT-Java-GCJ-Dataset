// Arup Guha
// 4/10/2020

import java.util.*;

public class Solution {
	
	public static int n;

	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		
		// Process cases.
		for (int loop=1; loop<=nC; loop++) {
		
			n = stdin.nextInt();
			String[] words = new String[n];
			String[] rev = new String[n];
			int[] starCnt = new int[n];
			for (int i=0; i<n; i++) {
				words[i] = stdin.next();
				rev[i] = reverse(words[i]);
				starCnt[i] = numStars(words[i]); 
			}
			
			String pre = getPre(words);
			String post = getPre(rev);
			if (post != null) post = reverse(post);
			
			if (pre == null || post == null)
				System.out.println("Case #"+loop+": *");
			else {
				
				StringBuffer mid = new StringBuffer();
				for (int i=0; i<n; i++) {
					if (starCnt[i] > 1) {
						int sI = words[i].indexOf('*');
						int eI = rev[i].length()-1-rev[i].indexOf('*');
						for (int j=sI; j<=eI; j++)
							if (words[i].charAt(j) != '*')
								mid.append(words[i].charAt(j));
						
					}
					
				}
				
				System.out.println("Case #"+loop+": "+pre+mid+post);
			}
		}
	}
	
	public static String getPre(String[] words) {
		
		String longPre = "";
		
		for (int i=0; i<n; i++) {
			if (words[i].charAt(0) == '*') continue;
			
			int j = 0;
			while (words[i].charAt(j) != '*') j++;
			
			String thisPre = words[i].substring(0,j);
			
			if (thisPre.length() > longPre.length()) {
				if (!thisPre.substring(0, longPre.length()).equals(longPre))
					return null;
				else
					longPre = thisPre;
			}
			
			else {
				if (!longPre.substring(0, thisPre.length()).equals(thisPre))
					return null;
			}
			
		}
		
		return longPre;
		
	}
	
	public static String reverse(String s) {
		char[] res = new char[s.length()];
		for (int i=0; i<s.length(); i++)
			res[s.length()-1-i] = s.charAt(i);
		return new String(res);
	}
	
	public static int numStars(String s) {
		int res = 0;
		for (int i=0; i<s.length(); i++)
			if (s.charAt(i) == '*')
				res++;
		return res;
	}
}