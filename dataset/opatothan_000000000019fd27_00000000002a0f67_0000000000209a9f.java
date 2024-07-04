import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		for(int z = 0;z < N; z++) {
			String[] input = br.readLine().split("");
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i< input.length; i++) {
				int n = Integer.parseInt(input[i]);
				for(int j = 0; j< n; j++) {
					sb.append("(");
				}
				sb.append(input[i]);
				for(int j = 0; j< n; j++) {
					sb.append(")");
				}
			}
			
			
			
			
			String temp = sb.toString();
			while(temp.contains(")(")) {
				int index = temp.indexOf(")(");
				sb.delete(index, index+2);
			
				temp = sb.toString();
			}
			
			System.out.println("Case #"+(z+1)+": "+temp );
		}
	}

}
