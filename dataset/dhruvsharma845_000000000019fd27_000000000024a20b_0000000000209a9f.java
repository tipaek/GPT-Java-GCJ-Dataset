import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int T = fr.nextInt();

		for(int k = 0; k < T; k++) {
			String s = fr.next();

			StringBuilder sb = new StringBuilder();
			int firstNum = Integer.parseInt(String.valueOf(s.charAt(0)));
			int lastNum = Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));

			while(firstNum > 0) {
				sb.append('(');
				firstNum--;
			}
			for(int i = 0; i < s.length(); i++) {
				sb.append(s.charAt(i));
				int num1 = Integer.parseInt(String.valueOf(s.charAt(i)));
				char paren = '@';
				int diff = -1;
					
				if(i < s.length() - 1) {
					int num2 = Integer.parseInt(String.valueOf(s.charAt(i+1)));
					if(num1 > num2) {
						paren = ')';
					}
					else if(num1 < num2){
						paren = '(';
					}
					diff = Math.abs(num1 - num2);	
				}
				else {
					paren = ')';
					diff = num1;
				}
				while(diff > 0) {
					sb.append(paren);
					diff--;
				}
			}

			System.out.println("Case #" + (k+1) + ": " + sb.toString());
		}

	}

	static class FastReader { 
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