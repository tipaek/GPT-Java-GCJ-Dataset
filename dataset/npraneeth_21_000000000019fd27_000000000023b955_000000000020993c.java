package com.gcj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Vestigium {

	public static void main(String args[]) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int i, j, k;

			int noOfRowsWithRepeatedElements = 0;
			int noOfColumnsWithRepeatedElements = 0;

			int noOfCases = Integer.valueOf(br.readLine());

			for (i = 0; i < noOfCases; i++) {

				int matrixSize = Integer.valueOf(br.readLine());

				int matrix[][] = new int[matrixSize][matrixSize];

				int trace = 0;

				int xorValue = 0;

				for (j = 1; j <= matrixSize; j++) {
					xorValue ^= j;
				}
				
				int columnXor[] = new int[matrixSize];

				for (j = 0; j < matrixSize; j++) {

					int rowXor = 0;
					String row = br.readLine();
					String[] rowElement = row.split(" ");

					for (k = 0; k < matrixSize; k++) {

						matrix[j][k] = Integer.valueOf(rowElement[k]);
						rowXor ^= matrix[j][k];
						columnXor[k] ^= matrix[j][k];

						if (j == k) {
							trace = trace + matrix[j][k];
						}
					}

					if ((rowXor ^ xorValue) != 0) {
						noOfRowsWithRepeatedElements += 1;
					}
				}

				for(j = 0 ; j < matrixSize; j++) {
					if((columnXor[j] ^ xorValue) != 0) {
						noOfColumnsWithRepeatedElements +=1;
					}
				}
				
				System.out.println("Case #" + i + ": " + trace + " " + noOfRowsWithRepeatedElements + " "
						+ noOfColumnsWithRepeatedElements);
				
				trace = 0;
				noOfRowsWithRepeatedElements = 0;
				noOfColumnsWithRepeatedElements = 0;

			}

		} catch (Exception ex) {

		}

	}

}
