package src;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[]R1 = new int[T];
		int[]R2 = new int[T];
		int[]R3 = new int[T];
		for(int i = 0;i<T;i++) {
			int N = scanner.nextInt();
			int[][] array = new int[N][N]; 
			int row = 0;
			int[] rowFlag = new int[4];
			int colFlag = -1;
			int col = 0;
			for(int j = 0;j <N ; j++) {
				for(int k = 0; k < N; k++) {
					int[] temp = array[j].clone();
					int[] temp1 = getColArray(array.clone(), k , j);
					array[j][k] = scanner.nextInt();
					if(k>0 && colFlag!= j) {
						if(hasContaion(temp, array[j][k])) {
							colFlag = j;
							row+=1;
						}
					}
					
					if(j>0 && !hasContaion(rowFlag, k+1)) {
						if(hasContaion(temp1, array[j][k])) {
							rowFlag[k] = k+1;
							col+=1;
						}
					}
					
					
					if(j == k) {
						R1[i] += array[j][k];
					}
				}
				
			}
			R2[i] = row;
			R3[i] = col;
	
		}
		
		scanner.close();
		for(int i = 0;i<T;i++){
			System.out.print("Case #"+(i+1)+": "+R1[i]+" "+R2[i]+ " "+R3[i]+ "\n");
		}
		
	}
	
	private static boolean hasContaion(int[] array, int r) {
		for(int i = 0; i<array.length; i++) {
			if(array[i] == r)
				return true;
			else
				continue;
		}
		
		return false;
		
	}
	private static int[] getColArray(int[][] array, int col ,int row) {
		int[] a = new int[row];
			if(row!= 0) {
				for(int i=0; i<row; i++){
					a[i] = array[i][col];
		       }
			}
		return a;
		
	}
}
