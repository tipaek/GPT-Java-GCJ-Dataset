package codejam.y2020.qualification;

import java.util.Arrays;
import java.util.Scanner;

class Vestigium {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] matrix = new int[10000];
		int[] nCounters = new int[100];
		try {
			int T = sc.nextInt();
			
			for(int test=0; test< T; test++) {
				int N = sc.nextInt();
				int size = N*N;
				if(matrix.length < N*N) {
					throw new IllegalArgumentException(
							String.format("N: %d, size: %d, max size: %d", N, size, matrix.length));
				}
				
				for(int i=0; i<size; i++) {
					matrix[i] = sc.nextInt();
				}
				int repeatCountInRows = 0;
				int repeatCountInCols = 0;
				for(int number=0; number<N; number++) {
					repeatCountInRows += repeatCountInRow(number, N, nCounters, matrix);
					repeatCountInCols += repeatCountInCol(number, N, nCounters, matrix);
				}
				System.out.println(repeatCountInRows+", "+repeatCountInCols);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	private static int repeatCountInRow(int rowNumber, int N, int[] nCounters, int[] matrix) {
		
		if(rowNumber>N || nCounters.length<N || matrix.length<N*N) {
			throw new IllegalArgumentException(String.format("rownum: %d, N: %d, size: %d", rowNumber, N, matrix.length));
		}
		int repeatCount = 0;
		// reset counters
		Arrays.fill(nCounters, 0, nCounters.length, 0);
		int startIndex = rowNumber*N;
		int endIndex = rowNumber*N + N;
		for(int i=startIndex; i<endIndex; i++) {
			nCounters[matrix[i]-1] ++;
		}
		for(int i=0; i<N; i++) {
			if(nCounters[i] > 1) {
				repeatCount ++;
				break;
			}
		}
		return repeatCount;
	}
	
	private static int repeatCountInCol(int colNumber, int N, int[] nCounters, int[] matrix) {
		
		if(colNumber>N || nCounters.length<N || matrix.length<N*N) {
			throw new IllegalArgumentException(String.format("colnum: %d, N: %d, size: %d", colNumber, N, matrix.length));
		}
		int repeatCount = 0;
		// reset counters 
		Arrays.fill(nCounters, 0, nCounters.length, 0);
		for(int i=0; i<N; i++) {
			nCounters[matrix[i*N + colNumber]-1] ++;
		}
		for(int i=0; i<N; i++) {
			if(nCounters[i] > 1) {
				repeatCount ++;
				break;
			}
		}
		return repeatCount;
	}
}
