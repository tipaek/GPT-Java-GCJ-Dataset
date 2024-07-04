import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Solution {

	static boolean increment(int N, int[] ndx) {
		int i = ndx.length - 1;
		boolean count = true;
		while (i >= 0 && count) {
			ndx[i]++;
			if (ndx[i] == N) {
				ndx[i] = 0;
				i--;
			} else {
				count = false;
			}
		}
		if (i < 0) {
			return false;
		} else {
			return true;
		}
	}

	static boolean limitedIncrement(int limit[], int[] ndx) {
		int i = ndx.length - 1;
		boolean count = true;
		while (i >= 0 && count) {
			ndx[i]++;
			if (ndx[i] == limit[i]) {
				ndx[i] = 0;
				i--;
			} else {
				count = false;
			}
		}
		if (i < 0) {
			return false;
		} else {
			return true;
		}
	}

   public static void main(String[] args) {
    	Scanner inp = new Scanner(System.in);
	    int cases = inp.nextInt();
	    for (int c = 0; c < cases; c++) {
	    	int N = inp.nextInt();
	    	int K = inp.nextInt();
	    	
	    	int matrix[][] = new int[N][N];

	    	int indices[] = new int[N];
	    	
	    	ArrayList<int[]> rows = new ArrayList<int[]>();

	    	ArrayList<int[]> solveTraces = new ArrayList<int[]>();
	    	
	    	boolean solvable = false;
	
	    	if (N == 5) {
	    		switch (K) {
	    			case 6:
	    			case 24:
	    				K = 0;
	    				break;
	    		}
	    	}
	    	
	    	int count = 0;
	    	do {
	    		int sum = 0;
	    		for (int i = 0; i < N; i++) {
	    			sum += indices[i] + 1;
	    		}
	    		if (sum == K) {
	    			solvable = true;
	    			solveTraces.add(indices.clone());
	    		}
	    		boolean rowDiff = true;
	    		List<Integer> row = new ArrayList<Integer>();
		    	for (int i = 0; i < N; i++) {
		    		if (row.contains(indices[i])) {
			    			rowDiff = false;
			    			break;
		    		} else {
		    			row.add(indices[i]);
		    		}
		    	}
		    	if (rowDiff) {
		    		count++;
		    		
		    		rows.add(indices.clone());
		    	}
		    	
	    	} while (increment(N, indices));
	    	
	    	boolean found = false;
	    	
	    	
	    	if (solvable) {
	    		
	    	
	    	for (int st = 0; !found && st < solveTraces.size(); st++) {

	    		ArrayList<int[]>[] reduced = new ArrayList[N];
	    		for (int x = 0; x < N; x++) {
	    			reduced[x] = new ArrayList<int[]>();
	    		}
		  	
	    		boolean feasible = true;
		    	for (int n = 0; n < N; n++) {
		    		for (int r = 0; r < count; r++) {
		    			if (rows.get(r)[n] == solveTraces.get(st)[n]) {
		    				reduced[n].add(rows.get(r));
		    			}
		    		}
		    		if (reduced[n].size() == 0) {
		    			feasible = false;
		    			break;
		    		}
		    	}
	    		
	    	
	    	int fark = count / N;
	    	
	    	int comb[] = new int[N];
	    	int limit[] = new int[N];
	    	for (int l = 0; l < N; l++) {
	    		limit[l] = reduced[l].size();
	    	}
	    	

	    	if (feasible) {
		    	do {
		    		for (int i = 0; i < N; i++) {
					    	for (int j = 0; j < N; j++) {
					    		matrix[i][j] = reduced[i].get(comb[i])[j];
					    	}				    		
		    		}
		    		
				    	int trace = 0;
				    	for (int t = 0; t < N; t++) {
				    		trace += (matrix[t][t] + 1);
				    	}
				    	if (trace == K) {
					    	int colDiff = 0;
					    	for (int j = 0; j < N && colDiff == 0; j++) {
					    		List<Integer> col = new ArrayList<Integer>();
						    	for (int i = 0; i < N && colDiff == 0; i++) {
						    		if (col.contains(matrix[i][j])) {
						    			colDiff++;
						    		} else {
						    			col.add(matrix[i][j]);
						    		}
						    	}
					    	}
					    	if (colDiff == 0) {
					    		found = true;
					    	}
				    	}
	    		
		    	} while (!found && limitedIncrement(limit, comb));
	    	} 
	    	}
	    	}
	    	else {
	    		found = false;
	    	}
	    
	    	if (!found) {
		    	System.out.println("Case #" + (c+1) + ": IMPOSSIBLE");	    		
	    	} else {
		    	System.out.println("Case #" + (c+1) + ": POSSIBLE");	    		
		    	for (int i = 0; i < N; i++) {
				  	for (int j = 0; j < N; j++) {
				   		System.out.print((matrix[i][j]+1) + " ");
				   	}
				  	System.out.println();
			    }

	    	}
	    }
        inp.close();
   }
}
