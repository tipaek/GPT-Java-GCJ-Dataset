package com.company;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
		int argumentIndex = 0;
		int testCases = new Integer(args[argumentIndex++]);
		int sizeOfMatrix = 2;
		int rowIndex = 0;
		int columnIndex = 0;
		int traceOfMatrix = 0;
		int sum;
		long rowWithDuplicates = 0;
		long columnWithDuplicates = 0;
        long numberLessThan64ForRow = 1;
        long numberMoreThan64ForRow = 1;
		long[] numberLessThan64ForColumn;
		long[] numberMoreThan64ForColumn;

        for (int testCaseIndex = 0; testCaseIndex < testCases; testCaseIndex++) {
			traceOfMatrix = 0;
			Set<Integer> rowIndexWithDuplicates = new HashSet<>();
			Set<Integer> columnIndexWithDuplicates = new HashSet<>();
			boolean recordedRow = false;
			boolean recordedColumn = false;
	        sizeOfMatrix = new Integer(args[argumentIndex++]);
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
			numberLessThan64ForColumn = new long[sizeOfMatrix];
			numberMoreThan64ForColumn = new long[sizeOfMatrix];
			
	        for (rowIndex = 0; rowIndex < sizeOfMatrix; rowIndex++) {
	        	recordedRow = false;
				numberLessThan64ForRow = 1;
				numberMoreThan64ForRow = 1;
                for (columnIndex = 0; columnIndex < sizeOfMatrix; columnIndex++) {
                	recordedColumn = false;
                    matrix[rowIndex][columnIndex] = new Integer(args[argumentIndex++]);
					int number = matrix[rowIndex][columnIndex];
					if (rowIndex == columnIndex) {
                        traceOfMatrix += number;
                    }
                    if (number < 64) {
                    	if (!checkDuplicate(numberLessThan64ForRow, number)) {
							numberLessThan64ForRow = recordNumber(numberLessThan64ForRow, number, 1);
						} else {
                    		recordedRow = true;
						}
					} else {
						if (!checkDuplicate(numberMoreThan64ForRow, number)) {
							numberMoreThan64ForRow = recordNumber(numberMoreThan64ForRow, number, 1);
						} else {
							recordedRow = true;
						}
					}
					if (recordedRow && !rowIndexWithDuplicates.contains(rowIndex)) {
						rowIndexWithDuplicates.add(rowIndex);
					}

					if (number < 64) {
						if (!checkDuplicate(numberLessThan64ForColumn[columnIndex], number)) {
							numberLessThan64ForColumn[columnIndex] = recordNumber(numberLessThan64ForColumn[columnIndex], number, 1);
						} else {
								recordedColumn = true;
						}
					} else {
						if (!checkDuplicate(numberMoreThan64ForColumn[columnIndex], number)) {
							numberMoreThan64ForColumn[columnIndex] = recordNumber(numberMoreThan64ForColumn[columnIndex], number, 1);
						} else {
							recordedColumn = true;
						}
					}
					if (recordedColumn && !columnIndexWithDuplicates.contains(columnIndex)) {
						columnIndexWithDuplicates.add(columnIndex);
					}
				}
            }
	        System.out.println(String.format("Case #%s: %s %s %s" ,
					testCaseIndex+1, traceOfMatrix, rowIndexWithDuplicates.size(), columnIndexWithDuplicates.size()));
        }
    }

	public static long recordNumber(long number, int position, long bit) {
    	long mask = 1l << position;
    	return (number & ~mask) | ((bit << position) & mask);
	}

	public static boolean checkDuplicate(long number, int position) {
    	return (number >> position & 1) == 1;
	}

	public static int[] readRow(String row) {
		String[] numbers = StringUtils.splitString(row, " ");
		return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
	}

	public static Integer sumOfArray(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
}
