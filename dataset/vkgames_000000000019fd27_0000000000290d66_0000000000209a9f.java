
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		//subtask 1
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t= sc.nextInt();
		for(int i=0;i<t;i++) {
			String s = sc.next();
			String ret = "";
			int l=0;
			int r = 0;
			while(r<s.length()) {

				if(s.charAt(l)=='0') {
					l++;
					r++;
					ret+="0";
				}
				else {
					while(r<s.length() && s.charAt(r)=='1') {
						r++;
					}
					r--; //add paranthesis
					String add = "(";
					for(int j=l;j<=r;j++) {
						add+="1";
					}
					add+=")";
					ret+=add;
					r++;
					l=r;
				}
			}
			System.out.println(ret);
		}
	}
}
