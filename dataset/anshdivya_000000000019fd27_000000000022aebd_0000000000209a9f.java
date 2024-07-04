import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FastReader s = new FastReader();
		
		int t = s.nextInt();
		
		for(int z = 1;z<=t;z++) {
			String str = s.next();
			int n = str.length();
			
			StringBuilder sb = new StringBuilder();
			int par = 0;
			
			for(int i=0;i<n;i++) {
				int val = str.charAt(i) - '0';
				
				while(par < val) {
					sb.append('(');
					par++;
				}
				
				while(par > val) {
					sb.append(')');
					par--;
				}
				
				sb.append(val);
			}
			
			while(par > 0) {
				sb.append(')');
				par--;
			}
			
			System.out.println("Case #"+z+": "+sb);
		}

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
