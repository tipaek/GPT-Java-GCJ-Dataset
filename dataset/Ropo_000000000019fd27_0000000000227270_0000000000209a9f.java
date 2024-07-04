// package Qualification_Round;

import java.io.*;
import java.util.*;

public class Solution {  
    public static void main(String[] args) {
        FastReader in = new FastReader();
        
        int numTrials = in.nextInt();
        for(int caseNum = 1; caseNum <= numTrials; caseNum++) {
            StringBuffer str = new StringBuffer(in.next());
            
            ArrayDeque<Integer> parenthesis = new ArrayDeque<Integer>();
            int currLvl = 0;
            for(int i = 0; i < str.length(); i++) {
                int currNum = Integer.parseInt(str.substring(i, i + 1));
                
                if(currNum > currLvl) {
                    for(int j = currLvl; j < currNum; j++) {
                        parenthesis.add(i);
                    }
                    
                    currLvl = currNum;
                }
                else if(currNum < currLvl) {
                    for(int j = currNum; j < currLvl; j++) {
                        parenthesis.add(-i);
                    }
                    
                    currLvl = currNum;
                }
            }
            
            while(currLvl > 0) {
                parenthesis.add(-(str.length()));
                currLvl--;
            }
            
            int lastTaken = 0;
            StringBuilder s = new StringBuilder();
            while(!parenthesis.isEmpty()) {
                int next = parenthesis.poll();
                
                if(next >= 0) {
                    s.append(str.substring(lastTaken, next) + "(");
                    lastTaken = next;
                }
                else {
                    s.append(str.substring(lastTaken, -next) + ")");
                    lastTaken = -next;
                }
            }
            s.append(str.substring(lastTaken, str.length()));
            
            System.out.println(s.toString().trim());
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
