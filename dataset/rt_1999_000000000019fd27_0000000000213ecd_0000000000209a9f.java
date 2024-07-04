import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t =  sc.nextInt();
		int  o =0;
		while(t-->0){
			o++;
			String st = sc.next();
			int n = st.length();
			int open  = 0;
			StringBuilder sb = new StringBuilder();
			int d = st.charAt(0)-'0';
			for(int i=1;i<=d;i++)
				sb.append("(");
			sb.append(d);
			open+=d;
			for(int i=1;i<n;i++){
				int val = st.charAt(i)-'0';
				int prev = st.charAt(i-1)-'0';
				if(val==prev)
					sb.append(val);
				else if(val<prev){
					int diff = Math.abs(val-prev);
					open-=diff;
					for(int j=1;j<=diff;j++)
						sb.append(")");
					sb.append(val);
				}else{
					int diff = Math.abs(val-prev);
					open+=diff;
					for(int j=1;j<=diff;j++)
						sb.append("(");
					sb.append(val);
				}
			}
			for(int i=1;i<=open;i++)
				sb.append(")");
			System.out.println("Case #"+o+": "+sb.toString());
		}
	}
} 