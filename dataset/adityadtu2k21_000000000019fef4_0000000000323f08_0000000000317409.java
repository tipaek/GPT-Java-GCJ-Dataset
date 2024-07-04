// package april2020;

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Solution {
//	static int n, cost[];
	static String M;
	static HashMap<String, Integer> dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader scn = new FastReader();
		
		int tc = scn.nextInt();
		
		for(int t = 1;t<=tc;t++) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			
			
			M = scn.next();
			dp = new HashMap<>();
			int ans = dfs(x,y,0);
			System.out.print("Case #"+t+": ");
			if(ans!=Integer.MAX_VALUE) {
				System.out.println(ans);
			}else {
				System.out.println("IMPOSSIBLE");
			}
		}
		
	}
	static int dfs(int x, int y, int cur) {
		String c = x+" "+y+" "+cur;
		
		if(dp.containsKey(c)) {
			return dp.get(c);
		}
		if(cur>=M.length()&&(x!=0||y!=0)) {
			dp.put(c, Integer.MAX_VALUE);
			return Integer.MAX_VALUE;
		}
		if(x==0&&y==0) {
			return cur;
		}
		char dir = M.charAt(cur);
		int xp = x, yp = y;
		if(dir=='N'||dir=='S') {
			yp+=(dir=='N')?1:-1;
		}else {
			xp+=(dir=='E')?1:-1;
		}
		
		//move
		int move=-1;
		if(Math.abs(xp)>Math.abs(yp)) {
			if(xp>0) {
				move=dfs(xp-1,yp,cur+1);
			}else {
				move = dfs(xp+1,yp,cur+1);
			}
		}else {
			if(yp>0) {
				move =dfs(xp,yp-1,cur+1);
			}else {
				move = dfs(xp,yp+1,cur+1);
			}
		}
		//dm
		int dm = dfs(xp,yp,cur+1);
		
		dp.put(c, Math.min(move, dm));
		return dp.get(c);
	}
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }


}
