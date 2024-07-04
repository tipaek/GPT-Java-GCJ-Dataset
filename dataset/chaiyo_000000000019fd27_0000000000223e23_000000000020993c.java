/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ggcj_2020;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author lap12537
 */
public class Vestigium {
    
    public static void vestigiumHelper (int[][] arr2dR, int[][] arr2dC, int N, int caseT) {
		int numberOfRepeatedRow = 0;
		int numberOfRepeatedColumn = 0;
		int traceSum = 0;
		for (int t = 0; t < N; t++) {
			Set<Integer> hang = new HashSet<>();
			Set<Integer> cot = new HashSet<>();
			for (int e = 0; e < N; e++) {
				if (e == t)
					traceSum += arr2dR[t][e];
				
				hang.add(arr2dR[t][e]);
				cot.add(arr2dC[t][e]);
			}
			if (hang.size() != N)
				numberOfRepeatedRow++;
			if (cot.size() != N)
				numberOfRepeatedColumn++;			
		}
		
		System.out.println(String.format("Case #%d: %d %d %d", caseT, traceSum, numberOfRepeatedRow, numberOfRepeatedColumn));
	}
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int T = input.nextInt();
        for (int t = 0; t < T; t++) {
            int N = input.nextInt();
			int[][] arr2dR = new int[N][N];
			int[][] arr2dC = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
					int num = input.nextInt();
					arr2dR[i][j] = num;
					arr2dC[j][i] = num;
                }
            }
			
			vestigiumHelper(arr2dR, arr2dC, N, t);
			
//			for (int i = 0; i < N*N; i++) {
//				System.out.println(arr2dR[i]);
//			}
//			System.out.println("Hello");
//			for (int i = 0; i < N*N; i++) {
//				System.out.println(arr2dC[i]);
//			}
        }
    }
    
}
