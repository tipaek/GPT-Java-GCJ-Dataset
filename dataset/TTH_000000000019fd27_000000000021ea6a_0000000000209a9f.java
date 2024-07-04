

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			StringBuilder temp = new StringBuilder();
			char[] input = br.readLine().toCharArray();
			int n = input.length;
			int open = 0;
			for(int j=0; j<n; j++) {
				int curr = input[j] - '0';
				while(curr > open) {
					temp.append("(");
					open++;
				}
				while(curr < open) {
					temp.append(")");
					open--;
				}
				temp.append(curr);
			}
			while(open>0) {
				temp.append(")");
				open--;
			}
			
			sb.append("Case #"+(i+1)+": "+temp+"\n");
		}
		System.out.print(sb.toString());
	}

}
