import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
	
	static class Checker {
		private boolean[] occurs;
		private boolean duplicates = false;
		public Checker(int nDim) {
			super();
			this.occurs = new boolean[nDim+1];
		}
		public void add(int val) {
			if (occurs[val]) {
				duplicates = true;
			} else {
				occurs[val] = true;
			}
		}
		public boolean isDuplicates() {
			return duplicates;
		}
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x=1; x<=t; x++) {
        	int nDim = in.nextInt();
        	Checker[] rows = new Checker[nDim];
        	Checker[] cols = new Checker[nDim];
        	for (int i=0; i<nDim; i++) {
        		rows[i] = new Checker(nDim);
        		cols[i] = new Checker(nDim);
        	}
        	int trace = 0;
        	for (int r=0; r<nDim; r++) {
        		for (int c=0; c<nDim; c++) {
        			int val = in.nextInt();
        			rows[r].add(val);
        			cols[c].add(val);
        			if (r==c) {
        				trace += val;
        			}
        		}
        	}
        	int nDupRows = 0;
        	int nDupCols = 0;
        	for (int i=0; i<nDim; i++) {
        		if (rows[i].isDuplicates()) {
        			nDupRows++;
        		}
        		if (cols[i].isDuplicates()) {
        			nDupCols++;
        		}
        	}

            System.out.format(Locale.ROOT, "Case #%d: %d %d %d%n", x, 
            		trace, nDupRows, nDupCols);
        }
        in.close();
    }
}
