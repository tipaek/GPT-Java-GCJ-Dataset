// package Qualification_Round;

import java.io.*;
import java.util.*;

public class Solution {  
    public static void main(String[] args) {
        FastReader in = new FastReader();
        
        int numTrials = in.nextInt();
        for(int caseNum = 1; caseNum <= numTrials; caseNum++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];
            
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            
            int rowsRep = 0;
            for(int i = 0; i < size; i++) {
                HashSet<Integer> contained = new HashSet<Integer>();
                for(int j = 0; j < size; j++) {
                    int next = matrix[i][j];
                    if(contained.contains(next)) {
                        rowsRep++;
                        break;
                    }
                    else {
                        contained.add(next);
                    }
                }
            }
            
            int colsRep = 0;
            for(int i = 0; i < size; i++) {
                HashSet<Integer> contained = new HashSet<Integer>();
                for(int j = 0; j < size; j++) {
                    int next = matrix[j][i];
                    if(contained.contains(next)) {
                        colsRep++;
                        break;
                    }
                    else {
                        contained.add(next);
                    }
                }
            }
            
            int trace = 0;
            for(int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowsRep + " " + colsRep);
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
