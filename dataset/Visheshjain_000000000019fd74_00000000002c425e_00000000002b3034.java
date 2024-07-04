
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = s.nextLong();
		int pint = 1;
		while (t-- > 0) {
			int n = s.nextInt();
			String[] ar = new String[n];
			String pre = "";
			String suf = "";
			boolean fin_ans = true;
			for (int i = 0; i < n; i++) {
				String cur = s.next();
				String p = "";
				String as = "";
				int k = 0;
				for (k = 0; k < cur.length(); k++) {
					if (cur.charAt(k) == '*') {
						break;
					}
					p += cur.charAt(k);
				}
				k++;
				as = cur.substring(k);
				boolean lans = check(p, pre);
				if(lans) {
					if(p.length() > pre.length())
						pre = p;
				}
				
				boolean rans = check2(suf,as );
				if(rans) {
					if(as.length() > suf.length())
						suf = as ;
				}
				if(!lans || !rans) {
					
					fin_ans = false;
				}
				
			}
			System.out.print("Case #"+pint+": ");
			pint++;
			if(fin_ans) {
				
				System.out.println(pre+suf);
			}else {
				System.out.println("*");
				
			}
		}
	}
public static boolean check(String a , String b) {
	int i = 0 ;
	int j = 0 ;
	while(i < a.length() && j < b.length()) {
		if(a.charAt(i) != b.charAt(j))
			return false;
		i++;
		j++;
		
	}
	return true;
}
public static boolean check2(String a , String b) {
	int i = a.length()-1 ;
	int j = b.length()-1 ;
	while(i >=0  && j >=0 ) {
		if(a.charAt(i) != b.charAt(j))
			return false;
		i--;
		j--;
		
	}
	return true;
}
}



