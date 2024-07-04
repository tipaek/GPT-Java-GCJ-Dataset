package com;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LatinMatrix {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		int testCases = Integer.valueOf(line);
		
		String[] casesResult = new String[testCases];
		
		int currentCase = 0;
		
		while (sc.hasNextLine()) {
			int row = 0;
			int column = 0;
			int sum = 0;
			
			line = sc.nextLine();
			int currentN = Integer.valueOf(line);
			
			int[][] array = new int[currentN][currentN];
			
				
			
			for (int i = 0; i < currentN; i++) {
				String[] currentStrLine = sc.nextLine().split(" ");

				Set<Integer> set = new HashSet<>(); 

				for (int j = 0; j < currentStrLine.length; j++) {
					array[i][j] = Integer.valueOf(currentStrLine[j]);
					if(!set.add(array[i][j])) {
						row++;
					}
				}
			}
			
			
			for (int i = 0; i < array.length; i++) {
				Set<Integer> set = new HashSet<>(); 

				sum += array[i][i];
				for (int j = 0; j < array[i].length; j++) {
					if(!set.add(array[j][i])) {
						column++;
					}
				}
			}

			casesResult[currentCase] = sum + " " + row + " " + column; 
			
			
			currentCase++;
		}
		
		
		//PrintWriter pw = new PrintWriter(new File(""));
		
		for (int i = 0; i < casesResult.length; i++) {
			System.out.println("Case #" + (i+1) + ": " + casesResult[i]);
			//pw.println("Case #" + (i+1) + ": " + casesResult[i]);
		}
		
		
	}
	
	
	
	
}
