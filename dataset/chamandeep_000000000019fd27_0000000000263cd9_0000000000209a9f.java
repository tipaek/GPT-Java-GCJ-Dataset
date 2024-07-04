//  package qualificaitonRound2020;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer; 
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader s=new FastReader(); 
        int t = s.nextInt(); 
        for(int m = 0 ; m < t ; m++) {
        	String S = s.next();
        	int count = 0;
        	int prev = 0;
        	Stack<Character> st = new Stack<>();
        	for(int i = 0 ; i < S.length() ; i++) {
        		int val = (S.charAt(i)-'0')-prev;
        		prev = (S.charAt(i)-'0');
        		if(val > 0) {
        			while(val > 0) {
        				st.push('(');
        				val--;
        			}
        			
        		}else if(val < 0){
        			val = val*-1;
        			while(val > 0) {
        				st.push(')');
        				val--;
        			}
        		}
    			st.push(S.charAt(i));
        	}
        	while(prev > 0) {
				st.push(')');
				prev--;
			}
        	String str = "";
        	while(!st.isEmpty()) {
        		str = st.pop()+str;
        	}
        	System.out.println("Case #"+(m+1)+": "+str);
        }
			
	}

	public static class FastReader 
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
