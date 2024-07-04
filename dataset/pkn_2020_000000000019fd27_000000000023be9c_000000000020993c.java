package com.codeJam.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Vestigium {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine().trim());
			Integer[][] M = new Integer[N][N];
			for (int row = 0; row < M.length; row++) {
				String[] strM = br.readLine().trim().split(" ");
				int[] A = Arrays.stream(strM).mapToInt(Integer::parseInt).toArray();
				for (int col = 0; col < M[row].length; col++) {
					M[row][col] = A[col];
				}
			}

			// modifying according to the requirement
			String out_ = Solution(N, M);
			System.out.println("Case #" + (i+1) + ": " + out_);

		}

		wr.close();
		br.close();
	}

	private static String Solution(int N, Integer[][] M) {
		String traceValue = trace(N, M);

		String rowColValue = rowColValue(N , M);
		
		return traceValue + " " + rowColValue;
	}

	private static String rowColValue(int N, Integer[][] M) {
		int row =0;
		int col =0;
		int count = 0 ;
		//for rows
		for (int i = 0; i < M.length; i++) {
			Integer[] temp = M[i];
			
			Set<Integer> check = convertArrayToSet(temp);
			if(check.size() <N) {
				count++;
			}
		}
		row = count ;

		count =0;
		//for columns
		for (int i = 0; i < M.length; i++) {
			Set<Integer> check = new HashSet<>();
			for (int j = 0; j < M.length; j++) {
				check.add(M[j][i]);				
			}
			if(check.size() <N) {
				count++;
			}
		}
		col = count ;
		return String.valueOf(row)+" "+String.valueOf(col);
	}
	
    public static <T> Set<T> convertArrayToSet(T array[]) 
    { 

        Set<T> set = new HashSet<>(Arrays.asList(array)); 
        return set; 
    } 
 
	private static String trace(int N, Integer[][] M) {
		// TODO Finding the trace of the matrice
		int sum = 0;
		for (int i = 0; i < M.length; i++) {
			sum += M[i][i];
		}
		return String.valueOf(sum);
	}

}
