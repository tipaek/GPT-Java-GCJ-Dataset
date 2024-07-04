import java.util.*;
import java.io.*;



public class Solution {
	public int trace;
	public int repCol;
	public int repRow;
	public static int [][] matrix;
	public ArrayList<Integer> r;
	public ArrayList<Integer> c;
	
	public void refresh() {
		trace = 0;
		repCol = 0;
		repRow = 0;
		
	}
	
	public void trace() {
		for(int i= 0; i < matrix.length; i++) {
			trace += matrix[i][i];
		}
	}
	
	public void repeats() {
		for(int i = 0; i < matrix.length; i++) {
			r = new ArrayList<>();
			c = new ArrayList<>();
			r.add(matrix[i][0]);
			c.add(matrix[0][i]);
			boolean rc = false;
			boolean rr = false;
			for(int j = 1; j < matrix.length; j++) {
				if(!rr && r.contains(matrix[i][j])) {
					repRow++;
					rr = true;
				}else if(!rr){
					r.add(matrix[i][j]);
				}
				if(!rc && c.contains(matrix[j][i])) {
					repCol++;
					rc = true;
				}else if(!rc) {
					c.add(matrix[j][i]);
				}
				
			}
			
		}
	}
	
	public void solve() {
		refresh();
		trace();
		repeats();
	}
	
	public void printResult(int i) {
		System.out.println("Case #" + i + ": " + trace + " " + repRow + " " + repCol);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Solution s = new Solution();
        for (int i = 0; i < total; ++i) {
        	
          int matrixSize = in.nextInt();
          matrix = new int[matrixSize][matrixSize];
          for(int j = 0; j < matrixSize; j++) {
        	  for(int k = 0; k < matrixSize; k++) {
        		  int a = in.nextInt();
            	  matrix[j][k] = a;
        	  }
          }
         s.solve();
         s.printResult((i+1));
        }

	}

}
