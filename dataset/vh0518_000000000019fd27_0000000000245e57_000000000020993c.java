import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		int tc=1;
		while (tc<=t) {
			int n = sc.nextInt();
			int[][] mat = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			calculate(mat, n,tc);
			tc++;
		}

	}

	private static void calculate(int[][] mat, int n,int testCase) {
		int dSum = 0;
		for (int i = 0; i < n; i++) {
			dSum += mat[i][i];
		}
		int rowCount = 0;
		int colCount = 0;
		for (int i = 0; i < n; i++) {
			HashSet<Integer> rowSet=new HashSet<>();
			HashSet<Integer> colSet=new HashSet<>();
			boolean rowCheck=false;
			boolean colCheck=false;
			for (int j = 0; j < n; j++) {
                   if(!rowCheck&&rowSet.contains(mat[i][j])) {
                	   rowCheck=true;
                	   rowCount++;
                   }
                   if(!colCheck&&colSet.contains(mat[j][i])) {
                	   colCheck=true;
                	   colCount++;
                   }
                   rowSet.add(mat[i][j]);
                   colSet.add(mat[j][i]);
			}
		}
		System.out.println("Case #"+testCase+":"+" "+dSum+" "+rowCount+" "+colCount);

	}

}
