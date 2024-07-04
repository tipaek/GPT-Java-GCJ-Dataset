package com.codejam.google;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

	private static int trace = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] res = new int[T][3];
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[][] matrix = new int[N][N];
			res[i] = checkIfLatinSquare(matrix, N, sc);
			trace = 0;
		}
		
		int idx = 1;
		for(int[] r : res) {
			System.out.println("Case #" +  idx++ + ": " + r[0] + " " + r[1] + " " + r[2]);
		}
	}

	private static int[] checkIfLatinSquare(int[][] matrix, int N, Scanner sc) {
		Set<Integer>[] rowSet = new HashSet[N];
		Set<Integer>[] colSet = new HashSet[N];
		for(int i = 0; i < N; i++) {
			rowSet[i] = new HashSet<>();
			colSet[i] = new HashSet<>();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				readNextElement(sc.nextInt(), rowSet, colSet, i, j);
			}
		}
		int[] res = new int[3];
		res[0] = trace;
		res[1] = duplicateEntriesCount(rowSet, N);
		res[2] = duplicateEntriesCount(colSet, N);
		return res;
	}

	private static int duplicateEntriesCount(Set<Integer>[] rowSet, int N) {
		int count = 0;
		for(Set<Integer> s : rowSet) {
			if(s.size() != N)
				count++;
		}
		return count;
	}
	
	private static void readNextElement(int nextInt, Set<Integer>[] rowSet, Set<Integer>[] colSet, int i, int j) {
		rowSet[i].add(nextInt);
		colSet[j].add(nextInt);
		if(i == j)
			trace += nextInt;
	}
}
