import java.util.*;
import java.io.*;

class Solution{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int numCases = 1; numCases <= t; numCases++){
			String s = br.readLine();
			int lc = 0;

			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < s.length(); i++){
				int n = s.charAt(i) - '0';
				while(lc < n){
					sb.append("(");
					lc++;
				}
				while(lc > n){
					sb.append(")");
					lc--;
				}
				sb.append(n);
			}

			for(int i = 0; i < lc; i++)
				sb.append(")");

			System.out.println(sb);

		}
	
		
		br.close();
	}

}