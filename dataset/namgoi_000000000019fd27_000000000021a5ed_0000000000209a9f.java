import java.util.*;
import java.io.*;

public class Solution {
//public class codejam1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <=T; testcase++) {
			int cur=0;
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				int strint = str.charAt(i)-'0';
				if(strint>cur) {
					for (int j = cur; j < strint; j++) {
						sb.append("(");		
					}
					cur=strint;
				}else if(strint<cur) {
					for (int j = cur; j > strint; j--) {
						sb.append(")");		
					}
					cur=strint;
				}
				sb.append(strint);
			}
			for (int j = cur; j > 0; j--) {
				sb.append(")");		
			}
			System.out.println(sb);
		}
	}
}