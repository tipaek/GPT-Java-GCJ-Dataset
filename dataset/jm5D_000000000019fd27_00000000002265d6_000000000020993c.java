
//2020 Code Jam Qualification Round   20200403 - 20200405 UTC
//Problem:  Vestigium
//Submitted by jm5D

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
//import java.io.FileReader;
//import java.io.FileWriter;


public class Solution {

	public static void main(String[] args) throws Exception{
		
		//BufferedReader reader = new BufferedReader(new FileReader("testData2020QualProbA"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		writer.flush();
		String inputString = reader.readLine();
		int numberOfCases = Integer.parseInt(inputString);
		int caseNumber = 1;
		while (caseNumber <= numberOfCases) {
			
			inputString = reader.readLine();
			int matrixSizeN = Integer.parseInt(inputString);
			
			int[][] matrix = new int[matrixSizeN][matrixSizeN];
			
			int rowsWithRepeats = 0;
			
			for (int i = 0; i < matrixSizeN; i++) {
				inputString = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(inputString, " ");
				boolean rowDuplicates = false;
				HashSet<Integer> rowSet = new HashSet<Integer>();
				for (int j = 0; j < matrixSizeN; j++) {
					int number = Integer.parseInt(tokenizer.nextToken());
					matrix[i][j] = number;
					if (!rowDuplicates) {
						if (!rowSet.contains(number)) rowSet.add(number);
						else rowDuplicates = true;
					}
				}
				if (rowDuplicates) rowsWithRepeats++;
				tokenizer = null;
				rowSet = null;
			}
			
			int columnsWithRepeats = 0;
			
			for (int i = 0; i < matrixSizeN; i++) {
				HashSet<Integer> columnSet = new HashSet<Integer>();
				boolean columnDuplicates = false;
				for (int j = 0; j < matrixSizeN; j++) {	
					if (!columnDuplicates) {
						int number = matrix[j][i];
						if (!columnSet.contains(number)) columnSet.add(number);
						else columnDuplicates = true;
					}
				}
				if (columnDuplicates) columnsWithRepeats++;
				columnSet = null;
			}
			
			int matrixTrace = 0;  //i.e. sum of numbers on main diagonal
			for (int i = 0; i < matrixSizeN; i++) {
				int j = i;
				matrixTrace += matrix[i][j];
			}
			
			writer.println("Case #" + caseNumber + ": " + matrixTrace + " " + rowsWithRepeats + " " + columnsWithRepeats);
			writer.flush();
			caseNumber++;
		}
		reader.close();
		writer.close();
		
	}
}