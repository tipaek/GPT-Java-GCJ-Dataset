import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static long solve(int N, int B, List<Integer> houses) {
		Collections.sort(houses);
		int count = 0;
		long total = 0;
		while (count < N && total < B) {
			total += houses.get(count);
			if (total <= B) {
				count++;
			}
		}
		return count;
    }
    
    public static void main(String[] args) {
    	Scanner inp = new Scanner(System.in);
	    int cases = inp.nextInt();
	    for (int c = 0; c < cases; c++) {
	    	int N = inp.nextInt();
	    	
	    	int matrix[][] = new int[N][N];
	    	
	    	for (int i = 0; i < N; i++) {
		    	for (int j = 0; j < N; j++) {
		    		matrix[i][j] = inp.nextInt();
		    	}
	    	}
	    	
	    	int trace = 0;
	    	for (int i = 0; i < N; i++) {
	    		trace += matrix[i][i];
	    	}
	    	int rowDiff = 0;
	    	for (int i = 0; i < N; i++) {
	    		List<Integer> row = new ArrayList<Integer>();
		    	for (int j = 0; j < N; j++) {
		    		if (row.contains(matrix[i][j])) {
		    			rowDiff++;
		    			break;
		    		} else {
		    			row.add(matrix[i][j]);
		    		}
		    	}
	    	}
	    	
	    	int colDiff = 0;
	    	for (int j = 0; j < N; j++) {
	    		List<Integer> col = new ArrayList<Integer>();
		    	for (int i = 0; i < N; i++) {
		    		if (col.contains(matrix[i][j])) {
		    			colDiff++;
		    			break;
		    		} else {
		    			col.add(matrix[i][j]);
		    		}
		    	}
	    	}

	    	System.out.println("Case #" + (c+1) + ": " + trace + " " + rowDiff + " " + colDiff);
	    }
        inp.close();
    }
}
