import java.util.*;
import java.io.*;

class Solution{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int numCases = 1; numCases <= t; numCases++){
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("1 1\n");
			int step = 1;
			int next = 2;
			if(n == 1000 || n == 999){
				sb.append("2 2\n");
				sb.append("3 3\n");
				if(n == 999)
					sb.append("4 3\n");
				sb.append("4 4\n");
				if(n == 1000)
					sb.append("5 4\n");
				sb.append("5 5\n");
				for(int i = 6; i <= 498; i++){
					sb.append(String.format("%d %d\n", i, i));
				}
				sb.append("499 498\n");
			}
			else if(500 < n && n <= 998){
				int diff = n - 499;
				// appears in diff + 1th row
				for(int i = 2; i <= diff; i++){
					sb.append(String.format("%d %d\n", i, i));
				}
				sb.append(String.format("%d %d\n", diff + 1, diff));
				for(int i = diff + 1; i <= 499; i++){
					sb.append(String.format("%d %d\n", i, i));
				}
			}
			else{
				while(step < n){
					sb.append(String.format("%d %d\n", next, next));
					next++;
					step++;
				}
			}
			System.out.printf("Case #%d:\n%s", numCases, sb.toString());
		}

		
		br.close();
	}

}