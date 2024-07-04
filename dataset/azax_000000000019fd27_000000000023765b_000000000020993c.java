import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
    	 Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
     int numCases = Integer.parseInt(sc.nextLine());
     for (int index = 0; index < numCases; index++) {
    	 	int size = Integer.parseInt(sc.nextLine());
    	  	int trace = 0;
    	  	int[][] m = new int[size][size];
    	  	for (int a = 0; a < size; a++) {
    	  		String[] line = sc.nextLine().split(" ");
    	  		
    	  		for (int b = 0; b < size; b++) {
    	  			m[a][b] = Integer.parseInt(line[b]);
	  		}
    	  		trace += m[a][a];
    	  	}
    	  	
    	  	int[] badNums = checkMatrix(m);
    	  	int r = badNums[0];
    	  	int c = badNums[1];
    	  	System.out.println("Case #" + (index + 1) + ": " + trace + " " + r + " " + c);
        }
        sc.close();
    }

    private static int[] checkMatrix(int[][] m) {
        int badRows = 0;
        int badCols = 0;
    
        for (int i = 0; i < m.length; i++) {
            boolean[] seen = new boolean[m.length];
            for (int j = 0; j < m.length; j++) {
                int val = m[i][j] - 1;
                boolean b = seen[val];
                if (b) {
                   badRows++;
                   break;
               }
                seen[val] = true;
            }
        }
    
        for (int i = 0; i < m.length; i++) {
          boolean[] seen = new boolean[m.length];
          for (int j = 0; j < m.length; j++) {
             int val = m[j][i] - 1;
             boolean b = seen[val];
             if (b) {
            	 	badCols++;
            	 	break;
            	 }
             seen[val] = true;
          }
        }
        return new int[] { badRows, badCols };
    }
}