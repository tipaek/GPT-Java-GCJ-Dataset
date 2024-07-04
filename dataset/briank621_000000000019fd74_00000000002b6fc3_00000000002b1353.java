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
			if(n == 501){
				sb.append("2 2\n");
				sb.append("3 2\n");
				step = 3;
			}
			while(step < n){
				if(step % 2 == 1)
					sb.append("2 2\n");
				else
					sb.append("1 1\n");
				step++;
			}
			System.out.printf("Case #%d:\n%s", numCases, sb.toString());
		}

		
		br.close();
	}

}