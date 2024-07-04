// package qualificaitonRound2020;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner; 
import java.util.StringTokenizer; 
public class Solution {
	public static boolean rowCheck(int[][] arr ,int row) {
		int[] map = new int[101];
		for(int i = 0 ; i < arr.length ; i++) {
			if(map[arr[row][i]] == 1) return true;
			map[arr[row][i]] = 1;
		}
		return false;
	}
	public static boolean columnCheck(int[][] arr ,int column) {
		int[] map = new int[101];
		for(int i = 0 ; i < arr.length ; i++) {
			if(map[arr[i][column]] == 1) return true;
			map[arr[i][column]] = 1;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader s=new FastReader(); 
        int t = s.nextInt(); 
        for(int m = 0 ; m < t ; m++) {
        	int n = s.nextInt();
        	int[][] arr =  new int[n][n];
        	for(int i = 0 ; i < n ; i++) {
        		for(int j = 0 ; j < n ; j++) {
        			arr[i][j] = s.nextInt();
        		}
        	}
        	int trace = 0;
        	int row = 0;
        	int column = 0;
        	for(int i = 0 ; i < n ; i++) trace += arr[i][i];
        	for(int i = 0 ; i < n ; i++) {
        		if(rowCheck(arr,i)) row++;
        	}
        	for(int i = 0 ; i < n ; i++) {
        		if(columnCheck(arr,i)) column++;
        	}
        	System.out.println("Case #"+(m+1)+": "+trace+" "+row+" "+column);
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
