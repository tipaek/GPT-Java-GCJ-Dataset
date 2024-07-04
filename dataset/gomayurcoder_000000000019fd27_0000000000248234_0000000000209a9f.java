import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = s.nextInt();
		for(int ti=1;ti<=t;ti++)
		{
			String str = s.next();
			StringBuilder sb = new StringBuilder();
			int p = 0;
			for(int i=0;i<str.length();i++) {
				int val = str.charAt(i)-'0';
				while(p<val) {
					sb.append('(');
					p++;
				}
				while(p>val) {
					sb.append(')');
					p--;
				}
				sb.append(str.charAt(i));
			}
			while(p!=0) {
				sb.append(')');
				p--;
			}
			
			String ans = sb.toString();
			System.out.println("Case #"+ti+": "+ans);
		}
	}
}