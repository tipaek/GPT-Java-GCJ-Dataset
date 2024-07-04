import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Solution{
 
	public static void main(String args[]) throws Exception{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		new Solution().solve(br,pw);
		br.close();
		pw.flush();
		pw.close();
		System.exit(0);
	}
 
	void solve(BufferedReader br,PrintWriter pw) throws Exception{
		
		int T = Integer.parseInt(br.readLine());	
		for(int i = 0;i < T;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			String M = st.nextToken();
			int count = 0;
			int X1 = 1001;
			int Y1 = 1001;
			boolean flag = false;
			int max = Integer.MIN_VALUE;
			for(int j = 0;j < M.length();j++){
				count++;
				if(M.charAt(j) == 'S'){
					Y = Y-1;
				}
				else if(M.charAt(j) == 'N'){
					Y = Y+1;
				}
				if(count >= Math.abs(Y)+X){
					
					flag = true;
					break;
				}
			}
			if(flag){
				pw.println("Case #" + (i+1) + ": "+count);
			}
			else{
				pw.println("Case #" + (i+1) + ": IMPOSSIBLE");
			}
			
			
		}
		
		
		

	}
}


