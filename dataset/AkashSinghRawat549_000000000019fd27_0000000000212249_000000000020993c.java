package Vestigium;

import java.util.ArrayList;
import java.util.Scanner;

public class Vestigium {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		ArrayList<String> matrix = new ArrayList<String>();
		for (int i = 0; i < cases; i++) {
			int matrixSize = sc.nextInt();
			int[][] arr= new int[matrixSize][matrixSize];
			for (int j = 0; j < matrixSize; j++) {
	            String[] arrRowItems = sc.nextLine().split(" ");
	            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int k = 0; k< matrixSize; k++) {
	                int arrItem = Integer.parseInt(arrRowItems[k]);
	                arr[j][k] = arrItem;
	            }
	        }
			System.out.println(arr);
		}
		
		
	}
		
}
