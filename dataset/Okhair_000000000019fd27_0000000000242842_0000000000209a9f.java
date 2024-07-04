import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		PrintWriter out= new PrintWriter(System.out);
		int t=sc.nextInt();
		int testnum=1;
		while(t-->0) {
			String s=sc.next();
			StringBuilder sb= new StringBuilder();
			int count=0;
			for(int i=0;i<s.length();i++) {
				int x=s.charAt(i)-'0';
				while(count<x) {
					sb.append("(");
					count++;
				}
				while(count>x) {
					sb.append(")");
					count--;
				}
				sb.append(x);
			}
			while(count-->0)
				sb.append(")");
			out.printf("Case #%d: %s%n", testnum++, sb);
		}
		out.close();
	}

}
