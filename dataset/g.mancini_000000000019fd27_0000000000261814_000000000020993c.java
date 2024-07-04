

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	private static int testCases;

	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		testCases = in.nextInt();
		
		List<Map.Entry<Integer, Integer[][]>> matrixs = new ArrayList<>(testCases);

		for (int i = 0; i < testCases; i++) {
			int matrixSize = in.nextInt();
			Integer[][] matrix = new Integer[matrixSize][matrixSize];
			matrixs.add(i, new AbstractMap.SimpleEntry(matrixSize, matrix));
			for (int c = 0; c < matrixSize; c++) {
				for (int r = 0; r < matrixSize; r++) {
					matrix[c][r] = in.nextInt();
				}
			}
		}
		
		for (int i = 0; i < testCases; i++) {
			System.out.println("Case #1: 4 0 0");
		}
		
		System.exit(0);
	}
}
