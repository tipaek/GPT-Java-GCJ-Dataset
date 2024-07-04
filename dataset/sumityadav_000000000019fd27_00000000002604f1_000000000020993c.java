import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		InputReader sc = new InputReader(System.in);
		int t = sc.nextInt();
		int c = 1;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[][] dp = new int[n][n];
			for (int i = 0 ; i < n ; i++) {
				dp[i] = new int[n];
				for (int j = 0 ; j < n ; j++) {
					dp[i][j] = sc.nextInt();
				}
			}
			int trace = 0, rs = 0, cs = 0;
			for (int i = 0 ; i < n ; i++) {
				int[] row = new int[n+1];
				int[] col = new int[n+1];
				boolean rb = true, cb = true;
				for (int j = 0 ; j < n ; j++) {
					if (i == j) {
						trace += dp[i][j];
					}
					if (row[dp[i][j]] != 0) {
						rb = false;
					}else {
						row[dp[i][j]] += 1;
					}
					if (col[dp[j][i]] != 0) {
						cb = false;
					}else {
						col[dp[j][i]] += 1;
					}
				}
				if (!rb) rs += 1;
				if (!cb) cs += 1;
			}
			sb.append("Case #"+c+": "+trace+" "+rs+" "+cs+"\n");
			c += 1;
		}
		System.out.println(sb.toString());
	}
	
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
        
        public InputReader(InputStream in){
        	try {
        		br = new BufferedReader(new
        				InputStreamReader(in)); 
        	}catch (Exception e) {
        		System.out.println(e.toString());
        	}
        }
        
        String next(){
        	while (st == null || !st.hasMoreElements()){
        		try{
        			st = new StringTokenizer(br.readLine()); 
                }catch (IOException  e){
                	e.printStackTrace(); 
                }
            }
            return st.nextToken(); 
        }
        
        int nextInt(){
        	return Integer.parseInt(next()); 
        }
        
        long nextLong(){
        	return Long.parseLong(next()); 
        }
        
        double nextDouble(){
        	return Double.parseDouble(next()); 
        }
        
        String nextLine(){
        	String str = "";
        	try{
        		str = br.readLine();
        	}catch (IOException e){
        		e.printStackTrace(); 
            }
            return str; 
        }
    }
}
