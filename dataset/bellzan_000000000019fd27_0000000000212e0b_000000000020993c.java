import java.io.*;
import java.util.*;

class Solution {
	static int[][] currentGrid;
	static int N;
	public static int findTrace() {
		int toReturn = 0;
		for (int m = 0; m < N; m++) {
			toReturn += currentGrid[m][m];
		}
		return toReturn;
	};
	public static int findR() {
		boolean[] seen;
		int problemCount = 0;
		int currentSquare;
		for (int m = 0; m < N; m++) {
			seen = new boolean[N+1];
			for (int l = 0; l < N; l++) {
				currentSquare = currentGrid[m][l];
				//System.out.println(currentSquare);
				if (seen[currentSquare] == false) {
					seen[currentSquare] = true;
				} else {
					problemCount++;
					l = N;
				}
			}
		}
		return problemCount;
	};
	public static int findC() {
		boolean[] seen;
		int problemCount = 0;
		int currentSquare;
		for (int m = 0; m < N; m++) {
			seen = new boolean[N+1];
			for (int l = 0; l < N; l++) {
				currentSquare = currentGrid[l][m];
				//System.out.println(currentSquare);
				if (seen[currentSquare] == false) {
					seen[currentSquare] = true;
				} else {
					problemCount++;
					l = N;
				}
			}
		}
		return problemCount;
	};
    public static void main(String[] args) throws IOException {
    	BufferedReader f = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        int trace = -1;
        int r = -1;
        int c = -1;
        for (int i = 0; i < T; i++) {
        	st = new StringTokenizer(f.readLine());
        	N = Integer.parseInt(st.nextToken());
        	currentGrid = new int[N][N];
        	for (int j = 0; j < N; j++) {
        		st = new StringTokenizer(f.readLine());
        		for (int k = 0; k < N; k++) {
        			currentGrid[j][k] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	trace = findTrace();
        	r = findR();
        	c = findC();
        	
        	//Prints current grid:
        	/*for (int j = 0; j < N; j++) {
        		for (int k = 0; k < N; k++) {
        			System.out.print(currentGrid[i][j]+" ");
        		}
        		System.out.println();
        	}
        	System.out.println();*/
        	
        	System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
        }
        f.close();
    }
}