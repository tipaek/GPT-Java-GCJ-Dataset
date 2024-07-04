package googlecodejamA;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		//subtask 1
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t= sc.nextInt();
		for(int i=0;i<t;i++) {
			String s = sc.next();
			int [] l = new int[s.length()];
			int [] r = new int[s.length()];
			l[0] = Integer.parseInt(s.substring(0,1));
			for(int j=1;j<s.length();j++) {
				int a = Integer.parseInt(s.substring(j-1,j));
				int b = Integer.parseInt(s.substring(j,j+1));
				if(b>a) l[j] = b-a;
			}
			for(int j=0;j<s.length()-1;j++) {
				int a = Integer.parseInt(s.substring(j,j+1));
				int b = Integer.parseInt(s.substring(j+1,j+2));
				if(a>b) r[j] = a-b;
			}
			r[s.length()-1] = Integer.parseInt(s.substring(s.length()-1,s.length()));
			String ret = "";
			for(int j=0;j<s.length();j++) {
				for(int k=0;k<l[j];k++) {
					ret+="(";
				}
				ret+=s.substring(j,j+1);
				for(int k=0;k<r[j];k++) {
					ret+=")";
				}
			}
			System.out.println("Case #"+(i+1)+":"+" "+ret);
		}
	}
}
