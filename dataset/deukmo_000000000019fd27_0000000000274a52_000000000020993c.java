package p1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
        	int N = in.nextInt();
        	int[][] M = new int[N][N];
        	for (int r=0; r<N; r++) {
        		for (int c=0; c<N; c++) {
        			M[r][c] = in.nextInt();
        		}
        	}
        	
        	int k = 0;
        	for (int rc=0; rc<N; rc++) {
        		k += M[rc][rc];
        	}
        	
        	int rCnt = 0;
        	for (int r=0; r<N; r++) {
        		boolean[] exist = new boolean[N];
        		boolean dup = false;
        		for (int c=0; c<N; c++) {
    				int idx = M[r][c] - 1;
        			if (exist[idx]) {
        				dup = true;
        				break;
        			} else {
        				exist[idx] = true;
        			}
        		}
        		if (dup) rCnt++;
        	}
        	
        	int cCnt = 0;
    		for (int c=0; c<N; c++) {
        		boolean[] exist = new boolean[N];
        		boolean dup = false;
    			for (int r=0; r<N; r++) {
    				int idx = M[r][c] - 1;
    				if (exist[idx]) {
        				dup = true;
        				break;
        			} else {
        				exist[idx] = true;
        			}
        		}
    			if (dup) cCnt++;
        	}
        	
    		System.out.print("Case #" + t + ": " + k + " " + rCnt + " " + cCnt + "\n");
        }

        in.close();
	}
}
