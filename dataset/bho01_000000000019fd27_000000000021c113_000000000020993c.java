import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 

public class Solution {
	
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
	
	public static void main(String args[]) {
		FastReader in = new FastReader();
		int t = in.nextInt();
		
		for(int i = 0; i < t; i++) {
			int size = in.nextInt();		
			int[][] matrix = new int[size][];
			
			for(int j = 0; j < size; j++) {
				FastReader inStr = new FastReader();
				String row = inStr.nextLine();
				matrix[j] = converter(row, size);
			}
			int k = trace(matrix);
			int r = rows(matrix);
			int c = cols(matrix);
			System.out.println("Case #" + (i + 1) + ": " + (k) + " " + (r) + " " + (c));		
		}
	}
	
	public static int trace(int[][] mat) {
		int sum = 0;
		
		for(int i = 0; i < mat.length; i++) {
			sum += mat[i][i];
		}
		
		return sum;
	}
	
	public static int rows(int[][] mat) {
		int counter = 0;
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				boolean checker = false;
				for(int k = j + 1; k < mat[i].length; k++) {
					if(mat[i][j] == mat[i][k]) {
						//System.out.println("rows ran inner");
						counter++;
						checker = true;
						break;
					}
				}
				if(checker) {
					break;
				}
			}
		}
		
		return counter;
	}
	
	public static int cols(int [][] mat) {
		int counter = 0;
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				boolean checker = false;
				for(int k = j + 1; k < mat.length; k++) {
					if(mat[j][i] == mat[k][i]) {
						counter++;
						checker = true;
						break;
					}
				}
				if(checker) {
					break;
				}
			}
		}
		
		return counter;
	}
	
	public static int[] converter(String yoink, int size) {
		int[] arr = new int[size];
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(yoink);
		int k = 0;
        while(m.find() && k < size) {
            arr[k] = Integer.parseInt(m.group());
        }
		return arr;
	}
	
}