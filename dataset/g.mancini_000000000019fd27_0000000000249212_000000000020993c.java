package com.google.code.jam;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Solution {

	private static long testCases;
	private static VestigiumInput vestigiumInput;

	public static void main(String[] args) {
		read(Solution::initVestigium, Solution::readVestigium);
		solveVestigium();
		System.exit(0);
	}

	private static void solveVestigium() {
		for (int i = 0; i < testCases; i++) {
			long trace = 0;
			StringBuilder solutionOutput = new StringBuilder();

			Map.Entry<Integer, Integer[][]> input = vestigiumInput.matrix.get(i);
			int size = input.getKey();
			Integer[][] matrix = input.getValue();
			long rowsWithDuplicate = 0;
			long columnsWithDuplicate = 0;
			Map<Integer, Set<Integer>> columnsValues = new HashMap<>();

			for (int r = 0; r < size; r++) {
				solutionOutput = new StringBuilder();
				Set<Integer> rowValues = new HashSet<>();
				for (int c = 0; c < size; c++) {
					rowValues.add(matrix[r][c]);
					Set<Integer> columnValues = columnsValues.get(c);
					if (columnValues == null) {
						columnValues = new HashSet<>();
						columnsValues.put(c, columnValues);
					}
					columnValues.add(matrix[r][c]);
					if(c == r) {
						trace += matrix[r][c];
					}
				}
				if (rowValues.size() != size) {
					rowsWithDuplicate++;
				}
				
			}
			for (Set<Integer> columnValues : columnsValues.values()) {
				if (columnValues.size() != size) {
					columnsWithDuplicate++;
				}
			}
			solutionOutput.append(trace).append(" ").append(rowsWithDuplicate).append(" ").append(columnsWithDuplicate);
			writeSolutionLine(i + 1, solutionOutput.toString());
		}
	}

	private static void read(Consumer<Integer> initInput, BiConsumer<Scanner, Integer> inputReader) {
		Scanner in = new Scanner(System.in);
		testCases = in.nextLong();

		initInput.accept((int) testCases);

		for (int i = 0; i < testCases; i++) {
			inputReader.accept(in, i);
		}
	}

	private static void writeSolutionLine(long index, String output) {
		System.out.println("Case #" + index + ": " + output);
	}

	private static void readVestigium(Scanner in, int index) {
		int matrixSize = in.nextInt();
		Integer[][] matrix = new Integer[matrixSize][matrixSize];
		vestigiumInput.matrix.add(index, new AbstractMap.SimpleEntry(matrixSize, matrix));
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
	}

	private static void initVestigium(int size) {
		vestigiumInput = new VestigiumInput();
		vestigiumInput.matrix = new ArrayList<>(size);
	}

	private static class VestigiumInput {

		private List<Map.Entry<Integer, Integer[][]>> matrix;

	}
}
