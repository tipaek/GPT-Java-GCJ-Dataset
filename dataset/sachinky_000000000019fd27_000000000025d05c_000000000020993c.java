/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=0;t<tc;t++){
        	int N = sc.nextInt();
        	int[][] mat = new int[N][N];
        	int trace=0, row_cnt=0, col_cnt=0;
        	HashSet<Integer> hs;
        	for(int r=0;r<N;r++){
        		hs = new HashSet<>();
        		for(int c=0;c<N;c++){
        			mat[r][c] = sc.nextInt();
        			hs.add(mat[r][c]);
        			if(r==c) trace += mat[r][r];
        		}
        		if(hs.size() < N) row_cnt++;
        	}

        	for(int c=0;c<N;c++){
        		hs = new HashSet<>();
        		for(int r=0;r<N;r++){
        			hs.add(mat[r][c]);
        		}
        		if(hs.size() < N) col_cnt++;
        	}
        	System.out.println("Case #"+tc+": "+trace+" "+row_cnt+" "+col_cnt);
        }
    }
}